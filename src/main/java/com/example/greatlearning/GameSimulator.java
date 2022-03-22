package com.example.greatlearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.example.greatlearning.constants.CommonConstants;
import com.example.greatlearning.entity.Dice;
import com.example.greatlearning.entity.DiceRollingHistory;
import com.example.greatlearning.entity.Game;
import com.example.greatlearning.entity.Performance;
import com.example.greatlearning.entity.Player;
import com.example.greatlearning.entity.ScoreBoard;
import com.example.greatlearning.enums.DiceStatus;
import com.example.greatlearning.enums.PlayerStatus;
import com.example.greatlearning.service.RankService;
import com.example.greatlearning.strategies.PerformanceSortingStartegy;
import com.example.greatlearning.utils.PrintUtility;
import com.example.greatlearning.utils.RandomUtils;

/**
 * 
 * @author Md Asif <asifmd786kgn@gmail.com>
 *
 */
public class GameSimulator {
	private Game game;
	private Dice dice;
	
	private DiceRollingHistory diceRollingHistory;
	private ScoreBoard scoreBoard;
	private RankService rankService;
	
	
	private List<Player> players;
	private Queue<Player> queue;
	
	private boolean interactiveMode;
	private Scanner scanner;
	private boolean isInitialized;
	
	public GameSimulator(int playerCount, int maxScore, boolean interactiveMode) {
		this.game = new Game(playerCount, maxScore);
		this.dice = Dice.getInstance();
		
		this.rankService = RankService.getInstance(); 
		this.diceRollingHistory = new DiceRollingHistory();
		
		this.interactiveMode = interactiveMode;
		this.scanner = new Scanner(System.in);
		this.isInitialized = false;
	}
	
	public void initGame() {
		initPlayers();
		initScoreBoard();
		initPlayerQueue();
		initRankPool();
		
		isInitialized = true;
		
		PrintUtility.printWelcomeBanner(game.getPlayersCount(), game.getMaxScore());
		PrintUtility.printOrder(new LinkedList<Player>(queue));
	}
	
	public void startGame() {
		if(!isInitialized) {
			return;
		}
		
		while(!queue.isEmpty()) {
			Player currentPlayer = queue.poll();
			
			//check if needs to skip the turn
			if(!diceRollingHistory.forceToSkipTurn(currentPlayer.getId())) {
				PrintUtility.printTurnMessage(currentPlayer.getName());
				int number = preformDiceRoll(currentPlayer);
				
				while(currentPlayer.getStatus() == PlayerStatus.PLAYING && number == CommonConstants.SIX) {
					PrintUtility.printRollAgainMessage(currentPlayer.getName());
					number = preformDiceRoll(currentPlayer);
				}
				
				//if the player has scored the maxScore then he will not participate in the game
				if(currentPlayer.getStatus() == PlayerStatus.PLAYING) {
					queue.offer(currentPlayer);
				} else if(currentPlayer.getStatus() == PlayerStatus.COMPLETED) {
					PrintUtility.printPlayerFinishMessage(currentPlayer.getName());
				}
				
				showPerformanceTable();
			} else {
				PrintUtility.printSkipMessage(currentPlayer.getName());
				
				//insert 0 to indicate that the player has skipped the turn.
				diceRollingHistory.addHistory(currentPlayer.getId(), 0);
				queue.offer(currentPlayer);
			}
			
			while(interactiveMode) {
				System.out.println("Enter y to continue");
				String userInput = scanner.nextLine();
				
				if(userInput.equalsIgnoreCase("y")) {
					break;
				}
			}
		}
		
		PrintUtility.printEndMessage();
	}
	
	private int preformDiceRoll(Player player) {
		int number = roleDice();
		PrintUtility.printAfterRollingMessage(player.getName(), number);
		
		Performance playerPerformance = scoreBoard.getPerformance(player.getId());
		
		if(diceRollingHistory.shouldAwardedWithBonus(player.getId(), number)) {
			playerPerformance.addToScore(CommonConstants.TWO * number);
		} else {
			playerPerformance.addToScore(number);
		}
		
		if(playerPerformance.getScore() >= game.getMaxScore()) {
			playerPerformance.setRank(rankService.getRankFromPool());
			player.setStatusToCompleted();
		}
		
		scoreBoard.setPerformance(player.getId(), playerPerformance);
		
		
		diceRollingHistory.addHistory(player.getId(), number);
		
		return number;
	}
	
	private int roleDice() {
		int number = 0;
		
		if(dice.getStatus() == DiceStatus.AVAILABLE) {
			dice.setStatusAsAcquire();
			number = dice.roll();
			dice.setStatusAsAvail();
		}
		
		return number;
	}
	
	private void initPlayers() {
		List<Player> players = new ArrayList<Player>();
		
		for(int i = 1; i <= this.game.getPlayersCount(); i++) {
			players.add(new Player(CommonConstants.PLAYER_NAME_PREFIX + i));
		}
		
		this.players = players;
	}
	
	private void initPlayerQueue() {
		//shuffle the players and push them to queue.
		
		RandomUtils.shuffleList(players);
		Queue<Player> queue = new LinkedList<Player>();
		
		for(Player player : players) {
			player.setStatusToPlaying();
			queue.add(player);
		}
		
		this.queue = queue;
	}
		
	private void initScoreBoard() {
		this.scoreBoard = ScoreBoard.getInstance();
		this.scoreBoard.initScoreBoard(players);
	}
	
	private void initRankPool() {
		rankService.initRankPool(game.getPlayersCount());
	}
	
	private void showPerformanceTable() {
		List<Performance> performances = scoreBoard.getAllPerformances();
		PerformanceSortingStartegy.sort(performances);
		PrintUtility.printScoreBoard(performances);
	}
}

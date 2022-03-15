package com.example.greatlearning.entity;

import com.example.greatlearning.enums.GameStatus;
import com.example.greatlearning.utils.RandomUtils;

/**
 * 
 * @author Md Asif <asifmd786kgn@gmail.com>
 *
 */
public class Game {
	private String id;
	private GameStatus status;
	
	private int playersCount;
	private int maxScore;
	
	public Game(int playersCount, int maxScore) {
		this.id = RandomUtils.generateRandomUUID();
		this.playersCount = playersCount;
		this.maxScore = maxScore;
		this.status = GameStatus.READY;
	}

	public String getId() {
		return id;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public int getPlayersCount() {
		return playersCount;
	}
	
	public GameStatus getStatus() {
		return status;
	}

	public void changeStatusToInProgress() {
		this.status = GameStatus.IN_PROGESS;
	}
	
	public void changeStatusToFinished() {
		this.status = GameStatus.FINISHED;
	}
}

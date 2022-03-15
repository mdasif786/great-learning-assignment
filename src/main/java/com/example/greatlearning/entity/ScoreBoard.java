package com.example.greatlearning.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Md Asif <asifmd786kgn@gmail.com>
 *
 */
public class ScoreBoard {
	private static ScoreBoard instance;
	
	Map<String, Performance> playerToPerformanceMap;
	
	private ScoreBoard() {
		playerToPerformanceMap = new HashMap<String, Performance>();
	}
	
	public static ScoreBoard getInstance() {
		if(instance == null) {
			instance = new ScoreBoard();
		}
		
		return instance;
	}
	
	public void initScoreBoard(List<Player> players) {
		for(Player player : players) {
			playerToPerformanceMap.put(player.getId(), new Performance(player));
		}
	}
	
	public Performance getPerformance(String playerId) {
		return playerToPerformanceMap.get(playerId);
	}
	
	public boolean setPerformance(String playerId, Performance performance) {
		if(playerToPerformanceMap.containsKey(playerId)) {
			playerToPerformanceMap.put(playerId, performance);
			return true;
		}
		
		return false;
	}
	
	public List<Performance> getAllPerformances() {
		List<Performance> performances = new ArrayList<Performance>();
		
		for(Map.Entry<String, Performance> entry : playerToPerformanceMap.entrySet()) {
			performances.add(entry.getValue());
		}
		
		return performances;
	}
}

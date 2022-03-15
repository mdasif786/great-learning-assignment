package com.example.greatlearning.entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.example.greatlearning.constants.CommonConstants;

/**
 * 
 * @author Md Asif <asifmd786kgn@gmail.com>
 *
 */
public class DiceRollingHistory {
	private Map<String, Queue<Integer>> history;;
	private int capacity;
	
	private final static int DEFAULT_CAPACITY = 5;
	
	public DiceRollingHistory() {
		this.capacity = DEFAULT_CAPACITY;
		history = new HashMap<String, Queue<Integer>>();
	}
	
	public DiceRollingHistory(int capacity) {
		this.capacity = capacity;
		history = new HashMap<String, Queue<Integer>>();
	}
	
	public boolean addHistory(String playerId, int diceValue) {
		Queue<Integer> playerHistory = this.history.get(playerId);
		
		if(playerHistory != null) {
			if(playerHistory.size() < this.capacity) {
				playerHistory.offer(diceValue);
			} else {
				playerHistory.poll();
				playerHistory.offer(diceValue);
			}
		} else {
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(diceValue);
			
			this.history.put(playerId, queue);
		}
		
		return true;
	}
	
	public List<Integer> getHistory(String playerId) {
		Queue<Integer> queue = history.get(playerId);
		
		return new LinkedList<Integer>(queue);
	}
	
	public boolean forceToSkipTurn(String playerId) {
		if(history.containsKey(playerId)) {
			LinkedList<Integer> diceHistory = new LinkedList<Integer>(history.get(playerId));
			
			if(diceHistory.size() > 1 && diceHistory.get(diceHistory.size() - 1) == CommonConstants.ONE && diceHistory.get(diceHistory.size() - 2) == CommonConstants.ONE) {
				return true;
			}
		}
		
		return false;
	}
}

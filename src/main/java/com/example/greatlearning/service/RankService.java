package com.example.greatlearning.service;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Rank service class.
 * 
 * @author md.asif
 *
 */
public class RankService {

	private static RankService instance;

	private Queue<Integer> rankPool;

	private RankService() {

	}

	public static RankService getInstance() {
		if (instance == null) {
			instance = new RankService();
		}

		return instance;
	}

	public void initRankPool(int capacity) {
		rankPool = new PriorityQueue<Integer>();

		for (int i = 1; i <= capacity; i++) {
			rankPool.offer(i);
		}
	}

	public int getRankFromPool() {
		return rankPool.poll();
	}

}

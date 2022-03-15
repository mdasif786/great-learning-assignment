package com.example.greatlearning.entity;

public class Performance {
	private Player player;
	private int score;
	private int rank;

	public Performance(Player player) {
		this.player = player;

		this.score = 0;
		this.rank = -1; // initially no rank is assigned against the players
	}

	public Player getPlayer() {
		return player;
	}

	public int getScore() {
		return score;
	}

	public int addToScore(int value) {
		this.score = this.score + value;
		return this.score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}

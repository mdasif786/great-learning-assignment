package com.example.greatlearning.utils;

import java.util.List;

import com.example.greatlearning.entity.Performance;
import com.example.greatlearning.entity.Player;

public class PrintUtility {
	public static void printWelcomeBanner(int playerCount, int maxScore) {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------- Welcome to the game of Dice with " + playerCount + " players & " + maxScore + " max score ----");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("");
	}
	
	public static void printTurnMessage(String playerName) {
		System.out.println("");
		System.out.println(playerName + " It's your turn ...");
	}
	
	public static void printAfterRollingMessage(String playerName, int score) {
		System.out.println(playerName + " Rolled the dice & got: " + score);
		System.out.println("");
	}
	
	public static void printSkipMessage(String playerName) {
		System.out.println("");
		System.out.println(playerName + " You have got consecutive twice 1, Skiping your turn :(");
		System.out.println("");
	}
	
	public static void printPlayerFinishMessage(String playerName) {
		System.out.println("");
		System.out.println(playerName + " Congratulation you have completed the game");
	}
	
	public static void printRollAgainMessage(String playerName) {
		System.out.println(playerName + " Wow :), you have 6, please roll the dice again");
		System.out.println("");
	}
	
	public static void printScoreBoard(List<Performance> performances) {
		System.out.println("");
		System.out.println("---------------- The updated score board ------------");
		System.out.println("======================================================");
		System.out.println("Player Name                Score                  Rank");
		System.out.println("======================================================");
		
		for(Performance performance : performances) {
			System.out.println(performance.getPlayer().getName() + "                     " + performance.getScore() + "                     " + performance.getRank());
		}

		System.out.println("======================================================");
		System.out.println("");
	}
	
	public static void printEndMessage() {
		System.out.println("");
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("------------------------ Thanks for the participations --------------------");
		System.out.println("---------------------------------- The End --------------------------------");
		System.out.println("---------------------------------------------------------------------------");
	}
	
	public static void printOrder(List<Player> players) {
		System.out.println("======================================================");
		System.out.println("======================================================");
		System.out.println("The order of the players is: ");
		for(Player player : players) {
			System.out.println(player.getName());
		}
		System.out.println("======================================================");
		System.out.println("======================================================");
	}
}

package com.example.greatlearning;

/**
 * 
 * @author Md Asif <asifmd786kgn@gmail.com>
 *
 */
public class Driver {
	public final static int MIN_ARGUMENT_LENGTH = 2;
	
	public static void main(String[] args) {
		int playerCount;
		int maxScore;
		boolean isInteractive = false;
		
		if(args.length >= MIN_ARGUMENT_LENGTH) {
			try {
				playerCount = Integer.parseInt(args[0]);
				maxScore = Integer.parseInt(args[1]);
			} catch(Exception e) {
				System.out.println("Invalid argument(s) passed");
				return;
			}
			
			//check for mode 1 = Interactive, otherwise non-interactive
			if(args.length >= 3) {
				if(args[2] == "1") {
					isInteractive = true;
				}
			}
			
			if(playerCount > 0 && maxScore > 0) {
				GameSimulator gameSimulator = new GameSimulator(playerCount, maxScore, isInteractive);
				gameSimulator.initGame();
				
				gameSimulator.startGame();
			}
		} else {
			System.out.println("Insufficient Argument passed");
		}
	}
}

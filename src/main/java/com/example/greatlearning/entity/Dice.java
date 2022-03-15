package com.example.greatlearning.entity;

import com.example.greatlearning.enums.DiceStatus;
import com.example.greatlearning.utils.RandomUtils;

/**
 * 
 * @author Md Asif <asifmd786kgn@gmail.com>
 *
 * Singleton class for Dice.
 *
 */
public class Dice {

	private final static int MIN_NUMBER_ON_DICE = 1;
	private final static int MAX_NUMBER_ON_DICE = 6;
	
	private static Dice instance;
	
	private DiceStatus status;
	
	private Dice() {

	}
	
	public static Dice getInstance() {
		if(instance == null) {
			instance = new Dice();
			instance.status = DiceStatus.AVAILABLE;
		}
		
		return instance;
	}
	
	public int roll() {
		return RandomUtils.getRandomNumber(MIN_NUMBER_ON_DICE, MAX_NUMBER_ON_DICE);
	}
	
	public DiceStatus getStatus() {
		return status;
	}
	
	public void setStatusAsAvail() {
		this.status = DiceStatus.AVAILABLE;
	}
	
	public void setStatusAsAcquire() {
		this.status = DiceStatus.ACQUIRED;
	}
}

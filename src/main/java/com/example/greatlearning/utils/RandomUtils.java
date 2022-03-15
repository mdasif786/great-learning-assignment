package com.example.greatlearning.utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * A random utility class.
 * 
 * @author Md Asif <asifmd786kgn@gmail.com>
 *
 */
public class RandomUtils {
	public static int getRandomNumber(int min, int max) {
	    Random random = new Random();
	    
	    return random.ints(min, max + 1).findFirst().getAsInt();
	}
	
	public static String generateRandomUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static void shuffleList(List<?> list) {
		Random random = new Random();
		Collections.shuffle(list, random);
	}
}

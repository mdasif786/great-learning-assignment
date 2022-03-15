package com.example.greatlearning.factories;

import com.example.greatlearning.entity.Player;
import com.example.greatlearning.utils.RandomUtils;

public class PlayerFactory {
	public Player createFactory(String name) {
		return new Player(name, RandomUtils.generateRandomUUID());
	}
}

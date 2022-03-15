package com.example.greatlearning.factories;

import com.example.greatlearning.entity.Performance;
import com.example.greatlearning.entity.Player;
import com.example.greatlearning.utils.RandomUtils;

public class PerformaceTableFactory {
	public Performance createPerformance(Player player) {
		return new Performance(player);
	}
}

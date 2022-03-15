package com.example.greatlearning.strategies;

import java.util.Collections;
import java.util.List;

import com.example.greatlearning.entity.Performance;

public class PerformanceSortingStartegy {
	public static void sort(List<Performance> performances) {		
		Collections.sort(performances, (a, b) -> {
			//increasing in rank
			if(a.getRank() != b.getRank()) {
				return a.getRank() - b.getRank();
			}
			
			//decreasing in score
			return b.getScore() - a.getScore();
		});
	}
}

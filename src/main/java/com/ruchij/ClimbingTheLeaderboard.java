package com.ruchij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingTheLeaderboard {
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		int[] ranks = ranked.stream().distinct().sorted().mapToInt(x -> x).toArray();
		ArrayList<Integer> result = new ArrayList<>();

		for (Integer score : player) {
			int position = Arrays.binarySearch(ranks, score);
			if (position >= 0) {
				result.add(ranks.length - position);
			} else {
				result.add(ranks.length + position + 2);
			}
		}

		return result;
	}
}

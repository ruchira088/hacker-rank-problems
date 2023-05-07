package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ClimbingTheLeaderboardTest {

	@Test
	void verifyArrayBinarySearch() {
		int[] numbers = {1, 2, 4, 8, 16, 32, 64};
		Assertions.assertEquals(-8, Arrays.binarySearch(numbers, 100));
	}

	@Test
	void verifyExpectedOutputOne() {
		List<Integer> ranked = List.of(100, 90, 90, 80);
		List<Integer> player = List.of(79, 80, 105);

		Assertions.assertEquals(List.of(4, 3, 1), ClimbingTheLeaderboard.climbingLeaderboard(ranked, player));

	}

	@Test
	void verifyExpectedOutputTwo() {
		List<Integer> ranked = List.of(100, 100, 50, 40, 40, 20, 10);
		List<Integer> player = List.of(5, 25, 50, 120);

		Assertions.assertEquals(List.of(6, 4, 2, 1), ClimbingTheLeaderboard.climbingLeaderboard(ranked, player));

	}

}
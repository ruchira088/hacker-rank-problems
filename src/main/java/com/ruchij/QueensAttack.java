package com.ruchij;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueensAttack {
	record Coordinate(int x, int y) { }

	public enum Direction {
		UP(coordinate -> new Coordinate(coordinate.x, coordinate.y + 1)),
		DOWN(coordinate -> new Coordinate(coordinate.x, coordinate.y - 1)),
		LEFT(coordinate -> new Coordinate(coordinate.x - 1, coordinate.y)),
		RIGHT(coordinate -> new Coordinate(coordinate.x + 1, coordinate.y)),
		UP_RIGHT(coordinate -> new Coordinate(coordinate.x + 1, coordinate.y + 1)),
		UP_LEFT(coordinate -> new Coordinate(coordinate.x - 1, coordinate.y + 1)),
		DOWN_RIGHT(coordinate -> new Coordinate(coordinate.x + 1, coordinate.y - 1)),
		DOWN_LEFT(coordinate -> new Coordinate(coordinate.x - 1, coordinate.y - 1));

		private final Function<Coordinate, Coordinate> nextMove;

		Direction(Function<Coordinate, Coordinate> nextMove) {
			this.nextMove = nextMove;
		}

		public Function<Coordinate, Coordinate> getNextMove() {
			return nextMove;
		}
	}

	public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
		Set<Coordinate> obstacleSet =
			obstacles.stream().map(QueensAttack::covertToCoordinate).collect(Collectors.toSet());

		return queensAttack(n, new Coordinate(c_q, r_q), obstacleSet);
	}

	private static Coordinate covertToCoordinate(List<Integer> points) {
		return new Coordinate(points.get(1), points.get(0));
	}

	private static int queensAttack(int dimensions, Coordinate queensPosition, Set<Coordinate> obstacles) {
		int count = 0;

		for (Direction direction : Direction.values()) {
			Coordinate current = queensPosition;
			boolean isValid = true;

			while (isValid) {
				current = direction.nextMove.apply(current);

				if (obstacles.contains(current) || current.x < 1 || current.x > dimensions || current.y < 1 || current.y > dimensions) {
					isValid = false;
				} else {
					count++;
				}
			}
		}

		return count;
	}
}

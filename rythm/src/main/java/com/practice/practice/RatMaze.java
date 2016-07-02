package com.practice.practice;

import java.util.Arrays;

public class RatMaze {

	public boolean findPath(int[][] input) {
		int[][] seq = new int[input.length][input.length];
		boolean pathExists = pathHelper(input, seq, 0, 0);
		if (pathExists) {
			System.out.println("Path found");
			for (int i = 0; i < seq.length; i++) {
				System.out.println(Arrays.toString(seq[i]));
			}
		} else {
			System.out.println("No Path found");
		}
		return pathExists;
	}

	private boolean pathHelper(int[][] input, int[][] seq, int i, int j) {
		if (i == input.length - 1 && j == input.length - 1) {
			if (input[i][j] == 1) {
				seq[i][j] = 1;
				return true;
			}
		}
		if (isValid(input, i, j)) {
			seq[i][j] = 1;
			if (pathHelper(input, seq, i + 1, j)) {
				return true;
			}
			if (pathHelper(input, seq, i, j + 1)) {
				return true;
			}
			seq[i][j] = 0;
		}

		return false;
	}

	private boolean isValid(int[][] input, int i, int j) {
		if (i < 0 || i >= input.length || j < 0 || j >= input.length || input[i][j] != 1) {
			return false;
		}
		return true;
	}

}

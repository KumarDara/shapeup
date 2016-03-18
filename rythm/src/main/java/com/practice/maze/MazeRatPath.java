package com.practice.maze;

public class MazeRatPath {
	private int length;

	public boolean printPath(int[][] input, int n) {
		int[][] sol = new int[n][n];
		this.length = n;
		boolean valid = isValidPath(input, 0, 0, sol);
		if (!valid) {
			System.out.println("No Path found");
			return valid;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
		return valid;
	}

	public boolean isSafe(int[][] input, int x, int y) {
		if ((x >= 0 && x < length) && (y >= 0 && y < length) && input[x][y] == 1) {
			return true;
		}
		return false;
	}

	public boolean isValidPath(int[][] input, int x, int y, int[][] sol) {
		if (x == this.length - 1 && y == this.length - 1) {
			if (input[x][y] == 1) {
				sol[x][y] = 1;
				return true;
			}
		}
		if (isSafe(input, x, y)) {

			if (isValidPath(input, x + 1, y, sol)) {
				sol[x][y] = 1;
				return true;
			}
			if (isValidPath(input, x, y + 1, sol)) {
				sol[x][y] = 1;
				return true;
			}
		}
		return false;
	}
}

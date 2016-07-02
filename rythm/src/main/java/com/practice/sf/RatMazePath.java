package com.practice.sf;

public class RatMazePath {

	public boolean findPath(int[][] input) {
		boolean pathFound = Boolean.FALSE;
		int[][] sol = new int[input.length][input.length];
		pathFound = findPath(input, 0, 0, sol);
		if (pathFound) {
			for (int i = 0; i < sol.length; i++) {
				for (int j = 0; j < sol.length; j++) {
					System.out.print(sol[i][j] + " ");
				}
				System.out.println();
			}
		}
		return pathFound;
	}

	private boolean findPath(int[][] input, int i, int j, int[][] sol) {
		if (i == input.length - 1 && j == input.length - 1 && input[i][j] == 1) {
			sol[i][j] = 1;
			return Boolean.TRUE;
		}
		if (isValid(input, i, j)) {
			sol[i][j] = 1;
			if (findPath(input, i, j + 1, sol)) {
				return Boolean.TRUE;
			}
			if (findPath(input, i + 1, j, sol)) {
				return Boolean.TRUE;
			}
			sol[i][j] = 0;
		}
		return Boolean.FALSE;
	}

	private boolean isValid(int[][] input, int i, int j) {
		return (i >= 0 && i < input.length && j >= 0 && j < input.length && input[i][j] == 1);
	}
}

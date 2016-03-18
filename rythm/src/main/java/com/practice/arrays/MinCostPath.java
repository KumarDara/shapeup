package com.practice.arrays;

public class MinCostPath {

	public int minCost(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int[][] tmp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				tmp[i][j] = input[i][j] + getMin(tmp, i, j);
			}
		}
		printPath(input, tmp);
		return tmp[m - 1][n - 1];
	}

	private void printPath(int[][] input, int[][] tmp) {
		int m = tmp.length - 1;
		int n = tmp[0].length - 1;
		while (m >= 0 && n >= 0) {
			System.out.print(input[m][n] + " ");
			if (m == 0 && n == 0) {
				break;
			}
			if (m - 1 >= 0 && n - 1 >= 0) {
				if (tmp[m - 1][n - 1] < tmp[m][n - 1]) {
					if (tmp[m - 1][n - 1] < tmp[m - 1][n]) {
						m--;
						n--;
					} else {
						m--;
					}
				} else if (tmp[m][n - 1] < tmp[m - 1][n]) {
					n--;
				} else {
					m--;
				}
			} else if (m - 1 > 0 && n - 1 < 0) {
				m--;
			} else {
				n--;
			}
		}
		System.out.println();
	}

	private int getMin(int[][] input, int i, int j) {
		int min = 0;

		if (i - 1 >= 0 && j - 1 >= 0) {
			min = Math.min(input[i - 1][j - 1], input[i][j - 1]);
			min = Math.min(input[i - 1][j], min);
		} else if (i - 1 < 0 && j - 1 >= 0) {
			min = input[i][j - 1];
		} else if (i - 1 >= 0 && j - 1 < 0) {
			min = input[i - 1][j];
		}
		return min;
	}

}

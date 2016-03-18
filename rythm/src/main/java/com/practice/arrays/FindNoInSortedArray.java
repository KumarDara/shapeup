package com.practice.arrays;

public class FindNoInSortedArray {

	public boolean isNumberExists(int[][] input, int finder, int m, int n) {
		return normalSearch(input, finder, m, n);
		//return binarySearch(input, finder, 0, m - 1, 0, n - 1, m, n);
	}

	private boolean normalSearch(int[][] input, int finder, int m, int n) {
		int i = 0, j = n - 1, k = 0;
		if (finder < input[0][0] || finder > input[m - 1][n - 1]) {
			return false;
		}
		for (; i < m && j >= 0;) {
			System.out.println("loop::" + (++k));
			int guess = input[i][j];
			if (finder == guess) {
				return true;
			} else if (finder > guess) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}

	private boolean binarySearch(int[][] input, int finder, int fromRow, int toRow, int fromCol, int toCol, int m,
			int n) {
		if (fromRow < 0 || fromRow >= m || toRow < 0 || toRow >= m || fromCol < 0 || fromCol >= n || toCol < 0
				|| toCol >= n) {
			return false;
		}
		if (finder < input[fromRow][fromCol] || finder > input[toRow][toCol]) {
			return false;
		}
		boolean flag;
		int rowpivot = fromRow + (toRow - fromRow) / 2;
		int colpivot = fromCol + (toCol - fromCol) / 2;
		int guess = input[rowpivot][colpivot];
		if (finder == guess) {
			return true;
		}

		if (finder > guess) {
			// 2X1 matrix case
			if (fromCol == toCol) {
				if (input[toRow][toCol] == finder) {
					return true;
				}
			}
			flag = binarySearch(input, finder, rowpivot + 1, toRow, fromCol, colpivot, m, n);
			if (flag) {
				return true;
			}
			flag = binarySearch(input, finder, fromRow, toRow, colpivot + 1, toCol, m, n);
			if (flag) {
				return true;
			}
		} else {
			// 2X1 matrix case
			if (fromCol == toCol) {
				if (input[fromRow][toCol] == finder) {
					return true;
				}
			}
			flag = binarySearch(input, finder, fromRow, toRow, fromCol, colpivot, m, n);
			if (flag) {
				return true;
			}
			flag = binarySearch(input, finder, fromRow, rowpivot - 1, colpivot + 1, toCol, m, n);
			if (flag) {
				return true;
			}
		}
		return false;
	}
}

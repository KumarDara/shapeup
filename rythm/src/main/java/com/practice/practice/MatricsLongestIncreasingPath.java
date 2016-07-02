package com.practice.practice;

import java.lang.Thread.UncaughtExceptionHandler;

import com.practice.matrices.MatrixLongestIncreasingSequence;

public class MatricsLongestIncreasingPath {

	public static void main(String[] args) {
		 int[][] matrix = { { 5, 6 }, { 4, 4 } };
		// int[][] matrix = { { 1, 2, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		// int matrix[][] = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		//int[][] matrix = { { 4, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		System.out.println(new MatricsLongestIncreasingPath().printPath(matrix));
	}

	public int printPath(int[][] input) {
		if (input == null) {
			return 0;
		}
		int maxLen = 0;
		int maxI = 0;
		int maxJ = 0;
		int[][] seq = new int[input.length][input.length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				int len = printPathHelper(input, seq, i, j);

				if (maxLen < len) {
					maxLen = len;
					maxI = i;
					maxJ = j;
				}
			}
		}

		System.out.println("maxI:" + maxI + ", maxJ:" + maxJ);
		printPath(input, seq, maxLen, maxI, maxJ);
		return maxLen;
	}

	private void printPath(int[][] input, int[][] seq, int maxLen, int maxI, int maxJ) {
		System.out.print(input[maxI][maxJ] + ",  ");
		maxLen--;
		while (maxI >= 0 && maxJ >= 0 && maxI < input.length && maxJ < input.length && maxLen > 0) {
			if (maxI - 1 >= 0 && seq[maxI][maxJ] - 1 == seq[maxI - 1][maxJ]) {
				maxI--;
				maxLen--;
				System.out.print(input[maxI][maxJ] + ",  ");
			}
			if (maxI + 1 < input.length && seq[maxI][maxJ] - 1 == seq[maxI + 1][maxJ]) {
				maxI++;
				maxLen--;
				System.out.print(input[maxI][maxJ] + ",  ");
			}
			if (maxJ - 1 >= 0 && seq[maxI][maxJ] - 1 == seq[maxI][maxJ - 1]) {
				maxJ--;
				maxLen--;
				System.out.print(input[maxI][maxJ] + ",  ");
			}
			if (maxJ + 1 < input.length && seq[maxI][maxJ] - 1 == seq[maxI][maxJ + 1]) {
				maxJ++;
				maxLen--;
				System.out.print(input[maxI][maxJ] + ",  ");
			}
		}
	}

	private int printPathHelper(int[][] input, int[][] seq, int i, int j) {
		if (!isValid(input, i, j)) {
			return 0;
		}
		if (seq[i][j] > 0) {
			return seq[i][j];
		}
		int top = 0, down = 0, left = 0, right = 0;
		int len = 0;
		if (i - 1 >= 0 && input[i][j] < input[i - 1][j]) {
			top = printPathHelper(input, seq, i - 1, j);
		}
		if (i + 1 < input.length && input[i][j] < input[i + 1][j]) {
			down = printPathHelper(input, seq, i + 1, j);
		}
		if (j - 1 >= 0 && input[i][j] < input[i][j - 1]) {
			left = printPathHelper(input, seq, i, j - 1);
		}
		if (j + 1 < input.length && input[i][j] < input[i][j + 1]) {
			right = printPathHelper(input, seq, i, j + 1);
		}
		len = 1 + Math.max(Math.max(top, down), Math.max(left, right));
		seq[i][j] = len;
		return len;
	}

	private boolean isValid(int[][] input, int i, int j) {
		if (i < 0 || i >= input.length || j < 0 || j >= input.length) {
			return false;
		}
		return true;
	}

}

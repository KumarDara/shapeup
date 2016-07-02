package com.practice.matrices;

public class MatrixLongestDecreasingSequence {
	
	public static void main(String[] args) {
		// int[][] matrix = { { 1, 2 }, { 4, 3 } };
		int[][] matrix = { { 1, 2, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		// int matrix[][] = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		int[][] seqMatrix = new int[matrix.length][matrix[0].length];
		System.out.println(new MatrixLongestDecreasingSequence().findLenOfMaxIncSeq(matrix, seqMatrix));
	}

	public int findLenOfMaxIncSeq(int[][] matrix, int[][] seqMatrix) {
		int result = 0;
		int maxI = 0;
		int maxJ = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				_findLenOfMaxIncSeq(matrix, seqMatrix, i, j);
				if (result < seqMatrix[i][j]) {
					result = seqMatrix[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}
		printPath(matrix, seqMatrix, result, maxI, maxJ);
		return result;
	}
	private void printPath(int[][] matrix, int[][] seqMatrix, int maxSequence, int maxI, int maxJ) {
		System.out.print(matrix[maxI][maxJ] + " ");
		maxSequence--;
		int i = maxI;
		int j = maxJ;
		while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[i].length && maxSequence != 0) {
			if (i - 1 >= 0 && seqMatrix[i][j] - 1 == seqMatrix[i - 1][j]) {
				System.out.print(matrix[i - 1][j] + " ");
				i--;
				maxSequence--;
			}
			if (j - 1 >= 0 && seqMatrix[i][j] - 1 == seqMatrix[i][j - 1]) {
				System.out.print(matrix[i][j - 1] + " ");
				j--;
				maxSequence--;
			}
			if (i + 1 < matrix.length && seqMatrix[i][j] - 1 == seqMatrix[i + 1][j]) {
				System.out.print(matrix[i + 1][j] + " ");
				i++;
				maxSequence--;
			}
			if (j + 1 < matrix[i].length && seqMatrix[i][j] - 1 == seqMatrix[i][j + 1]) {
				System.out.print(matrix[i][j + 1] + " ");
				j++;
				maxSequence--;
			}
		}
		System.out.println();
	}

	private int _findLenOfMaxIncSeq(int[][] matrix, int[][] seqMatrix, int i, int j) {
		// Base case
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length)
			return 0;

		if (seqMatrix[i][j] > 0) {
			return seqMatrix[i][j];
		}

		int top =0 , down=0, left=0, right = 0;

		if (i + 1 < matrix.length && matrix[i][j] > matrix[i + 1][j]) {
			down = _findLenOfMaxIncSeq(matrix, seqMatrix, i + 1, j);
		}
		if (j + 1 < matrix[i].length && matrix[i][j] > matrix[i][j + 1]) {
			right = _findLenOfMaxIncSeq(matrix, seqMatrix, i, j + 1);
		}
		if (i - 1 >= 0 && matrix[i][j] > matrix[i - 1][j]) {
			top = _findLenOfMaxIncSeq(matrix, seqMatrix, i - 1, j);
		}
		if (j - 1 >= 0 && matrix[i][j] > matrix[i][j - 1]) {
			left = _findLenOfMaxIncSeq(matrix, seqMatrix, i, j - 1);
		}
		seqMatrix[i][j] = 1 + Math.max(Math.max(top, down), Math.max(left, right));
		return seqMatrix[i][j];
	}

}

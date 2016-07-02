package com.practice.matrices;

public class MirrorMatrix {

	public int[][] getMirror(int[][] input) {
		int[][] transpose = transposeMatrix(input);
		for (int i = 0; i < transpose.length; i++) {
			for (int j = 0; j < transpose.length / 2; j++) {
				int tmp = transpose[i][j];
				transpose[i][j] = transpose[i][(transpose.length - 1) - j];
				transpose[i][(transpose.length - 1) - j] = tmp;
			}
		}
		return transpose;
	}

	private int[][] transposeMatrix(int[][] input) {
		int[][] transpose = new int[input.length][input[0].length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				transpose[i][j] = input[j][i];
			}
		}
		return transpose;
	}
}

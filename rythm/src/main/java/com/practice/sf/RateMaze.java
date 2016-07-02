package com.practice.sf;

import java.util.Arrays;

public class RateMaze {
	final static int N = 4;

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int solution[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		if (!solveMazeUtil(maze, solution, 0, 0)) {
			System.out.println("No solution for this maze");
		} else {
			for (int[] i : solution) {
				System.out.println(Arrays.toString(i));
			}
		}
	}

	private static boolean solveMazeUtil(int[][] maze, int[][] sol, int i, int j) {
		if (i == N - 1 && j == N - 1) {
			sol[i][j] = 1;
			return Boolean.TRUE; // We ran the maze
		}

		if (isValid(i, j, maze)) {
			sol[i][j] = 1;
			if (solveMazeUtil(maze, sol, i + 1, j)) {
				return Boolean.TRUE;
			}
			if (solveMazeUtil(maze, sol, i, j + 1)) {
				return Boolean.TRUE;
			}
			sol[i][j] = 0;
		}

		return Boolean.FALSE;
	}

	private static boolean isValid(int i, int j, int[][] maze) {
		return (i >= 0 && i < N && j >= 0 && j < N && maze[i][j] == 1);
	}

}

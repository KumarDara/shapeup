package com.practice.sf;

import java.util.ArrayList;
import java.util.List;

public class TriangleMaxSumPath {

	private static int[][] triangle = { { 12 }, { 6, 7 }, { 5, 6, 8 },
			{ 1, 3, 5, 4 }, { 9, 4, 7, 2, 1 } };

	public static void main(String[] args) {
		findTriangleMaxSumPath(triangle);
	}

	private static void findTriangleMaxSumPath(int[][] triangle) {
		// take a sum matrix with each element representing the max sum at that
		// element
		int[][] sumTri = new int[triangle.length][triangle[triangle.length - 1].length];
		// populate the sumTri with maxSum at every element
		// if there was only a single row in a triangle matrix, the max sum at
		// every element in that triangle is equal to the element value. so
		// populate the last row of the sumTri with the element from the input
		// matrix
		// otherwise the max sum at element sumTri[i][j] will be, the
		// max{sumTri[i][j] + sumTri[i-1][j], sumTri[i][j] + sumTri[i-1][j+1]}
		// maxSum would be the value at sumTri[0][0]
		for (int i = triangle.length - 1; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (i == sumTri.length - 1) {
					sumTri[i][j] = triangle[i][j];
				} else {
					sumTri[i][j] = Math.max(sumTri[i + 1][j],
							sumTri[i + 1][j + 1]) + triangle[i][j];
				}
			}
		}

		int maxSum = sumTri[0][0];
		System.out.println("Max Sum :: " + maxSum);
		// max sum path would be the path that constitutes this maxSum, which
		// can be obtained by back tracking
		// starting from sumTri[0][0], subtract the maxSum with the value from
		// input[0][0] and check the result index in the sumTri. The
		// corresponding index from the original triangle would be in the max
		// Sum path. do it until you reach the last level. It assumes that no
		// two
		// elements in a row has the same value
		List<Integer> sumPath = new ArrayList<Integer>();
		List<Cell> sumPathCells = new ArrayList<Cell>();
		int row = 1;
		int sum = sumTri[0][0] - triangle[0][0];
		sumPath.add(triangle[0][0]);
		sumPathCells.add(new Cell(0, 0));
		while (row < sumTri.length) {
			for (int j = 0; j < triangle[row].length; j++) {
				if (sumTri[row][j] == sum) {
					sumPathCells.add(new Cell(row, j));
					sumPath.add(triangle[row][j]);
					sum = sum - triangle[row][j];
					row++;
					break;
				}
			}
		}
		System.out.println("Max sum Path Elements ::" + sumPath);
		System.out.println("Max sum Path cells ::" + sumPathCells);
	}
}

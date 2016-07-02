package com.practice.arrays;

public class KnapSack {

	public int knapSack(int[] weights, int[] values, int maxWeight) {
		// taking a temporary array to store the possible values with the
		// combination of weights
		int[][] knap = new int[weights.length + 1][maxWeight + 1];
		for (int i = 1; i < knap.length; i++) {
			for (int j = 1; j <= maxWeight; j++) {
				// if weight is less than max weight then only it is eligible to
				// be part of knapsack
				if (weights[i - 1] <= j) {
					knap[i][j] = Math.max(values[i - 1] + knap[i - 1][j - weights[i - 1]], knap[i - 1][j]);
				} else {
					// if weight is greater than the current max weight then
					// take the value of the previous weight
					knap[i][j] = knap[i - 1][j];
				}
			}
		}

		return knap[weights.length][maxWeight];

	}

	public int knapSackRecursive(int[] weights, int[] values, int maxWeight, int length) {
		if (maxWeight == 0 || length == 0) {
			return 0;
		}
		if (weights[length - 1] <= maxWeight) {
			return Math.max(
					values[length - 1]
							+ knapSackRecursive(weights, values, (maxWeight - weights[length - 1]), length - 1),
					knapSackRecursive(weights, values, maxWeight, length - 1));
		} else {
			return knapSackRecursive(weights, values, maxWeight, length - 1);
		}
	}
}

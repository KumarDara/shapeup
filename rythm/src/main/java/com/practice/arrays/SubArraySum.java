package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
	// 1, 4, 20, 3, 10, 5
	public int[] getSubArray(int[] input, int sum) {
		int tmpSum;
		for (int i = 0; i < input.length; i++) {
			tmpSum = input[i];
			for (int j = i + 1; j < input.length; j++) {
				if (tmpSum == sum) {
					return populateArray(input, i, j - 1);
				}
				tmpSum = tmpSum + input[j];
			}
		}
		return null;
	}

	private int[] populateArray(int[] input, int i, int j) {
		int[] tmpArr = new int[j - i + 1];
		for (int tmpI = 0; tmpI < tmpArr.length; tmpI++) {
			tmpArr[tmpI] = input[i + tmpI];
		}
		return tmpArr;
	}

	public int[] zeroSumSubarray(int[] input) {
		// Creates an empty hashMap hM
		Map<Integer, Integer> hM = new HashMap<Integer, Integer>();

		// Initialize sum of elements
		int sum = 0;

		// Traverse through the given array
		for (int i = 0; i < input.length; i++) {
			// Add current element to sum
			sum += input[i];

			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (input[i] == 0 || sum == 0 || hM.get(sum) != null)
				return populateArray(input, hM.get(sum) + 1, i);

			// Add sum to hash map
			hM.put(sum, i);
		}

		// We reach here only when there is no subarray with 0 sum
		return null;
	}
}

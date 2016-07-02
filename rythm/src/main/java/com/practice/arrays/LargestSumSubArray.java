package com.practice.arrays;

public class LargestSumSubArray {

	public int maxSubArraySum(int input[]) {
		int max_so_far = input[0];
		int curr_max = input[0];

		for (int i = 1; i < input.length; i++) {
			curr_max = Math.max(input[i], curr_max + input[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}
}

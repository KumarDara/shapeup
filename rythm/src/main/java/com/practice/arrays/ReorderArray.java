package com.practice.arrays;

public class ReorderArray {

	/**
	 * Helps to reorder the array(2,3,5,7,9) to (2,5,3,9,7) in such a way that
	 * (2 < 5 > 3 < 9 > 7)
	 * 
	 * @param input
	 */
	public void reorder(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			if ((i % 2 == 1 && input[i] < input[i + 1]) || (i % 2 == 0 && input[i] > input[i + 1])) {
				int tmp = input[i];
				input[i] = input[i + 1];
				input[i + 1] = tmp;
			}
		}
	}
}

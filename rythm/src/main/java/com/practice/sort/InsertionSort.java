package com.practice.sort;

public class InsertionSort {

	public int[] sort(int[] input) {
		// start with 2nd element
		// if the 2nd element is smaller than 1st then swap
		// repeat the same steps till the end

		for (int j = 1; j < input.length; j++) {
			int key = input[j];
			int i = j - 1;
			while (i >= 0 && input[i] > key) {
				input[i + 1] = input[i];
				i--;
			}
			if (j != i + 1) {
				input[i + 1] = key;
			}
		}
		return input;
	}

}

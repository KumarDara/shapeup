package com.practice.sort;

public class InsertionSort implements Sort {

	public int[] sort(int[] input) {
		// start with 2nd element
		// if the 2nd element is smaller than 1st then swap
		// repeat the same steps till the end

		for (int j = 1; j < input.length; j++) {
			int key = input[j];
			int i = j - 1;
			// checking the current element with sorted portion of the array
			while (i >= 0 && input[i] > key) {
				input[i + 1] = input[i];
				i--;
			}
			// if the element is lesser than the biggest element in sorted
			// portion of the array
			// then place it accordingly.
			// if the element is greater than the sorted portion then append to
			// it and continue
			if (i != j - 1) {
				input[i + 1] = key;
			}
		}
		return input;
	}

}

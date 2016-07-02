package com.practice.sort;

public class SelectionSort implements Sort {

	public int[] sort(int[] input) {
		if (input != null) {
			for (int i = 0; i < input.length; i++) {
				int min = i;
				for (int j = i + 1; j < input.length; j++) {
					if (input[j] < input[min]) {
						min = j;
					}
				}
				if (min != i) {
					int tmp = input[min];
					input[min] = input[i];
					input[i] = tmp;
				}
			}
		}
		return input;
	}
}

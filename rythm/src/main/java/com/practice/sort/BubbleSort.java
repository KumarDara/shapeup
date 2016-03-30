package com.practice.sort;

public class BubbleSort {

	public int[] sort(int[] input) {
		if (input != null) {
			for (int i = input.length - 1; i >= 0; i--) {
				for (int j = 0; j <= i - 1; j++) {
					if (input[j] > input[j + 1]) {
						// swap the elements.
						int tmp = input[j];
						input[j] = input[j + 1];
						input[j + 1] = tmp;
					}
				}
			}
		}
		return input;
	}

	public int[] improvedSort(int[] input) {
		if (input != null) {
			// flag helps to understand further sorting required or not
			boolean sortrequired = Boolean.TRUE;
			for (int i = input.length - 1; i >= 0 && sortrequired; i--) {
				sortrequired = Boolean.FALSE;
				for (int j = 0; j <= i - 1; j++) {
					if (input[j] > input[j + 1]) {
						// swap the elements.
						int tmp = input[j];
						input[j] = input[j + 1];
						input[j + 1] = tmp;
						sortrequired = Boolean.TRUE;
					}
				}
			}
		}
		return input;
	}
}

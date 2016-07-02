package com.practice.sort;

import java.util.Arrays;

public class BubbleSort implements Sort {

	public int[] sort(int[] input) {
		if (input != null) {
			for (int i = 0; i < input.length - 1; i++) {
				for (int j = 0; j < input.length - i - 1; j++) {
					if (input[j] > input[j + 1]) {
						// swap the elements.
						int tmp = input[j];
						input[j] = input[j + 1];
						input[j + 1] = tmp;
					}
				}
				System.out.println(Arrays.toString(input));
			}
		}
		return input;
	}

	public int[] improvedSort(int[] input) {
		if (input != null) {
			// flag helps to understand further sorting required or not
			boolean sortrequired = Boolean.TRUE;
			for (int i = 0; i < input.length - 1 && sortrequired; i++) {
				sortrequired = Boolean.FALSE;
				for (int j = 0; j < input.length - i - 1; j++) {
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
	
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] input = new int[] {5,3,4,7,1};
		sort.sort(input);
	}
}

package com.test.sort;

public class MergeSort {

	public int[] sort(int[] input) {
		if (input != null) {
			mergeSort(input, 0, input.length - 1);
		}
		return input;
	}

	private void mergeSort(int[] input, int start, int end) {
		if (start < end) {
			int mid = start + ((end - start) / 2);
			mergeSort(input, start, mid);
			mergeSort(input, mid + 1, end);
			mergeHelper(input, start, mid, end);
		}
	}

	private void mergeHelper(int[] input, int start, int mid, int end) {
		int i = 0, j = 0, k = start;
		int[] left = new int[mid - start +1];
		int[] right = new int[end - mid];
		for (int tmp = 0; tmp < left.length; tmp++) {
			left[tmp] = input[start + tmp];
		}
		for (int tmp = 0; tmp < right.length; tmp++) {
			right[tmp] = input[mid + 1 + tmp];
		}

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				input[k] = left[i];
				i++;
			} else {
				input[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			input[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			input[k] = right[j];
			j++;
			k++;
		}
	}
}

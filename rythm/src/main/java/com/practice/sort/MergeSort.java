package com.practice.sort;

public class MergeSort implements Sort {

	public int[] sort(int[] input) {
		mergeSort(input, 0, input.length - 1);
		return input;
	}

	public void mergeSort(int[] input, int left, int right) {
		int mid;
		// base condition
		if (left < right) {
			mid = left + ((right - left) / 2); // to avoid integer overflow
			// divide the array from left to mid (First half)
			mergeSort(input, left, mid);
			// divide the array from mid + 1 to right (Second half)
			mergeSort(input, mid + 1, right);
			// merge both the halfs
			merge(input, left, mid, right);
		}
	}

	public void merge(int[] input, int left, int mid, int right) {
		int i = 0;
		int j = 0;
		int k = left;
		// defining the first half array
		int[] leftArray = new int[mid - left + 1];
		// defining the second half array
		int[] rightArray = new int[right - mid];
		// populate the first half array from input
		for (int tmp = 0; tmp < leftArray.length; tmp++) {
			leftArray[tmp] = input[left + tmp];
		}
		// populate the second half array from input
		for (int tmp = 0; tmp < rightArray.length; tmp++) {
			rightArray[tmp] = input[mid + 1 + tmp];
		}
		// iterate the elements from both the arrays
		while (i < leftArray.length && j < rightArray.length) {
			// left array element is smaller or equal to right array element
			if (leftArray[i] <= rightArray[j]) {
				input[k] = leftArray[i];
				i++;
				k++;
			} else {
				input[k] = rightArray[j];
				j++;
				k++;
			}
		}

		// sometimes rightArray will finish first so adding the remaining
		// leftArray elements to input
		while (i < leftArray.length) {
			input[k] = leftArray[i];
			i++;
			k++;
		}
		// sometimes leftArray will finish first so adding the remaining
		// rightArray elements to input
		while (j < rightArray.length) {
			input[k] = rightArray[j];
			j++;
			k++;
		}

	}
}

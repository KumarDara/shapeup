package com.practice.arrays;

public class RotatedArraySearch {

	public int search(int[] input, int no) {
		return searchRec(input, 0, input.length - 1, no);
	}

	private int searchRec(int[] arr, int l, int h, int key) {
		if (l > h) {
			return -1;
		}
		int mid = l + (h - l) / 2;
		if (arr[mid] == key) {
			return mid;
		}
		/* If arr[l...mid] is sorted */
		if (arr[l] <= arr[mid]) {
			/*
			 * As this subarray is sorted, we can quickly check if key lies in
			 * half or other half
			 */
			if (key >= arr[l] && key <= arr[mid])
				return searchRec(arr, l, mid - 1, key);

			return searchRec(arr, mid + 1, h, key);
		}

		/*
		 * If arr[l..mid] is not sorted, then arr[mid... r] must be sorted
		 */
		if (key >= arr[mid] && key <= arr[h])
			return searchRec(arr, mid + 1, h, key);

		return searchRec(arr, l, mid - 1, key);
	}

}

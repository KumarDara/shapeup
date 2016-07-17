package com.test.sort;

public class BinarySearch {

	public boolean isExists(int[] input, int no) {
		if (input != null) {
			int start = 0;
			int end = input.length - 1;

			while (start <= end) {
				int mid = start + ((end - start) / 2);
				if (no == input[mid]) {
					return true;
				}
				if (no > input[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return false;
	}
}

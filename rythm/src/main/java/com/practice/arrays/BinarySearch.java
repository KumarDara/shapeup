package com.practice.arrays;

public class BinarySearch {

	public boolean isNoExistis(int[] input, int no) {
		return isNoExistis(input, 0, input.length, no);
	}

	private boolean isNoExistis(int[] input, int start, int end, int no) {
		boolean exists = Boolean.FALSE;
		// verifying the start and end points to avoid ArrayIndexOutofBound
		// Exception
		if (start < 0 || end > input.length) {
			return Boolean.FALSE;
		}
		// checking whether the no exists in the boundaries or not
		if (no < input[start] || no > input[end - 1]) {
			return Boolean.FALSE;
		}
		while (start <= end) {

			int pivot = (start + (end - start) / 2) + (end - start) % 2; // finding
																			// the
																			// middle
																			// point
			if (no == input[pivot - 1]) {
				return Boolean.TRUE;
			}
			if (no < input[pivot - 1]) {
				end = pivot - 1;
			} else {
				start = pivot + 1;
			}
		}
		return exists;
	}
}

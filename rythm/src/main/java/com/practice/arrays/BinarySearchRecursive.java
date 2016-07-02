package com.practice.arrays;

public class BinarySearchRecursive {

	public int isNoExistis(int[] input, int no) {
		return isNoExistis(input, 0, input.length, no);
	}

	private int isNoExistis(int[] input, int start, int end, int no) {
		int pos = -1;
		// verifying the start and end points to avoid ArrayIndexOutofBound
		// Exception
		if (start < 0 || end > input.length) {
			return pos;
		}
		if (end < start) {
			return pos;
		}

		int pivot = (start + (end - start) / 2); // finding
													// the
													// middle
													// point
		if (no == input[pivot]) {
			return pivot;
		}
		if (no < input[pivot]) {
			// verifying whether the no is part of the first half
			return isNoExistis(input, start, pivot - 1, no);
		}
		// verifying whether the no is part of the second half
		return isNoExistis(input, pivot + 1, end, no);
	}
}

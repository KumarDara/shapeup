package com.practice.arrays;

public class BinarySearch {

	public int isNoExistis(int[] input, int no) {
		return isNoExistis(input, 0, input.length, no);
	}

	public int isNoExistis(int[] input, int start, int end, int no) {
		int pos = -1;
		// verifying the start and end points to avoid ArrayIndexOutofBound
		// Exception
		if (start != 0 || end != input.length) {
			return pos;
		}
		// checking whether the no exists in the boundaries or not
		if (no < input[start] || no > input[end - 1]) {
			return pos;
		}
		while (start <= end) {

			int pivot = (start + (end - start) / 2); // finding
														// the
														// middle
														// point
			if (no == input[pivot]) {
				return pivot;
			}
			if (no < input[pivot]) {
				end = pivot - 1;
			} else {
				start = pivot + 1;
			}
		}
		return pos;
	}
}

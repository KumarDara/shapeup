package com.practice.arrays;

public class BinarySearchRecursive {

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
		if (no == input[start]) {
			return Boolean.TRUE;
		}
		if (no == input[end - 1]) {
			return Boolean.TRUE;
		}
		int pivot = (start + (end-start)/2) + (end - start) % 2; // finding the middle point
		// verifying whether the no is part of the first half
		exists = isNoExistis(input, start, pivot, no);
		// avoiding duplicate calls in case of middle point and end are
		// equal(e.g:for length 1 array)
		if (!exists && pivot != end) {
			// verifying whether the no is part of the second half
			exists = isNoExistis(input, pivot, end, no);
		}
		return exists;
	}
}

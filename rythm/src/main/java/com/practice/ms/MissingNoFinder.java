package com.practice.ms;

public class MissingNoFinder {

	public int getMinssingNo(int[] input, int n) {
		int expectedSum = (n * (n + 1)) / 2;
		int actualSum = 0;
		for (int i = 0; i < input.length; i++) {
			actualSum += input[i];
		}
		int missingNo = expectedSum - actualSum;
		return missingNo;
	}
}

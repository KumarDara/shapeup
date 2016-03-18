package com.practice.arrays;

import java.util.Arrays;

public class LongestDecreasingSubsequence {

	public int getMaxCount(int[] input) {
		int max = 0;
		int[] tmp = new int[input.length];
		int[] tmpSeq = new int[input.length];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = 1;
		}
		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i] < input[j]) {
					if (tmp[j] + 1 > tmp[i]) {
						tmp[i] = tmp[j] + 1;
						tmpSeq[i] = j;
					}
				}
			}
		}

		int maxIndex = 0;
		for (int i = 1; i < tmp.length; i++) {
			if (tmp[i] > tmp[maxIndex]) {
				maxIndex = i;
			}
		}
		max = tmp[maxIndex];
		int[] seq = new int[max];
		for (int i = max - 1; i >= 0; i--) {
			seq[i] = input[maxIndex];
			maxIndex = tmpSeq[maxIndex];
		}
		System.out.println(Arrays.toString(seq));
		return max;
	}
}

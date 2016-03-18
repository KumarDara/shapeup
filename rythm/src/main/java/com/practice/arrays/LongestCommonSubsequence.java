package com.practice.arrays;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public int getLongestCommonSubsequenceLength(char[] arr1, char[] arr2) {
		int max = 0;
		int[][] tmp = new int[arr1.length + 1][arr2.length + 1];
		for (int i = 1; i < tmp.length; i++) {
			for (int j = 1; j < tmp[i].length; j++) {
				if (arr1[i - 1] == arr2[j - 1]) {
					tmp[i][j] = tmp[i - 1][j - 1] + 1;
				} else {
					tmp[i][j] = Math.max(tmp[i - 1][j], tmp[i][j - 1]);
				}
				if (tmp[i][j] > max) {
					max = tmp[i][j];
				}
			}
		}
		int i = tmp.length - 1, j = tmp[0].length - 1;
		char[] sub = new char[max];
		int sublen = max;
		while (i > 0 && j > 0) {
			if (arr1[i - 1] == arr2[j - 1]) {
				sub[--sublen] = arr1[i - 1];
				i--;
				j--;
			} else if (tmp[i - 1][j] > tmp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println(Arrays.toString(sub));
		return max;
	}

}

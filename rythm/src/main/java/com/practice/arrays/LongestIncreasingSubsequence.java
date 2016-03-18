package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int getLongetIncreasingSubsequenceCount(int[] input) {
		int max = 0;
		int[] subsequence = new int[input.length];
		int[] subsequenceArray = new int[input.length];
		// at least longest sequence would be 1 at every element.
		for (int i = 0; i < subsequence.length; i++) {
			subsequence[i] = 1;
			subsequenceArray[i] = i;
		}
		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				// possibility of increasing sequence
				if (input[i] > input[j]) {
					if (subsequence[j] + 1 > subsequence[i]) {
						subsequence[i] = subsequence[j] + 1;
						subsequenceArray[i] = j;
					}
				}
			}
		}

		int maxIndex = 0;
		for (int i = 0; i < subsequence.length; i++) {
			if (subsequence[i] > subsequence[maxIndex]) {
				maxIndex = i;
			}
		}
		max = subsequence[maxIndex];

		int[] solution = new int[max];
		for (int i = max - 1; i >= 0; i--) {
			solution[i] = input[maxIndex];
			maxIndex = subsequenceArray[maxIndex];
		}
		System.out.println(Arrays.toString(solution));
		return max;
	}

	public int longestSubsequenceRecursive(int arr[]) {
		int maxLen = 0;
		ArrayList<Integer> seq = new ArrayList<>();
		ArrayList<Integer> org = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			seq = new ArrayList<>();
			seq.add(arr[i]);
			int len = longestSubsequenceRecursive(arr, i + 1, arr[i], seq);
			if (len > maxLen) {
				maxLen = len;
				org = (ArrayList<Integer>) seq.clone();
			}
		}
		System.out.println(org);
		return maxLen + 1;
	}

	private int longestSubsequenceRecursive(int arr[], int pos, int lastNum, ArrayList<Integer> seq) {
		if (pos == arr.length) {
			return 0;
		}
		int t1 = 0;
		if (arr[pos] > lastNum) {
			t1 = 1 + longestSubsequenceRecursive(arr, pos + 1, arr[pos], seq);
		}
		int t2 = longestSubsequenceRecursive(arr, pos + 1, lastNum, seq);
		if (t1 > t2) {
			seq.add(arr[pos]);
		} else if (t2 > t1) {
			seq.add(arr[pos + 1]);
		}
		return Math.max(t1, t2);
	}
}

package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.LongestIncreasingSubsequence;

public class LongestIncreasingSubsequenceTest {

	@Test
	public void validTest() {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int max = obj.getLongetIncreasingSubsequenceCount(new int[] { 3, 4, -1, 0, 6, 2, 3 });
		max = obj.longestSubsequenceRecursive(new int[] { 3, 4, -1, 0, 6, 2, 3 });
		Assert.assertTrue(max == 4);
		max = obj.getLongetIncreasingSubsequenceCount(
				new int[] { 23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27 });
		max = obj.longestSubsequenceRecursive(
				new int[] { 23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27 });
		Assert.assertTrue(max == 10);

	}
}

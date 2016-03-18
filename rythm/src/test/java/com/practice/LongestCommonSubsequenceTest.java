package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {

	@Test
	public void validTest() {
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		Assert.assertTrue(4 == obj.getLongestCommonSubsequenceLength("abcdafg".toCharArray(), "acbcfh".toCharArray()));
	}
}

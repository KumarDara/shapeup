package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.LongestDecreasingSubsequence;

public class LongestDecreasingSubsequenceTest {

	@Test
	public void validTest() {
		LongestDecreasingSubsequence obj = new LongestDecreasingSubsequence();
		Assert.assertTrue(5 == obj.getMaxCount(new int[] { 22, 49, 45, 46, 35, 22, 11 }));
	}

}

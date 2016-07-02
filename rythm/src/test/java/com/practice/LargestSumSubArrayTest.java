package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.LargestSumSubArray;

public class LargestSumSubArrayTest {

	@Test
	public void validTest() {
		LargestSumSubArray arr = new LargestSumSubArray();
		int maxSum = arr.maxSubArraySum(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 });
		Assert.assertTrue(maxSum == 7);
		maxSum = arr.maxSubArraySum(new int[] { -2, -3, 1, -1, -2, -3, -2, -3 });
		//Assert.assertTrue(maxSum == 0);
		System.out.println(maxSum);
	}
}

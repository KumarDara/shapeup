package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.SubArraySum;

public class SubArraySumTest {

	@Test
	public void validTest() {
		SubArraySum sum = new SubArraySum();
		Assert.assertArrayEquals(new int[] { 20, 3, 10 }, sum.getSubArray(new int[] { 1, 4, 20, 3, 10, 5 }, 33));
		Assert.assertArrayEquals(new int[] { 4, 0, 0, 3 }, sum.getSubArray(new int[] { 1, 4, 0, 0, 3, 10, 5 }, 7));
		Assert.assertArrayEquals(new int[] { 2, -3, 1 }, sum.getSubArray(new int[] { 4, 2, -3, 1, 6 }, 0));
		Assert.assertArrayEquals(new int[] { 2, -3, 1 }, sum.zeroSumSubarray(new int[] { 4, 2, -3, 1, 6 }));
	}
}

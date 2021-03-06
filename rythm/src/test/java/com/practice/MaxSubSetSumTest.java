package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.MaxSubSetSum;

public class MaxSubSetSumTest {

	@Test
	public void validTest() {
		MaxSubSetSum setObj = new MaxSubSetSum();
		Assert.assertTrue(Boolean.TRUE == setObj.isSubSetAvailable(new int[] { 2, 3, 5, 7, 8 }, 12));
		Assert.assertTrue(Boolean.TRUE == setObj.isSubSetAvailable(new int[] { 2, 3, 5, 6, 7, 8 }, 11));
		Assert.assertTrue(Boolean.TRUE == setObj.isSubSetAvailable(new int[] { 2, 3, 5, 7 }, 10));
		Assert.assertTrue(Boolean.FALSE == setObj.isSubSetAvailable(new int[] { 2, 5, 7 }, 10));
	}
}

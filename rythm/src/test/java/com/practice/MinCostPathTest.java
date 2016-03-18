package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.MinCostPath;

public class MinCostPathTest {

	@Test
	public void validTest() {
		MinCostPath minObj = new MinCostPath();
		int[][] input = new int[][] { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int min = minObj.minCost(input);
		Assert.assertTrue(min == 8);
		input = new int[][] { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
		min = minObj.minCost(input);
		Assert.assertTrue(min == 7);
	}
}

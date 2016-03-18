package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.FindNoInSortedArray;

public class FindNoInSortedArrayTest {

	@Test
	public void validTest1() {
		FindNoInSortedArray find = new FindNoInSortedArray();
		int[][] input = { { 10, 13, 18 }, { 12, 15, 20 }, { 17, 19, 22 } };
		Assert.assertTrue(find.isNumberExists(input, 17, 3, 3));
		int[][] input2 = { { 10, 13 }, { 12, 15 } };
		Assert.assertTrue(find.isNumberExists(input2, 12, 2, 2));
	}

	@Test
	public void validTest2() {
		FindNoInSortedArray find = new FindNoInSortedArray();
		int[][] input = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		Assert.assertTrue(find.isNumberExists(input, 10, 4, 4));
		Assert.assertTrue(find.isNumberExists(input, 25, 4, 4));
		Assert.assertTrue(find.isNumberExists(input, 29, 4, 4));
		Assert.assertTrue(find.isNumberExists(input, 39, 4, 4));
		Assert.assertTrue(find.isNumberExists(input, 50, 4, 4));
		Assert.assertFalse(find.isNumberExists(input, 44, 4, 4));
	}

}

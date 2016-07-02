package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.BinarySearchRecursive;

public class BinarySearchRecursiveTest {

	@Test
	public void validTest() {
		BinarySearchRecursive search = new BinarySearchRecursive();
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5 }, 5) == 1);
		Assert.assertTrue(search.isNoExistis(new int[] { 5 }, 5) == 0);
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5, 7 }, 5) == 1);
		Assert.assertTrue(search.isNoExistis(new int[] { 1, 2, 5, 9 }, 5) == 2);
	}

	@Test
	public void invalidTest() {
		BinarySearchRecursive search = new BinarySearchRecursive();
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5 }, 3) == -1);
		Assert.assertTrue(search.isNoExistis(new int[] { 5 }, 3) == -1);
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5, 7 }, 3) == -1);
		Assert.assertTrue(search.isNoExistis(new int[] { 1, 2, 5, 9 }, 3) == -1);
	}
}

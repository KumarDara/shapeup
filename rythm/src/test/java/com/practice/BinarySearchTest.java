package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.BinarySearch;

public class BinarySearchTest {

	@Test
	public void validTest() {
		BinarySearch search = new BinarySearch();
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5 }, 5) == 1);
		Assert.assertTrue(search.isNoExistis(new int[] { 5 }, 5) == 0);
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5, 7 }, 5) == 1);
		Assert.assertTrue(search.isNoExistis(new int[] { 1, 2, 5, 9 }, 5) == 2);
		Assert.assertTrue(search.isNoExistis(new int[] { 1, 2, 3, 4,5 }, 5) == 4);
		Assert.assertTrue(search.isNoExistis(new int[] { 1, 2, 3, 4,5 }, 2) == 1);
	}

	@Test
	public void invalidTest() {
		BinarySearch search = new BinarySearch();
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5 }, 3) == -1);
		Assert.assertTrue(search.isNoExistis(new int[] { 5 }, 3) == -1);
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5, 7 }, 3) == -1);
		Assert.assertTrue(search.isNoExistis(new int[] { 1, 2, 5, 9 }, 3) == -1);
	}
}

package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.BinarySearch;

public class BinarySearchTest {

	@Test
	public void validTest() {
		BinarySearch search = new BinarySearch();
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5 }, 5));
		Assert.assertTrue(search.isNoExistis(new int[] { 5 }, 5));
		Assert.assertTrue(search.isNoExistis(new int[] { 2, 5, 7 }, 5));
		Assert.assertTrue(search.isNoExistis(new int[] { 1, 2, 5, 9 }, 5));
	}

	@Test
	public void invalidTest() {
		BinarySearch search = new BinarySearch();
		Assert.assertFalse(search.isNoExistis(new int[] { 2, 5 }, 3));
		Assert.assertFalse(search.isNoExistis(new int[] { 5 }, 3));
		Assert.assertFalse(search.isNoExistis(new int[] { 2, 5, 7 }, 3));
		Assert.assertFalse(search.isNoExistis(new int[] { 1, 2, 5, 9 }, 3));
	}
}

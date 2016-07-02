package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.BinarySearch;
import com.practice.arrays.RotatedArraySearch;

public class RotatedArraySearchTest {

	@Test
	public void validTest() {
		RotatedArraySearch search = new RotatedArraySearch();
		Assert.assertTrue(search.search(new int[] { 2, 5 }, 5) == 1);
		Assert.assertTrue(search.search(new int[] { 5 }, 5) == 0);
		Assert.assertTrue(search.search(new int[] { 5, 7, 2 }, 2) == 2);
		Assert.assertTrue(search.search(new int[] { 1, 2, 5, 9 }, 5) == 2);
		Assert.assertTrue(search.search(new int[] { 2, 5, 9, 1 }, 1) == 3);
		Assert.assertTrue(search.search(new int[] { 6, 9, 1, 2, 3, 4, 5 }, 1) == 2);
	}

	@Test
	public void invalidTest() {
		RotatedArraySearch search = new RotatedArraySearch();
		Assert.assertTrue(search.search(new int[] { 2, 5 }, 3) == -1);
		Assert.assertTrue(search.search(new int[] { 5 }, 3) == -1);
		Assert.assertTrue(search.search(new int[] { 2, 5, 7 }, 3) == -1);
		Assert.assertTrue(search.search(new int[] { 1, 2, 5, 9 }, 3) == -1);
	}
}

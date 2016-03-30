package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.sort.BubbleSort;

public class SortTest {

	@Test
	public void bubbleSortTest() {
		BubbleSort sort = new BubbleSort();
		int[] input = new int[] { 3, 1, 4, 7, 5 };
		sort.sort(input);
		Assert.assertArrayEquals(new int[] { 1, 3, 4, 5, 7 }, input);
		input = new int[] { 1, 3, 4, 5, 7 };
		sort.improvedSort(input);
		Assert.assertArrayEquals(new int[] { 1, 3, 4, 5, 7 }, input);
		input = new int[] { 9 };
		sort.improvedSort(input);
		Assert.assertArrayEquals(new int[] { 9 }, input);
	}

}

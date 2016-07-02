package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.sort.BubbleSort;
import com.practice.sort.HeapSort;
import com.practice.sort.InsertionSort;
import com.practice.sort.MergeSort;
import com.practice.sort.QuickSort;
import com.practice.sort.SelectionSort;
import com.practice.sort.Sort;

public class SortTest {

	@Test
	public void bubbleSortTest() {
		BubbleSort sort = new BubbleSort();
		sortHelper(sort);
	}

	@Test
	public void selectionSortTest() {
		SelectionSort sort = new SelectionSort();
		sortHelper(sort);
	}
	
	@Test
	public void insertionSortTest() {
		InsertionSort sort = new InsertionSort();
		sortHelper(sort);
	}

	@Test
	public void mergeSortTest() {
		MergeSort sort = new MergeSort();
		sortHelper(sort);
	}
	
	@Test
	public void quickSortTest() {
		QuickSort sort = new QuickSort();
		sortHelper(sort);
	}
	
	@Test
	public void heapSortTest() {
		HeapSort sort = new HeapSort();
		sortHelper(sort);
	}

	private void sortHelper(Sort sortObj) {
		int[] input = new int[] { 3, 1, 2, 7, 15,14 };
		sortObj.sort(input);
		Assert.assertArrayEquals(new int[] { 1, 2,3, 7, 14, 15 }, input);
		input = new int[] { 1, 3, 4, 5, 7 };
		sortObj.sort(input);
		Assert.assertArrayEquals(new int[] { 1, 3, 4, 5, 7 }, input);
		input = new int[] { 9 };
		sortObj.sort(input);
		Assert.assertArrayEquals(new int[] { 9 }, input);
		input = new int[] { 9, 4 };
		sortObj.sort(input);
		Assert.assertArrayEquals(new int[] { 4, 9 }, input);
		input = new int[] { 7, 6,5,4,3,2,1 };
		sortObj.sort(input);
		Assert.assertArrayEquals(new int[] { 1,2,3,4,5,6,7 }, input);
	}
}

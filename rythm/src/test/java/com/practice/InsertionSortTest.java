package com.practice;

import org.junit.Test;

import com.practice.sort.InsertionSort;

public class InsertionSortTest {

	@Test
	public void validTest() {
		InsertionSort sort = new InsertionSort();
		int input[] = new int[Integer.MAX_VALUE / 10];
		for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
			input[i] = i;
		}
		long start = System.currentTimeMillis();
		int[] op = sort.sort(input);
		System.out.println("Execution time:" + (System.currentTimeMillis() - start));
		// Assert.assertArrayEquals(new int[] {1,2,3,4,5,6,9}, op);
	}
}

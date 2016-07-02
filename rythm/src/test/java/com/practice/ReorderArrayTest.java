package com.practice;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.ReorderArray;

public class ReorderArrayTest {

	@Test
	public void validTest() {
		ReorderArray re = new ReorderArray();
		int[] input = new int[] {2,3,5,7,9};
		re.reorder(input);
		System.out.println(Arrays.toString(input));
		Assert.assertArrayEquals(new int[]{2,5,3,9,7}, input);
		input = new int[] {2,3,0,1};
		re.reorder(input);
		System.out.println(Arrays.toString(input));
		Assert.assertArrayEquals(new int[]{2,3,0,1}, input);
	}
}

package com.practice;

import org.junit.Test;

import com.practice.arrays.RotateSingularArray;

public class RotateSingularArrayTest {

	@Test
	public void rotateValid() {
		RotateSingularArray rot = new RotateSingularArray();
		rot.rotate(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 3);

	}
}

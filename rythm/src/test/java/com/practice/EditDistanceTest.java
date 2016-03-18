package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.EditDistance;

public class EditDistanceTest {

	@Test
	public void validTest() {
		EditDistance edit = new EditDistance();
		Assert.assertTrue(2 == edit.maxEdits("abcde".toCharArray(), "acdf".toCharArray()));
		Assert.assertTrue(0 == edit.maxEdits("abc".toCharArray(), "abc".toCharArray()));
		Assert.assertTrue(3 == edit.maxEdits("abc".toCharArray(), "abcdef".toCharArray()));
	}
}

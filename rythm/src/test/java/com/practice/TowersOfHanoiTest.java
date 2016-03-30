package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.recursion.TowersOfHanoi;

public class TowersOfHanoiTest {

	@Test
	public void validTest() {
		TowersOfHanoi t = new TowersOfHanoi();
		int height = 3;
		for (int i = 1; i <= height; i++) {
			t.getFromStack().push(i);
		}
		t.moveTower(height, t.getFromStack(), t.getToStack(), t.getWithStack());
		Assert.assertTrue(t.getToStack().size() == height);
	}

}

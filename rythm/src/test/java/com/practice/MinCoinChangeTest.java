package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.MinCoinChange;

public class MinCoinChangeTest {

	@Test
	public void validTest() {
		MinCoinChange coin = new MinCoinChange();
		Assert.assertTrue(2 == coin.minNoofCoins(new int[] { 2, 3, 5, 6 }, 10));
	}

}

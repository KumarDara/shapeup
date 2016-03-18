package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.arrays.MaxCoinChange;

public class MaxCoinChangeTest {

	@Test
	public void validTest() {
		MaxCoinChange coin = new MaxCoinChange();
		Assert.assertTrue(0 == coin.minNoofCoins(new int[] { 5, 6 }, 7));
	}

}

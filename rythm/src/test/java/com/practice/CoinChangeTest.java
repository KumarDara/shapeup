package com.practice;

import org.junit.Test;

import com.practice.arrays.CoinChange;

public class CoinChangeTest {
	@Test
	public void validTest() {
		CoinChange change = new CoinChange();
		System.out.println(change.getMaxChange(new int[] { 7 }, 4));
		/*
		 * Assert.assertTrue(4 == change.getMaxChange(new int[]{1,2,3}, 4));
		 * Assert.assertTrue(7 == change.getMaxChange(new int[]{3,4,6,7,9},
		 * 15)); Assert.assertTrue(5 == change.getMaxChange(new int[]{2,3,5,6},
		 * 10));
		 */
		// change.printCoinChangingSolution(4, new int[]{2,3});
		// change.printCoinChangingSolution(15, new int[]{3,4,6,7,9});
	}

}

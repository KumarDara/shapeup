package com.practice;

import org.junit.Test;

import com.practice.arrays.KnapSack;

import junit.framework.Assert;

public class KnapSackTest {

	@Test
	public void validTest() {
		KnapSack knapObj = new KnapSack();
		int[] weights = new int[] {10,20,30};
		int[] values = new int[] {160,100,120};
		int maxWeight = 50;
		int cnt = knapObj.knapSack(weights, values, maxWeight);
		Assert.assertTrue(cnt == 280);
	}
	
	@Test
	public void validTestRec() {
		KnapSack knapObj = new KnapSack();
		int[] weights = new int[] {10,20,30};
		int[] values = new int[] {60,100,120};
		int maxWeight = 50;
		int cnt = knapObj.knapSackRecursive(weights, values, maxWeight, 3);
		Assert.assertTrue(cnt == 220);
	}
}

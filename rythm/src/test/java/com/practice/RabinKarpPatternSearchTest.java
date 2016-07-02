package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.strings.RabinKarpPatternSearch;

public class RabinKarpPatternSearchTest {

	@Test
	public void validTest() {
		RabinKarpPatternSearch search = new RabinKarpPatternSearch();
		String text = "abcdefghij";
		String pattern = "efg";
		int patIndex = search.getPatternIndex(text.toCharArray(), pattern.toCharArray());
		System.out.println("Patindx::"+patIndex);
		Assert.assertTrue(patIndex == 4);
		patIndex = search.getPatternIndex(text.toCharArray(), "hij".toCharArray());
		System.out.println("Patindx::"+patIndex);
		Assert.assertTrue(patIndex == 7);
		patIndex = search.getPatternIndex(text.toCharArray(), "hijk".toCharArray());
		System.out.println("Patindx::"+patIndex);
		Assert.assertTrue(patIndex == -1);
	}
}

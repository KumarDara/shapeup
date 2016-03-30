package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.matrices.RowWiseColWiseSortSearch;

public class RowWiseColWiseSortSearchTest {

	@Test
	public void validTest() {
		RowWiseColWiseSortSearch obj = new RowWiseColWiseSortSearch();
		int[][] input = {{10,13,17,21},{14,16,19,24},{17,20,23,27},{21,25,29,35}};
		Assert.assertTrue(Boolean.TRUE == obj.isAvailable(input, 23));
	}
	
	@Test
	public void invalidTest() {
		RowWiseColWiseSortSearch obj = new RowWiseColWiseSortSearch();
		int[][] input = {{10,13,17,21},{14,16,19,24},{17,20,23,27},{21,25,29,35}};
		Assert.assertTrue(Boolean.FALSE == obj.isAvailable(input, 12));
	}
}

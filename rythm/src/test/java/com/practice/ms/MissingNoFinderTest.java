package com.practice.ms;

import org.junit.Assert;
import org.junit.Test;

public class MissingNoFinderTest {

	@Test
	public void validTest() {
		MissingNoFinder finder = new MissingNoFinder();
		int missingNo = finder.getMinssingNo(new int[]{1,2,4,5}, 5);
		Assert.assertTrue(missingNo == 3);
		missingNo = finder.getMinssingNo(new int[]{1,2,3,4,5,6,7}, 8);
		Assert.assertTrue(missingNo == 8);
	}
}

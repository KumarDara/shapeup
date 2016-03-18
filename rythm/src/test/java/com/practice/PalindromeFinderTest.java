package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.util.PalindromeFinder;

public class PalindromeFinderTest {

	@Test
	public void validTest() {
		PalindromeFinder finder = new PalindromeFinder();
		Assert.assertTrue(finder.isPalindrome("abcba"));
		Assert.assertTrue(finder.isPalindrome("aca"));
		Assert.assertTrue(finder.isPalindrome("abba"));
		Assert.assertTrue(finder.isPalindrome("abcddcba"));
	}

	@Test
	public void invalidTest() {
		PalindromeFinder finder = new PalindromeFinder();
		Assert.assertFalse(finder.isPalindrome("abcdba"));
		Assert.assertFalse(finder.isPalindrome("acda"));
		Assert.assertFalse(finder.isPalindrome("abahba"));
		Assert.assertFalse(finder.isPalindrome("abcddvdcba"));
	}
}

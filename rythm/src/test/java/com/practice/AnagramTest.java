package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.strings.Anagram;

public class AnagramTest {

	@Test
	public void validTest() {
		Anagram ana = new Anagram();
		Assert.assertTrue(ana.isAnagram("abcd", "badc"));
		Assert.assertTrue(ana.isAnagram("abcde", "ebadc"));
		Assert.assertFalse(ana.isAnagram("abcd", "ebadc"));
		Assert.assertFalse(ana.isAnagram("abcdi", "ebadc"));
	}
}

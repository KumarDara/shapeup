package com.practice;

import org.junit.Test;

import com.practice.strings.RemoveSpacesFromString;

import junit.framework.Assert;

public class RemoveSpacesFromStringTest {

	@Test
	public void validTest() {
		RemoveSpacesFromString str = new RemoveSpacesFromString();
		Assert.assertEquals("abcdekiop", str.removeSpaces("abc de  k i   op  "));
		Assert.assertEquals("", str.removeSpaces("   "));
	}
}

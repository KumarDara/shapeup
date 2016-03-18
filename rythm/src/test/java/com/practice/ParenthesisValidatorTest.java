package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.paranthesis.ParenthesisValidator;

public class ParenthesisValidatorTest {

	@Test
	public void validTest1() {
		ParenthesisValidator pr = new ParenthesisValidator();
		Assert.assertTrue(pr.validate("{{}}"));
	}

	@Test
	public void validTest2() {
		ParenthesisValidator pr = new ParenthesisValidator();
		Assert.assertTrue(pr.validate("c{a{b}ddd}"));
	}

	@Test
	public void validTest3() {
		ParenthesisValidator pr = new ParenthesisValidator();
		Assert.assertTrue(pr.validate("1{}s{{d}}c{}"));
	}

	@Test
	public void invalidTest1() {
		ParenthesisValidator pr = new ParenthesisValidator();
		Assert.assertFalse(pr.validate("{{{}}"));
	}

	@Test
	public void invalidTest2() {
		ParenthesisValidator pr = new ParenthesisValidator();
		Assert.assertFalse(pr.validate("{a}}"));
	}

	@Test
	public void invalidTest3() {
		ParenthesisValidator pr = new ParenthesisValidator();
		Assert.assertFalse(pr.validate("a{}b{"));
	}

}

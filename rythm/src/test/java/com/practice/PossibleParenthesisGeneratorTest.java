package com.practice;

import org.junit.Test;

import com.practice.paranthesis.PossibleParenthesisGenerator;

public class PossibleParenthesisGeneratorTest {

	@Test
	public void validTest1() {
		PossibleParenthesisGenerator gen = new PossibleParenthesisGenerator();
		gen.print(3);
	}
}

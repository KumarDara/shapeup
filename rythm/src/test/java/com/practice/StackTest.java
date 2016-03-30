package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.custom.Stack;

public class StackTest {

	@Test
	public void validTest() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack);
		Assert.assertTrue(3 == stack.pop());
		System.out.println(stack);
		Assert.assertTrue(2 == stack.peek());
		System.out.println(stack);
		Assert.assertTrue(2 == stack.pop());
		System.out.println(stack);
		Assert.assertTrue(1 == stack.pop());
		System.out.println(stack);
	}
}

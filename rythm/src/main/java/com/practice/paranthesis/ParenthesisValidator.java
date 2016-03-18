package com.practice.paranthesis;

import java.util.Stack;

public class ParenthesisValidator {

	public boolean validate(String input) {
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '{') {
				stack.push("{");
			} else if (input.charAt(i) == '}') {
				if (stack.size() > 0) {
					stack.pop();
				} else {
					return false;
				}

			}
		}
		if (stack.empty()) {
			return true;
		}
		return false;
	}
}

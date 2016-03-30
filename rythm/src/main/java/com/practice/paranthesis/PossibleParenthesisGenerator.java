package com.practice.paranthesis;

public class PossibleParenthesisGenerator {

	private void par(int open, int closed, String str) {

		if (closed == 0) {
			System.out.println(str);
			return;
		}

		if (open > 0) {
			par(open - 1, closed, str + "{");
		}

		if (closed > open) {
			par(open, closed - 1, str + "}");
		}
	}

	public void print(int n) {

		par(n, n, "");

	}

}

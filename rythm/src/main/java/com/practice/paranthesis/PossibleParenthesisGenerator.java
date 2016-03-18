package com.practice.paranthesis;

public class PossibleParenthesisGenerator {

	private void par(int n, int open, int closed, String str) {

		if (closed == n) {
			System.out.println(str);
			return;
		}

		if (open < n) {
			par(n, open + 1, closed, str + "{");
		}

		if (closed < open) {
			par(n, open, closed + 1, str + "}");
		}
	}

	public void print(int n) {

		par(n, 0, 0, "");

	}

}

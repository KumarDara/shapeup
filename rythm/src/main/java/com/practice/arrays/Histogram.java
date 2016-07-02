package com.practice.arrays;

import java.util.Stack;

public class Histogram {

	public int getLargestRectangleArea(int[] input) {
		if (input != null) {
			int maxArea = 0;
			int i = 0;
			Stack<Integer> stack = new Stack<Integer>();

			while (i < input.length) {
				if (stack.isEmpty() || input[stack.peek()] <= input[i]) {
					stack.push(i);
					i++;
				} else {
					int top = stack.pop();
					int area = input[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
					if (maxArea < area) {
						maxArea = area;
					}
				}
			}
			while (!stack.isEmpty()) {
				int top = stack.pop();
				int area = input[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if (maxArea < area) {
					maxArea = area;
				}
			}
			return maxArea;
		}
		return -1;
	}

	public static void main(String[] args) {
		Histogram hist = new Histogram();
		System.out.println(hist.getLargestRectangleArea(new int[] {6, 2, 5, 4, 5, 2, 6}));

	}
}

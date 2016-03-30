package com.practice.recursion;

import java.util.Stack;

public class TowersOfHanoi {
	private Stack<Integer> fromStack = new Stack<>();
	private Stack<Integer> toStack = new Stack<>();
	private Stack<Integer> withStack = new Stack<>();

	public Stack<Integer> getFromStack() {
		return fromStack;
	}

	public void setFromStack(Stack<Integer> fromStack) {
		this.fromStack = fromStack;
	}

	public Stack<Integer> getToStack() {
		return toStack;
	}

	public void setToStack(Stack<Integer> toStack) {
		this.toStack = toStack;
	}

	public Stack<Integer> getWithStack() {
		return withStack;
	}

	public void setWithStack(Stack<Integer> withStack) {
		this.withStack = withStack;
	}

	public void moveTower(int height, Stack<Integer> fromTower, Stack<Integer> toTower, Stack<Integer> withTower) {

		if (height >= 1) {
			moveTower(height - 1, fromTower, withTower, toTower);
			System.out.println("Before Move from:" + fromTower + "  to:" + toTower);
			toTower.push(fromTower.pop());
			System.out.println("After Move from:" + fromTower + "  to:" + toTower);

			moveTower(height - 1, withTower, toTower, fromTower);
		}
	}
}

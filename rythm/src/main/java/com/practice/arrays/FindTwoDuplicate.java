package com.practice.arrays;

import com.practice.util.Factorial;

public class FindTwoDuplicate {
	private int[] input = { 8, 5, 4, 5, 2, 3, 1, 6, 7, 8 };
	private int noOfElements = 8;

	public int[] findDuplicates() {
		long expectedSum = (noOfElements * (noOfElements + 1)) / 2;
		long expectedMul = Factorial.calculateFactorial(noOfElements);
		long sum = 0;
		long mul = 1;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			mul *= input[i];
		}
		int extraSum = (int) (sum - expectedSum);
		int extraMul = (int) (mul / expectedMul);
		int extraSub = (int) Math.sqrt((double) ((extraSum * extraSum) - (4 * extraMul)));
		int x = (extraSum + extraSub) / 2;
		int y = (extraSum - extraSub) / 2;
		return new int[] { x, y };
	}

	public static void main(String[] args) {
		/*
		 * FindTwoDuplicate find = new FindTwoDuplicate(); int[] dup =
		 * find.findDuplicates(); System.out.println("Duplicates are:"
		 * +dup[0]+","+dup[1]);
		 */
		System.out.println(Factorial.calculateFactorial(65));
	}
}

package com.practice.util;

public class Factorial {
	public static long calculateFactorial(int n) {
		if (n <= 1) {
			return 1;
		}
		// return n * calculateFactorial(n-1);
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
			if (result == 0) {
				System.out.println("i:::" + i);
				break;
			}
		}
		return result;
	}
}

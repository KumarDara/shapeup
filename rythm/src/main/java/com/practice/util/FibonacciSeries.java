package com.practice.util;

public class FibonacciSeries {

	public void printFibonacci(int seriesLength) {
		int x = 0;
		int y = 1;
		System.out.print(x + "," + y);
		for (int i = 0; i < seriesLength - 2; i++) {
			int tmp = x + y;
			System.out.print("," + tmp);
			x = y;
			y = tmp;
		}
	}
}

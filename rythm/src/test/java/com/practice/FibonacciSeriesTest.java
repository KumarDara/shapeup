package com.practice;

import org.junit.Test;

import com.practice.util.FibonacciSeries;

public class FibonacciSeriesTest {

	@Test
	public void validTest() {
		FibonacciSeries fib = new FibonacciSeries();
		fib.printFibonacci(15);
	}
}

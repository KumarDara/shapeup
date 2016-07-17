package com.test.oom;

public class ArraySizeExceedsError {

	public static void main(String[] args) {
		for (int i = 24; i >= 0; i--) {
			try {
				int[] arr = new int[Integer.MAX_VALUE/(16+i)];
				System.out.format("Successfully initialized an array with %,d elements.\n", Integer.MAX_VALUE/(14+i));
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}
}

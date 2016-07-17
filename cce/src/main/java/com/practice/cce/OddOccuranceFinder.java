package com.practice.cce;

public class OddOccuranceFinder {

	public static int oddOccurant(int[] input) {
		if (input != null) {
			int odd = 0;
			for (int i = 0; i < input.length; i++) {
				odd = odd ^ input[i];
			}
			if(odd == 0) {
				return -1;
			} else {
				return odd;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(oddOccurant(new int[]{1,2,3,4,4,3,2,1}));
		System.out.println(oddOccurant(new int[]{1,2,3,4,2,1,4,3}));
		System.out.println(oddOccurant(new int[]{1,2,3,4,4,3,2,1,6,5,7,6,6,7,6}));
	}
}

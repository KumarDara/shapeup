package com.practice.cce;

import com.test.sort.MergeSort;

public class NumbersSumInArray {
	
	public static boolean isSumExists(int[] input, int sum) {
		if(input != null) {
			MergeSort sort = new MergeSort();
			sort.sort(input);
			int i=0;
			int j=input.length-1;
			while(i<j) {
				int tmp = input[i] + input[j] ;
				if(tmp== sum) {
					return true;
				} else if( tmp < sum) {
					i++;
				} else {
					j--;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isSumExists(new int[]{1,9,3,4,5,6}, 14));
		System.out.println(isSumExists(new int[]{1,9,3,4,6}, 14));
		System.out.println(isSumExists(new int[]{1,5}, 3));
		System.out.println(isSumExists(new int[]{9}, 3));
		System.out.println(isSumExists(new int[]{1,5}, 6));
	}
}

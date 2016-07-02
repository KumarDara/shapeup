package com.practice.arrays;

public class MajorityNumber {

	public static int getMajorityNumber(int[] input) {
		int no = 0;
		int count  = 0;
		for(int i=0; i<input.length; i ++) {
			if(count == 0) {
				no = input[i];
				count = 1;
			} else {
				if(no == input[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		return count <= 0 ? 0 : no;
	}
	
	public static void findDuplicates(int[] input) {
		for(int i=0; i< input.length; i++) {
			if(input[Math.abs(input[i])] >= 0) {
				input[Math.abs(input[i])] = -input[Math.abs(input[i])];
			} else {
				System.out.println(Math.abs(input[i]));
			}
		}
	}
	public static void main(String[] args) {
		findDuplicates(new int[] {1, 2, 3, 1, 3, 6, 5});
	}
}

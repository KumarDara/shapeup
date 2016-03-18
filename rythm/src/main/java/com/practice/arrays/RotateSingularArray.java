package com.practice.arrays;

public class RotateSingularArray {

	public void rotate(int[] input, int noofrotations) {
		int[] tmpArr = new int[noofrotations];
		for (int i = 0; i < noofrotations; i++) {
			tmpArr[i] = input[i];
		}
		int len = input.length;
		int tmpArrIndx = 0;
		for (int j = 0; j < len; j++) {

			if (j >= len - noofrotations) {
				input[j] = tmpArr[tmpArrIndx];
				tmpArrIndx++;
			} else {
				input[j] = input[noofrotations + j];
			}
		}

		for (int j = 0; j < len; j++) {
			System.out.print(input[j] + ", ");
		}
	}

}

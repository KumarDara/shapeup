package com.practice.arrays;

import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static void deleteElements() {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		int retainTo = in.nextInt();
		int deleteTo = in.nextInt();
		String[] inputStrArr = input.split(",");
		int expectedArrLen = deleteHelper(inputStrArr, retainTo, deleteTo);
		int[] inputIntArr = getIntArr(inputStrArr, retainTo, deleteTo, expectedArrLen);
		displayHelper(inputIntArr);
		Collections c;
	}

	static int deleteHelper(String[] inputStrArr, int retainTo, int deleteTo) {
		int retainIncr = 0;
		int deleteIncr = 1;

		int j = 0;
		for (int i = 0; i < inputStrArr.length; i++) {
			if (retainIncr == retainTo) {

				if (deleteIncr == deleteTo) {
					retainIncr = 0;
					deleteIncr = 1;
				} else {
					deleteIncr++;
				}

			} else {

				j++;
				retainIncr++;
			}

		}
		return j;
	}

	static int[] getIntArr(String[] inputStrArr, int retainTo, int deleteTo, int expectedLen) {
		int retainIncr = 0;
		int deleteIncr = 1;
		int[] inputIntArr = new int[expectedLen];
		int j = 0;
		for (int i = 0; i < inputStrArr.length; i++) {
			if (retainIncr == retainTo) {

				if (deleteIncr == deleteTo) {
					retainIncr = 0;
					deleteIncr = 1;
				} else {
					deleteIncr++;
				}

			} else {
				inputIntArr[j] = Integer.parseInt(inputStrArr[i]);
				j++;
				retainIncr++;
			}

		}
		return inputIntArr;
	}

	static void displayHelper(int[] inputIntArr) {
		for (int i = 0; i < inputIntArr.length; i++) {
			System.out.print(inputIntArr[i]);
			if (i < inputIntArr.length - 1) {
				System.out.print(",");
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		deleteElements();

	}

}

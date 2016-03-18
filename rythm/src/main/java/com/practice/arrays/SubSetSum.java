package com.practice.arrays;

public class SubSetSum {

	public boolean isSubSetAvailable(int[] input, int sum) {
		boolean availableFlag = false;
		boolean[][] possibleArr = new boolean[input.length + 1][sum + 1];
		for (int i = 0; i < possibleArr.length; i++) {
			possibleArr[i][0] = true;
		}
		int possibleI = 0;
		int possibleJ = sum;
		for (int i = 1; i <= input.length; i++) {
			if (availableFlag) {
				break;
			}
			for (int j = 1; j <= sum; j++) {
				if (input[i - 1] <= j) {
					possibleArr[i][j] = possibleArr[i - 1][j - input[i - 1]];
				} else {
					possibleArr[i][j] = possibleArr[i - 1][j];
				}
				if (j == sum && possibleArr[i][j]) {
					possibleI = i;
					availableFlag = true;
				}
			}
		}
		System.out.println((availableFlag ? "Subset" : "Subset Not") + " Found");
		int breaker = sum;
		while (possibleI > 0 && possibleJ > 0) {
			int no = input[possibleI - 1];
			System.out.println(no);
			if (possibleArr[possibleI - 1][possibleJ]) {
				possibleI--;
			} else {
				possibleI--;
				possibleJ = possibleJ - no;
			}
			if (breaker - no == 0) {
				break;
			}
			breaker = breaker - no;
		}
		return availableFlag;
	}
}

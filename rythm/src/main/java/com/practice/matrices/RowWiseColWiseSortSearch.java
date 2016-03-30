package com.practice.matrices;

public class RowWiseColWiseSortSearch {

	public boolean isAvailable(int[][] input, int no) {
		boolean found = false;
		int i = input.length - 1;
		int j = input[0].length - 1;
		if (no < input[0][0] || no > input[i][j]) {
			return false;
		}

		j = 0;
		while (i >= 0 && j < input[0].length) {
			// started from bottom left
			if (no == input[i][j]) {
				found = true;
				break;
			}

			if (no > input[i][j]) {
				// no is greater than bottom left element so verify in the next
				// column
				j++;
			} else {
				// no is less than bottom left element so verify in the before
				// row
				i--;
			}
		}
		return found;
	}

}

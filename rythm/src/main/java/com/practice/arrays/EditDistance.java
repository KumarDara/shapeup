package com.practice.arrays;

public class EditDistance {

	public int maxEdits(char[] str1, char[] str2) {
		int[][] tmp = new int[str1.length + 1][str2.length + 1];
		for (int i = 0; i < tmp[0].length; i++) {
			tmp[0][i] = i;
		}
		for (int i = 0; i < tmp.length; i++) {
			tmp[i][0] = i;
		}
		for (int i = 1; i < tmp.length; i++) {
			for (int j = 1; j < tmp[0].length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					tmp[i][j] = tmp[i - 1][j - 1];
				} else {
					tmp[i][j] = Math.min(tmp[i][j - 1], Math.min(tmp[i - 1][j - 1], tmp[i - 1][j])) + 1;
				}
			}
		}
		printEdits(tmp, str1, str2);
		return tmp[str1.length][str2.length];
	}

	public void printEdits(int[][] tmp, char[] str1, char[] str2) {
		int i = tmp.length - 1;
		int j = tmp[0].length - 1;
		while (i > 0 && j > 0) {
			if (str1[i - 1] == str2[j - 1]) {
				i = i - 1;
				j = j - 1;
			} else if (tmp[i][j] == tmp[i - 1][j - 1] + 1) {
				System.out.println("Edit " + str1[i - 1] + " in string1 to " + str2[j - 1] + " in string2");
				i = i - 1;
				j = j - 1;
			} else if (tmp[i][j] == tmp[i - 1][j] + 1) {
				System.out.println("Delete in string1 " + str1[i - 1]);
				i = i - 1;
			} else if (tmp[i][j] == tmp[i][j - 1] + 1) {
				System.out.println("Add in string1 " + str2[j - 1]);
				j = j - 1;
			}
		}
	}
}

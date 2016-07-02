package com.practice.strings;

public class RabinKarpPatternSearch {
	private static final int prime = 101;

	public int getPatternIndex(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;
		long txtHash = getHash(text, m);
		long patternHash = getHash(pattern, m);
		for (int i = 0; i < n - m + 1; i++) {
			if (txtHash == patternHash && checkEqual(text, i, i + m, pattern, 0, m)) {
				return i;
			}
			txtHash = reHash(text, i, i + m, m, txtHash);
		}
		return -1;
	}

	private boolean checkEqual(char[] text, int start1, int end1, char[] pattern, int start2, int end2) {
		if (end1 - start1 != end2 - start2) {
			return false;
		}
		while (start1 < end1 && start2 < end2) {
			if (text[start1] != pattern[start2]) {
				return false;
			}
			start1++;
			start2++;
		}
		return true;
	}

	private long reHash(char[] text, int oldIndex, int newIndex, int patternLen, long oldHash) {
		long newHash = oldHash - text[oldIndex];
		newHash = newHash/prime;
		newHash += text[newIndex] * Math.pow(prime, patternLen-1);
		return newHash;
	}

	private long getHash(char[] input, int length) {
		long hash = 0;
		for (int i = 0; i < length; i++) {
			hash += input[i] * Math.pow(prime, i);
		}
		return hash;
	}
}

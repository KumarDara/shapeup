package com.practice.util;

public class PalindromeFinder {

	public boolean isPalindrome(String input) {
		int start = 0;
		int end = input.length() - 1;
		while (start < end) {
			if (input.charAt(start) != input.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}

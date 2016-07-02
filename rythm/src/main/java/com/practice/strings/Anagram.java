package com.practice.strings;

public class Anagram {

	/**
	 * Helps to find whether both strings are anagrams or not
	 * 
	 * @param firstStr
	 * @param secondStr
	 * @return
	 */
	public boolean isAnagram(String firstStr, String secondStr) {
		if (firstStr == null || secondStr == null || firstStr.length() != secondStr.length()) {
			return Boolean.FALSE;
		}
		if (firstStr.equals(secondStr)) {
			return Boolean.TRUE;
		}
		// counter to hold the count of each character in the string
		int[] counter = new int[128];

		for (int i = 0; i < firstStr.length(); i++) {
			int ascii = firstStr.charAt(i);
			// incrementing the current value of the counter for this character
			counter[ascii] = counter[ascii] + 1;
		}
		for (int i = 0; i < secondStr.length(); i++) {
			int ascii = secondStr.charAt(i);
			// the current character not exists in first string so they are not
			// anagrams
			if (counter[ascii] == 0) {
				return Boolean.FALSE;
			}
			// decrementing the current value of the counter for this character
			counter[ascii] = counter[ascii] - 1;
		}
		for (int i = 0; i < 128; i++) {
			// if any of the character count is +ve meaning it is not exists in
			// the second string
			if (counter[i] != 0) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
}

package com.practice.crack;

public class IsUniqueString {

	public boolean isUnique(String str) {
		if (str == null || str.length() > 128) {
			// max we can have 128 unique characters in string if it is
			// exceeding 128 then it has duplicates
			return Boolean.FALSE;
		}
		boolean[] charPresent = new boolean[128];
		for (int indx = 0; indx < str.length(); indx++) {
			int charAscii = str.charAt(indx);
			if (charPresent[charAscii]) {
				// if the same character already present then confirm it is not
				// an unique string
				return Boolean.FALSE;
			}
			// updating the array to represent the character is present
			charPresent[charAscii] = Boolean.TRUE;
		}
		return Boolean.TRUE;
	}
}

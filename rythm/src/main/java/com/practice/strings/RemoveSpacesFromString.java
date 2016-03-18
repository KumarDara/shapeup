package com.practice.strings;

public class RemoveSpacesFromString {

	public String removeSpaces(String input) {
		StringBuilder bldr = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				bldr.append(input.charAt(i));
			}
		}
		return bldr.toString();
	}

}

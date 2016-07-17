package com.practice.cce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MorseMatch {
	private static Map<Character, String> morseKeys = new HashMap<Character, String>(36);
	private static Map<String, List<String>> dictionary = new HashMap<String, List<String>>();
	private static final int MAX_LEN = 80;

	public static void registerKeys(Character key, String val) {
		morseKeys.put(key, val);
	}

	public static String encode(String key) {
		if (key != null) {
			StringBuilder bldr = new StringBuilder();
			for (int i = 0; i < key.length(); i++) {
				bldr.append(morseKeys.get(key.charAt(i)));
			}
			return bldr.toString();
		}
		return null;
	}

	public static void addWord(String key, String value) {
		if (dictionary.get(key) == null) {
			dictionary.put(key, new ArrayList<String>());
		}
		dictionary.get(key).add(value);
	}

	public static void decode(String key) {
		if (key != null && key.length() > 0) {
			String[] words = key.split(" ");
			StringBuilder value = new StringBuilder();
			for (String word : words) {
				word = word.trim();
				if (word.length() > 0) {
					List<String> matchedWords = getMatches(word);
					if (matchedWords != null) {
						if (matchedWords.size() == 1) {
							value.append(matchedWords.get(0));
						} else if (matchedWords.size() > 1) {
							List<String> smallestSameLenMatches = getSmallestSameLenMatches(matchedWords);
							value.append(smallestSameLenMatches.get(0));
							if (smallestSameLenMatches.size() > 1) {
								value.append("!");
							}
						}
					} else {
						String match = findBestMatch(word);
						value.append(match).append("?");
					}
					value.append(" ");
				}
			}
			System.out.println("Key: " + key + " Value:" + value.toString().trim());
		}
	}

	public static List<String> getMatches(String word) {
		return dictionary.get(word);
	}

	public static List<String> getSmallestSameLenMatches(List<String> matches) {
		int smallestLen = MAX_LEN;
		List<String> smallestSameLenMatches = new ArrayList<String>();
		for (String match : matches) {
			if (match.length() == smallestLen) {
				smallestSameLenMatches.add(match);
			} else if (match.length() < smallestLen) {
				smallestSameLenMatches.clear();
				smallestSameLenMatches.add(match);
				smallestLen = match.length();
			}
		}
		return smallestSameLenMatches;
	}

	public static String findBestMatch(String word) {
		String longestMatch = null;
		int longestMatchLen = 0;
		for (String morse : dictionary.keySet()) {
			int len = findLengthOfMatchingMorse(morse, word);
			if (len > longestMatchLen) {
				longestMatch = morse;
				longestMatchLen = len;
				System.out.println("Possible:::" + dictionary.get(longestMatch));
			}
		}
		return dictionary.get(longestMatch) == null ? "" : dictionary.get(longestMatch).get(0);
	}

	public static int findLengthOfMatchingMorse(String morse, String input) {
		int maxLen = 0;
		for (int i = 0; i < input.length() && i < morse.length(); i++) {
			if (input.charAt(i) == morse.charAt(i)) {
				maxLen++;
			} else {
				break;
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in);) {

			String key = null;
			while (!(key = scan.next().trim()).equals("*")) {
				String value = scan.next();
				registerKeys(key.charAt(0), value);
			}

			while (!(key = scan.next().trim()).equals("*")) {
				String value = encode(key);
				addWord(value, key);
			}

			while (!(key = scan.nextLine().trim()).equals("*")) {
				decode(key);
			}
			// System.out.println("Morsekeys:"+morseKeys);
			System.out.println("Dictionary:" + dictionary);
		} finally {

		}
	}

}

/*
 * A .- B -... C -.-. D -.. E . F ..-. G --. H .... I .. J .--- K -.- L .-.. M
 * -- N -. O --- P .--. Q --.- R .-. S ... T - U ..- V ...- W .-- X -..- Y -.--
 * Z --.. 0 ------ 1 .----- 2 ..--- 3 ...-- 4 ....- 5 ..... 6 -.... 7 --... 8
 * ---.. 9 ----.
 *
 * AN EARTHQUAKE EAT GOD HATH IM READY TO WHAT WROTH
 *
 * .--.....-- .....--.... --.----.. .--.-.----.. .--.....-- .--.
 * ..-.-.-....--.-..-.--.-. ..-- .-...--..-.-- ---- ..-- .-. ..-
 *
 */
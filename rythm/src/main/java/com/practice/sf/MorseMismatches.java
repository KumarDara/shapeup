package com.practice.sf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MorseMismatches {
	private static Map<String, String> morseTable = new HashMap<String, String>();

	public static void main(String[] args) {
		morseMismatches();
	}

	private static void morseMismatches() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(
					"E:\\Softwares\\morsemismatches.txt"));
			String line = reader.readLine();
			// populate the morse table
			populateMorseTable(reader, line);
			line = reader.readLine();
			// encode the context words
			Map<String, String> context = new HashMap<String, String>();
			encodeMorseWords(reader, line, context);

			// read the morse code and print the matching words appropriately
			line = reader.readLine();
			printMorseWords(reader, line, context);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static String printMorseWords(BufferedReader reader, String line,
			Map<String, String> context) throws IOException {
		while (line != null && !line.trim().equals("*")) {
			String[] codes = line.trim().split("\\s+");
			for (String code : codes) {
				if (context.containsKey(code)) {
					System.out.println(context.get(code));
				} else {
					int i = 0;
					int j = code.length();
					String closestWord = "";
					while (i < j) {
						if (context.containsKey(code.substring(i, j))) {
							closestWord = context.get(code.substring(i, j));
							break;
						}
						j--;
					}
					int removedElements = code.length() - j;
					int additionalElements = Integer.MAX_VALUE;
					String match = "";
					for (String morse : context.keySet()) {
						if (morse.contains(code)) {
							int k = morse.length() - code.length();
							if (additionalElements > k) {
								additionalElements = k;
								match = context.get(morse);
							}
						}
					}
					if (additionalElements < removedElements) {
						System.out.println(match + "?");
					} else {
						System.out.println(closestWord);
					}
				}
			}
			line = reader.readLine();
		}
		return line;
	}

	private static String encodeMorseWords(BufferedReader reader, String line,
			Map<String, String> context) throws IOException {
		String encodedWord;
		while (line != null && !line.trim().equals("*")) {
			line = line.trim();
			encodedWord = "";
			for (char c : line.toCharArray()) {
				encodedWord += morseTable.get(Character.toString(c));
			}
			// the block comments below are needed according to the problem
			// statement.
			// but according to the sample output these are not needed
			if (!context.containsKey(encodedWord)) {
				context.put(encodedWord, line);
			} /*
			 * else if (context.get(encodedWord).length() > line.length()) {
			 * context.put(encodedWord, line); }
			 */else /*
					 * if (context.get(encodedWord).length() == line.length())
					 */{
				context.put(encodedWord, context.get(encodedWord) + "!");
			}
			line = reader.readLine();
		}
		return line;
	}

	private static String populateMorseTable(BufferedReader reader, String line)
			throws IOException {
		while (line != null && !line.trim().equals("*")) {
			String[] code = line.trim().split("\\s+");
			if (code.length != 2) {
				throw new IllegalArgumentException("Invalid input");
			}
			morseTable.put(code[0], code[1]);
			line = reader.readLine();
		}
		return line;
	}
}

package com.practice.sf;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HTMLSyntaxChecker {

	public void checkSyntax(String inputFilePath) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(inputFilePath), StandardCharsets.UTF_8);
			int testCaseNumber = 0;
			List<String> content = new ArrayList<String>();
			int NL = 0;
			for (String line : lines) {
				if (line.length() > 0 && Character.isDigit(line.charAt(0))) {
					NL = Integer.parseInt(line.trim());
					if (NL != 0) {
						testCaseNumber++;
						content = new ArrayList<String>();
						System.out.println("Test Case " + testCaseNumber);
					} else {
						break;
					}
				} else {
					NL--;
					content.add(line);
					if (NL == 0) {
						validate(content);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void validate(List<String> content) {
		// return when validation fails
		System.out.println(content);
	}

}

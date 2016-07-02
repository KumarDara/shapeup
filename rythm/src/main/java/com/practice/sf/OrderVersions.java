package com.practice.sf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderVersions {

	public static void main(String[] args) {
		List<String> versions = new ArrayList<String>();
		versions.add("1.1.0");
		versions.add("1.1.0.1");
		versions.add("2.1");
		versions.add("0.1.1");
		versions.add("0.1.1");
		versions.add("0.0.1.1");
		versions.add("1.2.23.4");
		versions.add("1.2.3.1");
		Collections.sort(versions, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] version1Tokens = o1.split("\\.");
				String[] version2Tokens = o2.split("\\.");
				int i = 0;
				for (i = 0; i < version1Tokens.length; i++) {
					if (i == version2Tokens.length) {
						return 1;
					} else if (!version1Tokens[i].equals(version2Tokens[i])) {
						int version1Int = Integer.parseInt(version1Tokens[i]);
						int version2Int = Integer.parseInt(version2Tokens[i]);
						if (version1Int > version2Int) {
							return 1;
						} else if (version1Int < version2Int) {
							return -1;
						}
					}
				}

				if (version2Tokens.length == i) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		System.out.println(versions);
	}

}

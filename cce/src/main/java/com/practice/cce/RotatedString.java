package com.practice.cce;

public class RotatedString {

	public static boolean isRotatedString(String str1, String str2) {
		if(str1 != null && str2 != null) {
			if(str1.length() != str2.length()) {
				return false;
			}
			String tmpStr1 = str1 + str1;
			boolean isPart = tmpStr1.indexOf(str2) != -1;
			return isPart;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isRotatedString("abcd", "bcda"));
		System.out.println(isRotatedString("abcd", "bcdab"));
		System.out.println(isRotatedString("abcd", "acdb"));
	}
}

package com.practice.strings;

public class KMPPatternSearch {

	public int getPatternIndex(char[] text, char[] pattern) {
		int[] lpsArr = getLargestPrefixSuffixArr(pattern);
		int indx = getIndex(text,pattern,lpsArr);
		return indx;
	}
	
	private int[] getLargestPrefixSuffixArr(char[] pattern) {
		int[] lps = new int[pattern.length];
		int j=0;
		int i=1;
		while(i<pattern.length) {
			if(pattern[i] == pattern[j]) {
				lps[i] = j+1;
				j++;
				i++;
			} else {
				if(j != 0) {
					j = lps[j-1];
				} else {
					i++;
				}
			}
		}
		return lps;
	}
	
	private int getIndex(char[] text, char[] pattern, int[] lpsArr) {
		int i=0,j=0;
		while(i<text.length) {
			if(text[i]== pattern[j]) {
				i++;
				j++;
				if(j == pattern.length) {
					return i-j;
				}
			} else {
				if(j!=0) {
					j = lpsArr[j-1];
				} else {
					i++;
				}
			}
		}
		return -1;
	}
}

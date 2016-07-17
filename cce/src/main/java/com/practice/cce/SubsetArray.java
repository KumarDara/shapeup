package com.practice.cce;

import java.util.Arrays;

import com.test.sort.BinarySearch;
import com.test.sort.MergeSort;

public class SubsetArray {

	public static boolean isSubset(int[] mainArr, int[] secondaryArr) {
		if (mainArr != null && secondaryArr != null) {
			MergeSort sort = new MergeSort();
			sort.sort(mainArr);
			sort.sort(secondaryArr);
			return isSubsetPrivate(mainArr, secondaryArr);
			/*BinarySearch search = new BinarySearch();
			for(int i=0; i<secondaryArr.length; i++) {
				boolean available = search.isExists(mainArr, secondaryArr[i]);
				System.out.println("Searching:"+secondaryArr[i]+" in "+Arrays.toString(mainArr)+" and found:"+available);
				if(!available) {
					return false;
				}
				
			}
			return true;*/
		}
		return false;
	}

	private static boolean isSubsetPrivate(int[] mainArr, int[] secondaryArr) {
		int i = 0, j = 0;
		while (i < mainArr.length && j < secondaryArr.length) {
			if (mainArr[i] == secondaryArr[j]) {
				i++;
				j++;
			} else if (mainArr[i] < secondaryArr[j]) {
				i++;
			} else {
				return false;
			}
		}
		if (j >= secondaryArr.length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isSubset(new int[] { 2, 9, 3, 5, 11, 4 }, new int[] { 11, 4, 9 }));
		System.out.println(isSubset(new int[] { 2, 9, 3, 5, 11, 4, 6 }, new int[] { 11, 6, 9, 5 }));
		System.out.println(isSubset(new int[] { 2 }, new int[] { 2 }));
		System.out.println(isSubset(new int[] { 7 }, new int[] { 1 }));
		System.out.println(isSubset(new int[] { 2, 9, 3, 5, 11, 4, 6 }, new int[] { 11, 6, 9, 7 }));
		System.out.println(isSubset(new int[] { 1, 4, 2 }, new int[] { 1, 4, 4, 2 }));
	}

}

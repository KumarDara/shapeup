package com.practice.sort;

public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		quickSort(input, 0, input.length - 1);
		return input;
	}

	public void quickSort(int[] input, int start, int end) {
		if (start < end) {
			int pivot = findPivot(input, start, end);
			quickSort(input, start, pivot - 1);
			quickSort(input, pivot + 1, end);
		}
	}

	private int findPivot(int[] input, int start, int end) {
		// assuming end element is the pivot element
		int pivot_ele = input[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (input[i] <= pivot_ele) {
				int tmp = input[i];
				input[i] = input[pIndex];
				input[pIndex] = tmp;
				pIndex++;
			}
		}
		int tmp = input[end];
		input[end] = input[pIndex];
		input[pIndex] = tmp;
		return pIndex;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 2, 3 };
		int odd = 0;
		for (int i = 0; i < arr.length; i++) {
			odd = odd ^ arr[i];
		}
		System.out.println(odd);
	}
}

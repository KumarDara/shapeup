package com.practice.sort;

public class HeapSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		if (input != null) {
			int heapSize = input.length;
			//[1, 2, 3, 4, 5]
			//for n elements leafs would be n/2 to n-1 [3,4,5]
			//non leafs would be n/2-1 to 0[1,2] so running heapify for all non leaf nodes.
			//               1
			//			2        3
			//       4     5
			//
			for (int i = heapSize / 2 - 1; i >= 0; i--) {
				maxHeapify(input, heapSize, i);
			}
			//after running heapify it would become [5,4,3,1,2]

			for (int i = heapSize - 1; i >= 0; i--) {
				//swapping the first element with last element 
				//as we know that first element is max element in the non sorted list.
				int tmp = input[i];
				input[i] = input[0];
				input[0] = tmp;
				//heapifying the remaining list.
				maxHeapify(input, i, 0);
			}
		}
		return input;
	}

	private void maxHeapify(int[] input, int heapSize, int root) {
		int largest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		if (left < heapSize && input[left] > input[largest]) {
			largest = left;
		}
		if (right < heapSize && input[right] > input[largest]) {
			largest = right;
		}
		if (largest != root) {
			int tmp = input[root];
			input[root] = input[largest];
			input[largest] = tmp;
			maxHeapify(input, heapSize, largest);
		}
	}
	
	private void minHeapify(int[] input, int heapSize, int root) {
		int smallest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		if (left < heapSize && input[left] < input[smallest]) {
			smallest = left;
		}
		if (right < heapSize && input[right] < input[smallest]) {
			smallest = right;
		}
		if (smallest != root) {
			int tmp = input[root];
			input[root] = input[smallest];
			input[smallest] = tmp;
			minHeapify(input, heapSize, smallest);
		}
	}

}

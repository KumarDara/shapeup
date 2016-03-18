package com.practice.custom;

class CircularLinkedList {

	String data[];
	int size;
	int currentSize;

	public CircularLinkedList() {
		size = 10;
		data = new String[size];
	}

	public CircularLinkedList(int size) {
		if (size > 0) {
			this.size = size;
			data = new String[size];
		}
	}

	public boolean add(String value) {
		data[currentSize] = value;
		currentSize++;
		return true;
	}

	public boolean insert(String current, String value) {

		int position = 0;
		for (int i = 0; i < size; i++) {
			if (data[i] == current) {

				position = i;
				break;
			}
		}

		String tmp = data[position + 1];
		data[position + 1] = value;
		for (int i = position + 2; i < currentSize; i++) {
			String localtmp = data[i];
			data[i] = tmp;
			tmp = localtmp;
		}
		currentSize++;
		return true;
	}

	public boolean delete(String value) {
		boolean found = false;
		int valIndex = 0;
		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				found = true;
				valIndex = i;
				break;
			}
		}
		if (found) {
			for (int i = valIndex + 1; i < currentSize; i++) {
				data[valIndex] = data[i];
				valIndex++;
			}
			currentSize--;
		}
		return found;
	}

	public void display(String value) {
		boolean found = false;
		int valIndex = 0;
		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				found = true;
				valIndex = i;
				break;
			}
		}
		if (found) {
			for (int i = valIndex; i < currentSize; i++) {
				System.out.print(data[i] + " ");
			}
			for (int i = 0; i < valIndex; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
	}

}

public class CircularLinkedListTest {
	public static void main(String args[]) throws Exception {
		CircularLinkedList list = new CircularLinkedList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.display("C");
		list.delete("C");

		list.delete("E");

		list.insert("B", "G");
		list.display("B");
	}
}

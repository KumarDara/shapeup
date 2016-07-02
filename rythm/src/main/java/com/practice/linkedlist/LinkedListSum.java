package com.practice.linkedlist;

public class LinkedListSum {
	class Node {
		Node next;
		int data;
	}

	public int getSum(Node head1, Node head2) {
		int head1Size = getSize(head1);
		int head2Size = getSize(head2);
		Node tmpHead1 = head1;
		Node tmpHead2 = head2;
		if (head1Size > 0 && head2Size > 0) {
			int diff = Math.abs(head1Size - head2Size);
			if(head1Size < head2Size) {
				int i=0;
				while(i<diff) {
					tmpHead2 = tmpHead2.next;
				}
			} else if(head1Size > head2Size) {
				int i=0;
				while(i<diff) {
					tmpHead1 = tmpHead1.next;
				}
			}
			int carry = 0;
			
		}
		return 0;
	}

	
	private int getSize(Node head) {
		if (head != null) {
			int size = 1;
			while (head.next != null) {
				size++;
			}
			return size;
		}
		return 0;
	}
}

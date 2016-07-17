package com.practice.cce;

public class ReverseLL {

	public Node reverse(Node head) {
		if (head != null) {
			Node prev = null;
			Node current = head;
			Node next = null;

			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
		}
		return head;
	}
//1-2-3
	public Node reverseRec(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node reverse = reverseRec(head.next);
		head.next.next = head;
		head.next = null;
		return reverse;
	}
}

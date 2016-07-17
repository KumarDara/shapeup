package com.practice.cce;

public class NthNodeLL {

	public Node getNthNodeFromEnd(Node head, int n) {
		if (head != null) {
			Node nthNode = head;
			for (int tmp = 0; tmp < n; tmp++) {
				if (nthNode == null) {
					return null;
				}
				nthNode = nthNode.next;
			}
			Node nthNodeFromEnd = head;
			while (nthNode != null) {
				nthNode = nthNode.next;
				nthNodeFromEnd = nthNodeFromEnd.next;
			}
			return nthNodeFromEnd;
		}
		return head;
	}

}

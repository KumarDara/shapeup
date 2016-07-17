package com.practice.cce;

public class MiddleNodeInLL {

	public Node getMiddleNode(Node head) {
		if(head != null) {
			Node slow = head;
			Node fast = head;
			while(fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return head;
	}
}


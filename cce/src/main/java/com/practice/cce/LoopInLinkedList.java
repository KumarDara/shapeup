package com.practice.cce;

public class LoopInLinkedList {
	
	public static boolean isLoopExists(Node head) {
		if(head != null) {
			Node slow = head;
			Node fast = head;
			while(fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow == fast) {
					return true;
				}
			}
			 
		}
		return false;
	}

}

class Node {
	Node next;
	int data;
}
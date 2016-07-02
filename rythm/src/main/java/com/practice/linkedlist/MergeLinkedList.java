package com.practice.linkedlist;

public class MergeLinkedList {
	class Node {
		int data;
		Node next;
	}

	public Node mergeSort(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node mid = getMid(head);
		Node midNext = mid.next;
		mid.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(midNext);
		Node merge =mergeSortHelper(left, right);
		return merge;
	}
	
	Node getMid(Node head) {
		if(head == null) {
			return head;
		}
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	Node mergeSortHelper(Node left, Node right) {
		if(left == null) {
			return right;
		}
		if(right == null) {
			return left;
		}
		Node merge = null;
		if(left.data <= right.data) {
			merge = left;
			merge.next = mergeSortHelper(left.next, right);
		} else {
			merge = right;
			merge.next = mergeSortHelper(left, right.next);
		}
		return merge;
	}
}

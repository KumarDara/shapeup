package com.practice.linkedlist;

public class ListNode<T> {
	private T data;
	private ListNode<T> next;
	private ListNode<T> random;

	public ListNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	public ListNode<T> getRandom() {
		return random;
	}

	public void setRandom(ListNode<T> random) {
		this.random = random;
	}

}

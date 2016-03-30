package com.practice.linkedlist;

public class DoubleListNode<T> {
	private DoubleListNode<T> previous;
	private T data;
	private DoubleListNode<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoubleListNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleListNode<T> next) {
		this.next = next;
	}

	public DoubleListNode(T data) {
		this.setData(data);
	}

	public DoubleListNode(T data, DoubleListNode<T> next, DoubleListNode<T> previous) {
		this.setData(data);
		this.setNext(next);
		this.setPrevious(previous);
	}

	public DoubleListNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleListNode<T> previous) {
		this.previous = previous;
	}
}

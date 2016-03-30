package com.practice.custom;

import com.practice.linkedlist.ListNode;
import com.practice.linkedlist.SingleLinkedList;

public class Stack<T> {
	private SingleLinkedList<T> list;

	public Stack() {
		list = new SingleLinkedList<>();
	}

	public T push(T item) {
		ListNode<T> node = new ListNode<>(item);
		if (list.getHead() != null) {
			node.setNext(list.getHead());
		}
		list.setHead(node);
		return item;
	}

	public T pop() {
		T removedVal = null;
		if (list.getHead() != null) {
			ListNode<T> tmpHead = list.getHead();
			list.setHead(tmpHead.getNext());
			removedVal = tmpHead.getData();
			tmpHead.setNext(null);
		}
		return removedVal;
	}

	public T peek() {
		T peekVal = null;
		if (list.getHead() != null) {
			ListNode<T> tmpHead = list.getHead();
			peekVal = tmpHead.getData();
		}
		return peekVal;
	}

	@Override
	public String toString() {
		StringBuilder tmp = new StringBuilder("[");

		if (this.list.getHead() != null) {
			ListNode<T> tmpNode = this.list.getHead();
			while (tmpNode != null) {
				tmp.append(tmpNode.getData()).append(", ");
				tmpNode = tmpNode.getNext();
			}
		}
		tmp.append("]");
		return tmp.toString();
	}

}

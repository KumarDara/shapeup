package com.practice.linkedlist;

public class DoubleLinkedList<T> {
	private DoubleListNode<T> head;
	private DoubleListNode<T> tail;
	private int length;

	public DoubleLinkedList() {

	}

	public DoubleListNode<T> getHead() {
		return head;
	}

	public void setHead(DoubleListNode<T> head) {
		this.head = head;
	}

	public DoubleListNode<T> getTail() {
		return tail;
	}

	public void setTail(DoubleListNode<T> tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public DoubleLinkedList(T data) {
		head = new DoubleListNode<T>(data);
		tail = head;
	}

	public void insertAtBegin(DoubleListNode<T> node) {
		node.setPrevious(null);
		node.setNext(this.getHead());
		if (this.getHead() != null) {
			this.getHead().setPrevious(node);
		}
		this.setHead(node);
		if (this.getTail() == null) {
			this.setTail(node);
		}
		length++;
	}

	public void insertAtEnd(DoubleListNode<T> node) {
		node.setNext(null);
		node.setPrevious(this.getTail());
		if (this.getTail() != null) {
			this.getTail().setNext(node);
		}
		this.setTail(node);
		if (this.getHead() == null) {
			this.setHead(node);
		}
		length++;
	}

	public void insert(T data, int position) {
		if (position > length || position < 0) {
			throw new ArrayIndexOutOfBoundsException("Provide Valid position to add element");
		}
		DoubleListNode<T> newNode = new DoubleListNode<T>(data);
		if (this.getHead() == null) {
			insertAtBegin(newNode);
		} else if (position == length) {
			insertAtEnd(newNode);
		} else {
			DoubleListNode<T> currentNode = this.getHead();
			for (int i = 1; i < position; i++) {
				currentNode = currentNode.getNext();
			}
			newNode.setNext(currentNode.getNext());
			newNode.setPrevious(currentNode);
			currentNode.setNext(newNode);
			length++;
		}
	}

	public DoubleListNode<T> removeFromBegin() {

		DoubleListNode<T> removedNode = this.getHead();
		this.setHead(removedNode.getNext());
		if (this.getHead() != null) {
			this.getHead().setPrevious(null);
		}
		removedNode.setNext(null);
		length--;
		return removedNode;
	}

	public DoubleListNode<T> removeFromEnd() {
		DoubleListNode<T> removedNode = this.getTail();
		this.setTail(removedNode.getPrevious());
		if (this.getTail() != null) {
			this.getTail().setNext(null);
		}
		removedNode.setPrevious(null);
		length--;
		return removedNode;
	}

	public boolean removeMatched(DoubleListNode<T> inputNode) {
		DoubleListNode<T> currentNode = this.getHead();
		if (currentNode != null) {
			if (currentNode.equals(inputNode)) {
				removeFromBegin();
				return true;
			} else if (this.getTail().equals(inputNode)) {
				removeFromEnd();
				return true;
			} else {
				while (currentNode.getNext() != null) {
					currentNode = currentNode.getNext();
					if (currentNode.equals(inputNode)) {
						currentNode.getPrevious().setNext(currentNode.getNext());
						currentNode.getNext().setPrevious(currentNode.getPrevious());
						currentNode.setNext(null);
						currentNode.setPrevious(null);
						length--;
						return true;
					}
				}
			}

		}
		return false;
	}

	public DoubleListNode<T> remove(int position) {
		if (position > length || position < 0) {
			throw new ArrayIndexOutOfBoundsException("Provide Valid position to delete element");
		}
		DoubleListNode<T> removedNode = null;
		DoubleListNode<T> currentNode = this.getHead();
		if (currentNode != null) {
			if (position == 0) {
				removeFromBegin();
			} else if (position == length) {
				removeFromEnd();
			} else {
				for (int i = 1; i <= position; i++) {
					currentNode = currentNode.getNext();
				}
				if (currentNode != null) {
					currentNode.getPrevious().setNext(currentNode.getNext());
					currentNode.getNext().setPrevious(currentNode.getPrevious());
					currentNode.setNext(null);
					currentNode.setPrevious(null);
					length--;
					removedNode = currentNode;
				}
			}

		}

		return removedNode;
	}

	@Override
	public String toString() {
		StringBuilder tmp = new StringBuilder("[");

		if (this.getHead() != null) {
			DoubleListNode<T> tmpNode = this.getHead();
			while (tmpNode != null) {
				tmp.append(tmpNode.getData()).append(", ");
				tmpNode = tmpNode.getNext();
			}
		}
		tmp.append("]");
		return tmp.toString();
	}
}

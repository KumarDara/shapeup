package com.practice.linkedlist;

public class SingleLinkedList<T> {
	private ListNode<T> head;
	private int length;

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public SingleLinkedList() {
	}

	public void insertAtBegin(ListNode<T> node) {
		node.setNext(head);
		head = node;
		length++;
	}

	public void insertAtEnd(ListNode<T> node) {
		if (head != null) {
			ListNode<T> tail = head;
			while (tail.getNext() != null) {
				tail = tail.getNext();
			}
			tail.setNext(node);
		} else {
			head = node;
		}
		length++;
	}

	public void insert(T data, int position) {
		if (position > length || position < 0) {
			throw new ArrayIndexOutOfBoundsException("Provide Valid position to add element");
		}
		ListNode<T> node = new ListNode<T>(data);
		if (getHead() == null) {
			setHead(node);
		} else if (position == 0) {
			node.setNext(getHead());
			setHead(node);
		} else {
			ListNode<T> positionNode = head;
			for (int i = 1; i < position; i++) {
				positionNode = positionNode.getNext();
			}
			node.setNext(positionNode.getNext());
			positionNode.setNext(node);
		}
		length++;
	}

	public ListNode<T> removeFromBegin() {
		ListNode<T> removedNode = this.getHead();
		if (removedNode != null) {
			this.setHead(this.getHead().getNext());
			removedNode.setNext(null);
			length--;
		}

		return removedNode;
	}

	public ListNode<T> removeFromEnd() {
		ListNode<T> removedNode = this.getHead();
		ListNode<T> previousNode = removedNode;
		while (removedNode.getNext() != null) {
			previousNode = removedNode;
			removedNode = removedNode.getNext();
		}
		if (removedNode != null) {
			if (previousNode != null) {
				previousNode.setNext(null);
			}
			length--;
		}
		return removedNode;
	}

	public boolean removeMatched(ListNode<T> inputNode) {
		ListNode<T> currentNode = this.getHead();
		ListNode<T> prevNode = null;
		if (currentNode != null) {
			// equals to Head
			if (currentNode.equals(inputNode)) {
				this.setHead(this.getHead().getNext());
				currentNode.setNext(null);
				length--;
				return true;
			}
			while (currentNode.getNext() != null) {
				prevNode = currentNode;
				currentNode = currentNode.getNext();
				if (currentNode.equals(inputNode)) {
					prevNode.setNext(currentNode.getNext());
					currentNode.setNext(null);
					length--;
					return true;
				}
			}
		}
		return false;
	}

	public ListNode<T> remove(int position) {
		if (position > length || position < 0) {
			throw new ArrayIndexOutOfBoundsException("Provide Valid position to delete element");
		}
		ListNode<T> removedNode = null;
		if (this.getHead() != null) {
			removedNode = this.getHead();
			// remove Head
			if (position == 0) {
				this.setHead(this.getHead().getNext());
				removedNode.setNext(null);
				length--;
			} else {
				ListNode<T> prevNode = null;
				for (int i = 1; i <= position; i++) {
					prevNode = removedNode;
					removedNode = removedNode.getNext();
				}
				prevNode.setNext(removedNode.getNext());
				removedNode.setNext(null);
				length--;
			}
		}
		return removedNode;
	}

	@Override
	public String toString() {
		StringBuilder tmp = new StringBuilder("[");

		if (this.getHead() != null) {
			ListNode<T> tmpNode = this.getHead();
			while (tmpNode != null) {
				if(tmpNode.getRandom() != null) {
					tmp.append(tmpNode.getData()).append("(").append(tmpNode.getRandom().getData()).append("), ");
				} else {
					tmp.append(tmpNode.getData()).append("(), ");
				}
				tmpNode = tmpNode.getNext();
			}
		}
		tmp.append("]");
		return tmp.toString();
	}
}

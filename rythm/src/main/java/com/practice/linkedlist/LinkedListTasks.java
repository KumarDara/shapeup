package com.practice.linkedlist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LinkedListTasks {

	/**
	 * Helps to find loop exists in the given Linked list
	 * 
	 * @param list
	 * @return
	 */
	public <T> boolean isLoopExists(SingleLinkedList<T> list) {
		boolean loopExists = Boolean.FALSE;
		if (list != null && list.getHead() != null) {
			ListNode<T> slowPtr = list.getHead();
			ListNode<T> fastPtr = list.getHead().getNext();
			while (slowPtr != fastPtr) {
				if (slowPtr == null || fastPtr == null || fastPtr.getNext() == null) {
					break;
				}
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext().getNext();
			}
			// if both pointers are equal then loop exists
			if (slowPtr == fastPtr) {
				loopExists = Boolean.TRUE;
			}
		}
		return loopExists;
	}

	/**
	 * Helps to get the starting node of the loop
	 * 
	 * @return
	 */
	public <T> ListNode<T> getLoopStartNode(SingleLinkedList<T> list) {
		ListNode<T> startNode = null;
		// checking wether loop exists or not
		if (list != null && list.getHead() != null) {
			ListNode<T> slowPtr = list.getHead();
			ListNode<T> fastPtr = list.getHead().getNext();
			while (slowPtr != fastPtr) {
				if (slowPtr == null || fastPtr == null || fastPtr.getNext() == null) {
					break;
				}
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext().getNext();
			}
			// if both pointers are equal then loop exists
			if (slowPtr == fastPtr) {
				// resetting the slowPtr to Head
				slowPtr = list.getHead();
				fastPtr = fastPtr.getNext();
				while (slowPtr != fastPtr) {
					slowPtr = slowPtr.getNext();
					fastPtr = fastPtr.getNext();
				}
				startNode = slowPtr;
			}
		}
		return startNode;
	}

	/**
	 * Helps to reverse the given Linked list
	 * 
	 * @param list
	 * @return
	 */
	public <T> void reverseList(SingleLinkedList<T> list) {
		if (list != null) {
			ListNode<T> current = list.getHead();
			ListNode<T> previous = null;
			while (current != null) {
				ListNode<T> next = current.getNext();
				// reversing the list
				current.setNext(previous);
				previous = current;
				current = next;
			}
			list.setHead(previous);
		}
	}

	public <T> ListNode<T> findNthNode(SingleLinkedList<T> list, int n) {
		ListNode<T> nthNode = null;
		if (list != null) {
			ListNode<T> fastPtr = list.getHead();
			ListNode<T> slowPtr = list.getHead();
			for (int i = 1; i < n; i++) {
				// provided invalid position
				if (fastPtr == null) {
					return nthNode;
				}
				fastPtr = fastPtr.getNext();
			}
			while (fastPtr.getNext() != null) {
				fastPtr = fastPtr.getNext();
				slowPtr = slowPtr.getNext();
			}
			nthNode = slowPtr;
		}
		return nthNode;
	}

	/**
	 * Helps to swap the odd and even positions of the list e.g:
	 * 1->2->3->4->5->6 will be 2->1->4->3->6->5
	 * 
	 * @param list
	 */
	public <T> void swapOddEvenPositions(SingleLinkedList<T> list) {
		if (list != null && list.getHead() != null) {
			ListNode<T> head = list.getHead();
			ListNode<T> current = list.getHead();
			ListNode<T> prev = null;
			while (current != null) {
				ListNode<T> next = current.getNext();

				if (current == head) {
					list.setHead(next);
				}
				if (next != null) {
					ListNode<T> nextNext = next.getNext();
					next.setNext(current);
					current.setNext(nextNext);
				}

				if (prev != null) {
					prev.setNext(next);
				}
				prev = current;
				current = current.getNext();
			}
		}
	}

	public <T> SingleLinkedList<T> copyRandomPointerUsingMap(SingleLinkedList<T> list) {
		if (list == null) {
			return null;
		}
		SingleLinkedList<T> newList = new SingleLinkedList<>();
		Map<ListNode<T>, ListNode<T>> nodesMap = new HashMap<>();
		ListNode<T> currNode = list.getHead();
		ListNode<T> prev = null;
		while (currNode != null) {
			ListNode<T> newNode = new ListNode<T>(currNode.getData());
			if (prev == null) {
				newList.setHead(newNode);
			} else {
				prev.setNext(newNode);
			}
			nodesMap.put(currNode, newNode);
			prev = newNode;
			currNode = currNode.getNext();
		}
		Iterator<ListNode<T>> itr = nodesMap.keySet().iterator();
		while (itr.hasNext()) {
			ListNode<T> oldNode = itr.next();
			ListNode<T> newNode = nodesMap.get(oldNode);
			newNode.setRandom(nodesMap.get(oldNode.getRandom()));
		}
		return newList;
	}

	public <T> SingleLinkedList<T> copyRandomPointer(SingleLinkedList<T> list) {
		if (list == null) {
			return null;
		}
		SingleLinkedList<T> newList = new SingleLinkedList<>();
		ListNode<T> currNode = list.getHead();
		ListNode<T> next = null;
		// iterating through the list and creating a copy of every node and
		// inserting it after the current node
		while (currNode != null) {
			ListNode<T> newNode = new ListNode<T>(currNode.getData());
			next = currNode.getNext();
			currNode.setNext(newNode);
			newNode.setNext(next);
			currNode = next;
		}
		currNode = list.getHead();
		// iterating through the updated list and updating the random pointers
		while (currNode != null) {
			ListNode<T> copyNode = currNode.getNext();
			if (currNode.getRandom() != null) {
				copyNode.setRandom(currNode.getRandom().getNext());
			}
			currNode = currNode.getNext().getNext();
		}
		currNode = list.getHead();
		ListNode<T> newNode = currNode.getNext();
		newList.setHead(newNode);
		// unlinking the pointers between old and new nodes
		while (newNode != null) {
			currNode.setNext(currNode.getNext().getNext());
			if (newNode.getNext() != null) {
				newNode.setNext(newNode.getNext().getNext());
			}
			currNode = currNode.getNext();
			newNode = newNode.getNext();
		}
		return newList;
	}
}

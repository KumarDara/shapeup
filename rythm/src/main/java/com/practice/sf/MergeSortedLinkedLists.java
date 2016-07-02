package com.practice.sf;

import com.practice.linkedlist.ListNode;
import com.practice.linkedlist.SingleLinkedList;

public class MergeSortedLinkedLists {

	public <T extends Comparable<T>> SingleLinkedList<T> merge(SingleLinkedList<T> firstList,
			SingleLinkedList<T> secondList) {
		ListNode<T> firstHead = firstList.getHead();
		ListNode<T> secondHead = secondList.getHead();
		SingleLinkedList<T> mergedList = new SingleLinkedList<>();
		ListNode<T> mergedHead = null;
		// iterating through the both lists and identifying the minimum of it
		while (firstHead != null && secondHead != null) {
			ListNode<T> tempNode = null;
			// if first list contains min value add it
			if (firstHead.getData().compareTo(secondHead.getData()) <= 0) {
				tempNode = new ListNode<T>(firstHead.getData());
				firstHead = firstHead.getNext();
			} else {
				// if second list contains min value add it
				tempNode = new ListNode<T>(secondHead.getData());
				secondHead = secondHead.getNext();
			}
			if (mergedHead == null) {
				mergedHead = tempNode;
				mergedList.setHead(mergedHead);
			} else {
				mergedHead.setNext(tempNode);
				mergedHead = mergedHead.getNext();
			}
		}
		// if first list contains any elements still then add it to the merged
		// list
		while (firstHead != null) {
			ListNode<T> tempNode = new ListNode<T>(firstHead.getData());
			firstHead = firstHead.getNext();

			if (mergedHead == null) {
				mergedHead = tempNode;
				mergedList.setHead(mergedHead);
			} else {
				mergedHead.setNext(tempNode);
				mergedHead = mergedHead.getNext();
			}
		}
		// if second list contains any elements still then add it to the merged
		// list
		while (secondHead != null) {
			ListNode<T> tempNode = new ListNode<T>(secondHead.getData());
			secondHead = secondHead.getNext();

			if (mergedHead == null) {
				mergedHead = tempNode;
				mergedList.setHead(mergedHead);
			} else {
				mergedHead.setNext(tempNode);
				mergedHead = mergedHead.getNext();
			}
		}
		return mergedList;
	}

	public <T extends Comparable<T>> SingleLinkedList<T> mergeListsWithoutExtraSpace(SingleLinkedList<T> listOne,
			SingleLinkedList<T> listTwo) {
		ListNode<T> firstHead = listOne.getHead();
		ListNode<T> secondHead = listTwo.getHead();
		ListNode<T> mergeHead = mergeListsRecursive(firstHead, secondHead);
		SingleLinkedList<T> mergeList = new SingleLinkedList<>();
		mergeList.setHead(mergeHead);
		return mergeList;
	}

	private <T extends Comparable<T>> ListNode<T> mergeListsRecursive(ListNode<T> headOne, ListNode<T> headTwo) {
		ListNode<T> mergeNode = null;
		if (headOne == null) {
			return headTwo;
		}
		if (headTwo == null) {
			return headOne;
		}
		if (headOne.getData().compareTo(headTwo.getData()) <= 0) {
			mergeNode = headOne;
			mergeNode.setNext(mergeListsRecursive(headOne.getNext(), headTwo));
		} else {
			mergeNode = headTwo;
			mergeNode.setNext(mergeListsRecursive(headOne, headTwo.getNext()));
		}
		return mergeNode;
	}

	public <T> SingleLinkedList<T> reverseList(SingleLinkedList<T> list) {
		ListNode<T> head = list.getHead();
		if (head != null) {
			ListNode<T> prev = null;
			while (head != null) {
				ListNode<T> next = head.getNext();
				head.setNext(prev);
				prev = head;
				head = next;
			}
			// making the last element as head
			list.setHead(prev);
		}

		return list;
	}
}

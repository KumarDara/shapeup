package com.practice;

import org.junit.Test;

import com.practice.linkedlist.ListNode;
import com.practice.linkedlist.SingleLinkedList;
import com.practice.sf.MergeSortedLinkedLists;

public class MergeSortedLinkedListsTest {

	@Test
	public void validTest() {
		MergeSortedLinkedLists mergeObj = new MergeSortedLinkedLists();
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		ListNode<Integer> head = new ListNode<Integer>(1);
		ListNode<Integer> two = new ListNode<Integer>(2);
		ListNode<Integer> three = new ListNode<Integer>(3);
		ListNode<Integer> four = new ListNode<Integer>(4);
		ListNode<Integer> five = new ListNode<Integer>(5);

		SingleLinkedList<Integer> listTwo = new SingleLinkedList<>();
		ListNode<Integer> six = new ListNode<Integer>(6);
		ListNode<Integer> seven = new ListNode<Integer>(7);
		ListNode<Integer> eight = new ListNode<Integer>(8);
		ListNode<Integer> nine = new ListNode<Integer>(9);
		ListNode<Integer> ten = new ListNode<Integer>(10);

		list.insertAtBegin(head);
		list.insertAtEnd(three);
		list.insertAtEnd(four);
		list.insertAtEnd(eight);

		listTwo.insertAtBegin(two);
		listTwo.insertAtEnd(five);
		listTwo.insertAtEnd(six);
		listTwo.insertAtEnd(seven);
		listTwo.insertAtEnd(nine);
		listTwo.insertAtEnd(ten);
		SingleLinkedList<Integer> mergeList = mergeObj.merge(list, listTwo);
		System.out.println(list);
		System.out.println(listTwo);
		System.out.println(mergeList);
		SingleLinkedList<Integer> mergeTwoList = mergeObj.mergeListsWithoutExtraSpace(listTwo, list);
		System.out.println(list);
		System.out.println(listTwo);
		System.out.println(mergeTwoList);
		mergeObj.reverseList(mergeTwoList);
		System.out.println(mergeTwoList);
	}
}

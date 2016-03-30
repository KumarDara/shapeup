/**
 * 
 */
package com.practice;

import static org.junit.Assert.*;

import org.junit.Test;

import com.practice.linkedlist.ListNode;
import com.practice.linkedlist.SingleLinkedList;

/**
 * @author KH1280
 *
 */
public class SingleLinkedListTest {

	/**
	 * Test method for
	 * {@link com.practice.linkedlist.SingleLinkedList#getHead()}.
	 */
	@Test
	public void validTest() {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		ListNode<Integer> head = new ListNode<Integer>(1);
		ListNode<Integer> two = new ListNode<Integer>(2);
		ListNode<Integer> three = new ListNode<Integer>(3);
		ListNode<Integer> four = new ListNode<Integer>(4);
		ListNode<Integer> five = new ListNode<Integer>(5);

		list.insertAtBegin(head);
		System.out.println(list + " length:" + list.getLength());
		list.insertAtEnd(two);
		System.out.println(list + " length:" + list.getLength());
		list.insert(3, 2);
		System.out.println(list + " length:" + list.getLength());
		list.insertAtEnd(four);
		System.out.println(list + " length:" + list.getLength());
		list.removeFromBegin();
		System.out.println(list + " length:" + list.getLength());
		list.removeFromEnd();
		System.out.println(list + " length:" + list.getLength());
		list.insertAtEnd(five);
		System.out.println(list + " length:" + list.getLength());
		list.remove(1);
		System.out.println(list + " length:" + list.getLength());
		list.removeMatched(five);
		System.out.println(list + " length:" + list.getLength());
		list.removeMatched(two);
		System.out.println(list + " length:" + list.getLength());

	}
}

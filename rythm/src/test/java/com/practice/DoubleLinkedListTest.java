/**
 * 
 */
package com.practice;

import org.junit.Test;

import com.practice.linkedlist.DoubleLinkedList;
import com.practice.linkedlist.DoubleListNode;

/**
 * @author KH1280
 *
 */
public class DoubleLinkedListTest {

	@Test
	public void validTest() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		DoubleListNode<Integer> head = new DoubleListNode<Integer>(1);
		DoubleListNode<Integer> two = new DoubleListNode<Integer>(2);
		DoubleListNode<Integer> three = new DoubleListNode<Integer>(3);
		DoubleListNode<Integer> four = new DoubleListNode<Integer>(4);
		DoubleListNode<Integer> five = new DoubleListNode<Integer>(5);

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

package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.linkedlist.LinkedListTasks;
import com.practice.linkedlist.ListNode;
import com.practice.linkedlist.SingleLinkedList;

public class LinkedListTasksTest {

	@Test
	public void validTest() {
		LinkedListTasks tasks = new LinkedListTasks();
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		ListNode<Integer> head = new ListNode<Integer>(1);
		ListNode<Integer> two = new ListNode<Integer>(2);
		ListNode<Integer> three = new ListNode<Integer>(3);
		ListNode<Integer> four = new ListNode<Integer>(4);
		ListNode<Integer> five = new ListNode<Integer>(5);
		list.insertAtBegin(head);
		list.insertAtEnd(two);
		list.insertAtEnd(three);
		list.insertAtEnd(four);
		list.insertAtEnd(five);
		Assert.assertFalse(tasks.isLoopExists(list));
		Assert.assertTrue(null == tasks.getLoopStartNode(list));
		five.setNext(three);
		Assert.assertTrue(tasks.isLoopExists(list));
		Assert.assertTrue(three == tasks.getLoopStartNode(list));
		Assert.assertFalse(two == tasks.getLoopStartNode(list));
		five.setNext(null);
		Assert.assertTrue(null == tasks.getLoopStartNode(list));
		five.setNext(four);
		Assert.assertTrue(four == tasks.getLoopStartNode(list));
		five.setNext(null);
		System.out.println(list);
		tasks.reverseList(list);
		System.out.println(list);
		Assert.assertTrue(two == tasks.findNthNode(list, 2));
		Assert.assertTrue(head == tasks.findNthNode(list, 1));
		Assert.assertTrue(four == tasks.findNthNode(list, 4));
		ListNode<Integer> six = new ListNode<Integer>(6);
		list.insertAtEnd(six);
		tasks.swapOddEvenPositions(list);
		System.out.println(list);
	}
}

package com.practice.practice;

public class CircularLinkedList {

	public boolean isCircular(Node head) {
		if(head == null) {
			return false;
		}
		Node slow = head;
		Node fast = head.next;
		while(slow != fast) {
			if(fast == null || slow == null || fast.next == null) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(slow == fast && fast.next == head) {
			return true;
		}
		
		return false;
	}
	
	public int findMiddle(Node head) {
		if(head == null) {
			return -1;
		}
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast =  fast.next.next;
		}
		return slow.data;
		
	}
	public Node merge(Node head1, Node head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		Node merge = new Node();
		if(head1.data <= head2.data) {
			merge.data = head1.data;
			merge.next = merge(head1.next, head2);
		} else {
			merge.data = head2.data;
			merge.next = merge(head1, head2.next);
		}
		return merge;
	}
	
	public Node reverse(Node head) {
		if(head == null) {
			return head;
		}
		Node curr = head;
		Node prev = null;
		while(curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		if(prev != null) {
			head = prev;
		}
		return head;
	}
	
	Node reverseRec(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node remaining = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return remaining;
	}
	
	Node reverseRec(Node head, Node prev) {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			head.next = prev;
			return head;
		}
		Node rev = reverseRec(head.next, head);
		head.next = prev;
		return rev;
	}
	Node deleteLowerNodes(Node head)
    {
        if(head == null) {
            return null;
        }
        Node current = head;
        Node prev = null;
        Node next = current.next;
        while(current != null && next != null) {
            if(current.data < next.data) {
                if(prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                    prev = current;
                }
            } else {
                prev = current;   
            }
            
            current = next;
            next = next.next;
        }
        return head;
    }
	public static void main(String[] args) {
		Node head = new Node();
		head.data = 1;
		Node two = new Node();
		two.data = 2;
		Node three = new Node();
		three.data = 3;
		Node four = new Node();
		four.data = 4;
		Node five = new Node();
		five.data = 5;
		
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		//five.next = three;
		
		CircularLinkedList list = new CircularLinkedList();
		//System.out.println(list.isCircular(head));
		//System.out.println(list.findMiddle(head));
		//Node merge = list.merge(head, two);
		Node tmp= list.reverseRec(head, null);
		list.print(tmp);
		//head = list.deleteLowerNodes(head);
		//list.print(head);
	}
	
	void print(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

class Node {
	int data;
	Node next;
}


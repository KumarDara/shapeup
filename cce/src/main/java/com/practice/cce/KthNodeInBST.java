package com.practice.cce;

import java.util.Stack;

public class KthNodeInBST {

	public int getKthSmallest(TreeNode root, int k) {
		if(root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode tmp = root;
			while(stack.isEmpty() || tmp != null) {
				if(tmp!= null) {
					stack.push(tmp);
					tmp = tmp.left;
				} else {
					TreeNode left = stack.pop();
					k--;
					if(k==0) {
						return left.data;
					}
					tmp = left.right;
				}
			}
		}
		return -1;
	}
	
	public int getKthSmallestRec(TreeNode root, int k) {
		if(root != null) {
			return getKthSmallestRec(root, k, new Counter());
		}
		return -1;
	}
	
	private int getKthSmallestRec(TreeNode root, int k, Counter cntr) {
		if(root != null) {
			int val = getKthSmallestRec(root.left, k, cntr);
			if(val != -1) {
				return val;
			}
			cntr.incr();
			if(cntr.get() == k) {
				return root.data;
			}
			getKthSmallestRec(root.right, k, cntr);
		}
		return -1;
	}
}

class Counter {
	int cnt;
	public void incr() {
		cnt++;
	}
	
	public int get() {
		return cnt;
	}
	
}
class TreeNode {
	TreeNode left;
	TreeNode right;
	int data;
}
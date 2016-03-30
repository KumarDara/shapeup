package com.practice;

import java.util.concurrent.atomic.AtomicInteger;


public class ConstructTree {
	public static void main(String[] args) {
		// int[] pre = { 5, 4, 2, 3, 8, 7, 9 };
		// int[] post = { 2, 3, 4, 7, 9, 8, 5 };
		int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
		new ConstructTree().constructFullBinaryTree(pre, post);
	}

	private void constructFullBinaryTree(int[] pre, int[] post) {
		AtomicInteger preIndex = new AtomicInteger(0);
		int low = 0;
		int high = post.length - 1;
		TreeNode root = _consutructFullBinaryTreeFromPreAndPost(pre, post, preIndex, low, high);
		root.print();
	}

	private TreeNode _consutructFullBinaryTreeFromPreAndPost(int[] pre, int[] post, AtomicInteger preIndex, int low,
			int high) {
		if (preIndex.get() >= pre.length || low > high) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preIndex.get()]);
		preIndex.getAndIncrement();

		if (low == high || preIndex.get() >= pre.length) {
			return root;
		}
		int i;
		for (i = low; i <= high; i++) {
			if (pre[preIndex.get()] == post[i]) {
				break;
			}
		}
		if (i <= high) {
			root.left = _consutructFullBinaryTreeFromPreAndPost(pre, post, preIndex, low, i);
			root.right = _consutructFullBinaryTreeFromPreAndPost(pre, post, preIndex, i + 1, high);
		}

		return root;
	}
}

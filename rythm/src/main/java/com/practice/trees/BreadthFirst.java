package com.practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirst {

	public <T extends Comparable<T>> void traverse(TreeNode<T> tree) {
		int height = tree.getHeight();
		for (int i = 1; i <= height; i++) {
			printTree(tree, i);
		}
	}

	private <T extends Comparable<T>> void printTree(TreeNode<T> tree, int level) {
		if (level <= 0) {
			return;
		}
		if (level == 1) {
			System.out.print(tree.getData()+" ");
		}
		printTree(tree.getLeft(), level - 1);
		printTree(tree.getRight(), level - 1);
	}
	
	public <T extends Comparable<T>> void traverseUsingQueue(TreeNode<T> root) {
		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode<T> tree = queue.poll();
			System.out.print(tree.getData()+" ");
			if(tree.getLeft() != null) {
				queue.add(tree.getLeft());
			}
			if(tree.getRight() != null) {
				queue.add(tree.getRight());
			}
		}
	}
}

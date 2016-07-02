package com.practice.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	private Node root;

	public BinaryTree(int val) {
		root = new Node(val);
	}

	public List<Integer> preOrderTraversal() {
		List<Integer> list = new ArrayList<>();
		preOrderTraverse(root, list);
		return list;
	}

	public List<Integer> inOrderTraversal() {
		List<Integer> list = new ArrayList<>();
		inOrderTraverse(root, list);
		return list;
	}

	public List<Integer> postOrderTraversal() {
		List<Integer> list = new ArrayList<>();
		postOrderTraverse(root, list);
		return list;
	}

	// Helps to preorder(V-L-R) traverse through the tree
	private void preOrderTraverse(Node node, List<Integer> list) {
		if (node != null) {
			// Adds the Visit
			list.add(node.key);
			// Traverse to the left if exists
			preOrderTraverse(node.left, list);
			// Traverse to the right if exists
			preOrderTraverse(node.right, list);
		}
	}

	// Helps to inorder(L-V-R) traverse through the tree
	private void inOrderTraverse(Node node, List<Integer> list) {
		if (node != null) {
			// Traverse to the left if exists
			inOrderTraverse(node.left, list);
			// Adds the Visit
			list.add(node.key);
			// Traverse to the right if exists
			inOrderTraverse(node.right, list);
		}
	}

	// Helps to postorder(L-R-V) traverse through the tree
	private void postOrderTraverse(Node node, List<Integer> list) {
		if (node != null) {
			// Traverse to the left if exists
			postOrderTraverse(node.left, list);
			// Traverse to the right if exists
			postOrderTraverse(node.right, list);
			// Adds the Visit
			list.add(node.key);

		}
	}
}

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
	}
}

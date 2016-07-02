package com.practice.trees;

public class BinarySearchTree {
	public <T extends Comparable<T>> TreeNode<T> search(TreeNode<T> root, T no) {
		if (root == null) {
			return null;
		}
		if (root.getData().compareTo(no) == 0) {
			return root;
		} else if (root.getData().compareTo(no) < 0) {
			return search(root.getRight(), no);
		} else {
			return search(root.getLeft(), no);
		}
	}

	public <T extends Comparable<T>> TreeNode<T> insert(TreeNode<T> root, T no) {
		TreeNode<T> node = new TreeNode<T>(no);
		if (root == null) {
			return node;
		}
		TreeNode<T> parent = null;
		TreeNode<T> current = root;
		while (current != null) {
			parent = current;
			if (current.getData().compareTo(no) <= 0) {
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}
		if (parent.getData().compareTo(no) <= 0) {
			parent.setRight(node);
		} else {
			parent.setLeft(node);
		}
		return root;
	}

}

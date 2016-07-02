package com.practice.trees;

import java.util.List;

public class TreeNode<T extends Comparable<T>> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;

	public TreeNode(T data) {
		this(data, null, null);
	}

	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public int getHeight() {
		int leftHeight = (this.left == null) ? 0 : left.getHeight();
		int rightHeight = (this.right == null) ? 0 : right.getHeight();
		int height = 1 + Math.max(leftHeight, rightHeight);
		return height;
	}

	public int getSize() {
		int leftSize = this.getLeft() == null ? 0 : this.getLeft().getSize();
		int rightSize = this.getRight() == null ? 0 : this.getRight().getSize();
		return 1 + leftSize + rightSize;
	}

	public boolean isBST() {
		if (this.left != null) {
			if (this.data.compareTo(this.left.data) < 0 || !this.left.isBST()) {
				return Boolean.FALSE;
			}
		}
		if (this.right != null) {
			if (this.data.compareTo(this.right.data) > 0 || !this.right.isBST()) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
}

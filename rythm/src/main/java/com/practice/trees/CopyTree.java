package com.practice.trees;

public class CopyTree {

	public <T extends Comparable<T>> TreeNode<T> copyTree(TreeNode<T> root){
		if(root == null) {
			return null;
		}
		TreeNode<T> copy = new TreeNode<T>(root.getData());
		copy.setLeft(copyTree(root.getLeft()));
		copy.setRight(copyTree(root.getRight()));
		return copy;
	}
}

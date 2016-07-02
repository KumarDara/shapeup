package com.practice.trees;

public class DeleteTree {

	public <T extends Comparable<T>> void deleteTree(TreeNode<T> root){
		if(root == null) {
			return;
		}
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		System.out.println("Node deleted:"+root.getData());
		root = null;
	}
}

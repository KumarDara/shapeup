package com.practice.sf;

import com.practice.trees.TreeNode;

public class MirrorBinaryTree {

	public <T extends Comparable<T>> void getMirrorTree(TreeNode<T> root) {
		if (root == null) {
			return;
		}
		getMirrorTree(root.getLeft());
		getMirrorTree(root.getRight());
		TreeNode<T> tmp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(tmp);

	}

	public <T extends Comparable<T>> boolean isMirror(TreeNode<T> root, TreeNode<T> mirror) {
		if (root == null && mirror == null) {
			return true;
		}
		if (root != null && mirror != null && root.getData().compareTo(mirror.getData()) == 0) {
			return isMirror(root.getLeft(), mirror.getRight()) && isMirror(root.getRight(), mirror.getLeft());
		}
		return false;
	}
	
	public <T extends Comparable<T>> boolean isSymmetry(TreeNode<T> root){
		return isMirror(root, root);
	}

}

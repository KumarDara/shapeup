package com.practice.trees;

public class LargestBSTInBinaryTree {
	public <T extends Comparable<T>> int largestBSTSize(TreeNode<T> root) {
		if(root == null) {
			return 0;
		}
		MinMax max = getLargestBST(root);
		return max.size;
	}

	private <T extends Comparable<T>> MinMax getLargestBST(TreeNode<T> root) {
		if (root == null) {
			return new MinMax();
		}
		MinMax leftMinMax = getLargestBST(root.getLeft());
		MinMax rightMinMax = getLargestBST(root.getRight());
		MinMax currentMinMax = new MinMax();
		if (!leftMinMax.isBst || !rightMinMax.isBst || leftMinMax.max > (Integer) root.getData()
				|| rightMinMax.min < (Integer) root.getData()) {
			currentMinMax.size = Math.max(leftMinMax.size, rightMinMax.size);
			currentMinMax.isBst = false;
			return currentMinMax;
		}

		currentMinMax.isBst = true;
		currentMinMax.size = 1 + (leftMinMax.size + rightMinMax.size);
		currentMinMax.min = (root.getLeft() == null) ? (Integer) root.getData() : leftMinMax.min;
		currentMinMax.max = (root.getRight() == null) ? (Integer) root.getData() : rightMinMax.max;
		return currentMinMax;
	}
}

class MinMax {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	int size;
	boolean isBst = true;
}
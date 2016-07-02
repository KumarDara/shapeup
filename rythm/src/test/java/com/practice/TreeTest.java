package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.sf.MirrorBinaryTree;
import com.practice.trees.BreadthFirst;
import com.practice.trees.CopyTree;
import com.practice.trees.DeleteTree;
import com.practice.trees.TreeNode;
import com.practice.util.TreeUtil;

public class TreeTest {

	@Test
	public void mirrorTree() {

		TreeUtil util = new TreeUtil();
		MirrorBinaryTree mirror = new MirrorBinaryTree();

		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> three = new TreeNode<>(3);
		TreeNode<Integer> two = new TreeNode<>(2, one, three);

		util.inOrderTraverse(two);
		System.out.println("Calling iterative preorder");
		util.iterativePostorderTraversal(two);
		/*
		 * mirror.getMirrorTree(two); util.inOrderTraverse(two);
		 * System.out.println();
		 */
		TreeNode<Integer> six = new TreeNode<>(6);
		TreeNode<Integer> eight = new TreeNode<>(8);
		TreeNode<Integer> seven = new TreeNode<>(7, six, eight);
		util.inOrderTraverse(seven);
		System.out.println();
		/*
		 * mirror.getMirrorTree(seven); util.inOrderTraverse(seven);
		 * System.out.println();
		 */
		TreeNode<Integer> root = new TreeNode<>(5, two, seven);

		util.inOrderTraverse(root);
		System.out.println();
		mirror.getMirrorTree(root);
		util.inOrderTraverse(root);
	}

	@Test
	public void breadthFirstTest() {
		BreadthFirst breadthObj = new BreadthFirst();
		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> three = new TreeNode<>(3);
		TreeNode<Integer> two = new TreeNode<>(2, one, three);

		TreeNode<Integer> six = new TreeNode<>(6);
		TreeNode<Integer> eight = new TreeNode<>(8);
		TreeNode<Integer> seven = new TreeNode<>(7, six, eight);

		TreeNode<Integer> root = new TreeNode<>(5, two, seven);
		System.out.println();
		breadthObj.traverse(root);
		System.out.println();
		breadthObj.traverseUsingQueue(root);

	}

	@Test
	public void deleteTreeTest() {
		DeleteTree tree = new DeleteTree();
		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> three = new TreeNode<>(3);
		TreeNode<Integer> two = new TreeNode<>(2, one, three);

		TreeNode<Integer> six = new TreeNode<>(6);
		TreeNode<Integer> eight = new TreeNode<>(8);
		TreeNode<Integer> seven = new TreeNode<>(7, six, eight);

		TreeNode<Integer> root = new TreeNode<>(5, two, seven);
		tree.deleteTree(root);
	}

	@Test
	public void copyTreeTest() {
		CopyTree tree = new CopyTree();
		TreeUtil util = new TreeUtil();
		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> three = new TreeNode<>(3);
		TreeNode<Integer> two = new TreeNode<>(2, one, three);

		TreeNode<Integer> six = new TreeNode<>(6);
		TreeNode<Integer> eight = new TreeNode<>(8);
		TreeNode<Integer> seven = new TreeNode<>(7, six, eight);

		TreeNode<Integer> root = new TreeNode<>(5, two, seven);
		System.out.println();
		util.inOrderTraverse(root);
		TreeNode<Integer> copy = tree.copyTree(root);
		System.out.println("Copied:::::");
		util.inOrderTraverse(copy);
	}

	@Test
	public void symmetryTest() {
		MirrorBinaryTree mirror = new MirrorBinaryTree();
		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> three = new TreeNode<>(3);
		TreeNode<Integer> two = new TreeNode<>(2, one, three);

		TreeNode<Integer> six = new TreeNode<>(6);
		TreeNode<Integer> eight = new TreeNode<>(8);
		TreeNode<Integer> seven = new TreeNode<>(7, six, eight);

		TreeNode<Integer> root = new TreeNode<>(5, two, seven);

		Assert.assertFalse(mirror.isSymmetry(root));

		TreeNode<Integer> oneM = new TreeNode<>(1);
		TreeNode<Integer> threeM = new TreeNode<>(3);
		TreeNode<Integer> twoM = new TreeNode<>(2, oneM, threeM);

		TreeNode<Integer> twoMM = new TreeNode<>(2, threeM, oneM);

		TreeNode<Integer> rootM = new TreeNode<>(5, twoM, twoMM);

		Assert.assertTrue(mirror.isSymmetry(rootM));
	}
}

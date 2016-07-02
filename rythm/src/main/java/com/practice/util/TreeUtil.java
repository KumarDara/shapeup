package com.practice.util;

import java.util.Stack;

import com.practice.trees.TreeNode;

public class TreeUtil {
	// Helps to preorder(V-L-R) traverse through the tree
	public <T extends Comparable<T>> void preOrderTraverse(TreeNode<T> root) {
		if (root != null) {
			// Adds the Visit
			System.out.print(root.getData() + " ");
			// Traverse to the left if exists
			preOrderTraverse(root.getLeft());
			// Traverse to the right if exists
			preOrderTraverse(root.getRight());
		}
	}

	// Helps to inorder(L-V-R) traverse through the tree
	public <T extends Comparable<T>> void inOrderTraverse(TreeNode<T> root) {
		if (root != null) {
			// Traverse to the left if exists
			inOrderTraverse(root.getLeft());
			// Adds the Visit
			System.out.print(root.getData() + " ");

			// Traverse to the right if exists
			inOrderTraverse(root.getRight());
		}
	}

	// Helps to postorder(L-R-V) traverse through the tree
	public <T extends Comparable<T>> void postOrderTraverse(TreeNode<T> root) {
		if (root != null) {
			// Traverse to the left if exists
			postOrderTraverse(root.getLeft());

			// Traverse to the right if exists
			postOrderTraverse(root.getRight());
			// Adds the Visit
			System.out.print(root.getData() + " ");
		}
	}

	public <T extends Comparable<T>> boolean isEqual(TreeNode<T> root1, TreeNode<T> root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.getData().compareTo(root2.getData()) == 0) {
			return isEqual(root1.getLeft(), root2.getLeft()) && isEqual(root1.getRight(), root2.getRight());
		} else {
			return false;
		}
	}

	public <T extends Comparable<T>> int getSize(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		int leftSize = getSize(root.getLeft());
		int rightSize = getSize(root.getRight());
		return 1 + leftSize + rightSize;
	}

	public <T extends Comparable<T>> int getHeight(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.getLeft());
		int rightHeight = getHeight(root.getRight());
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public <T extends Comparable<T>> boolean isSumPathExists(TreeNode<T> root, T data) {
		if (root == null) {
			return false;
		}
		Integer rootNo = (Integer) root.getData();
		Integer no = (Integer) data;
		Integer sub = rootNo - no;
		if (sub == 0) {
			if (root.getLeft() == null && root.getRight() == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return isSumPathExists(root.getLeft(), (T) sub) || isSumPathExists(root.getRight(), (T) sub);
		}
	}

	public <T extends Comparable<T>> boolean isBST(TreeNode<T> root) {
		if (root == null) {
			return false;
		}
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private <T extends Comparable<T>> boolean isBST(TreeNode<T> root, Integer lower, Integer upper) {
		if (root == null) {
			return true;
		}
		Integer data = (Integer) root.getData();
		if (data <= lower || data > upper) {
			return false;
		}
		return isBST(root.getLeft(), lower, data) && isBST(root.getRight(), data, upper);
	}

	public <T extends Comparable<T>> void iterativePreorderTraversal(TreeNode<T> root) {
		// VLR
		if (root == null) {
			return;
		}
		Stack<TreeNode<T>> stackObj = new Stack<>();
		stackObj.push(root);
		while (!stackObj.isEmpty()) {
			TreeNode<T> tmpRoot = stackObj.pop();
			System.out.println(tmpRoot.getData() + ",");
			if (tmpRoot.getRight() != null) {
				stackObj.push(tmpRoot.getRight());
			}
			if (tmpRoot.getLeft() != null) {
				stackObj.push(tmpRoot.getLeft());
			}

		}
	}

	public <T extends Comparable<T>> void iterativeInorderTraversal(TreeNode<T> root) {
		// LVR
		if (root == null) {
			return;
		}
		Stack<TreeNode<T>> stackObj = new Stack<>();
		while (true) {
			if (root != null) {
				stackObj.push(root);
				root = root.getLeft();
			} else {
				if (stackObj.isEmpty()) {
					break;
				}
				TreeNode<T> tmpRoot = stackObj.pop();

				System.out.println(tmpRoot.getData() + ",");
				root = tmpRoot.getRight();
			}

		}
	}

	public <T extends Comparable<T>> void iterativePostorderTraversal(TreeNode<T> root) {
		//LRV
		if(root == null) {
			return;
		}
		TreeNode<T> current = root;
		Stack<TreeNode<T>> stack = new Stack<>();
		while(current != null || !stack.isEmpty()) {
			if(current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				TreeNode<T> tmp = stack.peek().getRight();
				if(tmp == null) {
					tmp = stack.pop();
					System.out.println(tmp.getData()+",");
					while(!stack.isEmpty() && tmp == stack.peek().getRight()) {
						tmp = stack.pop();
						System.out.println(tmp.getData()+",");
					}
				} else {
					current = tmp;
				}
			}
		}
	}
}

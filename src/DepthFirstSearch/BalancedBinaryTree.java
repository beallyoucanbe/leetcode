package DepthFirstSearch;

import Tree.TreeNode;
/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined
 *  as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {

		if(root == null)
			return true;
		if(root.getLeft() == null && root.getRight() == null)
			return true;
		return Math.abs(depth(root.getLeft()) - depth(root.getRight())) <= 1 && isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}
	
	private int depth(TreeNode root){
		if(root == null)
			return 0;
		return Math.max(depth(root.getLeft()), depth(root.getRight())) + 1;
	}
}

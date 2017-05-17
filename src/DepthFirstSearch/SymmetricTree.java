package DepthFirstSearch;

import Tree.TreeNode;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 来判断一个二叉树是否为对称树
 * 可以从几个角度来考虑
 * 1，使用递归进行求解，先判断左右子结点是否相等，不等就返回false，
 *    相等就将左子结点的左子树与右子结果的右子结点进行比较操作，
 *    同时将左子结点的左子树与右子结点的左子树进行比较，只有两个同时为真是才返回true，否则返回false。 
 * 2， 对称树的中序遍历一定是对称的
 */
public class SymmetricTree {

	public boolean isSymmetricTree(TreeNode root){
		if(root == null)
			return false;
		else
			return isSample(root.left, root.right);
	}
	private boolean isSample(TreeNode left, TreeNode right){
		if(left == null && right == null)
			return true;
		else if(left == null || right == null)
			return false;
		else
			return left.val == right.val && isSample(left.left, right.right) && isSample(left.right, right.left);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package DepthFirstSearch;

import Tree.TreeNode;
/*
 * Given a binary tree and a sum, determine
 *  if the tree has a root-to-leaf path 
 *  such that adding up all the values along the path equals the given sum.
 * 在递归中如何在递归过程中从底层直接返回
 */

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		
		return dfsFunction(root, sum, 0);		
	}
	
	private boolean dfsFunction(TreeNode node, int sum, int cursum){
		if(node == null)
			return false;
		if(node.left == null && node.right == null)
			return node.val + cursum == sum;
		return dfsFunction(node.left, sum, cursum + node.val) || (dfsFunction(node.right, sum, cursum + node.val));
	}
}

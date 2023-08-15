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
		if(node.getLeft() == null && node.getRight() == null)
			return node.getVal() + cursum == sum;
		return dfsFunction(node.getLeft(), sum, cursum + node.getVal()) || (dfsFunction(node.getRight(), sum, cursum + node.getVal()));
	}
}

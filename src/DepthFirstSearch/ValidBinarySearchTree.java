package DepthFirstSearch;

import Tree.TreeNode;
/*
 * 刚开始写的程序没有考虑完整，一定要满足某个节点的所有左子节点比当前节点小，
 * 所有右子节点比当前节点大。
 */

public class ValidBinarySearchTree {

	//无效的方法
//	 public boolean isValidBST(TreeNode root) {
//	
//		 if(root == null)
//			 return true;
//		 if(root.left != null && root.val <= root.left.val)
//			 return false;
//		 if(root.right != null && root.val >= root.right.val)
//			 return false;
//		 return isValidBST(root.left) && isValidBST(root.right);
//	 }
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	
	private boolean isValidBST(TreeNode root, double min, double max){
		if(root == null)
			return true;
		if(root.getVal() <= min || root.getVal() >= max)
			return false;
		return isValidBST(root.getLeft(), min, root.getVal()) && isValidBST(root.getRight(), root.getVal(), max);
	}
}

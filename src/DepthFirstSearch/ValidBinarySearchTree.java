package DepthFirstSearch;

import Tree.TreeNode;
/*
 * �տ�ʼд�ĳ���û�п���������һ��Ҫ����ĳ���ڵ���������ӽڵ�ȵ�ǰ�ڵ�С��
 * �������ӽڵ�ȵ�ǰ�ڵ��
 */

public class ValidBinarySearchTree {

	//��Ч�ķ���
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
		if(root.val <= min || root.val >= max)
			return false;
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
}

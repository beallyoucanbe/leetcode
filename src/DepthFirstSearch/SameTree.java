package DepthFirstSearch;

import Tree.TreeNode;
/*
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical
 *  and the nodes have the same value.
 */
/*
 * 通过这几个程序学习如何把程序写的精简
 */

/*
 * if(root1 == null && root2 == null)
			return true;
		else if(root1 == null || root2 == null )
			return false;
	这几行程序经常被用来进行空值的判断，第一个if，两个都为空，第二个if，其中有一个为空
 */

public class SameTree {

	public boolean isSameTree(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		else if(root1 == null || root2 == null )
			return false;
		else return root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SameTree test = new SameTree();
		
		TreeNode root1 = new TreeNode(0);
		TreeNode root2 = new TreeNode(0);
		if(root1.left == null)
			System.out.println("root.left == null");
		else
			System.out.println("root.left != null");
		if(test.isSameTree(root1, root2))
			System.out.println("true");
		else
			System.out.println("false");
	}

}

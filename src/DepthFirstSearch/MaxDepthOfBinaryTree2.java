package DepthFirstSearch;

import Tree.TreeNode;

public class MaxDepthOfBinaryTree2 {

	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		int leftdepth = root.left != null ? maxDepth(root.left) : Integer.MIN_VALUE;
		int rightdepth = root.right != null ? maxDepth(root.right) : Integer.MIN_VALUE;
		return Math.max(leftdepth, rightdepth) + 1;
	}

	public static void main(String[] str) {

		MaxDepthOfBinaryTree2 test = new MaxDepthOfBinaryTree2();

		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.left = node9;
		node6.right = node10;

		int result = test.maxDepth(node1);
		System.out.println("============");
		System.out.println(result);
	}
}

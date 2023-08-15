package DepthFirstSearch;

import Tree.TreeNode;

public class MaxDepthOfBinaryTree2 {

	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.getLeft() == null && root.getRight() == null)
			return 1;
		int leftdepth = root.getLeft() != null ? maxDepth(root.getLeft()) : Integer.MIN_VALUE;
		int rightdepth = root.getRight() != null ? maxDepth(root.getRight()) : Integer.MIN_VALUE;
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
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node3.setLeft(node5);
		node3.setRight(node6);
		node4.setLeft(node7);
		node4.setRight(node8);
		node6.setLeft(node9);
		node6.setRight(node10);

		int result = test.maxDepth(node1);
		System.out.println("============");
		System.out.println(result);
	}
}

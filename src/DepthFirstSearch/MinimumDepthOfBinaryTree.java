package DepthFirstSearch;

import Tree.TreeNode;

/*
 * 考虑好如何返回最小深度 int
 * 之前的方法是把mindepth作为类的成员变量，这样就可以在每个方法及递归中及时改变
 * 按层遍历，遍历到第一个叶子节点即可
 */

public class MinimumDepthOfBinaryTree {
	
	int mindepth = Integer.MAX_VALUE;
	int currentdepth = 0;
	
	public void minDepth(TreeNode root){
	
		minDepth(root, currentdepth);
		
	}
	
	private void minDepth(TreeNode root, int currentdepth){
		if(root == null)
			return;
		currentdepth++;
		
		if(root.getLeft() == null && root.getRight() == null){
			if(currentdepth < mindepth)
				mindepth = currentdepth;
		}
		minDepth(root.getLeft(), currentdepth);
		minDepth(root.getRight(), currentdepth);
		currentdepth--;			
	}
	
	public static void main(String[] args){
		MinimumDepthOfBinaryTree test = new MinimumDepthOfBinaryTree();
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
		
		test.minDepth(node1);
		System.out.println(test.mindepth);
	}
}
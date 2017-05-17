package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

/*
 * 作为一个方法返回
 * int leftdepth = root.left == null ? Integer.MAX_VALUE
					: minDepth(root.left);
	理解这两句话代表的意思
	如果某一个节点只有一个左节点或是右节点，那么他的深度则由存在的节点所决定
	如果只写成 leftdepth = minDepth(root.left);
	由于左节点为null，方法会返回0，而深度的定义是一定要到叶子，
	此时就会出错
	即如果一个子树只有一个孩子，则其深度由存在的孩子节点决定，这时就要把另外一边设置为MAX
 */

/*
 * 另外一种方法为广度优先
 * 按广度优先原则逐层遍历，当找到第一个叶子节点时的层数即为最小深度
 * 可以像本例一样，用一个队列和一个int 变量来记录每一级的节点数及其变化
 */

public class MinimumDepthOfBinaryTree2 {

	//递归的方法
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		else {
			int leftdepth = root.left == null ? Integer.MAX_VALUE
					: minDepth(root.left);
			int rightdepth = root.right == null ? Integer.MAX_VALUE
					: minDepth(root.right);
			return Math.min(leftdepth, rightdepth) + 1;
		}
	}
	//采用BFS广度优先的方法
	public int minDepthBFS(TreeNode root) {
		if(root == null)
			return 0;
		int depth = 1;
		int currentlevel = 1; //定义当前层的节点数
		int nextlevel = 0; //定义下一层的节点数
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.remove();
			currentlevel--;
			if(node.left == null & node.right == null)
				return depth;
			if(node.left != null){
				queue.add(node.left);
				nextlevel++;
			}
			if(node.right != null){
				queue.add(node.right);
				nextlevel++;
			}
			if(currentlevel == 0){
				if(nextlevel != 0)
					depth++;
				currentlevel = nextlevel;
				nextlevel = 0;
			}
		}
		return depth;
	}

	public static void main(String[] str) {

		MinimumDepthOfBinaryTree2 test = new MinimumDepthOfBinaryTree2();

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

		int result = test.minDepth(node1);
		System.out.println("============");
		System.out.println(result);
	}
}

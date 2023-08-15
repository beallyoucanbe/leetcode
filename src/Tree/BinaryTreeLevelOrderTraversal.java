package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 即写出二叉树的分层遍历算法
 * 要用循环，而非递归，同时应用队列的数据结构
 */

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int levLength = queue.size();
			List<Integer> levs = new ArrayList<Integer>();
			for (int i = 0; i < levLength; i++) {
				TreeNode node = queue.remove();
				levs.add(node.getVal());
				if (node.getLeft() != null)
					queue.add(node.getLeft());
				if (node.getRight() != null)
					queue.add(node.getRight());
			}
			res.add(levs);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

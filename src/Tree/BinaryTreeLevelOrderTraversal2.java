package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 */
/*
 * 这里跟普通的按层遍历只有一处变化，这里要求输出的顺序是从底层到根部的输出，这样只需先把按层遍历的结果存储在一种数据结构中，如栈中，
 * 就可以在遍历完之后再输出
 */

public class BinaryTreeLevelOrderTraversal2 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int levLength = queue.size();
			List<Integer> levs = new ArrayList<Integer>();
			for (int i = 0; i < levLength; i++) {
				TreeNode node = queue.remove();
				levs.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			stack.add(levs);
		}
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

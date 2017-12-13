package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 */
/*
 * 方法， 层次遍历， 并把每一层的最后一个元素加入结果集中
 */

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		levelTraversal(root, res);
		return res;
	}

	private void levelTraversal(TreeNode root, List<Integer> list) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int queueLength = queue.size();
			for (int i = 0; i < queueLength; i++) {
				TreeNode node = queue.remove();
				if (i == queueLength - 1)
					list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeRightSideView test = new BinaryTreeRightSideView();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		// System.out.println(node1.left.right == node6);
		List<Integer> res = test.rightSideView(node1);
		// System.out.println(ancesto.val);

		for (Integer a : res)
			System.out.println(a + " ");
	}

}

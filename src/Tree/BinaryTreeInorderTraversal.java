package Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 树的中序遍历
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		inorderTraversal(root, res);
		return res;

	}

	private void inorderTraversal(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		inorderTraversal(node.getLeft(), list);
		list.add(node.getVal());
		inorderTraversal(node.getRight(), list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

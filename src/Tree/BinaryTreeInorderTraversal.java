package Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Ê÷µÄÖÐÐò±éÀú
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
		inorderTraversal(node.left, list);
		list.add(node.val);
		inorderTraversal(node.right, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

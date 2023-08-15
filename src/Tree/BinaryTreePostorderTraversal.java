package Tree;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		postorderTraversal(root, res);
		return res;
	}
	
	private void postorderTraversal(TreeNode root, List<Integer> list){
		if(root == null)
			return;
		postorderTraversal(root.getLeft(), list);
		postorderTraversal(root.getRight(), list);
		list.add(root.getVal());
	}
}

package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		preorderTraversal(root, res);
		return res;
	}
	
	private void preorderTraversal(TreeNode root, List<Integer> list){
		if(root == null)
			return;
		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

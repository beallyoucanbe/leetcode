package Tree;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (postorder == null || postorder.length == 0 || inorder == null
				|| inorder.length == 0)
			return null;
		// 建立根节点
		//TreeNode root = dfs(postorder, 0, inorder, inorder.length - 1, inorder.length);  ;

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

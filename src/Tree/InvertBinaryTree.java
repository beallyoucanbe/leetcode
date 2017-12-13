package Tree;

/*
 * 把一个二叉树左右翻转，即左右对称的翻转
 * 递归解法，一次翻转节点的左右结点，然后递归翻转左右孩子
 * 利用树的分层遍历，对每一层依次交换两个对应的节点
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {

		if(root == null)
			return root;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
	}

}

package Tree;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 题目从二叉搜索树变成了普通二叉树
 * 利用先找路径的方法，然后找两条路径的公共节点的方法，当数据量很大时，大量的递归会消耗大量的空间
 * 一个方法的思想是：当两个节点均在当前节点的左边时，当前节点肯定不是最下的公共祖先
 * 只有当当前节点一个在左边，一个在右边时，当前节点肯定是最下的公共祖先
 */

public class LowestCommonAncestorofBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if(root == null || root == p || root == q)
			return root;
		//查看左子树是否有目标节点，没有为null
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		//同样查看右子树是否有目标节点，没有为null
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		//都不为空，说明左右子树都有目标节点，公共祖先就是当前节点本身
		if(left != null && right != null)
			return root;
		return left != null ? left : right;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

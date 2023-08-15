package Tree;

import java.util.ArrayList;

/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 *  “The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 *  that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 */
/*
 * 最简单的方法，由于是二叉搜索树，利用二叉搜索树的特点，如果p，q均大于root则公共节点在root的又子树，如果均小于root
 * 则肯定在左子树，如果一大一小，则root即为所求，利用这个性质递归
 */
/*
 * 方法二：通过深度优先搜索分别找到从root到目标节点的一条链路，然后分析这两条链路的最后一个公共节点。
 */
public class LowestCommonAncestoofaBinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null)
			return null;
		if(Math.max(p.getVal(), q.getVal()) < root.getVal())
			return lowestCommonAncestor(root.getLeft(), p, q);
		else if(Math.min(p.getVal(), q.getVal()) > root.getVal())
			return lowestCommonAncestor(root.getRight(), p, q);
		else return root;
	}
	//最重要的是如何找到以后立刻从递归底层直接结束程序并返回，可以借鉴返回值为boolean的方法
	//由于是二叉搜索树，所以可以在每一步都判断路径的走法,二叉搜索树，可以根据值的特点去判断
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;
		ArrayList<TreeNode> tra1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> tra2 = new ArrayList<TreeNode>();
		
		TravelPath(root, p, tra1);
		TravelPath(root, q, tra2);
		
		for (int i = tra1.size() - 1; i >= 0; i--) {
			for (int j = tra2.size() - 1; j >= 0; j--) {
				if (tra2.get(j) == tra1.get(i))
					return tra2.get(j);
			}
		}
		return null;
	}
	private boolean TravelPath(TreeNode root, TreeNode node,
			ArrayList<TreeNode> traPath){
		traPath.add(root);
		if(root == node)
			return true;
		if(root.getLeft() != null){
			if(TravelPath(root.getLeft(), node, traPath))
				return true;
		}
		if(root.getRight() != null){
			if(TravelPath(root.getRight(), node, traPath))
				return true;
		}
		traPath.remove(traPath.size() - 1);
		
		return false;
	}
/*
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;
		ArrayList<TreeNode> tra1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> tra2 = new ArrayList<TreeNode>();
		findTraPath(root, p, tra1);
		findTraPath(root, q, tra2);
		for (int i = tra1.size() - 1; i >= 0; i--) {
			for (int j = tra2.size() - 1; j >= 0; j--) {
				if (tra2.get(j) == tra1.get(i))
					return tra2.get(j);
			}
		}
		return null;
	}

	private void findTraPath(TreeNode root, TreeNode node,
			ArrayList<TreeNode> traPath) {
		if (root == null)
			return;
		traPath.add(root);
		if (root == node) {
			return;  //找到错误的原因，如果找到了node，return只是返回当前递归的方法，返回后还会继续执行
			         //后面的语句，而并非停止整个的递归程序
		}
		findTraPath(root.left, node, traPath);
		findTraPath(root.right, node, traPath);
		traPath.remove(traPath.size() - 1);
	}
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestoofaBinarySearchTree test = new LowestCommonAncestoofaBinarySearchTree();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node1.setLeft(node2);
		node1.setRight(node4);
		node2.setLeft(node3);
		node2.setRight(node6);
		node4.setLeft(node5);
		// System.out.println(node1.left.right == node6);
		TreeNode ancesto = test.lowestCommonAncestor2(node1, node3, node5);
		// System.out.println(ancesto.val);

	}

}

package Tree;

import java.util.ArrayList;

/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 *  ��The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 *  that has both v and w as descendants (where we allow a node to be a descendant of itself).��
 */
/*
 * ��򵥵ķ����������Ƕ��������������ö������������ص㣬���p��q������root�򹫹��ڵ���root���������������С��root
 * ��϶��������������һ��һС����root��Ϊ��������������ʵݹ�
 */
/*
 * ��������ͨ��������������ֱ��ҵ���root��Ŀ��ڵ��һ����·��Ȼ�������������·�����һ�������ڵ㡣
 */
public class LowestCommonAncestoofaBinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null)
			return null;
		if(Math.max(p.val, q.val) < root.val)
			return lowestCommonAncestor(root.left, p, q);
		else if(Math.min(p.val, q.val) > root.val)
			return lowestCommonAncestor(root.right, p, q);
		else return root;
	}
	//����Ҫ��������ҵ��Ժ����̴ӵݹ�ײ�ֱ�ӽ������򲢷��أ����Խ������ֵΪboolean�ķ���
	//�����Ƕ��������������Կ�����ÿһ�����ж�·�����߷�,���������������Ը���ֵ���ص�ȥ�ж�
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
		if(root.left != null){
			if(TravelPath(root.left, node, traPath))
				return true;
		}
		if(root.right != null){
			if(TravelPath(root.right, node, traPath))
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
			return;  //�ҵ������ԭ������ҵ���node��returnֻ�Ƿ��ص�ǰ�ݹ�ķ��������غ󻹻����ִ��
			         //�������䣬������ֹͣ�����ĵݹ����
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
		node1.left = node2;
		node1.right = node4;
		node2.left = node3;
		node2.right = node6;
		node4.left = node5;
		// System.out.println(node1.left.right == node6);
		TreeNode ancesto = test.lowestCommonAncestor2(node1, node3, node5);
		// System.out.println(ancesto.val);

	}

}

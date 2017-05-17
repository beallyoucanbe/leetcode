package Tree;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * ��Ŀ�Ӷ����������������ͨ������
 * ��������·���ķ�����Ȼ��������·���Ĺ����ڵ�ķ��������������ܴ�ʱ�������ĵݹ�����Ĵ����Ŀռ�
 * һ��������˼���ǣ��������ڵ���ڵ�ǰ�ڵ�����ʱ����ǰ�ڵ�϶��������µĹ�������
 * ֻ�е���ǰ�ڵ�һ������ߣ�һ�����ұ�ʱ����ǰ�ڵ�϶������µĹ�������
 */

public class LowestCommonAncestorofBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if(root == null || root == p || root == q)
			return root;
		//�鿴�������Ƿ���Ŀ��ڵ㣬û��Ϊnull
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		//ͬ���鿴�������Ƿ���Ŀ��ڵ㣬û��Ϊnull
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		//����Ϊ�գ�˵��������������Ŀ��ڵ㣬�������Ⱦ��ǵ�ǰ�ڵ㱾��
		if(left != null && right != null)
			return root;
		return left != null ? left : right;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

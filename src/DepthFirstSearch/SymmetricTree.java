package DepthFirstSearch;

import Tree.TreeNode;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * ���ж�һ���������Ƿ�Ϊ�Գ���
 * ���ԴӼ����Ƕ�������
 * 1��ʹ�õݹ������⣬���ж������ӽ���Ƿ���ȣ����Ⱦͷ���false��
 *    ��Ⱦͽ����ӽ��������������ӽ�������ӽ����бȽϲ�����
 *    ͬʱ�����ӽ��������������ӽ������������бȽϣ�ֻ������ͬʱΪ���ǲŷ���true�����򷵻�false�� 
 * 2�� �Գ������������һ���ǶԳƵ�
 */
public class SymmetricTree {

	public boolean isSymmetricTree(TreeNode root){
		if(root == null)
			return false;
		else
			return isSample(root.left, root.right);
	}
	private boolean isSample(TreeNode left, TreeNode right){
		if(left == null && right == null)
			return true;
		else if(left == null || right == null)
			return false;
		else
			return left.val == right.val && isSample(left.left, right.right) && isSample(left.right, right.left);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

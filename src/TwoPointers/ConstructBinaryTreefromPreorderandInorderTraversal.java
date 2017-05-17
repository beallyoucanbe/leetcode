package TwoPointers;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 */
class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder == null || preorder.length == 0 || inorder == null
				|| inorder.length == 0)
			return null;
		// �������ڵ�
		TreeNode root = dfs(preorder, 0, inorder, inorder.length - 1,
				inorder.length);
		;

		return root;
	}

	private TreeNode dfs(int[] preorder, int start, int[] inorder, int end,
			int length) {
		// �������壺start����������ʼλ�ã�
		// end�������������λ�ã�length�� �����ڵ���
		if (length <= 0)
			return null;
		int value = preorder[start];
		TreeNode root = new TreeNode(value);

		// �ݹ���ֹ����������ֻ��һ���ڵ�
		if (length == 1)
			return root;

		// �ֲ���������������������
		int i = 0;
		while (i < length) {
			if (value == inorder[end - i]) {
				break;
			}
			i++;
		}
		// ����������������
		root.left = dfs(preorder, start + 1, inorder, end - i - 1, length - i
				- 1);
		// ����������������
		// root.right = dfs(preorder, end - i + 1, inorder, end, i);
		root.right = dfs(preorder, start + length - i, inorder, end, i);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromPreorderandInorderTraversal test = new ConstructBinaryTreefromPreorderandInorderTraversal();
		int[] preorder = { 4, 1, 2, 3 };
		int[] inorder = { 1, 2, 3, 4 };
		TreeNode root = test.buildTree(preorder, inorder);
	}
}
package Tree;

/*
 * ��һ�����������ҷ�ת�������ҶԳƵķ�ת
 * �ݹ�ⷨ��һ�η�ת�ڵ�����ҽ�㣬Ȼ��ݹ鷭ת���Һ���
 * �������ķֲ��������ÿһ�����ν���������Ӧ�Ľڵ�
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

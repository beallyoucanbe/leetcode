package Tree;
/*
 * Given a binary tree, find the maximum path sum. 
 * For this problem, a path is defined as any sequence of nodes 
 * from some starting node to any node in the tree along the parent-child connections. 
 * The path does not need to go through the root.
 */

/*
 * �����ĵײ㿪ʼ���㣬��Ҫ����ÿ���ڵ���Ӧ�����ֵ��
 * �ݹ�ı��ʽ��ΪMath.max(root, root + left, root + right);
 */
public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		if(root == null)
			return 0;
		maxSum(root);
		return max;
	}

	public int maxSum(TreeNode root){
		if(root == null)
			return 0;
		 int leftVal = maxSum(root.left);  //�ݹ�����֧·������
		 int rightVal = maxSum(root.right); //�ݹ�����֧·������
		 //�����ǰ�ֲ��⣨root, root + left, root+ right, root + left + right��
		 //�����Ž⣬��������ս��
		 int curMax = root.val;
		 if(leftVal > 0)
			 curMax += leftVal;
		 if(rightVal > 0)
			 curMax += rightVal;
		 if(curMax > max)
			 max = curMax;
		 
		 //���ش�Ҷ�ӽڵ㵽root�����·���ͣ�root, root + left, root + right��;
		 return Math.max(root.val, Math.max(root.val + leftVal, root.val + rightVal));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

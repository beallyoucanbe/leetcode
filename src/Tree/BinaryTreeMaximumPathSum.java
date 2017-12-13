package Tree;
/*
 * Given a binary tree, find the maximum path sum. 
 * For this problem, a path is defined as any sequence of nodes 
 * from some starting node to any node in the tree along the parent-child connections. 
 * The path does not need to go through the root.
 */

/*
 * 从树的底层开始计算，需要计算每个节点相应的最大值，
 * 递归的表达式即为Math.max(root, root + left, root + right);
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
		 int leftVal = maxSum(root.left);  //递归求左支路的最大和
		 int rightVal = maxSum(root.right); //递归求右支路的最大和
		 //如果当前局部解（root, root + left, root+ right, root + left + right）
		 //是最优解，则更新最终结果
		 int curMax = root.val;
		 if(leftVal > 0)
			 curMax += leftVal;
		 if(rightVal > 0)
			 curMax += rightVal;
		 if(curMax > max)
			 max = curMax;
		 
		 //返回从叶子节点到root的最大路径和（root, root + left, root + right）;
		 return Math.max(root.val, Math.max(root.val + leftVal, root.val + rightVal));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

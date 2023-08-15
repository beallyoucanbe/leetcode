package Tree;
/**
 * Arrays
 * 方法判断一棵树是否是另外一棵树的子树
 * @author shuoyi.zhao
 *
 */
public class isSubtree {

	public boolean isSubtree(TreeNode root1, TreeNode root2){
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		boolean result = false;
		if(root1.getVal() == root2.getVal())
			result = ispart(root1, root2);
		if(!result)
			result = isSubtree(root1.getLeft(), root2);
		if(!result)
			result = isSubtree(root1.getRight(), root2);
		return result;
	}
	
	private boolean ispart(TreeNode node1, TreeNode node2){
		if(node2 == null)
			return true;
		if(node1 == null)
			return false;
		if(node1.getVal() != node2.getVal())
			return false;
		return ispart(node1.getLeft(), node2.getLeft()) && ispart(node1.getRight(), node2.getRight());
	}
}

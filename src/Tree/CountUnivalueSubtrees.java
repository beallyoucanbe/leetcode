package Tree;
/**
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5
 

return 4.
 * @author shuoyi.zhao
 *
 */
public class CountUnivalueSubtrees {
	
	private int count = 0;
	 public int countUnivalSubtrees(TreeNode root) {
		 isUnivalSubtree(root);
		 return count;
	 }
	 private boolean isUnivalSubtree(TreeNode root){
		 if(root == null)
			 return true;
		 if(root.left == null && root.right == null){
			 count++;
			 return true;
		}
		 boolean left = isUnivalSubtree(root.left);
		 boolean right = isUnivalSubtree(root.right);
		 if(left && right && (root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)){
			 count++;
			 return true;
		 }
		 return false;
	 }
}

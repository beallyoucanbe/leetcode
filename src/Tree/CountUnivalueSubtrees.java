package Tree;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * <p>
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * <p>
 * For example:
 * Given binary tree,
 * <p>
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * <p>
 * <p>
 * return 4.
 *
 * @author shuoyi.zhao
 */
public class CountUnivalueSubtrees {

  private int count = 0;

  public int countUnivalSubtrees(TreeNode root) {
    isUnivalSubtree(root);
    return count;
  }

  private boolean isUnivalSubtree(TreeNode root) {
    if (root == null)
      return true;
    if (root.getLeft() == null && root.getRight() == null) {
      count++;
      return true;
    }
    boolean left = isUnivalSubtree(root.getLeft());
    boolean right = isUnivalSubtree(root.getRight());
    if (left && right && (root.getLeft() == null || root.getVal() == root.getLeft().getVal()) && (
        root.getRight() == null || root.getVal() == root.getRight().getVal())) {
      count++;
      return true;
    }
    return false;
  }
}

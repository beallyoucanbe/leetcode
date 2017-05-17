package Tree;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
 * where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:

    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.

 

Show Hint 

Follow up:
Can you figure out ways to solve it with O(n) time complexity?
 * @author shuoyi.zhao
 *
 */
/*
 * 方法。可以借鉴判断一棵树是否是二叉树的方法来做，如果是的话，就实时更新节点数
 * 非O(n)的方法，也是最容易想到的，从顶部向底部，对每个节点进行判断是否为搜索树，并返回其节点数
 * 另外一种就是从底部向上，也就是深度优先，先递归到叶子，然后向上判断，只遍历一次
 */
/*
 * 考虑重新定义节点信息，把当前节点的信息如是否是搜索树，最大节点数等添加到节点中去
 */
public class LargestBSTSubtree2 {
	
	public int largestBSTSubtree(TreeNode root) {
		if(root == null)
			return 0;
		return 0;
	}
}

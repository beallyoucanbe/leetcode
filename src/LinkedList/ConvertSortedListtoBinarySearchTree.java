package LinkedList;

import Tree.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author shuoyi.zhao
 *
 */
public class ConvertSortedListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		return constructTree(head, null);
	}
	public TreeNode constructTree(ListNode left, ListNode right){
		if(left == right)
			return null;
		ListNode p = left;
		ListNode  q = left;
		while(q != right && q.next != right){
			p = p.next;
			q = q.next.next;
		}
		TreeNode root = new TreeNode(p.val);
		root.left = constructTree(left, p);
		root.right = constructTree(p.next, right);
		return root;
	}
	public static void main(String[] args) {
		
	}
}

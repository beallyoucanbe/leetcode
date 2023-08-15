package LinkedList;

import java.awt.HeadlessException;

import javax.xml.transform.Templates;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author shuoyi.zhao
 *
 */
public class ReverseNodesink_Group {

	public ListNode reverseKGroup(ListNode head, int k) {

		if(head == null || head.getNext() == null || k <= 1)
			return head;
		ListNode newhead = new ListNode(0);
		newhead.setNext(head);
		ListNode pre = newhead;
		ListNode left = head;
		ListNode right = left;
		while(right != null){
			for(int i = 1; i < k; i++){
				right = right.getNext();
				if(right == null)
					break;
			}
			if(right == null)
				break;
			pre.setNext(reverse(left, right));
			pre = left;
			left = right = left.getNext();
		}
		return newhead.getNext();
	}
	public ListNode reverse(ListNode left, ListNode right){
		ListNode newhead = new ListNode(0);
		newhead.setNext(left);
		while(newhead.getNext() != right){
			ListNode tmp = left.getNext();
			left.setNext(tmp.getNext());
			tmp.setNext(newhead.getNext());
			newhead.setNext(tmp);
		}
		return newhead.getNext();
	}
	public static void main(String[] args) {
		ReverseNodesink_Group test = new ReverseNodesink_Group();
		int[] nums = {1,2,3,4,5,6,7,8};
		ListNode head = ListNodeFunction.arrayToList(nums);
		head  =  test.reverseKGroup(head, 3);
		ListNodeFunction.display(head);
	}
}

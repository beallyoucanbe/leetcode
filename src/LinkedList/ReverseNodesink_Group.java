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

		if(head == null || head.next == null || k <= 1)
			return head;
		ListNode newhead = new ListNode(0);
		newhead.next  = head;
		ListNode pre = newhead;
		ListNode left = head;
		ListNode right = left;
		while(right != null){
			for(int i = 1; i < k; i++){
				right = right.next;
				if(right == null)
					break;
			}
			if(right == null)
				break;
			pre.next = reverse(left, right);
			pre = left;
			left = right = left.next;
		}
		return newhead.next;
	}
	public ListNode reverse(ListNode left, ListNode right){
		ListNode newhead = new ListNode(0);
		newhead.next = left;
		while(newhead.next != right){
			ListNode tmp = left.next;
			left.next = tmp.next;
			tmp.next = newhead.next;
			newhead.next = tmp;
		}
		return newhead.next;
	}
	public static void main(String[] args) {
		ReverseNodesink_Group test = new ReverseNodesink_Group();
		int[] nums = {1,2,3,4,5,6,7,8};
		ListNode head = ListNodeFunction.arrayToList(nums);
		head  =  test.reverseKGroup(head, 3);
		ListNodeFunction.display(head);
	}
}

package LinkedList;

/*
 * 在链表中，交换每两个相邻的节点
 */

public class SwapNodes {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newhead = new ListNode(0);
		newhead.next = head;
		ListNode pre = newhead;
		ListNode cur = pre.next;
		while (cur != null && cur.next != null) {

			ListNode temp = cur.next.next;
			pre.next = cur.next;
			cur.next.next = cur;
			cur.next = temp;
			cur = cur.next;
			pre = pre.next.next;
		}
		head = newhead.next;
		return head;
	}
	
	public static void main(String[] args){
		SwapNodes test = new SwapNodes();
		int[] nums = {1};
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);	
		
		ListNode newlist = test.swapPairs(head);
		node.display(newlist);
	} 
}

package LinkedList;

/*
 * 在链表中，交换每两个相邻的节点
 */

public class SwapNodes {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.getNext() == null)
			return head;
		ListNode newhead = new ListNode(0);
		newhead.setNext( head);
		ListNode pre = newhead;
		ListNode cur = pre.getNext();
		while (cur != null && cur.getNext() != null) {

			ListNode temp = cur.getNext().getNext();
			pre.setNext(cur.getNext());
			cur.getNext().setNext(cur);
			cur.setNext(temp);
			cur = cur.getNext();
			pre = pre.getNext().getNext();
		}
		head = newhead.getNext();
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

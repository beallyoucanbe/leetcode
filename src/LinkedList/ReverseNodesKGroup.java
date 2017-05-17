package LinkedList;

public class ReverseNodesKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {

		if (head == null || head.next == null || k == 1)
			return head;
		ListNode newhead = new ListNode(0);
		newhead.next = head;
		ListNode pre = newhead;
		ListNode start = pre.next;
		while (true) {
			ListNode index = start;
			for (int i = 1; i < k; i++) {
				index = index.next;
				if (index == null)
					break;
			}
			if (index == null)
				break;
			ListNode tail = index;
			ListNode next = tail.next;
			reverseKGroup(start, tail);
			pre.next = start;
			tail.next = next;
			pre = tail;
			start = pre.next;
		}
		head = newhead.next;
		return head;
	}
	public void reverseKGroup(ListNode start, ListNode tail) {

		ListNode pre = start;
		ListNode cur = pre.next;
		pre.next = null;
		while (cur != tail) {
              ListNode temp = cur.next;
              cur.next = pre;
              pre = cur;
              cur = temp;
		}	
		tail.next = pre;
	}
}

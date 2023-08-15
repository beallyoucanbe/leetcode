package LinkedList;

public class ReverseNodesKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {

		if (head == null || head.getNext() == null || k == 1)
			return head;
		ListNode newhead = new ListNode(0);
		newhead.setNext(head);
		ListNode pre = newhead;
		ListNode start = pre.getNext();
		while (true) {
			ListNode index = start;
			for (int i = 1; i < k; i++) {
				index = index.getNext();
				if (index == null)
					break;
			}
			if (index == null)
				break;
			ListNode tail = index;
			ListNode next = tail.getNext();
			reverseKGroup(start, tail);
			pre.setNext(start);
			tail.setNext(next);
			pre = tail;
			start = pre.getNext();
		}
		head = newhead.getNext();
		return head;
	}
	public void reverseKGroup(ListNode start, ListNode tail) {

		ListNode pre = start;
		ListNode cur = pre.getNext();
		pre.setNext(null);
		while (cur != tail) {
              ListNode temp = cur.getNext();
              cur.setNext(pre);
              pre = cur;
              cur = temp;
		}	
		tail.setNext(pre);
	}
}

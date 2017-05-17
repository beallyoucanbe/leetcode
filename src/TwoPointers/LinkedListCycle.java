package TwoPointers;

/*
 * Given a linked list, determine if it has a cycle in it.
 */

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode node1 = head, node2 = head;
		while (node2 != null && node2.next !=null) {
			node1 = node1.next;
			node2 = node2.next.next;
			if (node1 == node2)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 7032, 15013, 6890, 8877, 11344, 320, 13037, 9414, 6817,
				2509, 3158, 3882, -4438, 10054, -6376, 9356, -807, 8661, 10824,
				-2218};
		LinkedListCycle test = new LinkedListCycle();
		ListNode head = ListNodeFunction.arrayToList(nums);
		ListNodeFunction.display(head);
		System.out.println(test.hasCycle(head));
	}
}

package TwoPointers;

/*
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 */
public class LinkedListCycle2 {

	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null)
			return null;
		ListNode slow = head, fast = head;
		//只需判断快指针是否为空即可
		while (fast.next !=null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast){ // node1 当前位置为相遇地点
				fast = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}

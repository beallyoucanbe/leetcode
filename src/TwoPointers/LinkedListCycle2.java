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
		//ֻ���жϿ�ָ���Ƿ�Ϊ�ռ���
		while (fast.next !=null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast){ // node1 ��ǰλ��Ϊ�����ص�
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

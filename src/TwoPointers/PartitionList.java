package TwoPointers;

/*
 * Given a linked list and a value x, partition it 
 * such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */

public class PartitionList {

	public ListNode partition(ListNode head, int x) {

		if (head == null)
			return head;
		ListNode node = head;
		ListNode head1 = null, tail1 = null, head2 = null, tail2 = null;
		while (node != null) {
			if (node.val < x) {
				if (head1 == null) {
					head1 = tail1 = new ListNode(node.val);
				} else {
					tail1.next = new ListNode(node.val);
					tail1 = tail1.next;
				}
			} else {
				if (head2 == null) {
					head2 = tail2 = new ListNode(node.val);
				} else {
					tail2.next = new ListNode(node.val);
					tail2 = tail2.next;
				}
			}
			node = node.next;
		}
		if(head1 == null)
			return head2;
		tail1.next = head2;
		return head1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PartitionList test = new PartitionList();
		int[] nums = { 1 };
		ListNode head = ListNodeFunction.arrayToList(nums);
		ListNodeFunction.display(head);
		head = test.partition(head, 0);
		ListNodeFunction.display(head);
	}

}

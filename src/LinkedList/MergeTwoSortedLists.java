package LinkedList;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode node1 = l1, node2 = l2, newhead = null, newtail = null;
		while (node1 != null && node2 != null) {
			if (node1.getVal() < node2.getVal()) {
				if (newhead == null) {
					newhead = node1;
					newtail = node1;
					node1 = node1.getNext();
				} else {
					newtail.setNext(node1);
					newtail = newtail.getNext();
					node1 = node1.getNext();
				}
			} else {
				if (newhead == null) {
					newhead = node2;
					newtail = node2;
					node2 = node2.getNext();
				} else {
					newtail.setNext(node2);
					newtail = newtail.getNext();
					node2 = node2.getNext();
				}
			}
		}
		while (node1 != null) {
			newtail.setNext(node1);
			newtail = newtail.getNext();
			node1 = node1.getNext();
		}
		while (node2 != null) {
			newtail.setNext(node2);
			newtail = newtail.getNext();
			node2 = node2.getNext();
		}
		return newhead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoSortedLists test = new MergeTwoSortedLists();
		int[] nums1 = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };
		int[] nums2 = { 2, 4, 5, 6, 8, 12, 23 };
		ListNodeFunction node = new ListNodeFunction();
		ListNode headA = node.arrayToList(nums1);
		ListNode headB = node.arrayToList(nums2);
		node.display(headA);
		node.display(headB);
		ListNode newlist = test.mergeTwoLists(headA, headB);
		node.display(newlist);
	}
}

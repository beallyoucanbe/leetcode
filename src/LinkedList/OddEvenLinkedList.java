package LinkedList;

import java.util.Arrays;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. 
 * The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example:Given 1->2->3->4->5->NULL,  return 1->3->5->2->4->NULL.
 */
/**
 * 学习分割单链表的方法，奇偶分割成为两个单链表
 */

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {

		if (head == null || head.getNext() == null || head.getNext().getNext() == null)
			return head;
		ListNode oddhead = head, oddtail = oddhead, evenhead = head.getNext(), eventail = evenhead;
		head = head.getNext().getNext();
		boolean flag = true; // 标志位，用来判断是奇数还是偶数
		while (head != null) { // 这种方法是把
			if (flag) {
				oddtail.setNext(head);
				oddtail = oddtail.getNext();

			} else {
				eventail.setNext(head);
				eventail = eventail.getNext();
			}
			head = head.getNext();
			flag = !flag;
		}
		oddtail.setNext(null);
		eventail.setNext(null);
		oddtail.setNext(evenhead);
		return oddhead;
	}

	public ListNode oddEvenList2(ListNode head) {
		if(head == null || head.getNext() == null)
			return head;
		ListNode odd = head, even = head.getNext(), evenhead = head.getNext();
		while(even != null && even.getNext() != null){  // 为什么要两重非空的保证
			odd.setNext(even.getNext());
			odd = even.getNext();
			even.setNext( odd.getNext());
			even = even.getNext();
		}
		odd.setNext(evenhead);
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OddEvenLinkedList test = new OddEvenLinkedList();
		ListNodeFunction lists = new ListNodeFunction();
		int[] nums = new int[5];
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int) (Math.random() * 10);
		System.out.println(Arrays.toString(nums));
		ListNode head = lists.arrayToList(nums);
		lists.display(head);
		lists.display(test.oddEvenList2(head));
	}

}

package LinkedList;

import java.util.Arrays;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 */
/*
 * 解题方法：首先利用快慢指针将单链表分为两部分（注意奇偶以及左右的位置），然后将后半部分翻转，最后一一插入即可
 * 最开始使用递归的方式旋转单链表，但是实际运行中发现当数据量过大时会出现堆栈溢出的错误，所以还是要使用迭代的方式去避免
 */
public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null || head.getNext() == null || head.getNext().getNext() == null)
			return;
		ListNode slow = head, fast = head, pre = null; // 第一步：利用快慢指针将单链表从中间位置分开成为两个链表
		while (fast != null && fast.getNext() != null) {
			pre = slow;
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		pre.setNext(null);
		ListNode left = head; // left和right即为单链表的左右两个部分
		ListNode right = slow;

		// 第二部，将后半部分翻转
		right = reverseList2(right);
		// 第三部： 将两部分依次合并
		ListNode lnode = left, rnode = right;
		head = left;
		while (rnode != null) {
			if ((lnode.getNext() != null && rnode.getNext() != null) || (lnode.getNext() == null && rnode.getNext() == null)) {
				ListNode temp = rnode;
				rnode = rnode.getNext();
				ListNode second = lnode.getNext();
				lnode.setNext(temp);
				temp.setNext(second);
				lnode = second;
			}
			else{
				lnode.setNext(rnode);
				break;
			}
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.getNext() == null)
			return head;
		ListNode second = head.getNext();
		head.setNext(null);
		ListNode res = reverseList(second);
		second.setNext(head);
		return res;
	}
	
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.getNext() == null)
			return head;
		ListNode second = head.getNext();
		head.setNext(null);
		while(second != null){
			ListNode temp = second;
			second = second.getNext();
			temp.setNext(head);
			head = temp;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReorderList test = new ReorderList();
		ListNodeFunction lists = new ListNodeFunction();
		int[] nums = new int[9];
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int) (Math.random() * 100);
		System.out.println(Arrays.toString(nums));
		ListNode head = lists.arrayToList(nums);
		lists.display(head);
		test.reorderList(head);
		lists.display(head);
	}

}

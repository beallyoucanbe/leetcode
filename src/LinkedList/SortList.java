package LinkedList;

import java.util.Arrays;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 时间复杂度为nlog(n)的排序算法首先想到为归并排序和快速排序，而其他如冒泡，选择均为n^2.
 * 这里选用数组的归并排序来实现链表的归并排序，
 * 有一个问题即为如何找到链表的中间节点将链表分为两段，最快的方法是选用fast-low方法，一个指针每次走一步，一个指针每次走两步
 * 当快指针为null时， 慢指针即为链表的中间位置
 */
public class SortList {

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;
		return mergeSort(head);
	}

	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)   //如果只有一个元素或为空，则直接返回
			return head;
		ListNode slow = head, fast = head, pre = null;  // 通过快慢指针把单链表分为左右两个单链表
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNodeFunction.display(head);
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(slow);
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode head = new ListNode(0); // 建立一个临时头节点，最后要记得删除
		ListNode tail = head;
		while (left != null && right != null) {
			if (left.val > right.val) {
				tail.next = right;
				right = right.next;
			} else {
				tail.next = left;
				left = left.next;
			}
			tail = tail.next;
		}
		if (left != null)
			tail.next = left;
		if (right != null)
			tail.next = right;
		head = head.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortList test = new SortList();
		int[] nums = new int[10];
		for(int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random() * 100);
		System.out.println(Arrays.toString(nums));
		ListNode head = ListNodeFunction.arrayToList(nums);
		ListNodeFunction.display(head);
		ListNodeFunction.display(test.sortList(head));
	}

}

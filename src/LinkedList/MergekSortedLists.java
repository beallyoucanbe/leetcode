package LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 */
/*
 * 分析：可以借鉴归并排序的算法，用分治法，每次两两合并
 */

public class MergekSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return helper(lists, 0, lists.size() - 1);
	}

	private ListNode helper(ArrayList<ListNode> lists, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			return merge(helper(lists, l, m), helper(lists, m + 1, r));
		}
		return lists.get(l);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		dummy.next = l1;
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				l1 = l1.next;
			} else {
				ListNode next = l2.next;
				cur.next = l2;
				l2.next = l1;
				l2 = next;
			}
			cur = cur.next;
		}
		if (l2 != null)
			cur.next = l2;
		return dummy.next;
	}

	public ListNode mergeKLists2(ListNode[] lists) {

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				new Comparator<ListNode>() {
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}
				});

		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			if (node != null)
				heap.add(node);
		}

		ListNode head = null;
		ListNode tail = head;

		while (heap.size() > 0) {
			ListNode item = heap.poll();
			if (item != null) {
				if (head == null) {
					head = item;
					tail = head;
				} else {
					tail.next = item;
					tail = tail.next;
				}
			}
			item = item.next;
			if (item != null) {
				heap.add(item);
			}
		}
		return head;
	}

	public static void main(String[] args) {

		MergekSortedLists test = new MergekSortedLists();
		int[] nums1 = { 1, 4, 7, 9 };
		int[] nums2 = { 3, 6, 12, 16, 17, 21 };
		int[] nums3 = { 8, 15 };
		ListNode list1 = ListNodeFunction.arrayToList(nums1);
		ListNode list2 = ListNodeFunction.arrayToList(nums2);
		ListNode list3 = ListNodeFunction.arrayToList(nums3);
		ListNode[] lists = new ListNode[3];
		lists[1] = list1;
		lists[2] = list2;
		lists[3] = list3;
		for (ListNode list : lists) {
			ListNodeFunction.display(list);
		}
		ListNode result = test.mergeKLists2(lists);
		ListNodeFunction.display(result);
	}
}

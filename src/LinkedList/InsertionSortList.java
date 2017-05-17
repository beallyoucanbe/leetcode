package LinkedList;

import java.util.Arrays;

/*
 * Sort a linked list using insertion sort.
 * �ò�������ķ�ʽ
 * ��ʵ���������黹��Ҫ��һЩ����������������ʡȥ�˺ཻܶ���Ĺ�����ֻ��Ҫ�ҵ���ȷ��λ�ã�Ȼ��ѵ�ǰ�ڵ���뵽��ȷ��λ�ü���
 */
public class InsertionSortList {

	// ����Ĳ������򷽷�
	public void insertionSort(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			int a = nums[i];
			for (int j = i; j >= 0; j--) {
				if (nums[j] < nums[j - 1])
					nums[j] = nums[j - 1];
				else
					break;
			}
		}
	}

	public ListNode insertionSortList(ListNode head) {

		if (head == null || head.next == null)
			return head;
		ListNode newhead = new ListNode(Integer.MIN_VALUE); // �½�һ����ͷ��������Сֵ�������Ժ�Ĳ���
		while (head != null) {
			ListNode temp = head;
			head = head.next;
			insert(newhead, temp);
		}
		head = newhead.next;
		return head;
	}

	private void insert(ListNode newhead, ListNode temp) {
		ListNode p = newhead;
		ListNode pre = null;
		int num = temp.val;
		while (p != null) {
			if (p.val <= num) {
				pre = p;
				p = p.next;
			} else
				break;
		}
		temp.next = p;
		pre.next = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InsertionSortList test = new InsertionSortList();
		ListNodeFunction lists = new ListNodeFunction();
		int[] nums = new int[9];
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int) (Math.random() * 10);
		ListNode head = lists.arrayToList(nums);
		System.out.println(Arrays.toString(nums));
		lists.display(head);
		lists.display(test.insertionSortList(head));
	}
}

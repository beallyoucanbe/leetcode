package LinkedList;

import java.util.Arrays;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * ʱ�临�Ӷ�Ϊnlog(n)�������㷨�����뵽Ϊ�鲢����Ϳ������򣬶�������ð�ݣ�ѡ���Ϊn^2.
 * ����ѡ������Ĺ鲢������ʵ������Ĺ鲢����
 * ��һ�����⼴Ϊ����ҵ�������м�ڵ㽫�����Ϊ���Σ����ķ�����ѡ��fast-low������һ��ָ��ÿ����һ����һ��ָ��ÿ��������
 * ����ָ��Ϊnullʱ�� ��ָ�뼴Ϊ������м�λ��
 */
public class SortList {

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;
		return mergeSort(head);
	}

	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)   //���ֻ��һ��Ԫ�ػ�Ϊ�գ���ֱ�ӷ���
			return head;
		ListNode slow = head, fast = head, pre = null;  // ͨ������ָ��ѵ������Ϊ��������������
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
		ListNode head = new ListNode(0); // ����һ����ʱͷ�ڵ㣬���Ҫ�ǵ�ɾ��
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

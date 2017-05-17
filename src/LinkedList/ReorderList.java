package LinkedList;

import java.util.Arrays;

/*
 * Given a singly linked list L: L0��L1������Ln-1��Ln,
 * reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����
 * You must do this in-place without altering the nodes' values.
 */
/*
 * ���ⷽ�����������ÿ���ָ�뽫�������Ϊ�����֣�ע����ż�Լ����ҵ�λ�ã���Ȼ�󽫺�벿�ַ�ת�����һһ���뼴��
 * �ʼʹ�õݹ�ķ�ʽ��ת����������ʵ�������з��ֵ�����������ʱ����ֶ�ջ����Ĵ������Ի���Ҫʹ�õ����ķ�ʽȥ����
 */
public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode slow = head, fast = head, pre = null; // ��һ�������ÿ���ָ�뽫��������м�λ�÷ֿ���Ϊ��������
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode left = head; // left��right��Ϊ�������������������
		ListNode right = slow;

		// �ڶ���������벿�ַ�ת
		right = reverseList2(right);
		// �������� �����������κϲ�
		ListNode lnode = left, rnode = right;
		head = left;
		while (rnode != null) {
			if ((lnode.next != null && rnode.next != null) || (lnode.next == null && rnode.next == null)) {
				ListNode temp = rnode;
				rnode = rnode.next;
				ListNode second = lnode.next;
				lnode.next = temp;
				temp.next = second;
				lnode = second;
			}
			else{
				lnode.next = rnode;
				break;
			}
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode second = head.next;
		head.next = null;
		ListNode res = reverseList(second);
		second.next = head;
		return res;
	}
	
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode second = head.next;
		head.next = null;
		while(second != null){
			ListNode temp = second;
			second = second.next;
			temp.next = head;
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

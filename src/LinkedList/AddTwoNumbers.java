package LinkedList;

import java.util.Arrays;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)  Output: 7 -> 0 -> 8
 */
/*
 * ����Ŀ�����Ͼ��Ƕ������������мӷ���������ĿҪ�󣬸�λ����ͷ���
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode p = l1, q = l2;
		ListNode sum = new ListNode(0);
		ListNode sumtail = sum;
		int carry = 0; // �ӷ��еĽ�λ

		while (p != null && q != null) {
			int a = p.val, b = q.val;
			int num = (a + b + carry);
			carry = num / 10;
			num = num % 10;
			ListNode temp = new ListNode(num);
			sumtail.next = temp;
			sumtail = sumtail.next;
			p = p.next;
			q = q.next;
		}
		if (p != null) {
			while (p != null) {
				int a = p.val;
				int num = (a + carry);
				carry = num / 10;
				num = num % 10;
				ListNode temp = new ListNode(num);
				sumtail.next = temp;
				sumtail = sumtail.next;
				p = p.next;
			}
		}
		if (q != null) {
			while (q != null) {
				int b = q.val;
				int num = (b + carry);
				carry = num / 10;
				num = num % 10;
				ListNode temp = new ListNode(num);
				sumtail.next = temp;
				sumtail = sumtail.next;
				q = q.next;
			}
		}
		if(carry == 1){
			ListNode temp = new ListNode(1);
			sumtail.next = temp;
			sumtail = sumtail.next;
		}
		
		sum = sum.next;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddTwoNumbers test = new AddTwoNumbers();
		ListNodeFunction lists = new ListNodeFunction();
		int[] nums1 = {1};
		int[] nums2 = {9, 9};
		ListNode l1 = lists.arrayToList(nums1);
		ListNode l2 = lists.arrayToList(nums2);
		lists.display(l1);
		lists.display(l2);

		lists.display(test.addTwoNumbers(l1, l2));
	}

}

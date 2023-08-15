package LinkedList;

import java.util.Arrays;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)  Output: 7 -> 0 -> 8
 */
/*
 * 该题目本质上就是对两个大数进行加法，根据题目要求，各位均在头结点
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
		int carry = 0; // 加法中的进位

		while (p != null && q != null) {
			int a = p.getVal(), b = q.getVal();
			int num = (a + b + carry);
			carry = num / 10;
			num = num % 10;
			ListNode temp = new ListNode(num);
			sumtail.setNext(temp);
			sumtail = sumtail.getNext();
			p = p.getNext();
			q = q.getNext();
		}
		if (p != null) {
			while (p != null) {
				int a = p.getVal();
				int num = (a + carry);
				carry = num / 10;
				num = num % 10;
				ListNode temp = new ListNode(num);
				sumtail.setNext(temp);
				sumtail = sumtail.getNext();
				p = p.getNext();
			}
		}
		if (q != null) {
			while (q != null) {
				int b = q.getVal();
				int num = (b + carry);
				carry = num / 10;
				num = num % 10;
				ListNode temp = new ListNode(num);
				sumtail.setNext(temp);
				sumtail = sumtail.getNext();
				q = q.getNext();
			}
		}
		if(carry == 1){
			ListNode temp = new ListNode(1);
			sumtail.setNext(temp);
			sumtail = sumtail.getNext();
		}
		
		sum = sum.getNext();
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

package LinkedList;

import java.util.Arrays;

/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:Given 1->2->3->4->5->NULL and k = 2,
 *                   return 4->5->1->2->3->NULL.
 */

/*
 * ����һ�ַ��������Ȱѵ��������β��ӹ���һ������Ȼ�����ҵ����ʵ�λ�öϿ�������
 */

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null || k == 0)
			return head;
		int length = 1;
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
			length++;
		}
		k = k % length;
		if(k == 0)
			return head;
		for(int i = 0; i < length - k; i++){
			ListNode temp = head;
			head = head.next;
			temp.next = null;
			tail.next = temp;
			tail = tail.next;
		}

		return head;
	}
	
	public ListNode rotateRight2(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		int length = 1;
		ListNode tail = head;   //�ҵ�����Ľڵ�����Լ�β�ڵ�
		while (tail.next != null) {
			tail = tail.next;
			length++;
		}
		k = k % length;
		if(k == 0)
			return head;
		tail.next = head;  //����һ����
		
		int step = length - k - 1;
		ListNode res = head;
		while(step > 0){
			step--;
			res = res.next;
		}
		
		head = res.next;
		res.next = null;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList test = new RotateList();
		ListNodeFunction lists = new ListNodeFunction();
		int[] nums = new int[5];
		for(int i = 0; i < nums.length; i++)
			nums[i] = (int)(Math.random() * 10);
		System.out.println(Arrays.toString(nums));
		ListNode head = lists.arrayToList(nums);
		lists.display(head);
		lists.display(test.rotateRight2(head, 2));
	}

}

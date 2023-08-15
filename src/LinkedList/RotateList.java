package LinkedList;

import java.util.Arrays;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:Given 1->2->3->4->5->NULL and k = 2,
 *                   return 4->5->1->2->3->NULL.
 */

/**
 * 还有一种方法就是先把单链表的收尾相接构成一个环，然后再找到合适的位置断开环即可
 */

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.getNext() == null || k == 0)
			return head;
		int length = 1;
		ListNode tail = head;
		while (tail.getNext() != null) {
			tail = tail.getNext();
			length++;
		}
		k = k % length;
		if(k == 0)
			return head;
		for(int i = 0; i < length - k; i++){
			ListNode temp = head;
			head = head.getNext();
			temp.setNext(null);
			tail.setNext(temp);
			tail = tail.getNext();
		}

		return head;
	}
	
	public ListNode rotateRight2(ListNode head, int k) {
		if (head == null || head.getNext() == null || k == 0)
			return head;
		int length = 1;
		ListNode tail = head;   //找到链表的节点格数以及尾节点
		while (tail.getNext() != null) {
			tail = tail.getNext();
			length++;
		}
		k = k % length;
		if(k == 0)
			return head;
		tail.setNext(head);  //构成一个环
		
		int step = length - k - 1;
		ListNode res = head;
		while(step > 0){
			step--;
			res = res.getNext();
		}
		
		head = res.getNext();
		res.setNext(null);
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

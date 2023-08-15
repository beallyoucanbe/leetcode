package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除链表中所有元素相同的节点，即多个值只保留一个，利用双指针的思想。一个用来遍历链表，一个用来记录当前链表
 */
public class RemoveDuplicates {

	public ListNode deleteDuplicates(ListNode head) {

		if(head == null)
			return head;
		Set set = new HashSet<Integer>();
		//把第一个元素放进集合
		set.add(head.getVal());
		ListNode cur = head;
		ListNode next = head.getNext();
		while(next != null){
			if(!set.contains(next.getVal())){
				set.add(next.getVal());
				cur = cur.getNext();
				next = next.getNext();
			}
			else{
				cur.setNext(next.getNext());
				next = next.getNext();
			}		
		}
		return head;
	}

	public static void main(String[] args) {
		RemoveDuplicates test = new RemoveDuplicates();
		int[] nums = { 1, 2, 3,3,4,5,6,7,7,7,7, 4, 5, 6, 7, 8 };
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);

		ListNode newlist = test.deleteDuplicates(head);
		node.display(newlist);
	}

}

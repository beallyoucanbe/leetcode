package LinkedList;

/**
 * 遍历一次即可找到答案的方法
 * 利用双指针，两个指针距离为n,当前面指针指向尾部时，前一个指针指向Nth from the end
 */

public class RemoveNthNodeFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if(head == null)
			return head;
		ListNode first = head;
		for(int i = 1; i < n; i++)
			first = first.getNext();
		
		if(first.getNext() == null)
			return head.getNext();
		first = first.getNext();
		ListNode second = head;
		while(first.getNext() != null){
			first = first.getNext();
			second = second.getNext();
		}
		second.setNext(second.getNext().getNext()) ;
		return head;
	}
	
	public static void main(String[] args){
		RemoveNthNodeFromEnd test = new RemoveNthNodeFromEnd();
		int[] nums = {1, 2, 3};
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);	
		
		ListNode newlist = test.removeNthFromEnd(head, 3);
		node.display(newlist);
	} 

}

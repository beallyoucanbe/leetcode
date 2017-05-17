package LinkedList;

/*
 * 
 * ����һ�μ����ҵ��𰸵ķ���
 * ����˫ָ�룬����ָ�����Ϊn,��ǰ��ָ��ָ��β��ʱ��ǰһ��ָ��ָ��Nth from the end
 */

public class RemoveNthNodeFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if(head == null)
			return head;
		ListNode first = head;
		for(int i = 1; i < n; i++)
			first = first.next;
		
		if(first.next == null)
			return head.next;
		first = first.next;
		ListNode second = head;
		while(first.next != null){
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
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

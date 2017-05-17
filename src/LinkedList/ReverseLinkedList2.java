package LinkedList;

/*
 * ����m��n������m��n֮��Ĳ�����ת���������ֲ���
 * �ؼ�����¼m���ڵ��m-1���ڵ㣬n���ڵ��n-1���ڵ�
 * ����Ҫ���ǵ� m = 1,��������ڿ��������ʱ��һ��Ҫע��ͷ��������
 */

public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || m == n)
			return head;
		ListNode dummyhead = new ListNode(0);
		dummyhead.next = head;
		ListNode before = dummyhead;  //��һ����������ʾ��m-1���ڵ㡣
		for(int i = 0; i < m - 1; i++){
			before = before.next;
			if(before == null)
				return head;
		}
		
		ListNode mNode = before.next;  //start��ʾ��m���ڵ㣬������¼�ýڵ㣬�Ա�ͺ��������������
		
		ListNode newhead = mNode; 
		ListNode next = mNode.next;
		newhead.next = null;
		
		for(int i = m; i < n; i++){
			ListNode temp = next.next;
			next.next = newhead;
			newhead = next;
			next = temp;
		}
		//ѭ������֮��nextnode��Ϊ��һ���ڵ�
		
		before.next = newhead;
		mNode.next = next;
		
		return dummyhead.next;
	}
	public static void main(String[] args){
		ReverseLinkedList2 test = new ReverseLinkedList2();
		int[] nums = {1, 2};
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);	
		
		ListNode newlist = test.reverseBetween(head, 1, 2);
		node.display(newlist);
	} 
	
}

package LinkedList;

/*
 * 给出m和n，把在m和n之间的部分旋转，其他部分不变
 * 关键，记录m个节点和m-1个节点，n个节点和n-1个节点
 * 由于要考虑到 m = 1,的情况，在考虑链表的时候一定要注意头结点的问题
 */

public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || m == n)
			return head;
		ListNode dummyhead = new ListNode(0);
		dummyhead.setNext(head);
		ListNode before = dummyhead;  //用一个变量来表示第m-1个节点。
		for(int i = 0; i < m - 1; i++){
			before = before.getNext();
			if(before == null)
				return head;
		}
		
		ListNode mNode = before.getNext();  //start表示第m个节点，保留记录该节点，以便和后面的链表相连接
		
		ListNode newhead = mNode; 
		ListNode next = mNode.getNext();
		newhead.setNext(null);
		
		for(int i = m; i < n; i++){
			ListNode temp = next.getNext();
			next.setNext(newhead);
			newhead = next;
			next = temp;
		}
		//循环结束之后，nextnode即为下一个节点
		
		before.setNext(newhead);
		mNode.setNext(next);
		
		return dummyhead.getNext();
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

package LinkedList;
/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 用判断有环链表的方法去解决，先把其中一个链表接到另一个链表的结尾处，然后判断这个链表的环的起始位置
 */
public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		ListNode tailA = headA;
		while(tailA.getNext() != null)   //找到链表A的尾节点
			tailA = tailA.getNext();
		//System.out.println(tailA);
		tailA.setNext(headB);  // 把链表B接到A的后面 , 构成一个有环链表
		
		ListNode slow = headA, fast = headA;  //构造两个快慢指针, 判断是否会有焦点
		do{
			if(fast.getNext() == null || fast.getNext().getNext() == null){
				//System.out.println("没有交点");
				tailA.setNext(null);
				return null;
			}
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}while(slow != fast); ///快慢指针会相遇，然后将快指针移动到A的表头		
		fast = headA;
		while(slow != fast){
			slow = slow.getNext();
			fast = fast.getNext();
		}
		tailA.setNext(null);
		//System.out.println("have intersection  " + slow);
		return slow;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionofTwoLinkedLists test = new IntersectionofTwoLinkedLists();
		int[] nums1 = { 1,3,5,7,9,11,13,15,17,19,21};
		int[] nums2 = {2};
		ListNodeFunction node = new ListNodeFunction();
		ListNode headA = node.arrayToList(nums1);
		ListNode headB = node.arrayToList(nums2);
		ListNode newlist = test.getIntersectionNode(headA, headB);
	}
}

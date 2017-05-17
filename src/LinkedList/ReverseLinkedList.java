package LinkedList;

/*
 * 把一个单链表反转
 * 用递归和迭代两种方式
 */

/*
 * 正确认识递归：递归和迭代都是循环的一种。简单地说，递归是重复调用函数自身实现循环。
迭代是函数内某段代码实现循环，而迭代与普通循环的区别是：循环代码中参与运算的变量同时是保存结果的变量，
当前保存的结果作为下一次循环计算的初始值。 递归循环中，遇到满足终止条件的情况时逐层返回来结束。
迭代则使用计数器结束循环。当然很多情况都是多种循环混合采用，这要根据具体需求。
 */
public class ReverseLinkedList {

	//这种方法一直递归到最后一个，然后再返回
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		//get second node
		ListNode second = head.next;
		//set the first's next to be null
		head.next = null;
		ListNode rest = reverseList(second);	
		second.next = head;  //完成以上步棸时，second节点已经被移动到链表的末尾，故只需要将head节点接在末尾即可。
		return rest;
	}
	
	public ListNode reverseList2(ListNode head){
		if(head == null && head.next == null)
			return head;
		ListNode newhead = head;
		head = head.next;
		newhead.next = null;
		
		while(head != null){
			ListNode second = head.next;
			head.next = newhead;
			newhead = head;
			head = second;
		}
		return newhead;
	}

	public static void main(String[] args){
		ReverseLinkedList test = new ReverseLinkedList();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);	
		
		ListNode newlist = test.reverseList(head);
		node.display(newlist);
	} 
}

package LinkedList;
/**
 * 删除链表中所有值为val的节点
 * 用两个指针
 */

/**
 * 1. 对于链表，在删除当前节点时，需要知道当前节点的父节点。
2. 对于非头节点，删除操作很方便，对于头节点需要额外的操作，
为了在遍历的过程中，保持删除操作的一致性和避免区分头节点和非头节点，有两种方法来避免这种麻烦：
①可以为链表设置辅助头节点（即在原来链表前插入头节点），这样对具有辅助头节点的链表，
在遍历时就不存在区分头节点和非头节点的问题。
The key to solve this problem is using a helper node to track the head of the list.
②从头节点的下一个节点开始遍历查找删除，遍历完成后再处理头节点。
 */

/*
 * 当输入只有一个{3}，val = 3时，第一个方法会报错，二三会正常运行，思考为什么。
 */
public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		while (head.getVal() == val)
			head = head.getNext();     //会出现空指针的可能
		ListNode cur = head;
		ListNode next = head.getNext();
		while (next != null) {
			if (next.getVal() == val) {
				cur.setNext(next.getNext());
				next = next.getNext();
			} else {
				next = next.getNext();
				cur = cur.getNext();
			}
		}
		return head;
	}
	
	public ListNode removeElements2(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode cur = head;
		ListNode next = head.getNext();
		while (next != null) {
			if (next.getVal() == val) {
				cur.setNext(next.getNext());
				next = next.getNext();
			} else {
				next = next.getNext();
				cur = cur.getNext();
			}
		}
		if(head.getVal() == val)
			head = head.getNext();
		return head;
	}
	
	public ListNode removeElements3(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode temp = new ListNode(0);
		temp.setNext(head);
		ListNode cur = temp;
		ListNode next = temp.getNext();
		while (next != null) {
			if (next.getVal() == val) {
				cur.setNext(next.getNext());
				next = next.getNext();
			} else {
				next = next.getNext();
				cur = cur.getNext();
			}
		}
		head = temp.getNext();
		return head;
	}
	
	public static void main(String[] args){
		RemoveLinkedListElements test = new RemoveLinkedListElements();
		int[] nums = {3};
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);	
		
		ListNode newlist = test.removeElements2(head, 3);
		node.display(newlist);
	} 

}

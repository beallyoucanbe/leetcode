package LinkedList;

/*
 *  Definition for singly-linked list.
 */
public class ListNode {

	private int val;

	private ListNode next;

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode(int x){
		val = x;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	
	public String toString(){
		return val + " ";
	}
}

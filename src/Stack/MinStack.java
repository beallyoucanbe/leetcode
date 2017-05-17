package Stack;

import java.util.Vector;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack. 
 *  pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element. 
 * getMin() -- Retrieve the minimum element in the stack. 
 */
class Node {
	int val;
	int min;
	Node next;

	public Node(int x) {
		val = x;
		min = x;
		next = null;
	}
}

public class MinStack {
	Node head;

	public void push(int x) {
		if (head == null)
			head = new Node(x);
		else {
			Node temp = new Node(x);
			temp.min = Math.min(x, head.min);
			temp.next = head;
			head = temp;
		}
	}

	public void pop() {

		if (head == null)
			return;
		head = head.next;
	}

	public int top() {

		if (head == null)
			return Integer.MAX_VALUE;
		return head.val;
	}

	public int getMin() {

		if (head == null)
			return Integer.MAX_VALUE;
		return head.min;

	}
}

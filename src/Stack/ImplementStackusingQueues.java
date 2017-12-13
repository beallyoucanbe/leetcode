package Stack;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement the following operations of a stack using queues. 
 * You must use only standard operations of a queue
 * which means only push to back, peek/pop from front, size, 
 * and is empty operations are valid.
 */
/*
 * 在java中，Queue作为公共接口，已经被LinkedList实现，所以，一个LinkList对象可以作为一个Queue来用。
 */

class Queue{
	List<Integer> queue ;
	
	public void push(int x){
		if(queue == null){
			queue = new ArrayList<Integer>();
			queue.add(x);
		}
		else{
			
		}
			
	}
}
public class ImplementStackusingQueues {
	ArrayList mystack;
	// Push element x onto stack.
	public void push(int x) {

		if(mystack == null){
			mystack = new ArrayList<Integer>();
			mystack.add(x);
		}
			
		
	}

	// Removes the element on top of the stack.
	public void pop() {

	}

	// Get the top element.
	public int top() {
		  return 0;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		  return true;
	}

}

package Stack;

import java.util.Stack;

/*
 * Implement the following operations of a queue using stacks. 
 */
public class ImplementQueueusingStacks {

	Stack myQueue;
	 // Push element x to the back of queue.
    public void push(int x) {
        myQueue.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        
    }

    // Get the front element.
    public int peek() {
        return 0;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return myQueue.isEmpty();
    }

}

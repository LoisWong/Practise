import java.util.Stack;


public class Queue {
	class MyQueue {
		Stack<Integer> stack = new Stack<Integer>();
	    // Push element x to the back of queue.
	    public void push(int x) {
	        Stack<Integer> backup = new Stack<Integer>();
	        while(!stack.empty()){
	        	backup.push(stack.pop());
	        }
	        stack.push(x);
	        while(!backup.empty()){
	        	stack.push(backup.pop());
	        }
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        stack.pop(); 
	    }

	    // Get the front element.
	    public int peek() {
	        return stack.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return stack.empty();
	    }
	}
}

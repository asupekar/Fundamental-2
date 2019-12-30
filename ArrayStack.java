package asupekar_lab6;

/**
 * Implements stack using array
 * 
 * @author Aishwarya
 * @version: 1.0
 */
public class ArrayStack {

	private double[] s;	// Holds stack elements
	private int top;	// Stack top pointer

	/**
	 * Constructor.
	 * 
	 * @param capacity The capacity of the stack.
	 */

	public ArrayStack(int capacity) {

		s = new double[capacity];
		top = 0;

	}
	
	/**
	 * 
	 * @return size of the stack
	 */
	public int size() {
		return top;
	}

	/**
	 * The empty method checks for an empty stack.
	 * 
	 * @return true if stack is empty.
	 */

	public boolean empty() {
		return top == 0;
	}

	/**
	 * The push method pushes a value onto the stack.
	 * 
	 * @param x The value to push onto the stack.
	 * @exception StackOverflowException When the stack is full.
	 */

	public void push(double x) {
		if (top == s.length)
			throw new StackOverFlowException();
		else {
			s[top] = x;
			top++;
		}

	}

	/**
	 * The pop method pops a value off the stack.
	 * 
	 * @return The value popped.
	 * @exception EmptyStackException When the stack is empty.
	 */

	public double pop() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			top--;
			return s[top];
		}
	}

	/**
	 * The peek method returns the value at the top of the stack.
	 * 
	 * @return value at top of the stack.
	 * @exception EmptyStackException When the stack is empty.
	 */

	public double peek() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			return s[top - 1];
		}

	}

}

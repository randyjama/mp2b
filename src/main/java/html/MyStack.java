package html;

/*
 * Implementation of a simple stack for HtmlTags.
 * You should implement this class.
 */

import java.util.ArrayList;

public class MyStack {
	// An ArrayList to hold HtmlTag objects.
	private ArrayList<HtmlTag> stack_internal;

	/**
	 * Creates an empty stack
	 */
	public MyStack() {
		this.stack_internal = new ArrayList<HtmlTag>();
	}

	/**
	 * Push a tag onto the top of the stack.
	 * 
	 * @param tag
	 *            must be a valid HtmlTag
	 */
	public void push(HtmlTag tag) {
		stack_internal.add(tag);
	}

	/**
	 * Removes the tag at the top of the stack. Should throw an exception if the
	 * stack is empty.
	 * 
	 * @return HtmlTag from the top of the stack
	 * @throws Exception
	 *             if the stack is empty
	 */
	public HtmlTag pop() throws Exception {
		if (stack_internal.isEmpty()) {
			throw new Exception("Error: Stack is empty.");
		} else { // pop last in array and trim
			HtmlTag result = stack_internal.get(stack_internal.size() - 1);
			stack_internal.remove(stack_internal.size() - 1);
			stack_internal.trimToSize();
			return result;
		}
	}

	/**
	 * Looks at the object at the top of the stack but does not actually remove the
	 * object. Should throw an exception if the stack is empty.
	 * 
	 * @return HtmlTag at the top of the stack
	 * @throws Exception
	 *             if stack is empty
	 */
	public HtmlTag peek() throws Exception {
		if (stack_internal.isEmpty()) {
			throw new Exception("Error: Stack is empty.");
		} else {
			return stack_internal.get(stack_internal.size() - 1);
		}
	}

	/*
	 * Tests if the stack is empty. Returns true if the stack is empty; false
	 * otherwise.
	 */
	/**
	 * Tests if the stack is empty. Returns true if the stack is empty, false
	 * otherwise.
	 * 
	 * @return boolean representing whether or not stack is empty
	 */
	public boolean isEmpty() {
		if (stack_internal.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}

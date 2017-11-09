package html;

/*
 * Implementation of a simple stack for HtmlTags.
 * You should implement this class.
 */

import java.util.ArrayList;

public class MyStack {
	// An ArrayList to hold HtmlTag objects.
	private ArrayList<HtmlTag> stack_internal;

	/*
	 * Create an empty stack.
	 */
	public MyStack( ) {
		this.stack_internal = new ArrayList<HtmlTag>( );
	}

	/*
	 * Push a tag onto the top of the stack.
	 */
	public void push( HtmlTag tag ) {

	}

	/*
	 * Removes the tag at the top of the stack.
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag pop( ) {

	}

	/*
	 * Looks at the object at the top of the stack but
	 * does not actually remove the object.
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag peek( ) {

	}

	/*
	 * Tests if the stack is empty.
	 * Returns true if the stack is empty;
	 * false otherwise.
	 */
	public boolean isEmpty( ) {

	}
}

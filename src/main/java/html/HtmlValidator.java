package html;

import java.util.LinkedList;
import java.util.Queue;

/*
 * This is the HtmlValidator class.
 * You should implement this class.
 */
public class HtmlValidator {

	private Queue<HtmlTag> queue;

	public HtmlValidator() {
		this.queue = new LinkedList<HtmlTag>();
	}

	public HtmlValidator(Queue<HtmlTag> tags) {
		if (tags == null) {
			throw new IllegalArgumentException("Error: Queue cannot be null.");
		}
		this.queue = new LinkedList<>(tags);
	}

	/**
	 * Adds the given tag to the end of validator's queue. If tag passed is null,
	 * throw IllegalArgumentException.
	 * 
	 * @param tag
	 *            cannot be null
	 */
	public void addTag(HtmlTag tag) {
		if (tag == null) {
			throw new IllegalArgumentException("Error: Queue cannot be null.");
		}
		queue.add(tag);
	}

	/**
	 * Return validator's queue of HTML tags. The queue contains all tags that were
	 * passed to the constructor (if any) in their proper order; it should also
	 * reflect any changes made such as adding tags with "addTag" or removing tags
	 * with "removeAll".
	 * 
	 * @return result
	 */
	public Queue<HtmlTag> getTags() {
		return new LinkedList<>(queue);
	}

	/**
	 * Remove from validator's queue any tags that match the given element. This
	 * includes both the opening and closing tags. If element is null, throw an
	 * IllegalArgumentException
	 * 
	 * @param element
	 *            cannot be null
	 */
	public void removeAll(String element) {
		HtmlTag eleOpen = new HtmlTag(element);
		HtmlTag eleClosed = new HtmlTag(element, false);
		while (queue.contains(eleOpen) || queue.contains(eleClosed)) {
			HtmlTag polled = queue.poll();
			if (polled.equals(eleOpen) || polled.equals(eleClosed)) {
				// match: discard polled and get next poll from queue
				polled = null;
			} else {
				// place back into queue
				queue.add(polled);
			}
		}
	}
	
	/**
	 * Returns a string that is an indented text representation of the HTML
	 * tags in the queue. In this string, each tag is on its own line. Every
	 * opening tag that requires a closing tag increases the level of
	 * indentation of following tags by four spaces untilo its closing tag
	 * is reached.
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String validate() throws Exception {
		Queue<HtmlTag> qTemp = new LinkedList<>(queue); 
		MyStack stack = new MyStack();
		
		String result = ""; // each tag is on a new line
		String indent = ""; // each indent increases by 4 spaces
		boolean first = true;
		
		while (!qTemp.isEmpty()) {
			HtmlTag checker = qTemp.poll();
			
			if(!checker.isSelfClosing() && checker.isOpenTag()) {
				result += "\n" + indent + checker.toString();
				stack.push(checker);
				indent += "    ";
			}
			else if (checker.isSelfClosing()) {
				result += "\n" + indent + checker.toString();
			}
			else {
				// check if closing tag matches most recently opened tag
				if (!checker.matches(stack.peek())) {
					result += "\nERROR unexpected tag: " + checker;
				}
				else {
					indent = indent.substring(0, indent.length() - 4);
					result += "\n" + indent + checker.toString();
					stack.pop();
				}
			}
			// initial behaviour of first tag => remove new line
			if (first) {
				result = result.replace("\n", "");
				first = false;
			}
		}
		
		//check if stack is empty
		while (!stack.isEmpty()) {
			
		}
		
		return result;
	}
}


















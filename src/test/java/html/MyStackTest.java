package html;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {

	@Test
	public void test0() throws Exception {
		
		MyStack stack = new MyStack();
		
		HtmlTag a = new HtmlTag("a");
		HtmlTag b = new HtmlTag("b", false);
		HtmlTag c = new HtmlTag("c");
		HtmlTag d = new HtmlTag("d");
		
		stack.push(a);
		stack.push(b);
		stack.push(c);
		stack.push(d);
		
		assertFalse(stack.isEmpty());
		assertEquals(d, stack.peek());
		
		assertEquals(d, stack.pop());
		assertEquals(c, stack.pop());
		assertEquals(b, stack.pop());
		assertEquals(a, stack.pop());
		
		//stack should now be empty
		assertTrue(stack.isEmpty());
		
	}

}

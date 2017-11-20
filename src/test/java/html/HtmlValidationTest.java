package html;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.junit.Test;

public class HtmlValidationTest {

	@Test
	public void test0() {
		HtmlTag tagA = new HtmlTag("c", false);
		HtmlTag tagB = new HtmlTag("c");
		HtmlTag tag1 = new HtmlTag("a");
		HtmlTag tag2 = new HtmlTag("b", false);
		HtmlTag tag3 = new HtmlTag("b");
		HtmlTag tag4 = new HtmlTag("a", false);
		HtmlTag tag5 = new HtmlTag("c", false);
		HtmlTag tag6 = new HtmlTag("c");

		Queue<HtmlTag> queue = new LinkedList<>();
		HtmlValidator val;

		// add tag via actual queue class, no <c> or </c>
		queue.add(tagA);
		queue.add(tagB);
		queue.add(tag1);
		queue.add(tag2);
		queue.add(tag3);
		queue.add(tag4);

		try {
			val = new HtmlValidator(queue);

			// add tag via htmlval class
			val.addTag(tag5);
			val.addTag(tag6);

			assertEquals(8, val.getTags().size());

			val.removeAll("c"); // should remove all <c> and </c>
			assertEquals(queue.size() - 2, val.getTags().size());

		} catch (Exception IllegalArgumentException) {
			fail("Error: illegal argument.");
		}
	}

	// test HtmlValidator validate() method
	@Test
	public void test1() throws Exception {
		Scanner scanner = new Scanner("expected_output_7.txt");
		
		/*
		String content = "";
		do {
			content += new Scanner(new File("expected_output_7.txt")).nextLine().trim();
			//.useDelimiter("\\Z").next();
			System.out.println(content);
		} while (scanner.hasNext());
		*/
		
		String content = new Scanner(new File("expected_output_7.txt")).useDelimiter("//Z").next();
		
		HtmlTag tag1 = new HtmlTag("!doctype");
		//HtmlTag tag2 = new HtmlTag("!-- --");
		HtmlTag tag3 = new HtmlTag("html");
		HtmlTag tag4 = new HtmlTag("head");
		HtmlTag tag5 = new HtmlTag("title");
		HtmlTag tag6 = new HtmlTag("title", false);
		HtmlTag tag7 = new HtmlTag("meta");
		HtmlTag tag8 = new HtmlTag("link");
		HtmlTag tag9 = new HtmlTag("head", false);
		HtmlTag tag10 = new HtmlTag("body");
		HtmlTag tag11 = new HtmlTag("p");
		HtmlTag tag12 = new HtmlTag("a");
		HtmlTag tag13 = new HtmlTag("a", false);
		HtmlTag tag14 = new HtmlTag("p", false);
		HtmlTag tag15 = new HtmlTag("p");
		HtmlTag tag16 = new HtmlTag("img");
		HtmlTag tag17 = new HtmlTag("p", false);
		HtmlTag tag18 = new HtmlTag("body", false);
		HtmlTag tag19 = new HtmlTag("html", false);


		
		Queue<HtmlTag> queue = new LinkedList<>();
		
		queue.add(tag1);
		//queue.add(tag2);
		queue.add(tag3);
		queue.add(tag4);
		queue.add(tag5);
		queue.add(tag6);
		queue.add(tag7);
		queue.add(tag8);
		queue.add(tag9);
		queue.add(tag10);
		queue.add(tag11);
		queue.add(tag12);
		queue.add(tag13);
		queue.add(tag14);
		queue.add(tag15);
		queue.add(tag16);
		queue.add(tag17);
		queue.add(tag18);
		queue.add(tag19);
		
		HtmlValidator val = new HtmlValidator(queue);
		
		System.out.println(val.validate());
		// assertEquals(content.trim(), val.validate().trim());
	}

	// test error handling
	@Test
	public void test2() throws Exception {

		// MANUALLY CONSTRUCT THE STRING RESULT FOR COMPARISON

		HtmlTag tag1 = new HtmlTag("!doctype");
		HtmlTag tag2 = new HtmlTag("a"); // unclosed
		HtmlTag tag3 = new HtmlTag("headings");
		HtmlTag tag4 = new HtmlTag("title");
		HtmlTag tag5 = new HtmlTag("meta");
		HtmlTag tag6 = new HtmlTag("meta");
		HtmlTag tag7 = new HtmlTag("title", false);
		HtmlTag tag8 = new HtmlTag("headings", false);
		HtmlTag tag9 = new HtmlTag("title", false); // extra

		String compare = tag1.toString() + "\n" + tag2.toString() + "\n    " + tag3.toString() + "\n        "
				+ tag4.toString() + "\n            " + tag5.toString() + "\n            " + tag6.toString()
				+ "\n        " + tag7.toString() + "\n    " + tag8.toString() + "\nERROR unexpected tag: "
				+ tag9.toString() + "\nERROR unclosed tag: <a>";

		Queue<HtmlTag> queue = new LinkedList<>();

		queue.add(tag1);
		queue.add(tag2);
		queue.add(tag3);
		queue.add(tag4);
		queue.add(tag5);
		queue.add(tag6);
		queue.add(tag7);
		queue.add(tag8);
		queue.add(tag9);

		HtmlValidator val = new HtmlValidator(queue);

		System.out.println(val.validate());
		System.out.println(compare);

		assertEquals(compare, val.validate());
	}

}

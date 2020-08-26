package assgn2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class loopArrayTest {

	private loopArray<String> testArray;
	
	@Before
	public void setup() throws Exception {
		System.out.println("Setting it up!");
		testArray = new loopArray<>();
	}
	@Test
	public void testOffer() {
		System.out.println("Running: testOffer");
		testArray.offer("Sink");
		testArray.offer("quater");
		assertEquals("Sink",testArray.peek());
	}
	@Test
	public void testPoll() {
		System.out.println("Running: testPop");
		testArray.offer("Sink");
		String str = testArray.poll();
		assertEquals("Sink",str);
	}

	@After
	public void afterEachTestMethod() {
		System.out.println("TearDown!");
		testArray = null;
		assertNull(testArray);
	}
}

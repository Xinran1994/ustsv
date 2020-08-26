package assgn3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assgn2.loopArray;

public class SimplePriorityQueueTest {

	private SimplePriorityQueue pq1;
	private SimplePriorityQueue pq2;
	private SimplePriorityQueue pq3;
	
//	three queue:
//	1. initial capacity;
//	2. given capacity;
//	3. passing a array;
	
	@Before
	public void setup() throws Exception {
		System.out.println("Setting it up!");
		pq1 = new SimplePriorityQueue();
		pq2 = new SimplePriorityQueue(17);
		pq3 = new SimplePriorityQueue(new int[] {9,4,7,3,5,8});
		
	}
	// test pq1
	@Test
	public void test_PQ1_Add() {
		System.out.println("Running: test qp1 Add");
		pq1.add(0);
		assertEquals(0, pq1.peek());
	}
	@Test
	public void test_PQ1_Poll() {
		System.out.println("Running: test pq1 Poll");
		pq1.add(4);
		pq1.add(2);
		pq1.poll();
		assertEquals(4, pq1.peek());
	}
	// test pq2
	@Test
	public void test_PQ2_Add() {
		System.out.println("Running: test qp1 Add");
		pq2.add(0);
		assertEquals(0, pq2.peek());
	}
	@Test
	public void test_PQ2_Poll() {
		System.out.println("Running: test pq1 Poll");
		pq2.add(4);
		pq2.add(2);
		pq2.poll();
		assertEquals(4, pq2.peek());
	}
	// test pq3
	@Test
	public void test_PQ3_Add() {
		System.out.println("Running: test qp1 Add");
		pq3.add(0);
		assertEquals(0, pq3.peek());
	}
	@Test
	public void test_PQ3_Poll() {
		System.out.println("Running: test pq1 Poll");
		pq3.poll();
		assertEquals(4, pq3.peek());
	}

	@After
	public void afterEachTestMethod() {
		System.out.println("TearDown!");
		pq1 = null;
		pq2 = null;
		pq3 = null;
		assertNull(pq1);
		assertNull(pq2);
		assertNull(pq3);
	}

}

package assgn4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assgn3.SimplePriorityQueue;

public class SimpleHashMapTest {
	
	private SimpleHashMap<Integer, Integer> map;

	@Before
	public void setup() throws Exception {
		System.out.println("Setting it up!");
		map = new SimpleHashMap<>(5, 0.82F);
		
	}

	@Test
	public void test_map_put() {
		System.out.println("Running: test qp1 Add");
		map.put(0, 1);
		assertEquals((Integer)1, map.get(0));
	}
	
	@Test
	public void test_map_update() {
		System.out.println("Running: test pq1 Poll");
		map.put(0, 4);
		assertEquals((Integer)4, map.get(0));
	}
	
	@Test
	public void test_map_remove() {
		System.out.println("Running: test qp1 Add");
		map.remove(0);
		assertEquals(null, map.get(0));
	}
	
	@After
	public void afterEachTestMethod() {
		System.out.println("TearDown!");
		map = null;
		assertNull(map);
	}
}

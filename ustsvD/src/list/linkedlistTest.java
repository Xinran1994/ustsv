package list;

import static org.junit.Assert.*;

import org.junit.Test;

public class linkedlistTest {

	@Test
	public void test() {
		linkedlist<Integer> list = new linkedlist<>();
		list.add(1, 0);
 		list.addFirst(4);
		list.addLast(7);
		list.add(5, 3);
		// 4, 1, 7, 5
		
		int output1 = list.getFirst();
		assertEquals(4, output1);
		
		int output2 = (list.getLast());
        assertEquals(5, output2);
        
        list.setElement(0, 8);
        int output3 = list.get(0);
        assertEquals(8, output3);
        
        int output4 = list.size();
        assertEquals(4, output4);
        
        list.remove(1);
        int output5 = list.get(1);	
        assertEquals(7, output5);
        
        list.removeFirst();
        int output6 = list.get(0);	
        assertEquals(7, output6);
	}

}

package LinkedList;

public class findCycle {
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode first = head;
        ListNode second = head.next;
        
        while(first != second){
            if(second == null || second.next == null) return false;
            first = first.next;
            second = second.next.next;
            
        }
        return true;
    }
}

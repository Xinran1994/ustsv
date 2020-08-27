package LinkedList;


public class reverse {
	
    public ListNode reverseList(ListNode head) {
        // recursively backwards
        //we start with node head
        //1. if curr == null, return
        //2. if curr's next element == null, this means it is the last node, so make this as the head of reversed list
        // 3. recursively traverse the list
        // 4. select curr.next.next == curr
        // 5. set curr.next = null
        ListNode cur = head;
        if(head == null || head.next == null) return head;
        head = reverseList(head.next);
        cur.next.next = cur;
        cur.next = null;
        return head;
    }
    
    public ListNode reverseList2(ListNode head) {
        //need two pointer start and end
        // we do a while loop to move the first element to the position that after the end pointer. till start == end
        // d -> 2 ->3->4->5->1->null
        // d-> 3 ->  
        if(head == null ||head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode start = head;
        ListNode end = head;
        while(end.next != null){
            end = end.next;
        }
        while(start != end){
            dummy.next = start.next;
            start.next = end.next;
            end.next = start;
            start = dummy.next;
        }
        return dummy.next;
    }
}
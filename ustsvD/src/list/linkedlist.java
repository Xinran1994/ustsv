package list;

public class linkedlist<E> {
	
	 private class ListNode {
	       E e;
	       ListNode next;

	       ListNode() {
	           this(null, null);
	       }

	       ListNode(E e) {
	           this(e, null);
	       }

	       ListNode(E e, ListNode next) {
	           this.e = e;
	           this.next = next;
	       }
	   }
	 private int size;
	 private ListNode dummy = new ListNode(); // dummy's next point to the head 
	 private ListNode tail = dummy;
	 
	 // 1
	 public void addLast(E e) {
		 size++;
		 tail.next = new ListNode(e);
		 tail = tail.next;
	 }
	 // 1
	 public void addFirst(E e) {
		 ListNode head = dummy.next;
		 ListNode newnode = new ListNode(e);
		 newnode.next = head;
		 dummy.next = newnode;
		 size++;
		 if(head == null) {
			 tail = newnode;
		 }
	 }
	 // n
	 public void add(E e, int index) {
		 rangeCheck(index);
		 if(index == 0) {
			 addFirst(e);
		 } else if(index == size) {
			 addLast(e);
		 } else {
			 ListNode idx = dummy.next;
			 while(index > 0) {
				 idx = idx.next;
				 index--;
			 }
			 ListNode next = idx.next;
			 ListNode newnode = new ListNode();
			 idx.next = newnode;
			 newnode.next = next;
			 size++;
		 }
	 }
	 // 1
	 public void removeFirst() {
		 if(dummy.next == null) return;
		 ListNode next = dummy.next.next;
		 dummy.next = next;
		 size--;
		 if(next == null) {
			 tail = dummy;
		 }
	 }
	 // n
	 public void removeLast() {
		 if(tail == dummy) return;
		 ListNode cur = dummy.next;
		 int i = 0;
		 while(i < size - 1) {
			 cur = cur.next; 
			  i++;
		 }
		 tail = cur;
		 cur.next = null;
		 size--;
		 
	 }
	 // n
	 public void remove(int index) {
		 rangeCheck(index);
		 if(index == 0) {
			 removeFirst();
		 } else if(index == size) {
			 removeLast();
		 } else {
			 ListNode cur = dummy.next;
			 while(index > 1) {
				 cur = cur.next;
				 index--;
			 }
			 ListNode nextNode = cur.next.next;
			 cur.next = nextNode;
			 
		 }
	 }
	 // n
	 public void setElement(int index, E newElement) {
		 rangeCheck(index);
		 ListNode cur = dummy.next;
		 while(index > 0) {
			 cur = cur.next;
		 }
		 cur.e = newElement;
	 }
	 // 1
	 public E getFirst() {
		 if(dummy.next == null) return null;
		 return dummy.next.e;
	 }
	 // 1
	 public E getLast() {
		 if(tail == dummy) return null;
		 return tail.e;
	 }
	 // n
	 public E get(int index) {
		 rangeCheck(index);
		 if(index == 0) {
			 return getFirst();
		 } else if(index == size) {
			 return getLast();
		 } else {
			 ListNode cur = dummy.next;
			 while(index > 1) {
				 cur = cur.next;
				 index--;
			 }
			 return cur.next.e;
		 }
	 }
	 // 1
	 public int size() {
		 return size;
	 }
	 // 1
	 public boolean isEmpty() {
		 return size == 0;
	 }

	 public void rangeCheck(int index) {
		 if(index < 0 || index > size) {
			 throw new NullPointerException();
		 }
	 }
	 
	 public static void main(String[] args) {
		 linkedlist<String> list = new linkedlist<>();
		 list.addLast("s");
		 list.addLast("i");
		 list.addLast("n");
		 list.addLast("k");
		 System.out.println(list.get(2));
	 }
}

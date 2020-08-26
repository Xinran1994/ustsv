package list;

public class arraylist<E> {
	   private static final int DEFAULT_CAPACITY = 10;
	   private E[] arr;
	   private int capacity;
	   private int idx; // starting at 0, pointing to the the next empty space
	   
	   public arraylist() {
	      this(DEFAULT_CAPACITY);
	   }
	   public arraylist(int capacity){
	     this.capacity = capacity;
	     idx = 0;
	     arr = (E[])new Object[capacity];
	   }
	   
	   // O(n)
	   public void addLast(E e) {
	     add(e, idx);    
	   }
	   // O(n)
	   public void addFirst(E e) {
	     add(e, 0);      
	   }

	   // O(n)
	   public void add(E e, int index) {
	     rangeCheck(index);

	     if(idx == capacity) {
	       resize(capacity * 2);
	     }
	     for(int i = index; i < idx; i++) {
	        arr[i + 1] = arr[i];
	     }    
	     arr[index] = e;
	     idx++;
	   }

	   // O(n)
	   public void removeFirst() {
	     remove(0);
	   }
	   // O(n)
	   public void removeLast() {
	     remove(idx - 1);
	   }
	   // O(n)
	   public void remove(int index) {
		 rangeCheck(index);
	     for(int i = index; i < idx; i++){
	       arr[i] = arr[i + 1];
	     }
	     idx--;
	     if(idx < capacity / 2){
	       resize(capacity / 2);
	     }  
	   }
	   // O(1)
	   public void setElement(int index, E newElement) {
		 rangeCheck(index);
	     arr[index] = newElement;
	   }
	   // O(1)
	   public E getFirst() {
	      return arr[0]; 
	   }
	   // O(1)
	   public E getLast() {
	      return arr[idx - 1]; 
	   }
	   // O(1)
	   public E get(int index) {
	      rangeCheck(index);
	      return arr[index];
	   }
	   // O(1)
	   public int size() {
	     return idx;
	   }
	   // O(1)
	   public boolean isEmpty() {
	      return idx == 0;
	   }
	   public void rangeCheck(int index) {
	     if(index < 0 || index > idx){
	       throw new ArrayIndexOutOfBoundsException();
	     }
	   }
	   public void resize(int newCapacity) {
	     E[] newarr = (E[])new Object[newCapacity];
	     capacity = newCapacity;
	     for(int i = 0; i < idx; i++) {
	       newarr[i] = arr[i];
	     }
	     arr = newarr;  
	   }
	   
	   public static void main(String[] args) {
		   arraylist<Integer> list = new arraylist<>(3);
		   list.add(1, 0);
		   list.addFirst(4);
		   list.addLast(7);
		   list.add(5, 3);
		   System.out.println(list.size());
		   list.remove(2);
		   System.out.println(list.get(2));
		   
		   arraylist<String> list2 = new arraylist<>(12);
		   list2.addFirst("s");
		   System.out.println( list2.get(0));
	   }
	}

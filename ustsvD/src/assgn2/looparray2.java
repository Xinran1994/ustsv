package assgn2;

public class looparray2<E> {

	   private static final int INITIAL_CAPACITY = 16;
	   private E[] arr;
	   private int head;
	   private int tail;
	   private int size;

	   public looparray2() {
	       arr = (E[]) new Object[INITIAL_CAPACITY];
	       head = 0;
	       tail = 0;
	       size = 0;
	   }

	   public void add(E val, int index) {
	       if (index < 0 || index >= size) {
	           throw new IndexOutOfBoundsException("");
	       }
	       if (size == arr.length) {
	           resize();
	       }
	       int newIndex = circularIndex(head + index);
	       int tempIndex = tail;
	       while (tempIndex != newIndex) {
	           arr[tempIndex] = arr[circularIndex(tempIndex - 1)];
	           tempIndex = circularIndex(tempIndex - 1);
	       }
	       tail = circularIndex(tail + 1);
	       size++;
	       arr[newIndex] = val;
	   }

	   public void addFirst(E val) {
	       head = circularIndex(head - 1);
	       size++;
	       arr[head] = val;
	   }

	   private void resize() {
	       E[] newArr = (E[]) new Object[arr.length << 1];
	       for (int i = 0; i < arr.length; i++) {
	           newArr[i] = arr[i];
	       }
	       arr = newArr;
	   }

	   public void addLast(E val) {
	       size++;
	       arr[tail++] = val;
	       tail %= arr.length;
	   }

	   public void remove(int index) {
	       if (index < 0 || index >= size) {
	           throw new IndexOutOfBoundsException("");
	       }
	       int targetIndex = circularIndex(head + index);
	       int temp = targetIndex;
	       while (temp != circularIndex(tail - 1)) {
	           arr[temp] = arr[circularIndex(temp + 1)];
	           temp = circularIndex(temp + 1);
	       }
	       size--;
	       tail--;
	   }

	   private int circularIndex(int index) {
	       return (index + arr.length) & (arr.length - 1);
	   }

	   public void removeFirst() {
	       if (size == 0) {
	           throw new IndexOutOfBoundsException("");
	       }
	       size--;
	       head = circularIndex(head + 1);
	   }

	   public void removeLast() {
	       if (size == 0) {
	           throw new IndexOutOfBoundsException("");
	       }

	       size--;
	       tail = circularIndex(tail - 1);
	   }

	   public void setElement(int index, E newElement) {
	       if (index < 0 || index >= size) {
	           throw new IndexOutOfBoundsException("");
	       }
	       arr[circularIndex(head + index)] = newElement;
	   }

	   public E get(int index) {
	       if (index < 0 || index >= size) {
	           throw new IndexOutOfBoundsException("");
	       }
	       return arr[circularIndex(head + index)];
	   }

	   public E getFirst() {
	       if (size == 0) {
	           return null;
	       }
	       return arr[head];
	   }

	   public E getLast() {
	       if (size == 0) {
	           return null;
	       }
	       return arr[circularIndex(tail - 1)];
	   }

	   public int size() {
	       return size;
	   }

	   public boolean isEmpty() {
	       return size == 0;
	   }
	}

package assgn2;

public class loopArray<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	 
	E[] arr;
	int size;
	int head;
	int tail;
	
	loopArray() {
		this(DEFAULT_CAPACITY);
	}
	
	loopArray(int capacity) {
		arr = (E[])new Object[capacity];
		head = 0;
		tail = 0;
		size = 0;
	}
	// 1
	public E peek() {
		isEmpty();
		return arr[head];
	}
	// 1
	public void offer(E e) {
		if(size == arr.length) {
			resize();
		}
		size++;
		arr[tail++] = e;
		tail = tail % arr.length;
	}
	// 1
	public E poll() {
		isEmpty();
		size--;
		E removedE = arr[head];
		arr[head++] = null;
		head = head % arr.length;
		return removedE;
	}
	
	public int size() {
		return size;
	}
	
	public void isEmpty() {
		if(head == tail && size == 0) {
			throw new IllegalArgumentException("No element in the LoopArray");
		}
	}
	public void resize() {
		int newCapacity = arr.length * 2;
		E[] newArr = (E[]) new Object[newCapacity];
		for(int i = newCapacity - head; i < newCapacity; i++) {
			newArr[i] = arr[head++];
		}
		arr = newArr;
	}
}

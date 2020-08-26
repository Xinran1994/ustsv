package assgn3;

/* Only integers are allowed, designed to be a min-heap **/
public class SimplePriorityQueue {
	
   private static final int DEFAULT_CAPACITY = 11;
   
   private int[] minHeap;
   private int size;
   private boolean expand; // expansion or contraction
	
   public SimplePriorityQueue() {
	   this(DEFAULT_CAPACITY);
   }
 
   public SimplePriorityQueue(int initialCapacity) {
	   isValid(initialCapacity);
	   minHeap = new int[initialCapacity];
	   size = 0;
   }

   // Heapify
   public SimplePriorityQueue(int[] collection) {
	   int n = collection.length;
	   heapify(collection);
	   size = n;
   }
  
   // n
   public void heapify(int[] heap) {
	   for(int i = heap.length - 1; i >= 0; i--) {
		   ShiftDown(i);
	   }
	   minHeap = heap;
   }
   // logn
   public void add(int element) {
	   if(size == minHeap.length) {
		   expand = true;
		   resize(expand);
	   }
	   size++;
	   minHeap[size] = element;
	   ShiftUp();
   }
   
   public void ShiftUp() {
	   int child = size;
	   int parent = (size - 1) / 2;
	   while(parent >= 0 && minHeap[child] < minHeap[parent]) {
		   swap(minHeap, child, parent);
		   child = parent;
		   parent = (child - 1) / 2;
	   }
   }
   // logn
   public int poll() {
	   if(isEmpty()) {
		   throw new NullPointerException("The heap is empty");
	   }
	   int top = minHeap[0];
	   swap(minHeap, 0, size - 1);
	   size--;
	   ShiftDown(0);
	   if(size > 1 && size < minHeap.length / 2) {
		   expand = false;
		   resize(expand);
	   }
	   return top;
   }
   
   public void ShiftDown(int idx) {
	   int parent = idx;
	   int leftChild = 2 * parent + 1;
	   int rightChild = 2 * parent + 2;
	   if(leftChild > size - 1) { // no child
		   return;
	   } else if(rightChild > size - 1) { // have left , no right 
		   if(minHeap[rightChild] < minHeap[parent]) {
			   swap(minHeap, parent, rightChild);
		   }
	   } else { // have left and right
		   int minIdx = minHeap[leftChild] > minHeap[rightChild]? rightChild: leftChild;
		   if(minHeap[parent] > minHeap[minIdx]) {
			   swap(minHeap, parent, minIdx);
			   parent = minIdx;
			   leftChild = 2 * minIdx + 1;
			   rightChild = 2 * minIdx + 2;
		   }
	   }
   }
   // 1
   public int peek() {
	   if(isEmpty()) {
		   throw new NullPointerException("The heap is empty");
	   }
	   return minHeap[0];
   }
   // 1
   public int size() {
	   return size;
   }
   // 1
   public boolean isEmpty() {
	   return size == 0;
   }
   
   public void resize(boolean expand) {
	   int newCapacity = expand ? size * 2 : size / 2;
	   int[] newHeap = new int[newCapacity];
	   for(int i = 0; i < size; i++) {
		   newHeap[i] = minHeap[i];
	   }
	   minHeap = newHeap;
   }
   
   public void swap(int[] heap, int i, int j) {
	   int temp = heap[i];
	   heap[i] = heap[j];
	   heap[j] = temp;
   }
   
   public void isValid(int capacity) {
	   if(capacity < 1) {
		   throw new IllegalArgumentException("Illegal capacity");
	   }
   }
}

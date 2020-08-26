package assgn4;

import java.util.LinkedList;

class Pair<E, F> {
	public E key;
	public F value;
	
	public Pair(E key, F value) {
		this.key = key;
		this.value = value;
	}
}
class Bucket<E, F> {
	public LinkedList<Pair<E, F>> bucket;
	
	public Bucket() {
		bucket = new LinkedList<>();
	}
	
	public F get(E key) {
		for(Pair<E, F> pair : bucket) {
			if(pair.key.equals(key)) {
				return pair.value;
			} 
		}
		return null;
	}
	
	public void update(E key, F value) {
		boolean found = false;
		for(Pair<E, F> pair : this.bucket) {
			if(pair.key.equals(key)) { // found and update
				pair.value = value;
				found = true;
			} 
		}
		// put new pair
		if(found == false) {
			this.bucket.add(new Pair<>(key, value));
		}
	}
	
	public void remove(E key) {
		for(Pair<E, F> pair : this.bucket) {
			if(pair.key.equals(key)) {
				this.bucket.remove(pair);
			}
		}
	}
}
public class SimpleHashMap<E, F> {
	
	
	private static final int DEFAULT_CAPACITY = 14;
	private static final float DEFAULT_FACTOR = 0.8F;
	
	private int idx; // represents the index of bucket
	private int size;
	private float factor;
	private boolean expand;
	private Bucket<E, F>[] hashTable;
	
	
	public SimpleHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_FACTOR);
	}
	
	public SimpleHashMap(int capacity, float factor) {
		hashTable = new Bucket[capacity];
		for(int i = 0; i < capacity; i++) {
			hashTable[i] = new Bucket<>();
		}
		this.factor = factor;
		idx = -1;
		size = 0;
		expand = false;
	}
	
	public F get(E key) {
		if(!containsKey(key)) {
			throw new NullPointerException("No key is found");
		}
		idx = getIndex(key);
		return hashTable[idx].get(key);
	}
	
	public void put(E key, F value) {
		if(size > hashTable.length * factor) {
			expand = true;
			resize(expand);
		}
		size++;
		idx = getIndex(key);
		Bucket<E, F> curBucket = hashTable[idx];
		curBucket.update(key, value);
//		System.out.println(curBucket.bucket.size());
	}
	
	public void remove(E key) {
		if(!containsKey(key)) {
			throw new NullPointerException("No found");
		}
		if(size < hashTable.length * factor) {
			resize(expand);
		}
		size--;
		Bucket<E, F> curBucket = hashTable[idx];
		curBucket.remove(key);
	}
	
	private int getIndex(E key) {
		int hashCode = key.hashCode();
		int prime = 37;
		int result = 1;
		result= (result * prime + hashCode) % hashTable.length;
		return result;
	}
	
	public boolean containsKey(E key) {
		idx = getIndex(key);
		Bucket<E, F> curBucket = hashTable[idx];
		if(curBucket.get(key) != null) { // contains key
			return true;
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void resize(boolean expand) {
//		int newCapacity;
//		if(expand) {
//			newCapacity = hashTable.length * 2; 
//		} else {
//			newCapacity = hashTable.length / 2;
//		}
//		Bucket<E, F>[] newTable = new Bucket[newCapacity];
//		for(int i = 0; i < newCapacity; i++) {
//			   newTable[i] = new Bucket<E, F>();
//				...
//		   }
//		hashTable = newTable;
	}
 }

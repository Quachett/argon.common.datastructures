package uk.co.argon.common.datastructures.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractHeap<T extends Comparable<T>> implements Heap<T> {
	protected T[] heap;
	protected int index;
	protected int size;
	protected int maxSize;
	private static final String CONTAINS = "contains";
	private static final String POSITION = "position";
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public T getParent(int pos) {
		if(size==0 || pos>=size)
			return null;
		return heap[(int) (Math.ceil((double)pos/2)-1)];
	}

	@Override
	public T getLeftChild(int pos) {
		if(size==0 || pos>=size)
			return null;
		return heap[getLeftChildIndex(pos)];
	}

	@Override
	public T getRightChild(int pos) {
		if(size==0 || pos>=size)
			return null;
		return heap[getRightChildIndex(pos)];
	}

	@Override
	public T peek() {
		if(size==0)
			return null;
		return heap[0];
	}

	@Override
	public T poll() {
		if(size==0)
			return null;
		return delete(0);
	}

	@Override
	public boolean contains(T t) {
		if(size==0)
			return false;
		return Boolean.parseBoolean(search(t).get(CONTAINS));
	}

	@Override
	public int getIndex(T t) {
		if(size==0)
			return -1;
		return Integer.parseInt(search(t).get(POSITION));
	}

	@Override
	public T getParentByValue(T t) {
		int pos = getIndex(t);
		if(pos == -1)
			return null;
		else
			return heap[getParentIndex(pos)];
	}

	@Override
	public T getLeftChildByValue(T t) {
		int pos = getIndex(t);
		if(pos == -1)
			return null;
		else
			return heap[getLeftChildIndex(pos)];
	}

	@Override
	public T getRightChildByValue(T t) {
		int pos = getIndex(t);
		if(pos == -1)
			return null;
		else
			return heap[getRightChildIndex(pos)];
	}
	
	@Override
	public void print() {
		System.out.println(Arrays.toString(heap));
	}
	
	private Map<String, String> search(T t) {
		Map<String, String> result = new HashMap<>();
		
		for(int i=0; i<size; i++) {
			if(t.compareTo(heap[i])==0) {
				result.put(CONTAINS, "true");
				result.put(POSITION, String.valueOf(i));
				return result;
			} 
		}
		result.put(CONTAINS, "false");
		result.put(POSITION, String.valueOf(-1));
		
		return result;
	}
	
	protected void swap(int pos1, int pos2) {
		T temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
	
	protected int getLeftChildIndex(int pos) {
		return 2*pos + 1;
	}
	
	protected int getRightChildIndex(int pos) {
		return 2*pos + 2;
	}
	
	protected int getParentIndex(int pos) {
		return (int) (Math.ceil((double)pos/2)-1);
	}
}

package uk.co.argon.common.datastructures.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class MaxHeap<T extends Comparable<? super T>> extends AbstractHeap<T> {
	public MaxHeap(int maxSize, Class<T> clazz) {
		super.maxSize = maxSize;
		super.index = 0;
		super.size = 0;
		super.heap = getGenericArray(clazz, maxSize);
	}
	
	public T[] getGenericArray(Class<T> clazz, int capacity) {
		return (T[]) Array.newInstance(clazz, capacity);
	}
	
	@Override
	public int insert(T t) {
		heap[index]= t;
		heapifyUp(index);
		size++;
		return index++;
	}
	
	@Override
	public void insert(Collection<T> col) {
		col.forEach(t -> insert(t));
	}	

	@Override
	public boolean updateByValue(T t, T newT) {
		int pos = getIndex(t);
		if(pos==-1)
			return false;
		else {
			heap[pos] = newT;
			if(pos==0)
				return true;
			if(newT.compareTo(heap[getParentIndex(pos)])>0)
				heapifyUp(pos);
			else
				heapifyDown(pos);
			return true;
		}
	}

	@Override
	public boolean update(int pos, T t) {
		if(pos>=size)
			return false;
		else {
			heap[pos] = t;
			if(pos==0)
				return true;
			if(t.compareTo(heap[getParentIndex(pos)])>0)
				heapifyUp(pos);
			else
				heapifyDown(pos);
			return true;
		}
	}

	@Override
	public boolean deleteByValue(T t) {
		int pos = getIndex(t);
		if(pos==-1)
			return false;
		
		heap[pos]=null;
		swap(pos, index-1);

		size--;
		index--;
		heapifyDown(pos);
		return true;
	}

	@Override
	public T delete(int pos) {
		if(pos>=size)
			return null;
		
		T t = heap[pos];
		heap[pos]=null;
		swap(pos, index-1);

		size--;
		index--;
		heapifyDown(pos);
		return t;
	}
	
	@Override
	public void heapSortAsc(Class<T> clazz) {
		if(size!=0) {
			int j = index;
			int s = size; 
			T[] h = Arrays.copyOf(heap, size);
			T[] tmp = getGenericArray(clazz, size);
			for(int i=1;i<=s;i++)
				tmp[s-i] = poll();
			
			System.out.println(Arrays.toString(tmp));
			unarchive(h, s, j);
		}
		else {
			System.out.println("List is Empty");
		}
	}
	
	@Override
	public void heapSortDsc(Class<T> clazz) {
		if(size!=0) {
			int j = index;
			int s = size; 
			T[] h = Arrays.copyOf(heap, size);
			for(int i=0;i<s;i++)
				System.out.print(poll() + " ");
			
			unarchive(h, s, j);
		}
		else {
			System.out.println("List is Empty");
		}
	}
	
	private void heapifyUp(int pos) {
		int parent = getParentIndex(pos);
		
		if(parent<0 || heap[pos].compareTo(heap[parent])<=0)
			return;
		
		swap(pos, parent);
		heapifyUp(parent);
	}
	
	private void heapifyDown(int pos) {
		int leftChild = getLeftChildIndex(pos);
		int rightChild = getRightChildIndex(pos);
		
		if(leftChild>=size)
			return;
		else if(heap[pos].compareTo(heap[leftChild])>=0 && rightChild>=size)
			return;
		else if(heap[pos].compareTo(heap[leftChild])>=0 && heap[pos].compareTo(heap[rightChild])>=0)
			return;
		
		if(heap[rightChild]==null) {
			if(heap[pos].compareTo(heap[leftChild])>=0)
				return;
			else {
				swap(pos, leftChild);
				heapifyDown(leftChild);
			}
		}				
		else if(heap[leftChild].compareTo(heap[rightChild])>=0) {
			swap(pos, leftChild);
			heapifyDown(leftChild);
		} else {
			swap(pos, rightChild);
			heapifyDown(rightChild);
		}
	}
	
	private void unarchive(T[] h, int s, int i) {
		index = i;
		size = s;
		heap = Arrays.copyOf(h, s);
		h = null;
	}
}

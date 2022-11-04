package uk.co.argon.common.datastructures.heap;

import java.util.Collection;

public interface Heap<T> {
	public int size();
	public T getParent(int pos);
	public T getParentByValue(T t);
	public T getLeftChild(int pos);
	public T getLeftChildByValue(T t);
	public T getRightChild(int pos);
	public T getRightChildByValue(T t);
	public int insert(T t);
	public void insert(Collection<T> col);
	public boolean updateByValue(T t, T newT);
	public boolean update(int pos, T t);
	public boolean deleteByValue(T t);
	public T delete(int pos);
	public T peek();
	public T poll();
	public boolean contains(T t);
	public int getIndex(T t);
	public void print();
	public void heapSortAsc(Class<T> clazz);
	public void heapSortDsc(Class<T> clazz);
}

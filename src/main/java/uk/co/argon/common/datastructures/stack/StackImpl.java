package uk.co.argon.common.datastructures.stack;

public interface StackImpl<T> {
	public void push(T data);
	public T pop();
	public T peek();
	public int size();
	public boolean isEmpty();
	public int indexOf(Object o);
}

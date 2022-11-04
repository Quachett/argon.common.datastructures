package uk.co.argon.common.datastructures.queue;

public interface Queue<T> {
	public boolean queue(T data);
	public T poll();
	public T peek();
	public int size();
	public boolean isEmpty();
	
}

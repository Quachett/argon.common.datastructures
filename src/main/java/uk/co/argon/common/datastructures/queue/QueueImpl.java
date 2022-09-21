package uk.co.argon.common.datastructures.queue;

public interface QueueImpl<T> {
	public boolean add(T data);
	public T poll();
	public T peek();
	public int size();
	public boolean isEmpty();
	
}

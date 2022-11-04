package uk.co.argon.common.datastructures.queue;

import uk.co.argon.common.datastructures.linkedlist.LinkedList;
import uk.co.argon.common.datastructures.linkedlist.SinglyLinkedList;

public class FifoQueue<T extends Comparable<T>> implements Queue<T> {
	
	private LinkedList<T> ll = new SinglyLinkedList<>();
	
	public FifoQueue() {}
	
	public FifoQueue(T t) {
		this.queue(t);
	}
	
	@Override
	public boolean queue(T data) {
		ll.queue(data);
		return true;
	}

	@Override
	public T poll() {
		if(this.isEmpty())
			return null;
		return ll.removeFirst();
	}
	
	@Override
	public T peek() {
		return ll.peekFirst();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return ll.isEmpty();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return ll.size();
	}
}

package uk.co.argon.common.datastructures.queue;

import uk.co.argon.datastructures.linkedlist.SinglyLinkedList;

public class Queue<T extends Comparable<T>> extends SinglyLinkedList<T> {

	public boolean queue(T data) {
		add(data);
		return true;
	}

	public T poll() {
		if(this.isEmpty())
			return null;
		return removeFirst();
	}
	
	public T peek() {
		return peekFirst();
	}
}

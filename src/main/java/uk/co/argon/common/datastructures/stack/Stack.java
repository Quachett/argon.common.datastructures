package uk.co.argon.common.datastructures.stack;

import uk.co.argon.datastructures.linkedlist.SinglyLinkedList;

public class Stack<T extends Comparable<T>> extends SinglyLinkedList<T> {
	
	public Stack() {
		addHead(null);
	}

	public void push(T data) {
		addHead(data);
	}

	public T pop() {
		if(this.isEmpty())
			throw new RuntimeException(EMPTY);
		return removeFirst();
	}

	public T peek() {
		if(this.isEmpty())
			throw new RuntimeException(EMPTY);
		return peekFirst();
	}

	public boolean isEmpty() {
		return get(0)==null;
	}

}

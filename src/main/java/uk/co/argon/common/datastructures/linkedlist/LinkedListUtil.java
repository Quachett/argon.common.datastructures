package uk.co.argon.common.datastructures.linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class LinkedListUtil<T> implements LinkedList<T> {
	
	protected Node<T> head, tail = null;
	protected int size = 0;
	protected static final String EMPTY = "List is empty";

	@Override
	public Node<T> getNode(int index) {
		if(index>size())
			throw new IndexOutOfBoundsException("Index: " + index + " is out of Bounds for List of size: " + size());
		if(index == 0)
			return this.head;
		if(index == (size()-1))
			return this.tail;
		return navigate(index, true).next;
	}
	
	@Override
	public T get(int index) {
		if(index>=size())
			throw new IndexOutOfBoundsException("Index: " + index + " is out of Bounds for List of size: " + size());
		
		if(index==0)
			return this.head.data;
		
		if(index==(size()-1))
			return this.tail.data;
		
		Node<T> node = navigate(index, true);
		return node.next.data;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public T peekFirst() {
		if(isEmpty())
			throw new RuntimeException(EMPTY);
		return this.head.data;
	}

	@Override
	public T peekLast() {
		if(isEmpty())
			throw new RuntimeException(EMPTY);
		return this.tail.data;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> trav = head;

			@Override
			public boolean hasNext() {
				return trav != null;
			}

			@Override
			public T next() {
				T data = trav.data;
				trav = trav.next;
				return data;
			}};
	}

	@Override
	public boolean contains(T t) {
		if(isEmpty())
			throw new RuntimeException(EMPTY);
		Node<T> trav = this.head;
		while(trav!=null) {
			if(trav.compare(t)==0) 
				return true;
			trav = trav.next;
		}
		return false;
	}
	
	@Override
	public void removeDuplicates() {
		Node<T> trav = this.head;
		Set<T> set = new HashSet<>();
		set.add(trav.data);
		while(trav.next!=null) {
			
			if(set.contains(trav.next.data))
				remove(trav);
			else {
				set.add(trav.next.data);
				trav = trav.next;
			}
		}
	}

	@Override
	public int indexOf(Object o) {
		if(isEmpty())
			throw new RuntimeException(EMPTY);
		Node<T> trav = this.head;
		int i = 0;
		while(trav!=null) {
			if(o.equals(trav))
				return i;
			trav = trav.next;
			i++;
		}
		return -1;
	}

	@Override
	public void clear() {
		this.head = this.tail = null;
		this.size = 0;
	}
	
	@Override
	public String toString() {
		if(isEmpty())
			throw new RuntimeException(EMPTY);
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> trav = this.head;
		while(trav!=null) {
			String delim = (trav.next!=null)?", ":"]\n";
			sb.append(trav.data + delim);
			trav = trav.next;
		}
		return sb.toString();
	}

	@Override
	public void pivotList(T t) {
		Node<T> trav = this.head;
		int index = indexOf(t);
		int i=0;
		
		while(trav != null) {
			T data = trav.data;
			if(trav.compare(t)>=0) {
				if(i<index) {
					swap(i, index, data);
					index--;
				}
				else
					trav = trav.next;
			}
			else {
				if(i>index) {
					swap(i, index, data);
					index++;
				}
				trav = trav.next;
			}
			i++;
		}
	}
	
	protected Node<T> navigate(int index, boolean fwdOnly) {
		Node<T> trav = null;
		if(!fwdOnly && (index / size() > 0.5)) {
			trav = this.tail;
			int i = size()-1;
			while(i>index) {
				if(i==index+1)
					return trav.prev.prev;
				i--;
				trav = trav.next;
			}
		}
		else {
			trav = this.head;
			int i = 0;
			while(i<index) {
				if(i==index-1)
					return trav;
				i++;
				trav = trav.next;
			}
		}
		return null;
	}
	
	protected boolean remove(Node<T> node) {
		Node<T> del = node.next;
		if(del.next==null) {
			node.next = null;
			this.tail = node;
		}
		else {
			node.next.next.prev = node;
			node.next = node.next.next;
		}
		
		this.size--;
		del = del.next = del.prev = null;
		
		if(isEmpty())
			this.head = this.tail = null;
		
		return true;
	}
	
	private void swap(int i, int index, T t) {
		removeAt(i);
		addAt(t, index);
	}
}

package uk.co.argon.common.datastructures.linkedlist;

public class DoublyLinkedList<T extends Comparable<T>> extends LinkedListUtil<T> {
	
	public DoublyLinkedList() {}
	
	public DoublyLinkedList(T data) {
		this.head = this.tail = new Node<T>(data, null, null);
		this.size++;
	}

	@Override
	public void add(T data) {
		if(isEmpty())
			this.head = this.tail = new Node<>(data, null, null);
		else {
			this.tail.next = new Node<>(data, null, this.tail);
			this.tail = tail.next;
		}
		this.size++;
	}

	@Override
	public void addNode(Node<T> node) {
		if(isEmpty())
			this.head = this.tail = node;
		else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	@Override
	public void addHead(T data) {
		if(isEmpty())
			this.head = this.tail = new Node<>(data, null, null);
		else {
			this.head.prev = new Node<>(data, head, null); 
			this.head = this.head.prev;
		}
		this.size++;
	}
	
	@Override
	public void addAt(T data, int index) {
		if(isEmpty())
			throw new RuntimeException("Index: " + index + " is out of Bounds for List of size: " + size());
		else if(index == 0)
			addHead(data);
		else {
			Node<T> trav = navigate(index, false);
			trav.next.prev = new Node<>(data, trav.next, trav);
			trav.next = trav.next.prev; 
		}
		this.size++;
	}

	@Override
	public T removeFirst() {
		if(isEmpty())
			throw new RuntimeException(EMPTY);
		T data = this.head.data;
		
		if(size()==1)
			this.head = this.tail = null;
		else {
			this.head.next.prev = null;
			this.head = this.head.next;
		}
		this.size--;
		
		return data;
	}

	@Override
	public boolean remove(T data) { //figure travel direction
		if(isEmpty())
			throw new RuntimeException(EMPTY);
		
		Node<T> trav = this.head;
		
		if(data.equals(trav.data)) {
			removeFirst();
			return true;
		}
		
		while(trav!=null) {
			if(data.equals(trav.next.data)) 
				return remove(trav);
			trav = trav.next;
		}
		return false;
	}

	@Override
	public T removeLast() {
		if(isEmpty())
			throw new RuntimeException(EMPTY);
				
		System.out.println(this.tail.data);
		
		T data = this.tail.data;
		
		if(size()==1)
			this.head = this.tail = null;
		else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		
		this.size--;
		
		return data;
	}

	@Override
	public T removeAt(int index) {
		if(isEmpty())
			throw new RuntimeException(EMPTY);
		
		if(index>=size())
			throw new RuntimeException("Index: " + index + " is out of Bounds for List of size: " + size());
		
		if(index==0)
			return removeFirst();
		
		if(index==size()-1)
			return removeLast();
		
		Node<T> trav = navigate(index, false);
		T data = trav.next.data;
		
		remove(trav);
		
		return data;
	}

	@Override
	public void pivotList(T value) {
		// TODO Auto-generated method stub
		
	}
}

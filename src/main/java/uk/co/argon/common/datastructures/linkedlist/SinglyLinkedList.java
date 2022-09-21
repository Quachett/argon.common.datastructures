package uk.co.argon.common.datastructures.linkedlist;

public class SinglyLinkedList<T extends Comparable<T>> extends LinkedListUtil<T> {
	
	public SinglyLinkedList() {}
	
	public SinglyLinkedList(T data) {
		super.head = super.tail = new Node<T>(data, null, null);
		super.size++;
	}

	@Override
	public void add(T data) {
		if(super.isEmpty())
			super.head = super.tail = new Node<>(data, null, null);
		else {
			super.tail.next = new Node<>(data, null, null);
			super.tail = tail.next;
		}
		super.size++;
	}

	@Override
	public void addNode(Node<T> node) {
		if(super.isEmpty())
			super.head = super.tail = node;
		else {
			super.tail.next = node;
			super.tail = node;
		}
		super.size++;
	}

	@Override
	public void addHead(T data) {
		if(super.isEmpty())
			super.head = super.tail = new Node<>(data, null, null);
		else {
			Node<T> node = new Node<>(data, head, null);
			super.head = node;
		}
		super.size++;
	}

	@Override
	public void addAt(T data, int index) {
		if(super.isEmpty())
			throw new RuntimeException("Index: " + index + " is out of Bounds for List of size: " + size());
		else if(index == 0)
			addHead(data);
		else {
			Node<T> trav = navigate(index, true);
			trav.next = new Node<>(data, trav.next, null);
		}
		super.size++;
	}
	
	@Override
	public T removeFirst() {
		if(super.isEmpty())
			throw new RuntimeException(EMPTY);
		
		T data = head.data;
		super.head = super.head.next;
		super.size--;
		
		if(super.isEmpty())
			super.head = super.tail = null;
		
		return data;
	}

	@Override
	public boolean remove(T data) {
		if(super.isEmpty())
			throw new RuntimeException(EMPTY);
		
		Node<T> trav = super.head;
		
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
		if(super.isEmpty())
			throw new RuntimeException(EMPTY);
		
		T data = null;
		
		if(size()==1) {
			super.head = super.tail = null;
			data = super.head.data;
			super.size--;
			return data;
		}
		
		Node<T> trav = super.head;
		while(trav!=null) {
			if(trav.next == super.tail) {
				data = trav.next.data;
				if(remove(trav))
					return data;
			}
			trav = trav.next;
		}
		return data;
	}

	@Override
	public T removeAt(int index) {
		if(super.isEmpty())
			throw new RuntimeException(EMPTY);
		
		if(index>=size())
			throw new RuntimeException("Index: " + index + " is out of Bounds for List of size: " + size());
		
		if(index==0)
			return removeFirst();
		
		Node<T> trav = navigate(index, true);
		T data = trav.next.data;
		remove(trav);

		return data;
	}

}

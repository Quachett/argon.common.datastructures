package uk.co.argon.common.datastructures.linkedlist;

public interface LinkedList<T> extends Iterable<T> {

	public class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;
		
		protected Node(E data, Node<E> next, Node<E> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public int size();
	public boolean isEmpty();
	public void queue(T data);
	public void addNode(Node<T> node);
	public void addHead(T data);
	public void addAt(T data, int index);
	public Node<T> getNode(int index);
	public T get(int index);
	public T peekFirst();
	public T peekLast();
	public T removeFirst();
	public boolean remove(T data);
	public T removeLast();
	public T removeAt(int index);
	public int indexOf(Object o);
	public boolean contains(T data);
	public void clear();
	public void removeDuplicates();
	public void pivotList(T value);
}

package uk.co.argon.common.datastructures.tree;

public class Node<T> {
	public T t;
	public int bf=0;
	public int height=0;
	public Node<T> left, right;
	
	public Node(T t, Node<T> left, Node<T> right) {
		this.t = t;
		this.left = left;
		this.right = right;
	}
}

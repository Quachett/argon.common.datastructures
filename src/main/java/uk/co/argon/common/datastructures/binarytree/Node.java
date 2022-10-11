package uk.co.argon.common.datastructures.binarytree;

public class Node<T> {
	T elem;
	Node<T> left, right;
	
	public Node(T elem, Node<T> left, Node<T> right) {
		this.elem = elem;
		this.left = left;
		this.right = right;
	}
}

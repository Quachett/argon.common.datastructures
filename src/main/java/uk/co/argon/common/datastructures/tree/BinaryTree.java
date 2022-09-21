package uk.co.argon.common.datastructures.tree;

public interface BinaryTree<T extends Comparable<T>> {
	public void add(T t);
	public void remove(T t);
	public boolean contains(T t);
	public void delete(T t);
	public void inOrderTraversal();
	public void preOrderTraversal();
	public void postOrderTraversal();
	public void breathFirstSearch();
}

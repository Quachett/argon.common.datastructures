package uk.co.argon.common.datastructures.binarytree;

import java.util.Collection;

public interface Tree<T> {
	public int size();
	public boolean isEmpty();
	public boolean contains(T elem);
	public void insert(T elem);
	public void insertCollection(Collection<T> collection);
	public void remove(T elem);
	public void preorderTraversal();
	public void inorderTraversal();
	public void postorderTraversal();
	public void breathFirstTraversal();
}

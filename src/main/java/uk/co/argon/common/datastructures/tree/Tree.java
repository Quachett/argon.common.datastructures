package uk.co.argon.common.datastructures.tree;

import java.util.Collection;

public interface Tree<T> {
	public int size();
	public boolean isEmpty();
	public boolean contains(T t);
	public void insert(T t);
	public void insertCollection(Collection<T> collection);
	public void remove(T t);
	public void preorderTraversal();
	public void inorderTraversal();
	public void postorderTraversal();
	public void breathFirstTraversal();
}

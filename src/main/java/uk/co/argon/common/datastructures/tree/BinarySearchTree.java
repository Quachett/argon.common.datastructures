package uk.co.argon.common.datastructures.tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTreeUtil<T> {
	
	@Override
	public void add(T t) {
		root = add(root, t);
	}
	
	private BinaryTreeNode<T> add(BinaryTreeNode<T> root, T t) {
		return null;
	}

	@Override
	public void remove(T t) {
		root = remove(root, t);
	}
	
	private BinaryTreeNode<T> remove(BinaryTreeNode<T> root, T t) {
		return null;
	}

	@Override
	public boolean contains(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}
}

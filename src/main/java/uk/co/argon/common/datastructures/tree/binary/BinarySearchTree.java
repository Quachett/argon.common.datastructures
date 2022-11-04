package uk.co.argon.common.datastructures.tree.binary;

import java.util.Collection;

import uk.co.argon.common.datastructures.tree.AbstractBinaryTree;
import uk.co.argon.common.datastructures.tree.Node;

public class BinarySearchTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {
	
	public BinarySearchTree() {}
	
	public BinarySearchTree(T t) {
		this.insert(t);
	}
	
	public BinarySearchTree(Collection<T> collection) {
		this.insertCollection(collection);
	}

	@Override
	public void insert(T t) {
		if(t!= null && !contains(t)) {
			root = insert(root, t);
			numNodes++;
		}
	}

	@Override
	public void insertCollection(Collection<T> collection) {
		collection.forEach(t->insert(t));
	}

	@Override
	public void remove(T t) {
		if(contains(t)) {
			root = remove(root, t);
			numNodes--;
		}
	}
	
	private Node<T> insert(Node<T> node, T t) {
		if(node == null)
			return new Node<T>(t, null, null);
		
		if(node.t.compareTo(t)<0)
			node.right = insert(node.right, t);
		else
			node.left = insert(node.left, t);
		
		return node;
	}

	private Node<T> remove(Node<T> node, T t) {
		if(node.t.compareTo(t)==0) {
			Node<T> successor;
			if(node.left == null && node.right == null)
				return null;
			else if(node.right != null) {
				if(node.right.left==null) {
					node.right.left = node.left;
					return node.right;
				}
				else {
					successor = findSuccessor(node.right);
					remove(node, successor.t);
					successor.left = node.left;
					successor.right = node.right;
					return successor;
				}
			}
			else
				return node.left;
		}
		else if(node.t.compareTo(t)<0)
			node.right = remove(node.right, t);
		else
			node.left = remove(node.left, t);
		return node;
	}

	private Node<T> findSuccessor(Node<T> node) {
		if(node.left == null)
			return node;
		return findSuccessor(node.left);
	}
}

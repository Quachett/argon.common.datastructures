package uk.co.argon.common.datastructures.tree.binary;

import java.util.Collection;

import uk.co.argon.common.datastructures.tree.Node;

public class BalancedBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	public BalancedBinarySearchTree() {}
	
	public BalancedBinarySearchTree(T t) {
		this.insert(t);
	}
	
	public BalancedBinarySearchTree(Collection<T> collection) {
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
		if(node == null) {
			 node = new Node<T>(t, null, null);
			System.out.println("Node:= " + node.t + "\tBF:= " + node.bf);
			return node;
		}
		
		if(node.t.compareTo(t)<0)
			node.right = insert(node.right, t);
		else
			node.left = insert(node.left, t);
		
		update(node);
		System.out.println("Node:= " + node.t + "\tBF:= " + node.bf);
		
		return balance(node);
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
		
		update(node);
		return balance(node);
	}
	
	private Node<T> update(Node<T> node) {
		int lh = (node.left!=null)?node.left.height:-1;
		int rh = (node.right!=null)?node.right.height:-1;
		
		node.height = 1 + Math.max(lh, rh);
		node.bf = rh - lh;
		
		return node;
	}
	
	private Node<T> balance(Node<T> node) {
		if(node.bf==-2) {
			if(node.left.bf<=0)
				return rightRotation(node);
			else
				return leftRightCase(node);
		} else if(node.bf==2) {
			if(node.right.bf>=0)
				return leftRotation(node);
			else
				return rightLeftCase(node);
		} else
			return node;
	}
	
	private Node<T> rightRotation(Node<T> node) {
		Node<T> left = node.left;
		node.left = left.right;
		left.right = node;
		
		update(node);
		update(left);
		
		return left;
	}
	
	private Node<T> leftRotation(Node<T> node) {
		Node<T> right = node.right;
		node.right = right.left;
		right.left = node;
		
		update(node);
		update(right);
		
		return right;
	}
	
	private Node<T> leftRightCase(Node<T> node) {
		node.left = leftRotation(node.left);
		return rightRotation(node);
	}
	
	private Node<T> rightLeftCase(Node<T> node) {
		node.right = rightRotation(node.right);
		return leftRotation(node);
	}

	private Node<T> findSuccessor(Node<T> node) {
		if(node.left == null)
			return node;
		return findSuccessor(node.left);
	}
}

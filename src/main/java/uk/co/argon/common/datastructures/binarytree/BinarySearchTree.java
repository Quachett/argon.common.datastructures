package uk.co.argon.common.datastructures.binarytree;

import java.util.Collection;

public class BinarySearchTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {
	
	public BinarySearchTree() {}
	
	public BinarySearchTree(T elem) {
		this.insert(elem);
	}
	
	public BinarySearchTree(Collection<T> collection) {
		this.insertCollection(collection);
	}

	@Override
	public boolean contains(T elem) {
		if(isEmpty())
			return false;
		if(root.elem.compareTo(elem)==0)
			return true;
		
		Node<T> parent = search(elem);
		if(parent.left == null && parent.right == null)
			return false;
		return (parent.left.elem.compareTo(elem)==0 || parent.right.elem.compareTo(elem)==0);
	}

	private Node<T> search(T elem) {
		return getParent(root, elem);
	}

	@Override
	public void insert(T elem) {
		if(isEmpty())
			root = new Node<>(elem, null, null);
		else {
			Node<T> node = new Node<T>(elem, null, null);
			Node<T> parent = search(elem);
			if(parent.elem.compareTo(elem)>0)
				parent.left =node;
			else
				parent.right = node;
		}
		numNodes++;
	}
	
	@Override
	public void insertCollection(Collection<T> collection) {
		collection.forEach(e -> insert(e));
	}

	@Override
	public void remove(T elem) {
		if(!isEmpty()) {
			Node<T> replacer=null;
			Node<T> node=null;
			if(root.elem.compareTo(elem)==0) {
				replacer = findPredecessor(root.left.left);
				super.root = remove(root, findPredecessor(root.left));
			}
			else {
				Node<T> parent = search(elem);
				if(parent.left != null && parent.left.elem.compareTo(elem)==0) {
					replacer = findPredecessor(parent.left.left);
					parent.left = remove(parent.left, replacer);
				}
				if(parent.right != null && parent.right.elem.compareTo(elem)==0) {
					replacer = findPredecessor(parent.right.left);
					parent.right = remove(parent.right, replacer);
				}
			}
			/*if(node != null)
				
			System.out.println("Now node is: " + node);*/
			numNodes--;
		}
	}

	private Node<T> getParent(Node<T> node, T elem) {
		if(node.left == null && node.right == null)
			return node;
		if(node.left !=null && node.left.elem.compareTo(elem)==0)
			return node;
		if(node.right !=null && node.right.elem.compareTo(elem)==0)
			return node;
		if(node.elem.compareTo(elem)<0 && node.right == null)
			return node;
		if(node.elem.compareTo(elem)>0 && node.left == null)
			return node;
		
		if(node.elem.compareTo(elem)>0)
			return getParent(node.left, elem);
		else
			return getParent(node.right, elem);
	}

	private Node<T> findPredecessor(Node<T> node) {
		if(node==null)
			return node;
		if(node.right==null)
			return node;
		return findPredecessor(node.right);
	}
	
	private Node<T> resetPredecessor(Node<T> node) {
		if(node==null)
			return null;
		if(node.right==null)
			return node.right;
		node.right = resetPredecessor(node.right);
		return node;
	}
	
	private Node<T> remove(Node<T> node, Node<T> replacer) {
		if(replacer == null) {
			System.out.println("Replacing: " + node.elem + " with: " + ((replacer==null)?null:replacer.elem));
			if(node.left!=null)
				node = resetPredecessor(node.left);
			node = node.right;
			System.out.println("Now node is: " + node);
		}
		else {
			Node<T> nright = node.right;
			Node<T> nleft = (node.left!=null)?resetPredecessor(node.left):null;
			replacer.right = nright;
			if(node!=null) {
				replacer.left = nleft;
			}
			node = replacer;
		}
		return node;
	}
}

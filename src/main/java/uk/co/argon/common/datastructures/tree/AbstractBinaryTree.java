package uk.co.argon.common.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractBinaryTree<T extends Comparable<T>> implements Tree<T> {
	protected int numNodes = 0;
	protected Node<T> root;

	@Override
	public int size() {
		return numNodes;
	}

	@Override
	public boolean isEmpty() {
		return numNodes==0;
	}
	
	@Override
	public void preorderTraversal() {
		if(isEmpty())
			System.out.println("Tree is empty");
		else
			preorderTraversal(root);
	}
	
	@Override
	public void inorderTraversal() {
		if(isEmpty())
			System.out.println("Tree is empty");
		else
			inorderTraversal(root);
	}
	
	@Override
	public void postorderTraversal() {
		if(isEmpty())
			System.out.println("Tree is empty");
		else
			postorderTraversal(root);
	}
	
	@Override
	public void breathFirstTraversal() {
		if(isEmpty())
			System.out.println("Tree is empty");
		else {
			Queue<Node<T>> queue =  new LinkedList<>();
			queue.add(root);
			breathFirstTraversal(queue);
		}
	}

	@Override
	public boolean contains(T t) {
		return contains(root, t);
	}

	private boolean contains(Node<T> node, T t) {
		if(node == null)
			return false;
		else if(node.t.compareTo(t)==0)
			return true;
		else if(node.t.compareTo(t)<0) //element in tree is smaller than search element go right
			return contains(node.right, t);
		else
			return contains(node.left, t);
	}
	
	private void preorderTraversal(Node<T> node) {
		if(node != null) {
			System.out.print(node.t + ", ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}
	
	private void inorderTraversal(Node<T> node) {
		if(node != null) {
			inorderTraversal(node.left);
			System.out.print(node.t + ", ");
			inorderTraversal(node.right);
		}
	}
	
	private void postorderTraversal(Node<T> node) {
		if(node != null) {
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.t + ", ");
		}
	}
	
	private void breathFirstTraversal(Queue<Node<T>> queue) {
		Node<T> node = queue.poll();
		if(node != null) {
			System.out.print(node.t + ", ");
			queue.add(node.left);
			queue.add(node.right);
		}
		if(!queue.isEmpty())
			breathFirstTraversal(queue);
	}
}

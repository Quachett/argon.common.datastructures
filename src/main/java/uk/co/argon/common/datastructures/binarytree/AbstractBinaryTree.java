package uk.co.argon.common.datastructures.binarytree;

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
	
	private void preorderTraversal(Node<T> node) {
		if(node != null) {
			System.out.print(node.elem + ", ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}
	
	private void inorderTraversal(Node<T> node) {
		if(node != null) {
			inorderTraversal(node.left);
			System.out.print(node.elem + ", ");
			inorderTraversal(node.right);
		}
	}
	
	private void postorderTraversal(Node<T> node) {
		if(node != null) {
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.elem + ", ");
		}
	}
	
	private void breathFirstTraversal(Queue<Node<T>> queue) {
		Node<T> node = queue.poll();
		if(node != null) {
			System.out.print(node.elem + ", ");
			queue.add(node.left);
			queue.add(node.right);
		}
		if(!queue.isEmpty())
			breathFirstTraversal(queue);
	}
}

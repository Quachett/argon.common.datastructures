package uk.co.argon.common.datastructures.binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeTest {

	public static void main(String[] args) {
		Tree<Integer> tree;
		//tree = fillTree();
		//tree = fillTreeRoot();
		tree = fillWithCollection();
		testBST(tree);

	}
	
	private static void testBST(Tree<Integer> tree) {
		tree.breathFirstTraversal();
		System.out.println();
		tree.preorderTraversal();
		System.out.println();
		tree.inorderTraversal();
		System.out.println();
		tree.postorderTraversal();
		
		System.out.println("\n=======================================================");
		System.out.println(tree.contains(19));
		System.out.println("=======================================================");
		
		System.out.println("\n=======================================================");
		tree.remove(21);
		tree.breathFirstTraversal();
		System.out.println();
		tree.preorderTraversal();
		System.out.println();
		tree.inorderTraversal();
		System.out.println();
		tree.postorderTraversal();
		System.out.println("\n=======================================================");
		
		System.out.println("\n=======================================================");
		tree.remove(5);
		tree.breathFirstTraversal();
		System.out.println();
		tree.preorderTraversal();
		System.out.println();
		tree.inorderTraversal();
		System.out.println();
		tree.postorderTraversal();
		System.out.println("\n=======================================================");
	}
	
	private static Tree<Integer> fillTree() {
		Tree<Integer> tree = new BinarySearchTree<>();
		tree.insert(15);
		tree.insert(7);
		tree.insert(21);
		tree.insert(6);
		tree.insert(12);
		tree.insert(17);
		tree.insert(22);
		tree.insert(5);
		tree.insert(16);
		tree.insert(19);
		tree.insert(25);
		tree.insert(23);
		tree.insert(27);
		return tree;
	}
	
	private static Tree<Integer> fillTreeRoot() {
		Tree<Integer> tree = new BinarySearchTree<>(15);
		tree.insert(7);
		tree.insert(21);
		tree.insert(6);
		tree.insert(12);
		tree.insert(17);
		tree.insert(22);
		tree.insert(5);
		tree.insert(16);
		tree.insert(19);
		tree.insert(25);
		tree.insert(23);
		tree.insert(27);
		return tree;
	}
	
	private static Tree<Integer> fillWithCollection() {
		Tree<Integer> tree = new BinarySearchTree<>(getList());
		return tree;
	}
	
	private static List<Integer> getList() {
		return Arrays.asList(15,7,21,6,12,17,22,5,16,19,25,23,27);
		//return Stream.of(15,7,21,6,12,17,22,5,16,19,25,23,27).collect(Collectors.toList());
	}

}

package uk.co.argon.common.datastructures.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.argon.common.datastructures.tree.binary.BalancedBinarySearchTree;
import uk.co.argon.common.datastructures.tree.binary.BinarySearchTree;

public class TreeTest {

	public static void main(String[] args) {
		Tree<Integer> tree;
		List<Tree<Integer>> ltree;
		//tree = fillTree();
		//tree = fillTreeRoot();
		//putTest();
		//tree = fillWithCollection();
		//testBST(tree);
		ltree = fillWithCollectionBB();
		testBBST(ltree);
		//testBBST1();

	}
	
	private static void testBBST1() {
		Tree<Integer> t = new BalancedBinarySearchTree<Integer>(15);
	}
	
	private static void testBBST(List<Tree<Integer>> ltree) {
		for(Tree<Integer> tree: ltree) {
			System.out.println("=======================================================");
			tree.breathFirstTraversal();
			tree.remove(2);
			System.out.println();
			tree.breathFirstTraversal();
			System.out.println("\n=======================================================\n");
			
		}
	}

	private static void putTest() {
		Map<String, Integer> map = new HashMap<>();
		int i = 0;
		map.put("Pre", ++i);
		map.put("Post", map.get("Pre")+1);
		System.out.println(map);
		System.out.println("i = " + i);
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
		System.out.println("List size: " + getList().size());
		System.out.println("Tree size: " + tree.size());
		System.out.println("=======================================================");
		
		System.out.println("\n=======================================================");
		tree.remove(27);
		tree.breathFirstTraversal();
		System.out.println();
		tree.preorderTraversal();
		System.out.println();
		tree.inorderTraversal();
		System.out.println();
		tree.postorderTraversal();
		System.out.println("\n=======================================================");
		
		System.out.println("\n=======================================================");
		tree.remove(29);
		tree.breathFirstTraversal();
		System.out.println();
		tree.preorderTraversal();
		System.out.println();
		tree.inorderTraversal();
		System.out.println();
		tree.postorderTraversal();
		System.out.println("\n=======================================================");
		
		System.out.println("\n=======================================================");
		tree.remove(22);
		tree.breathFirstTraversal();
		System.out.println();
		tree.preorderTraversal();
		System.out.println();
		tree.inorderTraversal();
		System.out.println();
		tree.postorderTraversal();
		System.out.println("\n=======================================================");
		
		System.out.println("\n=======================================================");
		tree.remove(15);
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
		
		System.out.println("\n=======================================================");
		tree.remove(7);
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
		return Arrays.asList(15,9,21,7,10,18,22,5,16,19,25,23,27,8,6,3,1,8,11,13,12,14,15,15,15,28,30,29,17);
		//return Stream.of(15,7,21,6,12,17,22,5,16,19,25,23,27).collect(Collectors.toList());
	}
	
	private static List<Tree<Integer>> fillWithCollectionBB() {
		List<Tree<Integer>> lt = new ArrayList<>();
		Tree<Integer> tree = null;
		int i=1;
		for(List<Integer> l: getListBB()) {
			System.out.println("*-*-*-*-*Tree: " + i++);
			tree = new BalancedBinarySearchTree<>(l);
			lt.add(tree);
		}
		return lt;
	}
	
	private static List<List<Integer>> getListBB() {
		List<List<Integer>> ll = new ArrayList<>();
		ll.add(Arrays.asList(15,5,4,3,2,1,0,-1));
		ll.add(Arrays.asList(15,7,13,5,11,3,10,1,9));
		ll.add(Arrays.asList(15,25,17));
		ll.add(Arrays.asList(15,17,25));
		return ll;
		//return Stream.of(15,7,21,6,12,17,22,5,16,19,25,23,27).collect(Collectors.toList());
	}

}

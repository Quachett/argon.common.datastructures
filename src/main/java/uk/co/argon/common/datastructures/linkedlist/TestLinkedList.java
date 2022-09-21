package uk.co.argon.common.datastructures.linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestLinkedList {

	public static void main(String[] args) {
		algotest();
	}
	
	private static void sLL() {
		LinkedList<Integer> ll = new SinglyLinkedList<>(77);

		ll.add(1);
		ll.add(9);
		ll.add(15);
		ll.add(20);
		ll.add(32);
		ll.add(47);
		ll.add(63);
		System.out.println("Size: " + ll.size());
		System.out.println(ll.toString());
		
		System.out.println("Get index 3: " + ll.get(3));
		
		ll.addHead(99);
		System.out.println(ll.toString());
		System.out.println("Size: " + ll.size());
		System.out.println("peek first: " + ll.peekFirst());
		System.out.println("peek last: " + ll.peekLast());
		System.out.println("remove first: " + ll.removeFirst());
		System.out.println("Size: " + ll.size());
		System.out.println("remove last: " + ll.removeLast());
		System.out.println("Size: " + ll.size());
		int index = ll.indexOf(15);
		System.out.println(ll.toString());
		System.out.println("Index of 15: " + index);
		System.out.println("remove At index: " + ll.removeAt(index));
		System.out.println("Size: " + ll.size());
		System.out.println("remove 47: " + ll.remove(47));
		System.out.println("Size: " + ll.size());
		System.out.println("contains: " + ll.contains(47));
		System.out.println("contains: " + ll.contains(32));
		System.out.println(ll.toString());
		
		Iterator<Integer> itr = ll.iterator();
		
		System.out.println("\n\n=========================================================\n\n");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		ll.clear();
		System.out.println("Size: " + ll.size());
	}
	
	private static void dLL() {
		LinkedList<Integer> dll = new DoublyLinkedList<>();

		dll.add(1);
		dll.add(5);
		dll.add(15);
		
		System.out.println("List: " + dll.toString());
		dll.addHead(25);
		System.out.println("\n\n after adding 25 to head: " + dll.toString());
		dll.addAt(99,3);
		System.out.println("\n\n after adding 99 to head: " + dll.toString());
		dll.addAt(1515,1);
		System.out.println("\n\n after adding 1515 to head: " + dll.toString());
		
		System.out.println("Get index 3: " + dll.get(3));
		
		System.out.println("\n\n Remove At 4: " + dll.removeAt(4));
		System.out.println("\n\n List: " + dll.toString());
		System.out.println("\n\n Remove First: " + dll.removeFirst());
		System.out.println("\n\n Remove 5: " + dll.removeAt(3));
		System.out.println("\n\n List: " + dll.toString());
		System.out.println("\n\n Remove First: " + dll.removeFirst());
		System.out.println("\n\n List: " + dll.toString());
		System.out.println("\n\n Remove Last: " + dll.removeLast());
		System.out.println("\n\n List: " + dll.toString());
		System.out.println("\n\n Remove: " + dll.remove(1));
		System.out.println("\n\n List: " + dll.toString());
		
	}
	
	private static void algotest() {
		LinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		LinkedList<Integer> sll2 = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(1);
		sll.add(3);
		sll.add(2);
		sll.add(1);
		sll.add(9);
		sll.add(15);
		sll.add(20);
		sll.add(32);
		sll.add(47);
		sll.add(63);

		sll2.add(99);
		sll2.add(88);
		sll2.add(77);
		sll2.add(4);
		sll2.add(55);
		sll2.add(11);
		sll2.addNode(sll.getNode(7));
		
		sll.pivotList(9);
		System.out.println(sll.toString());
		
		System.out.println(sll2.toString());
		
		System.out.println("\n" + intersect(sll, sll2));
	}
	
	private static boolean intersect(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		if(ll1.isEmpty() || ll2.isEmpty())
			return false;

		int i = 0;
		int j = ll1.size();
		int k = ll2.size();
		int x = (j>k)?(j-k):0;
		int y = (k>j)?(k-j):0;

		System.out.println("[j,k]: [" + j + "," + k + "]");
		System.out.println("[x,y]: [" + x + "," + y + "]");
		
		if(ll1.getNode(j-1)!=ll2.getNode(k-1))
			return false;
	
		while(i<j && i<k) {
			if(ll1.getNode(i+x)==ll2.getNode(i+y))
				return true;
			i++;
		}
		
		return false;
	}
	
}

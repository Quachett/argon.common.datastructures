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

		ll.queue(1);
		ll.queue(9);
		ll.queue(15);
		ll.queue(20);
		ll.queue(32);
		ll.queue(47);
		ll.queue(63);
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

		dll.queue(1);
		dll.queue(5);
		dll.queue(15);
		
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
		sll.queue(1);
		sll.queue(2);
		sll.queue(1);
		sll.queue(3);
		sll.queue(2);
		sll.queue(1);
		sll.queue(9);
		sll.queue(15);
		sll.queue(20);
		sll.queue(32);
		sll.queue(47);
		sll.queue(63);

		sll2.queue(99);
		sll2.queue(88);
		sll2.queue(77);
		sll2.queue(4);
		sll2.queue(55);
		sll2.queue(11);
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

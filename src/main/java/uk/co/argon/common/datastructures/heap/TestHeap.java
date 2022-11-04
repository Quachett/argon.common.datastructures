package uk.co.argon.common.datastructures.heap;

import java.util.Arrays;
import java.util.List;

public class TestHeap<T> {

	public static void main(String[] args) {
		testMaxHeap();
	}
	
	private static void testMaxHeap() {
		List<Integer> l = getList();
		
		Heap<Integer> h = new MaxHeap<>(l.size(), Integer.class);
		h.insert(l);
		System.out.println("Size: " + h.size());
		System.out.println("Size: " + l.size());
		h.print();
		h.heapSortAsc(Integer.class);
		h.heapSortDsc(Integer.class);
		System.out.println("Size: " + h.size());
		System.out.println("Size: " + l.size());
		
		updateByValue(h);
		
		updateByPosition(h);
		
		deleteByValue(h);
		
		deleteByPosition(h);
		
		System.out.println("Peek: " + h.peek());
		System.out.println("Poll: " + h.poll());
		h.print();
	}
	
	private static void updateByValue(Heap<Integer> h) {
		h.updateByValue(7, 15);
		System.out.print("Update By Value\t");
		h.print();
	}
	
	private static void updateByPosition(Heap<Integer> h) {
		h.update(0, 25);
		System.out.print("Update By Position\t");
		h.print();
	}
	
	private static void deleteByValue(Heap<Integer> h) {
		h.deleteByValue(25);
		h.print();
	}
	
	private static void deleteByPosition(Heap<Integer> h) {
		h.delete(0);
		h.print();
	}
	
	private static List<Integer> getList() {
		return Arrays.asList(1,2,3,4,5,6,7,15,7,21,6,12,17,22,5,16,19,25,23,27);
		//return Stream.of(15,7,21,6,12,17,22,5,16,19,25,23,27).collect(Collectors.toList());
	}

}

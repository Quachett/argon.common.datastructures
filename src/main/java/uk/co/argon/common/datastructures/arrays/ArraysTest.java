package uk.co.argon.common.datastructures.arrays;

import java.util.Arrays;

public class ArraysTest {

	private static ArraysAlgorithms aa = new ArraysAlgorithms();
	public static void main(String[] args) {
		//testTwoSum();
		System.out.println(Boolean.parseBoolean("trues"));
	}
	
	private static void testSDA() {
		SingleDimensionArray<Integer> sda = new SingleDimensionArray<Integer>(Integer.class, 5);
		
		sda.insertElement(0, 15);
		sda.printArray();
		sda.insertAtFirst(25);
		sda.insertElement(1, 7);
		sda.insertElement(3, 12);
		sda.insertElement(5, 89);
		sda.printArray();
		sda.getElement(2);
		sda.getElement(3);
		sda.deleteElement(12);
		System.out.println("Element at index 3: " + sda.getElement(1));
		System.out.println("Element at index 10: " + sda.getElement(10));
		sda.printArray();
	}
	
	private static void testTwoSum() {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[] brr = {5,2,3,9,2,4};
		
		System.out.println(arr1.length);

		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(aa.rotate90Deg(arr)));
		System.out.println(Arrays.deepToString(aa.rotate90DegSameArray(arr,0,arr.length-1)));
	}

}

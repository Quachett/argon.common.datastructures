package uk.co.argon.common.datastructures.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class SingleDimensionArray<E> {
	private E[] elements = null;
	private int sizeOfArray;
	
	@SuppressWarnings("unchecked")
	public SingleDimensionArray(Class<E> clazz, int	 sizeOfArray) {
		this.elements = (E[]) Array.newInstance(clazz, sizeOfArray);
		this.sizeOfArray = sizeOfArray;
	}
	
	public void insertElement(int index, E elament) {
		if(index < 0 || index >= this.sizeOfArray)
			System.out.println("index out of Bounds");
		else if(elements[index]==null) {
			elements[index] = elament;
			System.out.println("Element inserted successfully");
		}
		else {
			System.out.println("Cell is already Occupied");
		}
	}
	
	public void insertAtFirst(E element) {
		if(elements[0]==null) {
			elements[0] = element;
			System.out.println("Element inserted");
		}
		else {
			int index = getIndex(null);
			if(index == -1)
				System.out.println("Array is full, can not add element");
			else {
				for(int i=index;i>0;i--)
					elements[i]= elements[i-1];
				elements[0]=element;
			}
		}
	}
	
	public void deleteElementByIndex(int index) {
		if(index < 0 || index >= this.sizeOfArray)
			System.out.println("index out of Bounds");
		else {
			this.elements[index] = null;
			System.out.println("Element Deleted");
		}
	}
	
	public void deleteElement(E element) {
		if(element == null)
			System.out.println("Cannot delete Null");
		else {
			int index = getIndex(element);
			this.elements[index] = null;
			System.out.println("Element Deleted");
		}
	}
	
	public void printArray() {
		System.out.println(Arrays.toString(elements));
	}
	
	public E getElement(int index) {
		if(index>=0 && index < this.sizeOfArray)
			return this.elements[index];
		else {
			System.out.println("Index out of bounds please pick a number between 0 and " + (this.sizeOfArray-1));
			return null;
		}
	}

	private int getIndex(E element) {
		int i = 0;
		for(E e: elements) {
			if(e==element)
				return i;
			i++;
		}
		return -1;
	}
}

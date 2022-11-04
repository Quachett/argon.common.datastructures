package uk.co.argon.common.datastructures.heap;

import java.lang.reflect.Array;

public class GenericArray<T> {
	private T[] t;
	@SuppressWarnings("unchecked")
	public T[] GenericArray(Class<T> clazz, int capacity) {
		t = (T[]) Array.newInstance(clazz, capacity);
		return t;
	}
}

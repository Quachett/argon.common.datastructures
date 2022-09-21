package uk.co.argon.common.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArraysAlgorithms {
	public int[] twoSum(int[] arr, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		
		int j=0;
		for(int i: arr) {
			int val = target-i;
			if(map.containsKey(val))
				return new int[]{map.get(val), j};
			map.put(i, j);
			j++;
		}
		
		throw new RuntimeException("No values found adding up to: " + target);
	}
	
	public int maxProduct(int[] arr) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MIN_VALUE;
		
		for(int i: arr) {
			if(i>min) {
				if(i>max) {
					min=max;
					max=i;
				}
				else
					min=i;
			}
		}
		
		return min*max;
	}
	
	public boolean isUnique(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for(int i: arr) {
			if(set.contains(i))
				return false;
			set.add(i);
		}
		return true;
	}
	
	public boolean arePermutation(int[] arr1, int[] arr2) {
		if(arr1.length!=arr2.length)
			return false;
		else if(Arrays.toString(arr1).equals(Arrays.toString(arr2)))
			return false;
		else {
			Map<Integer,Integer> list = new HashMap<>();
			
			for(int i: arr1) {
				if(list.containsKey(i))
					list.put(i, list.get(i)+1);
				else
					list.put(i, 1);
			}
			
			for(int i: arr2) {
				if(list.containsKey(i)) {
					if(list.get(i)>1)
						list.put(i, list.get(i)-1);
					else
					list.remove(i);
				}
				else
					return false;
			}
			
			if(!list.isEmpty()) {
				return false;
			}
		}
		
		return true;
	}
	
	public int[][] rotate90Deg(int[][] arr) {
		int col = arr[0].length;
		int newCol = 0;
		int row = arr.length;
		int[][] res = new int[col][row];
		
		for(int j = (col-1);j>=0;j--) {
			for(int i = 0;i<row;i++)
				res[i][newCol] = arr[j][i];
			newCol++;
		}
		
		return res;
	}
	
	public int[][] rotate90DegSameArray(int[][] arr, int i, int j) {
		if(i>j)
			return arr;
		else {
			
			rotate90DegSameArray(arr, i+1, j-1);
			int y = j;
			for(int x=i;x<j;x++) {
				int tl = arr[i][x];
				int tr = arr[x][j];
				int br = arr[j][y];
				int bl = arr[y][i];
				
				arr[x][j] = tl;
				arr[j][y] = tr;
				arr[y--][i] = br;
				arr[i][x] = bl;
			}
		}
		
		return arr;
	}
	
	public boolean binarySearch(int[] arr, int k) {
		return (Arrays.binarySearch(arr, k)>-1)?true:false;
	}
	
}

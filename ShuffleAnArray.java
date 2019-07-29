package com.hectorflores;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {

	int[] array;
	List<Integer> myList = new LinkedList<>();
	List<Integer> myListFinal = new LinkedList<>();
	
	
	
	public ShuffleAnArray(int[] nums) {
	    array = nums;
		for(int i = 0; i < nums.length; i++) {
			myList.add(nums[i]);
			myListFinal.add(nums[i]);
			
		}
		
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		int j = 0;
		
		for(int i : myListFinal) {
			
			array[j] = i;
			j++;
		}
		
		return array;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		
		Collections.shuffle(this.myList);
		int j = 0;
		for (int i : myList) {
			array[j] = i;
			j++;
		}
		
		return array;
		
	}

	public static void main(String[] args) {
		int[] array = {1,2,3};
		
		ShuffleAnArray sf = new ShuffleAnArray(array);
		
		sf.shuffle();
		//int[] b = sf.reset();
		
		
		for(int f : sf.array) {
			System.out.print(f+",");
		}
		
	
		
		
	

	}

}

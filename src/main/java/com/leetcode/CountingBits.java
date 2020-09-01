package com.leetcode;

import java.util.Arrays;

public class CountingBits {

	public static int[] countBits(int num) {
		int[] array = new int[num+1];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = numberof1Bits(i);
		}
		return array;
	}
	
	public static int numberof1Bits(int n) {
		 int count = 0;
		 while( n != 0)
	        {
	        n = n&(n-1);
	           count++;
	        }
	        return count;
		 
	 }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(20)));
	}

}

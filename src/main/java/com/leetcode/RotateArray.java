package com.leetcode;

public class RotateArray {

	public static void rotateArray(int[] nums, int k) {
		if (nums.length < 1) {
			return;
		}
		
        int value = 0;
        int before = 0;
        int after = 0;
        
		for (int i = 0; i < k; i++) {
			value = nums[nums.length-1];
			after = nums[0];
			for (int j = 1; j < nums.length; j++) {
				
				
				before = nums[j];
				nums[j] = after;
				after = before;
			}
			nums[0] = value;
		}
    }
	
	public static void main(String[] args) {
		int[] array = {};
		RotateArray.rotateArray(array, 3);
		for(int a : array) {
			System.out.print(a+",");
		}

	}

}

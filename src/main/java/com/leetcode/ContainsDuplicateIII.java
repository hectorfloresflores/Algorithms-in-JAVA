package com.leetcode;

public class ContainsDuplicateIII {
	public static boolean containsNearbyDuplicate(int[] nums, int k, int t) {
	
		for(int i = 0; i < (nums.length - k); i++) {
			
			for (int j = i+1; j <= i+k; j++) {
				
				if (Math.abs(nums[j]-nums[i]) <= t) {
					return true;
				}
				
			}
			
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		int[] array = {2,1};
System.out.println(containsNearbyDuplicate(array, 1,1));

	}

}

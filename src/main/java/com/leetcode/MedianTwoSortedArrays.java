package com.leetcode;

public class MedianTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array1 = {};
		int[] array2 = {1};
		System.out.println(mediantwoarrays(array1, array2));
		
	}
	
	public static double mediantwoarrays(int[] nums1, int[] nums2) {
		double result1=0,result2 = 0;
		
		
		for (int i = 0; i < nums1.length; i++) {
			result1 += nums1[i];
		}
	
		
		result1 /= nums1.length;
		
		
		for (int i = 0; i < nums2.length; i++) {
			result2 += nums2[i];
		}
		
		result2 /= nums2.length;
		
		
		if (Double.isNaN(result1)) {
			return result2;
		}else if (Double.isNaN(result2)) {
			return result1;
		}
		
		return (result2+result1)/2;
	}

}

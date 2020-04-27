package com.leetcode;

/*Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

		Example:

		Given array nums = [-1, 2, 1, -4], and target = 1.

		The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class ThreeSumClosest {

	public static int solution(int[] nums, int target){
		int difference = Integer.MAX_VALUE;
		int sum = difference;
		for(int i = 0;i < nums.length-2;i++) {
			for (int j = i+1; j < nums.length - 1; j++) {
				for(int k = j+1;k < nums.length;k++) {
					//System.out.println(nums[i]+nums[j]+nums[k]);
					if (target >= 0){
						if (Math.abs(nums[i]+nums[j]+nums[k]-target)< difference){


							difference = Math.abs(nums[i]+nums[j]+nums[k]-target);
							sum = nums[i]+nums[j]+nums[k];
						}
					}else{
						if(Math.abs(target-(nums[i]+nums[j]+nums[k]))< difference){


							difference = Math.abs(target-(nums[i]+nums[j]+nums[k]));
							sum = nums[i]+nums[j]+nums[k];
						}
					}

					System.out.println("i:"+nums[i]+" j:"+nums[j]+" k:"+nums[k]);
					System.out.println(nums[i]+nums[j]+nums[k]);
				}
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] nums = new int[]{-1,2,1,-4};
		System.out.println(solution(nums,-2));

	}

}

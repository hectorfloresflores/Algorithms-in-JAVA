package com.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 2)  {
            if (nums[0] == target) return 0;
            if (nums[1] == target) return 1;
            return -1;
        }
        return recursive(nums, 0, nums.length-1, target);
    }

    public int recursive(int[] nums, int left, int right, int value) {

        if (left == right) {
            if (nums[left] == value) return left;
            return -1;
        }
        int middle = left + Math.floorDiv((right - left),2);

        if (nums[middle] == value) return middle;
        //Left side is sorted
        if (((nums[middle] - nums[left]) >= 0 &&
                value >= nums[left] &&
                value <= nums[middle]) ||
                ((nums[right] - nums[middle+1] >= 0) && (value < nums[middle+1] ||
                        value > nums[right]))) {
            return recursive(nums, left, middle, value);

        } else {
           return recursive(nums,middle+1, right, value);
        }

    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
        int[] arr = new int[]{4,5,6,7,8,1,2,3};
        System.out.println(s.search(arr, 1));
    }
}

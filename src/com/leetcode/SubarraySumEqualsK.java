package com.leetcode;


/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *    Hide Hint #1
 * Will Brute force work here? Try to optimize it.
 *    Hide Hint #2
 * Can we optimize it by using some extra space?
 *    Hide Hint #3
 * What about storing sum frequencies in a hash table? Will it be useful?
 *    Hide Hint #4
 * sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int counter = 0;
        int sum;
        for (int i = 0; i <= nums.length-1; i++) {
            sum = 0;
            outerloop:
            for (int j = i; j <= nums.length-1; j++) {
                sum += nums[j];
                if (sum == k){
                    counter++;
                    break outerloop;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK test = new SubarraySumEqualsK();
        System.out.println(test.subarraySum(new int[]{1,2,3},3));
    }
}

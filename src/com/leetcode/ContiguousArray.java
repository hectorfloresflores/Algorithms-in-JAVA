package com.leetcode;

//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
//
//        Example 1:
//        Input: [0,1]
//        Output: 2
//        Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
//        Example 2:
//        Input: [0,1,0]
//        Output: 2
//        Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//Nuevo jeje
import java.util.HashMap;

public class ContiguousArray {

    /**
     * Time limit excee. Try the solution below
     * @param nums
     * @return
     */
    public static int findMaxLengthBruteForce(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0, ones = 0;
            for (int j = i; j < nums.length; j++) {
                if ((nums.length-i) < max) return max;
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    max = Math.max(max,((j-i)+1));
                }
            }
        }
        return max;

    }

    public static int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }
            if (map.containsKey(sum)) {
                max = Math.max(i-map.get(sum),max);
            } else {
                map.put(sum,i);
            }

        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(ContiguousArray.findMaxLength(new int[]{0,1,0,1}));
    }
}

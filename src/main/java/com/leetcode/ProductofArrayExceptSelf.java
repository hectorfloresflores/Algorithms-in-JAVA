package com.leetcode;

//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//        Example:
//
//        Input:  [1,2,3,4]
//        Output: [24,12,8,6]
//        Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
//
//        Note: Please solve it without division and in O(n).
//
//        Follow up:
//        Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

public class ProductofArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        boolean activate1 = false;
        boolean activate2 = false;
        int saveIndex = 0;
        long mult = 1;

        int counter = 0;
        for (int a : nums) {
            if (a == 0 && (!activate1 || !activate2)) {
                if (!activate1) {
                    saveIndex = counter;
                    activate1 = true;
                } else {
                    activate2 = true;
                }

            }
                mult *= a;
            counter++;
        }
        long mult2 = 1;
        if (activate1 == true && activate2 == false) {
            for (int i : nums) {
                if (i != 0) {
                    mult2 *= i;
                }
            }
        }


        int[] output = new int[nums.length];



        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                output[i] = ((int)mult % Integer.MAX_VALUE)/(nums[i]);
            } else if (activate1 == true && activate2 == false) {
                output[i] = ((int)mult2);
            }

        }

        return output;


    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf.productExceptSelf(new int[]{1,5,2,4,0});
    }

}

package com.hectorflores;

import java.util.HashMap;

//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//        Note:
//
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//        Example 1:
//
//        Input: [2,2,1]
//        Output: 1
//        Example 2:
//
//        Input: [4,1,2,1,2]
//        Output: 4
//ACEPTED

public class SingleNumber {
    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])-nums[i]);
            } else {
                map.put(nums[i],nums[i]);
            }

        }


        for (int i :  map.values()) {
            if (i != 0) {
                return i;
            }
        }

        return 0;

    }

}

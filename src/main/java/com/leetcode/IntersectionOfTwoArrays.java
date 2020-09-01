package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null)
            return new int[]{};
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int max = Math.max(nums1.length, nums2.length);

        for (int i = 0; i < max; i++) {
            if (i < nums1.length)
                set1.add(nums1[i]);
            if (i < nums2.length)
                set2.add(nums2[i]);
        }


        set1.removeIf(i -> !set2.contains(i));

        return set1.stream().
                mapToInt(Integer::intValue).
                toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
        i.intersection(new int[]{1,2,3}, new int[]{});
    }
}

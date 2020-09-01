package com.leetcode;

import java.util.HashSet;

public class CountingElements {

    public int countElements(int[] arr) {
        HashSet<Integer> numbers = new HashSet<>();
        int counter = 0;
        for(int a : arr) {
            numbers.add(a);
        }

        for (int i : arr) {
            if (numbers.contains(i+1))
                counter++;
        }
        return counter;
    }
}

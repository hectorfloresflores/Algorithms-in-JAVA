package com.hackerranck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptimizingBoxWeights {

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        arr.stream().forEach(System.out::println);
        // Write your code here
        Collections.sort(arr);

        long totalSum = 0;

        for (Integer i : arr) {
            totalSum += i;
        }
        //2,3,5,6,7
        long sumRight = 0;
        for (int i = arr.size()-1; i >= 0; i--) {
            sumRight += arr.get(i);
            //lets compare if this value it is greather than the sum of the rest
            if (sumRight > (totalSum - sumRight)) {
                return arr.subList(i, arr.size());
            }
        }
        return Collections.singletonList((int)sumRight);
    }

    public static void main(String[] args) {
        System.out.println(OptimizingBoxWeights.minimalHeaviestSetA(Arrays.asList(1,0,3,0, 2)));
    }
}

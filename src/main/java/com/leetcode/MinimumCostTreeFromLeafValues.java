package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumCostTreeFromLeafValues {

    public int mctFromLeafValues(int[] arr) {
        int middleLeft;
        int middleRight;
        if (arr.length % 2 == 0) {
            middleLeft = arr.length/2 -1;
            middleRight = arr.length/2;
        } else {
            middleLeft = (int)Math.floor(arr.length/2)-1;
            middleRight = (int)Math.floor(arr.length/2)+1;
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int start = 0; middleLeft >= start; middleLeft--) {
            leftSum += arr[middleLeft--];
            rightSum += arr[middleRight++];
        }
        boolean doesLeftSideArrHasMoreWeight = leftSum >= rightSum;

        if (doesLeftSideArrHasMoreWeight) {
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            Collections.reverse(list);
            arr = list.stream().mapToInt(i->i).toArray();
        }
        int minSum = arr[0];
        int sumvalue = 0;
        for (int i = 1; i < arr.length; i++) {
            sumvalue += minSum * arr[i];
        }
        return sumvalue;
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        System.out.println(list.isEmpty());
        MinimumCostTreeFromLeafValues m = new MinimumCostTreeFromLeafValues();
        m.mctFromLeafValues(new int[]{6,2,4});
    }
}

package com.hackerranck;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MagicSquareForming {

    static final List<Integer> evenArray = Stream.of(1, 3, 7, 9).collect(Collectors.toList());
    static final List<Integer> oddArray = Stream.of(2, 4, 6, 8).collect(Collectors.toList());
    static boolean[] used = new boolean[10];
    static HashMap<String, Queue<Integer>> map = new HashMap<>();
    public static int formingMagicSquare(List<List<Integer>> s) {
        int minCost = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int finalRow = row;
                int finalCol = col;
                Integer value = s.get(finalRow).get(finalCol);
                String valueMap = String.format("%s%s", row, col);
                if (row == 1 ^ col == 1) {
                    if (evenArray.stream().anyMatch(a -> value.equals(a))) {
                        used[value] = true;
                    } else {
                        map.put(valueMap, sortByRelative(evenArray, value));
                    }
                } else if (row == 1 && col == 1) {
                    used[value] = true;
                } else {
                    if (oddArray.stream().anyMatch(a -> value.equals(a))) {
                        used[value] = true;
                    } else {
                        map.put(valueMap, sortByRelative(oddArray, value));
                    }
                }

            }
        }
        // Write your code here
        //Key here it is that the solution matrix will only have the same numbers
        for (Map.Entry<String, Queue<Integer>> set : map.entrySet()) {

            Integer row = Integer.valueOf(set.getKey().split("")[0]);
            Integer col = Integer.valueOf(set.getKey().split("")[1]);
            Integer val = s.get(row).get(col);
            while (!set.getValue().isEmpty()) {
                Integer possibleValue = set.getValue().poll();
                if (!used[possibleValue]) {
                    minCost += Math.abs(val - possibleValue);
                    used[possibleValue] = true;
                }
            }


        }

        return minCost;
    }

    static Queue<Integer> getSuitableNumbers(int row, int column, Integer relative) {
        //Means we should use even array
        if (row == 1 ^ column == 1) {
            return sortByRelative(evenArray, relative); 
        } else if (row == 1 && column == 1) {
            used[relative] = true;
        }

        return sortByRelative(oddArray, relative);

    }

    static Queue<Integer> sortByRelative(List<Integer> number, int relative) {
        return number.stream()
            .sorted(Comparator.comparingInt(a -> Math.abs(a - relative)))
            .collect(Collectors.toCollection(PriorityQueue::new));
    }

    public static void main(String[] args) {
        //Queue<Integer> list = MagicSquareForming.sortByRelative(Stream.of(1,2,3,4,5,6).collect(Collectors.toList()), 5 );
        formingMagicSquare(Arrays.asList(Arrays.asList(5, 3, 4), Arrays.asList(1, 5, 8), Arrays.asList(6, 4, 2)));
    }
}

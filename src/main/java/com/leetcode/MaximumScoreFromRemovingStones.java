package com.leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {

        return recursive(a, b, c);
    }

    public int recursive(int a, int b, int c) {
        List<Integer> list = Arrays.asList(a,b,c);
        Collections.sort(list, Collections.reverseOrder());

        a = list.get(0);
        b = list.get(1);
        c = list.get(2);

        if (a >= b + c) {
            return  b + c;
        }
        return  a + (int)Math.floor((b + c - a)/2);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> a-b);
        queue.offer(2);
        queue.offer(1);
        queue.offer(3);

        System.out.printf(queue.poll().toString());
        System.out.printf(queue.poll().toString());
        System.out.printf(queue.poll().toString());
        MaximumScoreFromRemovingStones m = new MaximumScoreFromRemovingStones();
        System.out.println(m.maximumScore(6,2,1));

    }
}

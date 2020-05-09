package com.leetcode;

//You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
//
//direction can be 0 (for left shift) or 1 (for right shift).
//amount is the amount by which string s is to be shifted.
//A left shift by 1 means remove the first character of s and append it to the end.
//Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
//Return the final string after all operations.
//
//
//
//Example 1:
//
//Input: s = "abc", shift = [[0,1],[1,2]]
//Output: "cab"
//Explanation:
//[0,1] means shift to left by 1. "abc" -> "bca"
//[1,2] means shift to right by 2. "bca" -> "cab"
//Example 2:
//
//Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
//Output: "efgabcd"
//Explanation:
//[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
//[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
//[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
//[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"

import java.util.LinkedList;
import java.util.Stack;

class PerformStringShift {


        public static String stringShift(String s, int[][] shift) {
            int sum = 0;
            for (int[] array : shift) {
                if (array[0] == 0) {
                    sum += array[1];
                } else {
                    sum -= array[1];
                }
            }
            LinkedList<String> list = new LinkedList<>();
            for (char a : s.toCharArray()) {
                list.add(String.valueOf(a));
            }
            String aux = "";
            int restSum = 0;
//            sum = Math.abs(restSum);

            if (sum > 0) {
                while (sum != 0) {
                    aux = list.pollFirst();
                    list.add(list.size(),aux);
                    sum--;
                }
            } else if(sum < 0){
                while (sum != 0) {
                    aux = list.pollLast();
                    list.push(aux);
                    sum++;
                }
            }
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.pollFirst());

            }



            return sb.toString();
        }


    public static void main(String[] args) {


        System.out.println(PerformStringShift.stringShift("wpdhhcj", new int[][]{{0,7},{1,7},{1,0},{1,3},{0,3},{0,6},{1,2}}));
    }
}
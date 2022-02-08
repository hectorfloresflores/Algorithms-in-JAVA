package com.leetcode;

/*Given a string, your task is to count how many palindromic substrings in this string.

        The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

        Example 1:

        Input: "abc"
        Output: 3
        Explanation: Three palindromic strings: "a", "b", "c".


        Example 2:

        Input: "aaa"
        Output: 6
        Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


        Note:

        The input string length won't exceed 1000.*/


public class PalindromicSubstrings {

    public static int solution(String s) {

        int steps = 0;


        for (int i = 0; i < s.length(); i++) {
            steps += expandPalindromeInPos(s, i);

        }

        return steps;


    }

    private static int expandPalindromeInPos(String word, int pos) {
        int count = 1;
        int left = pos, right = pos;
        boolean once = false;

        left--;
        right++;
        if (left >= 0 && right < word.length() && word.charAt(left) == word.charAt(right)) {
            while (left >= 0 && right < word.length()) {
                if (word.charAt(left) == word.charAt(right)) {
                    count++;
                }
                left--;
                right++;
            }

        }

        left = pos;
        right = pos;
        left--;
        if (left >= 0 && right < word.length() && word.charAt(left) == word.charAt(right)) {
            while (left >= 0 && right < word.length()) {
                if (word.charAt(left) == word.charAt(right)) {
                    count++;
                }
                left--;
                right++;
            }

        }



        return count;

    }

    public static void main(String[] args) {
        System.out.println(PalindromicSubstrings.solution("aaa"));

        StringBuilder sb = new StringBuilder("esta es una prueba");
        sb.delete(2,6);
        System.out.println(sb.toString());
    }
}


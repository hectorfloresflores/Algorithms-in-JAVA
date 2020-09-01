package com.leetcode;

//Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
//
//        Note that after backspacing an empty text, the text will continue empty.
//
//        Example 1:
//
//        Input: S = "ab#c", T = "ad#c"
//        Output: true
//        Explanation: Both S and T become "ac".
//        Example 2:
//
//        Input: S = "ab##", T = "c#d#"
//        Output: true
//        Explanation: Both S and T become "".
//        Example 3:
//
//        Input: S = "a##c", T = "#a#c"
//        Output: true
//        Explanation: Both S and T become "c".
//        Example 4:
//
//        Input: S = "a#c", T = "b"
//        Output: false
//        Explanation: S becomes "c" while T becomes "b".
//        Note:
//
//        1 <= S.length <= 200
//        1 <= T.length <= 200
//        S and T only contain lowercase letters and '#' characters.
//        Follow up:
//
//        Can you solve it in O(N) time and O(1) space?

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {

        char[] arrayS = S.toCharArray();
        char[] arrayT = T.toCharArray();
        int residuo = 0;
        for (int i = arrayS.length-1; i >= 0;) {
            boolean flag = false;
            int counter = residuo;
            while (i >= 0 && arrayS[i] == '#') {
                counter++;
                i--;
            }
            if (counter == 0)flag = true;
            while (counter > 0 && i >= 0 && arrayS[i] != '#') {
                arrayS[i] = 0;
                counter--;
                i--;
            }
            residuo = counter;
            if (flag == true) {
                i--;
            }
        }
        String finalS = "";
        for (char c : arrayS) {
            if (c != '#' && c != 0) {
                finalS = finalS.concat(String.valueOf(c));
            }
        }
        residuo = 0;
        for (int i = arrayT.length-1; i >= 0;) {
            boolean flag = false;
            int counter = residuo;
            while (i >= 0 && arrayT[i] == '#') {
                counter++;
                i--;
            }
            if (counter == 0)flag = true;
            while (counter > 0 && i >= 0 && arrayT[i] != '#') {
                arrayT[i] = 0;
                counter--;
                i--;
            }
            residuo = counter;
            if (flag == true) {
                i--;
            }
        }
        String finalT = "";
        for (char c : arrayT) {
            if (c != '#' && c != 0) {
                finalT = finalT.concat(String.valueOf(c));
            }
        }


        return finalT.equals(finalS);
    }

    public static void main(String[] args) {

        System.out.println(BackspaceStringCompare.backspaceCompare("e##e#o##oyof##q", "e##e#fq##o##oyof##q"));
    }
}

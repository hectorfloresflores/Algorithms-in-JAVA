package com.codeforces;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * time limit per test2 seconds
 * memory limit per test256 megabytes
 * inputstandard input
 * outputstandard output
 * You are given two strings 𝑠 and 𝑡, each of length 𝑛 and consisting of lowercase Latin alphabets. You want to make 𝑠 equal to 𝑡.
 *
 * You can perform the following operation on 𝑠 any number of times to achieve it —
 *
 * Choose any substring of 𝑠 and rotate it clockwise once, that is, if the selected substring is 𝑠[𝑙,𝑙+1...𝑟], then it becomes 𝑠[𝑟,𝑙,𝑙+1...𝑟−1]. All the remaining characters of 𝑠 stay in their position.
 * For example, on rotating the substring [2,4] , string "abcde" becomes "adbce".
 *
 * A string 𝑎 is a substring of a string 𝑏 if 𝑎 can be obtained from 𝑏 by deletion of several (possibly, zero or all) characters from the beginning and several (possibly, zero or all) characters from the end.
 *
 * Find the minimum number of operations required to convert 𝑠 to 𝑡, or determine that it's impossible.
 *
 * Input
 * The first line of the input contains a single integer 𝑡 (1≤𝑡≤2000) — the number of test cases. The description of the test cases follows.
 *
 * The first line of each test case contains a single integer 𝑛 (1≤𝑛≤2000) — the length of the strings.
 *
 * The second and the third lines contain strings 𝑠 and 𝑡 respectively.
 *
 * The sum of 𝑛 over all the test cases does not exceed 2000.
 *
 * Output
 * For each test case, output the minimum number of operations to convert 𝑠 to 𝑡. If it is not possible to convert 𝑠 to 𝑡, output −1 instead.
 *
 * Example
 * inputCopy
 * 6
 * 1
 * a
 * a
 * 2
 * ab
 * ba
 * 3
 * abc
 * cab
 * 3
 * abc
 * cba
 * 4
 * abab
 * baba
 * 4
 * abcc
 * aabc
 * outputCopy
 * 0
 * 1
 * 1
 * 2
 * 1
 * -1
 * Note
 * For the 1-st test case, since 𝑠 and 𝑡 are equal, you don't need to apply any operation.
 *
 * For the 2-nd test case, you only need to apply one operation on the entire string ab to convert it to ba.
 *
 * For the 3-rd test case, you only need to apply one operation on the entire string abc to convert it to cab.
 *
 * For the 4-th test case, you need to apply the operation twice: first on the entire string abc to convert it to cab and then on the substring of length 2 beginning at the second character to convert it to cba.
 *
 * For the 5-th test case, you only need to apply one operation on the entire string abab to convert it to baba.
 *
 * For the 6-th test case, it is not possible to convert string 𝑠 to 𝑡.
 */
public class FRotatingSubstrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < test; i++) {
            int counter = 0;
            int length = sc.nextInt();
            sc.nextLine();
            Stack<String> sA = new Stack<>();
            Stack<String> sB = new Stack<>();

            for (String s : sc.nextLine().split("")) {
                sA.add(s);
            }

            for (String s : sc.nextLine().split("")) {
                sB.add(s);
            }

            if (sA.toString().equals(sB.toString()))
                System.out.println(0);
            else {
                boolean g = false;
                while (counter < length-1) {
                    sA.add(0,sA.pop());
                    counter++;
                    if (sA.toString().equals(sB.toString())) {
                        System.out.println(counter);
                        g = true;
                        break;
                    }

                }
                if (!g)
                System.out.println(-1);
            }


        }
    }

}

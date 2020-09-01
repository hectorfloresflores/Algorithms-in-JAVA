package com.leetcode;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        result = ~(result & 0);
        for (int i = m; i <= n; i++) {
            result = result & i;
        }
        return result;
    }

    public static  void main(String... args) {
        BitwiseANDofNumbersRange test = new BitwiseANDofNumbersRange();
        System.out.println(test.rangeBitwiseAnd(5,7));
    }

}

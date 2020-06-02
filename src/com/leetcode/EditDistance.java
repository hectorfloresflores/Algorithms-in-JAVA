package com.leetcode;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */

public class EditDistance {


    public int minDistance(String word1, String word2) {
        int w1l = word1.length()+1;
        int w2l = word2.length()+1;
       int[][] matrix = new int[w1l][w2l];
       for (int i = 0; i < w2l; i++) {
           matrix[0][i] = i;
       }
        for (int i = 0; i < w1l; i++) {
            matrix[i][0] = i;
        }
       for (int row = 1; row < w1l; row++) {
           for (int col = 1; col < w2l; col++) {
               if (word1.charAt(row-1) == word2.charAt(col-1)) {
                   matrix[row][col] = matrix[row-1][col-1];
               } else {
                   matrix[row][col] = Math.min(
                           Math.min(matrix[row-1][col],matrix[row-1][col-1]),
                           matrix[row][col-1]) + 1;
               }

           }
       }
        return matrix[w1l-1][w2l-1];
    }



    public static void main(String[] args) {
        String g = "hola";

        EditDistance e = new EditDistance();

        System.out.println(e.minDistance("tae","sea"));


    }


}

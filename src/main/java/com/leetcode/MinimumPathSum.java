package com.leetcode;

import java.util.HashMap;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum {

//    int minValue = Integer.MAX_VALUE;
//    int[][] check;
//
//    public int minPathSum(int[][] grid) {
//        //Initialize Max because there are no negatives.
//        if (grid.length == 0) return 0;
//        check = new int[grid.length][grid[0].length];
//
//        for (int i = 0; i < check.length; i++) {
//            for (int j = 0; j < check[0].length;j++) {
//                check[i][j] = Integer.MAX_VALUE;
//            }
//        }
//
//        recursive(grid,0,0, 0);
//
//        return minValue;
//    }
//
//    public void recursive(int[][] grid, int row, int column, int value) {
//
//        value += grid[row][column];
//
//
//        if ( check[row][column] < value){
//            if (column != (grid[0].length - 1)) {
//                check[row][column] = Math.min(check[row][column],
//                        check[row][column+1]);
//            }
//            if (row != (grid.length - 1)) {
//                check[row][column] = Math.min(check[row][column],
//                        check[row+1][column]);
//            }
//            return;
//        }
//        check[row][column] = value;
//
//
//        if (row == (grid.length - 1) && column == (grid[0].length - 1)) {
//            minValue = Math.min(minValue, value);
//            return;
//        }
//
//        //Go right if you can
//        if (column != (grid[0].length - 1)) {
//
//            recursive(grid, row, column + 1, value);
//        }
//        //Go down uf you can
//        if (row != (grid.length - 1)) {
//
//            recursive(grid, row + 1, column, value);
//        }
//    }

    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        int[][] matrix = new int[height][width];

        for (int rows = 0; rows < height; rows++) {
            for (int columns = 0; columns < width; columns++) {
                if (rows == 0 && columns == 0) {
                    matrix[rows][columns] = grid[rows][columns];
                } else {
                    matrix[rows][columns] = grid[rows][columns] +
                            Math.min(
                                    (rows == 0?Integer.MAX_VALUE:matrix[rows-1][columns]),
                                    (columns == 0?Integer.MAX_VALUE:matrix[rows][columns-1]));
                }
            }

        }
        return matrix[height-1][width-1];
    }
    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        long a = System.nanoTime();
        int[][] grid = new int[][]{
        {7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},
        {9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},
        {8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},
        {6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},
        {7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},
        {9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},
        {1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},
        {3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},
        {1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},
        {5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},
        {2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},
        {0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}
        };
        System.out.println(m.minPathSum(grid));
        long b = System.nanoTime();
        System.out.println(b-a);
    }

}

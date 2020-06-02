package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    List<Integer> list;
    private int col, row;
    private String dir;
    private int upDownLimit;
    private int rightLeftLimit;
    private int downUpLimit;
    private int leftRightLimit;
    public List<Integer> spiralOrder(int[][] matrix) {
        list = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        col = 0;
        row = 0;
        upDownLimit = 0;
        rightLeftLimit = matrix[0].length-1;
        downUpLimit = matrix.length-1;
        leftRightLimit = 0;

        dir = "right";


        do {

            list.add(matrix[row][col]);
        } while (next());



        return list;
    }



    private boolean next() {
        if (dir.equals("right")) {
            if (col < rightLeftLimit) {
                col++;
                return true;
            } else if (row < downUpLimit) {
                row++;
                dir = "down";
                upDownLimit++;
                return true;
            } else {
                return false;
            }
        } else if (dir.equals("down")) {
            if (row < downUpLimit) {
                row++;
                return true;
            } else if (col > leftRightLimit) {
                col--;
                dir = "left";
                rightLeftLimit--;
                return true;
            } else {
                return false;
            }
        } else if (dir.equals("left")) {
            if (col > leftRightLimit) {
                col--;
                return true;
            } else if (row > upDownLimit) {
                row--;
                dir = "up";
                downUpLimit--;
                return true;
            } else {
                return false;
            }
        } else if (dir.equals("up")) {
            if (row > upDownLimit) {
                row--;
                return true;
            } else if (col < rightLeftLimit) {
                col++;
                dir = "right";
                leftRightLimit++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] m = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] m1 = new int[][]{};
        sm.spiralOrder(m);
        System.out.printf(sm.list.toString());

    }
}

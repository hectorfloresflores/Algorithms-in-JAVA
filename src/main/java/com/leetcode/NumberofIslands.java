package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberofIslands {

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int heigth = grid.length;
        int width = grid[0].length;

        int islands = 0;



        for (int rows = 0; rows < heigth; rows++) {
            for (int columns = 0; columns < width; columns++) {

                if (grid[rows][columns] == '1') {
                    islands++;
                    recursiveProgation(grid,rows, columns);
                }

            }
        }

        return islands;

    }

    public static void recursiveProgation(char[][] propagation,
                                          int row, int col) {
        if (propagation[row][col] == '1') {
            propagation[row][col] = '0';
            //left propagation
            if (col != 0)
                recursiveProgation(propagation,row,col-1);

            //right propagation
            if (col != (propagation[0].length - 1) )
                recursiveProgation(propagation,row,col+1);
            //up propagation
            if (row != 0)
                recursiveProgation(propagation,row-1,col);

            //down propagation
            if (row != (propagation.length - 1))
                recursiveProgation(propagation,row+1,col);
        }



    }

    public static void main(String[] args) {
        char[][] island = new char[][]{{}};

        System.out.println(NumberofIslands.numIslands(island));




    }

}

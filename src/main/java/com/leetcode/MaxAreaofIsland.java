package com.leetcode;

public class MaxAreaofIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;

        int heigth = grid.length;
        int width = grid[0].length;

        int maxArea = 0;

        for (int rows = 0; rows < heigth; rows++) {
            for (int columns = 0; columns < width; columns++) {
                int[] area = new int[1];
                if (grid[rows][columns] == 1) {
                    recursiveProgation(grid ,rows, columns, area);
                    //Means we found at least one square and we will replace new area value
                    if (area[0] > maxArea) {
                        maxArea = area[0];
                    }
                }

            }
        }

        return maxArea;


    }

    public static void recursiveProgation(int[][] propagation,
                                          int row, int col, int[] squareAndArea) {
        if (propagation[row][col] == 1) {
            squareAndArea[0]++;
            propagation[row][col] = 0;
            //left propagation
            if (col != 0)
                recursiveProgation(propagation, row, col - 1, squareAndArea);

            //right propagation
            if (col != (propagation[0].length - 1)) {
                recursiveProgation(propagation, row, col + 1, squareAndArea);
            }
            //up propagation
            if (row != 0)
                recursiveProgation(propagation, row - 1, col, squareAndArea);

            //down propagation
            if (row != (propagation.length - 1))
                recursiveProgation(propagation, row + 1, col, squareAndArea);
        }
    }

    public static void main(String[] args) {
        int[][] island = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(MaxAreaofIsland.maxAreaOfIsland(island));
    }
}

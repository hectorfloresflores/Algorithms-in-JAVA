package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 Key1: They key it is to know that we have to use BFS and not DFS because an orange will rotte like a virus
 So having this in mind we will have a timeMatrix that will save the elapsed time starting from each rotten orange.
 If we used DFS we will not encounter the minimum time elapsed as easy as using BFS because will not expand like a virus
 but will follow the first path until reach the end and we dont want that.

 Key2: Because we are looking the fastest time to rotten all oranges, If there is more than 1 rotten oranges on a specific
 area that there are more non-rotten oranges we have to re calculate starting from each rotten orange. For example lets says
 That we have a matrix [3x3] with non-rotten oranges in all cells but on cell [0, 0] and [2, 2] we have rotten oranges.
 Like this
 [2,1,1]
 [1,1,1]
 [1,1,2]
 If we rotten all orange just from [0, 0], timeMatrix will be like this above
 [0,1,2]
 [1,2,3]
 [2,3,0]
 as you can see this is not correct because we have another rotten orange in [2, 2], so if we re-run starting from [2,2]
 timeMatrix will be like this
 [0,1,2]
 [1,2,1]
 [2,1,0]
 and the answer it is 2.

 key3 : We have also to check if there it is an orange that it is not rotten, so then there is it not solution for this.
 */


public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int time = 0;//This is the best time(minimum) if exists to rotten all oranges.
        if (grid == null) {
            return -1;
        }
        //We have to fill the timeMatrix with max values because we will improve the time of rotten oranges
        int[][] timeMatrix = new int[grid.length][grid[0].length];
        for (int i = 0; i < timeMatrix.length; i++) {
            Arrays.fill(timeMatrix[i], Integer.MAX_VALUE);
        }
        //This visitedMatrix it is int and not boolean because we will reuse it so each time we find a rotten orange we have to change
        //the visitedSymbol because probably there were a previous near rotten orange that visited this matrix.
        int[][] visitedMatrix = new int[grid.length][grid[0].length];
        int visitedSymbol = 1;//This is the symbol that whenever we find a rotten orange we will increment it to reuse the matrix
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 2) {
                    //We have to initialize this to zero because otherwise we cannot improve the time.
                    timeMatrix[row][column] = 0;
                    bfs(grid, row, column, timeMatrix, visitedMatrix, visitedSymbol);
                    visitedSymbol++;//Increment visitedSymbol
                }
            }
        }
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                //Let's get the max value but not the int max valuedd
                if (timeMatrix[row][column] > time && timeMatrix[row][column] != Integer.MAX_VALUE) {
                    time = timeMatrix[row][column];
                }
                //Means this orange it is not rotten so there is no solution and we return -1;
                if (grid[row][column] == 1 && timeMatrix[row][column] == Integer.MAX_VALUE) {
                    return -1;
                }
            }
        }
        return time;
    }

    void bfs(int[][] grid, int row, int column, int[][] timeMatrix, int[][] visitedMatrix, int visitedSymbol) {

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(row, column));
        List<Integer> current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            int currentRow = current.get(0);
            int currentColumn = current.get(1);

            //Means we havent visited it yet!
            addOneLevel(grid, currentRow, currentColumn, timeMatrix, visitedMatrix, visitedSymbol, queue);

        }
    }

    void addOneLevel(int[][] grid, int row, int column, int[][] timeMatrix, int[][] visitedMatrix, int visitedSymbol, Queue<List<Integer>> queue) {
        int left = column - 1, right = column + 1, up = row - 1, down = row + 1;

        visitedMatrix[row][column] = visitedSymbol;
        if (left >= 0 && grid[row][left] == 1 && visitedMatrix[row][left] != visitedSymbol && (timeMatrix[row][column]+1) < timeMatrix[row][left]) {
            timeMatrix[row][left] = timeMatrix[row][column]+1;
            queue.offer(Arrays.asList(row, left));
            visitedMatrix[row][left] = visitedSymbol;
        }
        if (up >= 0 && grid[up][column] == 1 && visitedMatrix[up][column] != visitedSymbol && (timeMatrix[row][column]+1) < timeMatrix[up][column]) {
            timeMatrix[up][column] = timeMatrix[row][column]+1;
            queue.offer(Arrays.asList(up, column));
            visitedMatrix[up][column] = visitedSymbol;
        }
        if (down < grid.length && grid[down][column] == 1 && visitedMatrix[down][column] != visitedSymbol && (timeMatrix[row][column]+1) < timeMatrix[down][column]) {
            timeMatrix[down][column] = timeMatrix[row][column]+1;
            queue.offer(Arrays.asList(down, column));
            visitedMatrix[down][column] = visitedSymbol;
        }
        if (right < grid[0].length && grid[row][right] == 1 && visitedMatrix[row][right] != visitedSymbol && (timeMatrix[row][column]+1) < timeMatrix[row][right]) {
            timeMatrix[row][right] = timeMatrix[row][column]+1;
            queue.offer(Arrays.asList(row, right));
            visitedMatrix[row][right] = visitedSymbol;
        }

    }

    public static void main(String[] args) {
        int[][] oranges = new int[][]{{2,1,1},{1,1,0},{0,1,2}};
            RottingOranges r = new RottingOranges();
        System.out.println(r.orangesRotting(oranges));
    }
}

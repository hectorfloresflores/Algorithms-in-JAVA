package com.lintcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {


    public void wallsAndGates(int[][] rooms) {
        int time = 0;//This is the best time(minimum) if exists to rotten all oranges.
        if (rooms == null) {
            return;
        }
        //This visitedMatrix it is int and not boolean because we will reuse it so each time we find a rotten orange we have to change
        //the visitedSymbol because probably there were a previous near rotten orange that visited this matrix.
        int[][] visitedMatrix = new int[rooms.length][rooms[0].length];
        int visitedSymbol = 1;//This is the symbol that whenever we find a rotten orange we will increment it to reuse the matrix
        for (int row = 0; row < rooms.length; row++) {
            for (int column = 0; column < rooms[0].length; column++) {
                if (rooms[row][column] == 0) {
                    //We have to initialize this to zero because otherwise we cannot improve the time.
                    bfs(rooms, row, column, visitedMatrix, visitedSymbol);
                    visitedSymbol++;//Increment visitedSymbol
                }
            }
        }
    }

    void bfs(int[][] grid, int row, int column, int[][] visitedMatrix, int visitedSymbol) {

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(row, column));
        List<Integer> current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            int currentRow = current.get(0);
            int currentColumn = current.get(1);

            //Means we havent visited it yet!
            addOneLevel(grid, currentRow, currentColumn, visitedMatrix, visitedSymbol, queue);

        }
    }

    void addOneLevel(int[][] grid, int row, int column, int[][] visitedMatrix, int visitedSymbol, Queue<List<Integer>> queue) {
        int left = column - 1, right = column + 1, up = row - 1, down = row + 1;

        visitedMatrix[row][column] = visitedSymbol;
        if (left >= 0 && grid[row][left] != -1 && visitedMatrix[row][left] != visitedSymbol && (grid[row][column]+1) < grid[row][left]) {
            grid[row][left] = grid[row][column]+1;
            queue.offer(Arrays.asList(row, left));
            visitedMatrix[row][left] = visitedSymbol;
        }
        if (up >= 0 && grid[up][column] != -1 && visitedMatrix[up][column] != visitedSymbol && (grid[row][column]+1) < grid[up][column]) {
            grid[up][column] = grid[row][column]+1;
            queue.offer(Arrays.asList(up, column));
            visitedMatrix[up][column] = visitedSymbol;
        }
        if (down < grid.length && grid[down][column] != -1 && visitedMatrix[down][column] != visitedSymbol && (grid[row][column]+1) < grid[down][column]) {
            grid[down][column] = grid[row][column]+1;
            queue.offer(Arrays.asList(down, column));
            visitedMatrix[down][column] = visitedSymbol;
        }
        if (right < grid[0].length && grid[row][right] != -1 && visitedMatrix[row][right] != visitedSymbol && (grid[row][column]+1) < grid[row][right]) {
            grid[row][right] = grid[row][column]+1;
            queue.offer(Arrays.asList(row, right));
            visitedMatrix[row][right] = visitedSymbol;
        }

    }

    public static void main(String[] args) {
        int[][] rooms = new int[][]{{0,-1},{2147483647,2147483647}};
        WallsAndGates wg =  new WallsAndGates();
        wg.wallsAndGates(rooms);
        System.out.println("here");
    }
}

package com.leetcode;

public class SurroundedRegions {
    public void solve(char[][] board) {

        if (board == null) {
            return;
        }
        char[] sign = new char[]{'A'};

        // left -> right on top
        for (int column = 0; column < board[0].length; column++) {
            bfs(board, 0, column, sign);
        }
        // up -> down on left
        for (int row = 1; row < board.length; row++) {

            bfs(board, row, 0, sign);
        }
        // left -> right on bottom
        for (int column = 1; column < board[0].length; column++) {

            bfs(board, board.length-1, column, sign);
        }
        // up -> down on right
        for (int row = 1; row < board.length - 1; row++) {

            bfs(board, row, board[0].length-1, sign);
        }
        sign[0] = 'X';
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                //bfs(board, row, column, sign);
                if (board[row][column] == 'O') {
                    board[row][column] = 'X';
                }
                if (board[row][column] == 'A') {
                    board[row][column] = 'O';
                }
            }
        }
    }

    void bfs(char[][] board, int row, int column, char[] sign) {

        if (row >= board.length ||
            column < 0 ||
            row < 0 ||
            column >= board[0].length) {
            return;
        }

        if (board[row][column] == 'O'){
            board[row][column] = sign[0];
            bfs(board, row+1, column, sign);
            bfs(board, row-1, column, sign);
            bfs(board, row, column+1, sign);
            bfs(board, row, column-1, sign);
        }

    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = new char[][]{{'O','O'},{'O','O'}};
        sr.solve(board);
    }
}

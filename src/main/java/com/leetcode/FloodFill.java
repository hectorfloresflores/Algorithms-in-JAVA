package com.leetcode;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color == image[sr][sc]) {
            return image;
        }
        return recursiveFloodFill(image, sr, sc, color, image[sr][sc]);
    }

    int[][] recursiveFloodFill(int[][] image, int sr, int sc, int color, int root) {
        System.out.print(sr + " " +  sc);
        //Color it if it has root color
        if (image[sr][sc] == root) {
            image[sr][sc] = color;
        } else {
            return image;
        }

        //go right
        if (sc != (image[0].length - 1)) {
            recursiveFloodFill(image, sr, sc + 1, color, root);
        }
        //go down
        if (sr != (image.length - 1)) {
            recursiveFloodFill(image, sr + 1, sc, color, root);
        }
        //go left
            if (sc != 0) {
                recursiveFloodFill(image, sr, sc - 1, color, root);
            }
        //go up
            if (sr != 0) {
                recursiveFloodFill(image, sr - 1, sc, color, root);
            }

        return image;
    }

}

package com.leetcode;

public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        return getFarestBetweenTwoPoints(points);
    }

    double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((y2-y1), 2) + Math.pow((x2-x1), 2));
    }

    double getFarestBetweenTwoPoints(int[][] points) {
        double max = 0;

        for (int i = 0; i < (points.length - 2); i++) {
            for (int j = i; j < (points.length - 1); j++) {
                for (int k = j; k < points.length; k++) {
                    double temp = Math.abs((points[i][0]*points[j][1] +  points[j][0]*points[k][1] + points[k][0]*points[i][1]  -
                        points[i][1]*points[j][0] - points[j][1]*points[k][0] - points[k][1]*points[i][0]
                        )/2.0);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LargestTriangleArea l = new LargestTriangleArea();
        l.largestTriangleArea(new int[][]{{8,10},{2,7},{9,2},{4,10}});
    }
}

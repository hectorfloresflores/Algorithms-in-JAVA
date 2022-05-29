package com.hackerranck;


public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        int height = 0;
        int valleys = 0;
        // Write your code here
        for (String letter : path.split("")) {
            if (letter.equalsIgnoreCase("U")) {
                height++;
            } else if (letter.equalsIgnoreCase("D")) {
                if (height == 0) {
                    valleys++;
                }
                height--;
            }
        }
        return valleys;
    }

    public static void main(String[] args) {
        System.out.println(CountingValleys.countingValleys(0, "UDDDUDUU"));
    }
}

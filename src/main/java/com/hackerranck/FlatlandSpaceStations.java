package com.hackerranck;

import java.util.Arrays;
import java.util.Collections;

public class FlatlandSpaceStations {

    static int flatlandSpaceStations(int n, int[] c) {
        int[] ordered = Arrays.stream(c).sorted().toArray();
        //This means
        int max = 0;
        for (int i = 0; i < ordered.length - 1; i++) {
            double diff = Math.floor((ordered[i+1]-ordered[i])/2);
            if (diff > max) {
                max = (int)diff;
            }
        }
        if (n != ordered[ordered.length-1] - 1) {
            int diff = n - ordered[ordered.length-1] - 1;
            if (diff > max) {
                max = diff;
            }
        }
        if (ordered[0] != 0 && ordered[0] > max) {
           max = ordered[0];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(FlatlandSpaceStations.flatlandSpaceStations(95, new int[]{68 ,81 ,46 ,54 ,30 ,11 ,19, 23, 22, 12, 38, 91, 48 ,75, 26, 86, 29, 83, 62}));
    }
}

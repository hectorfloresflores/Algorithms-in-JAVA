package com.leetcode;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        outer:
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    temperatures[i] = j - i;
                    continue outer;
                }
            }
            temperatures[i] = 0;
        }
        return temperatures;
    }

    public static void main(String[] args) {
        DailyTemperatures a = new DailyTemperatures();
        a.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}

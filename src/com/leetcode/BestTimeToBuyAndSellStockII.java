package com.leetcode;

public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minValue = prices[0];
        for (int i = 0; i < prices.length; i++) {

            if (prices[i] <= minValue) {
                minValue = prices[i];
            } else if (prices[i] > minValue) {
                maxProfit += prices[i] - minValue;
                minValue = prices[i];
//                i += 2;
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII.maxProfit(new int[]{7,6,4,3,1});
    }
}

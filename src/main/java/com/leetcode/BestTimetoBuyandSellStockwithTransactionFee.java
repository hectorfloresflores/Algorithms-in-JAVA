package com.leetcode;

public class BestTimetoBuyandSellStockwithTransactionFee {
    int maxProfit = 0;
    boolean lastTransactionBuy;
    int finalFee = 0;
    public int maxProfit(int[] prices, int fee) {
        finalFee = fee;
        lastTransactionBuy = false;
        recursiveCall(prices, 0, 0, prices[0]);
        return maxProfit;
    }

    void recursiveCall(int[] prices, int amountUntilNow, int pos, int lastPrice) {
        if (pos == prices.length) {
            maxProfit = Math.max(amountUntilNow, maxProfit);
            return;
        }
        int profit;
        //If last transaction was a buy we have to sell if it is convinient
        if (lastTransactionBuy) {
            //it it is convinient to sell at this day to make profit
            profit = (prices[pos] - lastPrice - finalFee);
            if (profit > 0) {
                lastTransactionBuy = false;
                recursiveCall(prices, amountUntilNow + profit, pos + 1, prices[pos]);
            }
            recursiveCall(prices, amountUntilNow, pos + 1, lastPrice);
        }
            lastTransactionBuy = true;
            recursiveCall(prices, amountUntilNow, pos + 1, prices[pos]);

    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithTransactionFee b = new BestTimetoBuyandSellStockwithTransactionFee();
        b.maxProfit(new int[]{4,5,2,4,3,3,1,2,5,4}, 1);
        System.out.println(b.maxProfit);
    }
}

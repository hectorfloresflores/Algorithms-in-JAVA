package com.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {

    public int coinChange(int[] coins, int amount){
        if (amount == 0) {
            return 0;
        }

        int[] save = new int[amount+1];
        Arrays.fill(save, amount+1);
        Arrays.sort(coins);
        save[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < save.length; j++) {
                save[j] = Math.min(save[j], save[j-coins[i]]+1);
            }
        }
        return save[save.length-1] == amount+1 ? -1 : save[save.length-1];
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{186,419,83,408}, 6249));
        //System.out.println(coinChange(new int[]{1,2,5,10}, 18));{2,4,5,6,8,10,12,14,15,16,18}
    }
}

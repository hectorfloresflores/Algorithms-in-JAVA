package com.leetcode;

public class KConcatenationMaximumSum {

    public int kConcatenationMaxSum(int[] arr, int k) {

        if (arr.length < 2) {
            if (arr[0] < 0) {
                return 0;
            } else {
                return arr[0];
            }
        }

        long lastSolution = 0;
        long max = 0;
        long res = 0;
        lastSolution = 0;
        long sumMax = 0;
        long sumi = 0;
        for (int index = 0; index < arr.length; ++index) {
            long l = Math.max(arr[index], arr[index]+lastSolution);
            max = Math.max(l,max);
            lastSolution = l;
            sumi += arr[index];

            sumMax = Math.max(sumi,sumMax);





        }

        res = max;
        if(k>1 && sumMax>0){
            if(sumi>0){
                res = Math.max(res, lastSolution+(k-2)*sumi+sumMax);
            }else{
                res =Math.max(res,lastSolution+sumMax);
            }
        }
        return (int) (res%(Math.pow(10,9)+7));
    }

    public static void main(String[] args) {
        KConcatenationMaximumSum k = new KConcatenationMaximumSum();

        System.out.println(k.kConcatenationMaxSum(new int[]{-5,4,-4,-3,5,-3},3));

    }
}


package com.leetcode;

public class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {

        //From 0 to 999 will be negatives -1000 to -1
        //From 1000 to 2000 will be positives 0 to 1000
        boolean[] arrBool = new boolean[2001];
        int multiplyBy2, divideBy2;
        for (int i = 0; i < arr.length; i++) {
            divideBy2 = (arr[i] / 2) + 1000;
            if ((arr[i] + 1000) % 2 == 0 &&
                    (divideBy2 >= 0 && divideBy2 <= 2000)) {

                if (arrBool[divideBy2]) {
                    return true;
                }

            }
            multiplyBy2 = (arr[i] * 2) + 1000;
            if (multiplyBy2 >= 0 && multiplyBy2 <= 2000) {


                if (arrBool[multiplyBy2]) {
                    return true;
                }

            }

            if (!arrBool[arr[i] + 1000]) {
                arrBool[arr[i] + 1000] = true;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        CheckIfNandItsDoubleExist c = new CheckIfNandItsDoubleExist();
        System.out.println(c.checkIfExist(new int[]{7,1,14,11}));
    }
}

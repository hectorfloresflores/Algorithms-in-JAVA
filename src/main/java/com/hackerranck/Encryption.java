package com.hackerranck;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Encryption {
    public static String encryption(String s) {
        // Write your code here
        char[] array = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        //String[] gg2 = gg3.split("");
        int squareRoot = (int) Math.ceil(Math.sqrt(array.length));
       // StringBuilder stringBuilder = new StringBuilder();



        for (int i = 0, multipler, count = 0, j = 0; count < array.length; j++, count++) {
            //If it is multile of 4
            if (j == (squareRoot - 1)) {
                j = 0;
                i++;
                stringBuilder.append(" ");

            }
            multipler = j * squareRoot;
            if ((multipler + i) < array.length) {


            stringBuilder.append(array[multipler + i]);
            }
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(Encryption.encryption("chillout"));
    }
}

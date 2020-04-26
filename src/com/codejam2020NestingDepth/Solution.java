package com.codejam2020NestingDepth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{
    public static void addNtime(LinkedList<Character> list, Character c,int n, int index){
        while(n > 0){
            list.add(index,c);
            n--;
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = input.nextInt();

        input.nextLine();

        for (int i = 0; i < testCases; i++) {

            String g = input.nextLine();

            char[] charArray = g.toCharArray();

            LinkedList<Character> list = new LinkedList<>();

            int nParenth = 0;
            int index = 0;
            int getNum = 0;
            for (char c : charArray){
                getNum = (c - 48);
                if (getNum > nParenth){
                    addNtime(list,Character.valueOf('('),getNum - nParenth,index);
                    index = getNum - nParenth;

                    list.add(index,c);
                    index++;
                    addNtime(list,Character.valueOf(')'),getNum - nParenth,index);
                    nParenth = getNum;

                }else if (getNum < nParenth){

                }else{

                }


            }
            System.out.println();
            //System.out.println("Case #"+i+": ");
        }




    }
}

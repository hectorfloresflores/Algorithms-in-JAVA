package com.hackerranck;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ItemsAndContainers {

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        System.out.println(s);
        // Write your code here
        //lets do it without efficiency because of the time :)
        //because both indices list has to have same size
        List<Integer> myList = new LinkedList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            int start = startIndices.get(i);
            int end = endIndices.get(i);
            myList.add(getNumberOfProducts(s.substring(start-1, end)));
        }
        return myList;
    }

    static int getNumberOfProducts(String s) {
        //lets remove leading astericks from left and right
        int left = s.indexOf("|");
        int right = s.lastIndexOf("|");
        String sub = s.substring(left, right+1);
        String checkString = s.substring(left, right+1).replace("|", "");
        if (checkString.isEmpty()) {
            return 0;
        }
        return checkString.length();
    }

    public static void main(String[] args) {
        System.out.println(ItemsAndContainers.numberOfItems("**", Arrays.asList(1), Arrays.asList(2)));
    }
}

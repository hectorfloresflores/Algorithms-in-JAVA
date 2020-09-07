package com.leetcode;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {

        char[] patternArray = pattern.toCharArray();
        String[] strArray = str.split(" ");

        if (patternArray.length != strArray.length)
            return false;
        boolean[] letters = new boolean[26];


        HashMap<String, Character> map = new HashMap<>();

        for (int i = 0; i < patternArray.length; i++) {
            if (!map.containsKey(strArray[i])) {
                if (!letters[patternArray[i]-97]) {
                    map.put(strArray[i], patternArray[i]);
                    letters[patternArray[i]-97] = true;
                } else {
                    return false;
                }
            } else if (!(map.get(strArray[i]).equals(patternArray[i]))){
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {

        WordPattern w = new WordPattern();
        System.out.println(w.wordPattern("ab", "cat dog"));

    }
}

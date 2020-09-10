package com.leetcode;

import java.util.HashMap;

public class NumberofMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String letter : S.split("")) {
            if (!map.containsKey(letter)){
                map.put(letter, 1);
            } else {
                map.put(letter, map.get(letter) + 1);
            }
        }
        int counter = 0;

        outerLoop:
        for (String word : words) {
            int sCounter = 0, wordCounter = 0;
            while (sCounter < S.length()
            && wordCounter < word.length()) {
              if (word.charAt(wordCounter) == S.charAt(sCounter)) {
                  wordCounter++;
                  sCounter++;
              } else {
                  sCounter++;
              }
            }

            if (wordCounter == (word.length()))
            counter++;


        }

        return counter;
    }
}

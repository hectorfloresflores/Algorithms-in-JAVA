package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        HashMap<Integer, Integer> equivalent = new HashMap<>();
        equivalent.put(2, 3);
        equivalent.put(3, 3);
        equivalent.put(4, 3);
        equivalent.put(5, 3);
        equivalent.put(6, 3);
        equivalent.put(8, 3);
        equivalent.put(7, 4);
        equivalent.put(9, 4);
        HashMap<Integer, String> mapping = new HashMap<>();
        mapping.put(2, "abc");
        mapping.put(3, "def");
        mapping.put(4, "ghi");
        mapping.put(5, "jkl");
        mapping.put(6, "mno");
        mapping.put(8, "tuv");
        mapping.put(7, "pqrs");
        mapping.put(9, "wxyz");
        String[] array = digits.split("");
        int n = array.length;
        int[] powers = new int[n];
        int pow = 1;
        int[] dividedPowers = new int[n];
        int inc = 0;
        for (String digit : digits.split("")) {
            pow *= equivalent.get(Integer.parseInt(digit));
            powers[inc] = pow;
            inc++;
        }

        for (int i = 0; i < n; i++) {
            dividedPowers[i] = pow/powers[i];
        }
        List<StringBuilder> combinations = new ArrayList<>(pow);

        for (int j = 0; j < n; j++) {
            String word = mapping.get(Character.getNumericValue(digits.charAt(j)));
            for (int i = 0, reach = dividedPowers[j], incremental = 1, index = 0; i < pow; i++){
                if (combinations.size() < (i + 1)) {
                    combinations.add(new StringBuilder());
                }
                combinations.get(i).append(word.charAt(index));
                if (reach == incremental) {
                    incremental = 1;
                    if (index == (word.length() - 1)) {
                        index = 0;
                    } else {
                        index++;
                    }
                    continue;
                }
                incremental++;
            }
        }
        return combinations.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        l.letterCombinations("");
    }
}

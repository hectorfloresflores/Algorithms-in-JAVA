package com.leetcode;

//Given an array of strings, group anagrams together.
//
//        Example:
//
//        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Output:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        Note:
//
//        All inputs will be in lowercase.
//        The order of your output does not matter.

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> listWords = new LinkedList<>();

        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String str = new String(array);
            if (map.containsKey(str)) {
                    map.get(str).add(s);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(s);
                map.put(str,list);
            }
        }

        for (List list : map.values()) {
            listWords.add(list);
        }

        return listWords;
    }

    public static void main(String[] args) {
        GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

}

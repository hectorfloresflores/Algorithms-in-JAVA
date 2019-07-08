package com.leetcode.algorithms;


import java.util.Collection;
import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(a));
	}

	
	//My solution
	
	public static int longestSubString(String s) {

		Collection<String> myStrings = new HashSet<>();
		String stringArray[] = s.split("");
		int counter = 0, final_counter = 0, master_counter=0;

		if (s == null || s.length() == 0) {
			return 0;
		}

		for (int i = 0; i < stringArray.length;i++) {

			if (myStrings.contains(stringArray[i])) {
				
				master_counter++;
				i = master_counter;
				myStrings = new HashSet<>();
				myStrings.add(stringArray[i]);
				counter = 1;
			} else {
				myStrings.add(stringArray[i]);
				counter++;
			}
			if (final_counter < counter)final_counter = counter;
		}

		return final_counter;
	}
	
	//The best solution
	
	public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}

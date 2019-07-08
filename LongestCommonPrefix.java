package com.leetcode.algorithms;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/
public class LongestCommonPrefix {

	public static String function(String[] args) {
		
		if (args == null || args.length == 0) {
			return "";
		}else if (args.length == 1) {
			return args[0];
		}else if (args[0].length() == 0) {
			return "";
		}
		
		char[] array = args[0].toCharArray();
		int[] aux = new int[args[0].length()];

		
		for(int i = 1; i < args.length;i++) {
			
			char[] arraySet = args[i].toCharArray();
			int count = 0;
			
			while(arraySet.length-1 >= count && array.length-1 >= count) {
				

				if (array[count] == arraySet[count]) {
					aux[count] += 1;
 				}else {
 					break;
 				}
				count++;
			}
			
		}
		
		int count = args.length-1;
		
		String my = "";
		
		for(int i = 0; i < aux.length; i++) {
			
			if (aux[i] == count) {
				my += array[i];
			}else {
				
				break;
			}
			
		}
		
		
		
		
		return my;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//String[] g = {"flake","flood","flow"};
		String[] g1 = {"aa","aa"};
		System.out.println(LongestCommonPrefix.function(g1));

	}

}

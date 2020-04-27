package com.leetcode;

public class PalindromeString {
	
	public static boolean isPalindrome(String str) {
		
		String myString = str.toLowerCase().replaceAll("[ ,.:;]", "");
		
		StringBuilder sb = new StringBuilder(myString);
				
		return myString.equals(sb.reverse().toString());
	}

	public static void main(String[] args) {
		
	
		System.out.println(isPalindrome("abcvv ,dcba"));

	}

}

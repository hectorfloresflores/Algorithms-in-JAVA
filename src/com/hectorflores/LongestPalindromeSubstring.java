package com.hectorflores;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		
		int[][] a = {{1,2},{1}};
		
		System.out.println(a.length);
 
		//System.out.println(LongestPalindromeSubstring.function("aacbcaa"));

	}
	
	/*
	 * My solution 897 ms
	 * */

	public static String function(String s) {

		String longestSubstring = "", finalString = "", longestTwoSubstring = "";

		char chararray[] = s.toCharArray();

		int back = 0, forward = 0;

		boolean two_pivot = false;

		if (s.length() <= 1) {

			return s;

		} else if (s.length() <= 2) {

			if (chararray[0] == chararray[1]) {

				return s;

			}

		} else if(chararray.length <= 3){

			if (chararray[0] == chararray[1] && chararray[0] != chararray[2]) {

				return String.valueOf(chararray[0])+String.valueOf(chararray[1]);

			}

		}

		for (int i = 0; i < chararray.length; i++) {

			if (longestSubstring.length() < longestTwoSubstring.length()) {

				longestSubstring = longestTwoSubstring;

			}

			if (longestSubstring.length() > finalString.length()) {

				finalString = longestSubstring;

			}

			back = i;

			forward = i + 1;

			two_pivot = false;

			longestSubstring = String.valueOf(chararray[i]);

			longestTwoSubstring = String.valueOf(chararray[i]);

			if (back - 1 >= 0 && forward < chararray.length && chararray[back] == chararray[forward]) {

				two_pivot = true;

				longestTwoSubstring = longestTwoSubstring.concat(String.valueOf(chararray[forward]));

				forward++;

				back--;

				while (back >= 0 && forward < chararray.length && chararray[back] == chararray[forward]) {

					longestTwoSubstring = longestTwoSubstring.concat(String.valueOf(chararray[forward]));

					longestTwoSubstring = String.valueOf(chararray[back]).concat(longestTwoSubstring);

					forward++;

					back--;

				}

			}

			back = i;

			forward = i + 1;

			if (back - 1 >= 0 && forward < chararray.length
					&& (chararray[back] != chararray[forward] || two_pivot == true)) {

				back--;

				while (back >= 0 && forward < chararray.length && chararray[back] == chararray[forward]) {

					longestSubstring = longestSubstring.concat(String.valueOf(chararray[forward]));

					longestSubstring = String.valueOf(chararray[back]).concat(longestSubstring);

					forward++;

					back--;

				}

			}

		}

		return finalString;

	}
	

}

/*The best solution runtime 4ms */

class Solution {
    int maxlen=0, start=0;
    public String longestPalindrome(String s) {
        if(s==null || s.isEmpty()){
            return s;
        }
        char[] arr = s.toCharArray();
        int n = s.length();
        int pointer = 0;
        while(pointer < n){
            pointer = palindromeCheck(pointer, arr, n);
            pointer++;
        }
        
        return s.substring(start, start+maxlen);
        
        
    }
    
    public int palindromeCheck(int mid, char[] arr, int n){
        int left= mid-1;
        while(mid<n-1 && arr[mid]==arr[mid+1]) mid++;
        int right = mid+1;
        
        while(left>=0 && right<n && arr[left]==arr[right]){
            left--;
            right++;
        }
        
        int len = right-left-1;
        if(len>=maxlen){
            maxlen= len;
            start = left+1;
        }
        return mid;
    }
}

package com.hectorflores;

import java.lang.*;
import java.util.Arrays;

public class PalindromeNumber {

	public static boolean isPalindrome(int x) {

		String integ = Integer.toString(x);
		// Integer array[] =

		char number[] = integ.toCharArray();

		if (x < 0) {
			return false;
		} else if (x > 0 && x < 10) {

			return true;
		} else if (integ.length() % 2 == 0) {
			// x is even
			int j = (integ.length());
			for (int i = 0; i < (integ.length()) / 2; i++) {

				if (number[i] != number[j - 1]) {
					return false;
				}
				j--;
			}
		} else if (integ.length() % 2 != 0) {
			// x is odd
			int j = (integ.length());
			for (int i = 0; i < ((integ.length() - 1) / 2); i++) {

				if (number[i] != number[j - 1]) {
					return false;
				}
				j--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(PalindromeNumber.isPalindrome(1112111));
	}

}

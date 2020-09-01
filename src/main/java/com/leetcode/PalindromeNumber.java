package com.leetcode;

import java.lang.*;
import java.util.Collections;

public class PalindromeNumber {

	public static boolean isPalindrome(int x) {

		String integ = Integer.toString(x);

		char[] number = integ.toCharArray();

		if (x < 0) {
			return false;
		} else if (x < 10) {
			return true;
		} else {
			int oddOrEven = integ.length() % 2 == 0 ? 0 : 1;
			int ee = 5/2;
			// x is even
			int j = (integ.length());
			for (int i = 0; i <= integ.length() / 2; i++) {

				if (number[i] != number[--j]) {
					return false;
				}

			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(PalindromeNumber.isPalindrome(126921));
	}

}

package com.leetcode;

import java.lang.Integer;
import java.util.Arrays;

public class ReverseBits {

	public static int reverseBits(int n) {

		String s = Integer.toBinaryString(n);
		int[] array = new int[32];

		for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
			array[j] = Character.getNumericValue(s.charAt(i));
		}

		return Integer.parseUnsignedInt(Arrays.toString(array).replaceAll("[ ,\\]\\[]", ""), 2);

	}

	public static void main(String[] args) {
System.out.println(ReverseBits.reverseBits(-3));
	}

}

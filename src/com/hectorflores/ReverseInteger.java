package com.hectorflores;

import java.lang.Math;


public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%d", reverse(0)));
	}

	static public int reverse(int x) {
		long value = x;
		double result = 0;
		String myString = new String();

		if(value == 0)return 0;
		if (value < 0)
			value *= -1;
		while (value != 0) {

			myString += Long.toString(value % 10);
			value /= 10;
		}

		result = Double.parseDouble((myString));

		if (x < 0) {
			result *= -1;
		}

		if (result >= Integer.MAX_VALUE-1 || result <= Integer.MIN_VALUE || result == 0) {
			return 0;
		}
		

		return (int) result;
	}

}


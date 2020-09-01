package com.leetcode;

public class Numberof1Bits {

	 public static int numberof1Bits(int n) {
	 
		 if (n == 0) {
			return 0;
		}
		 return Integer.toBinaryString(n).replaceAll("[0]", "").split("").length;
		 
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Numberof1Bits.numberof1Bits(4));
	}

}

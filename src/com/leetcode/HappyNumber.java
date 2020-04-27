package com.leetcode;

public class HappyNumber {

	public static boolean isHappy(int n) {
		char[] array ;
		
		while(true) {
			
		array =  String.valueOf(n).toCharArray();
		n = 0;
		for (int i = 0; i < array.length; i++) {
			int h = array[i]-48;
			n += (array[i]-48)*(array[i]-48);
		}
			
			
		if (n == 1 ) {
			
			return true;
		}else if (n == 89) {
			return false;
		}
		
			
		}
		
		
	}
	
	

	public static void main(String[] args) {
		System.out.println(isHappy(98594772));

	}

}

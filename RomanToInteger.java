package com.leetcode.algorithms;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(romantointeger("MMMCMXCIX"));
	}
	
	public static int romantointeger(String s) {
		int result = 0;
		
		
		for (int i = s.length(); i > 0; i--) {
			int before=0;
			int after = getInteger(s.substring(i-1));
			if (i!=1) {
				 before = getInteger(s.substring(i-2));
			}
			if (after > before) {
				result += after - before;
				i--;
			}else {
				result += after;
			}
	
			
		}
		
		
		return result;
	}
	
	public static int getInteger(String c) {
		
		int entero = 0;
			switch (c.charAt(0)) {
			
			case 'M':
				entero = 1000;
				break;
			case 'D':
				entero = 500;			
				break;
			case 'C':
				entero = 100;
				break;
			case 'L':
				entero = 50;
				break;
			case 'X':
				entero = 10;
				break;
			case 'V':
				entero = 5;
				break;
			case 'I':
				entero = 1;
				break;
		
			default:
				break;
			}
			
			return entero;
	}

}

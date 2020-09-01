package com.leetcode;

public class StringDivideString {

	public static String gcdOfStrings(String str1, String str2) {
        
		int result = str1.indexOf(str2);
		int result1 = str2.indexOf(str1);
		char[] charMax;
		char[] charMin;
		if (result != 0 && result1 != 0) {
			return "";
		}else if (result1 == 0) {
			
			charMax = str2.toCharArray();
			charMin = str1.toCharArray();
			
		}else{
			
			charMax = str1.toCharArray();
			charMin = str2.toCharArray();
			
		}
		
		StringBuilder sb = new StringBuilder(String.valueOf(charMin));
		
		for (int i = charMin.length; i > 0; i--) {
			
			if (isMultiple(sb.toString().toCharArray(),charMax) && isMultiple(sb.toString().toCharArray(), charMin)) {
				return sb.toString();
			}
			sb.deleteCharAt(sb.length()-1);
			
			
		}
		
		
		return "";
    }

	private static boolean isMultiple(char[] charMin, char[] charMax) {
	
		double value = ((double)charMax.length / (double)charMin.length);
		value %= 1;
		if (value % 1 != 0) {
			return false;
		}
		
		for (int i = 0; i < charMax.length; i += charMin.length) {
			
			for (int j = i, k = 0; j <i+charMin.length; j++, k++) {
				
				if (charMax[j] != charMin[k]) {
					return false;
				}
				
			}
			
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
	
		//System.out.println(StringDivideString.isMultiple("ABC".toCharArray(), "ABC".toCharArray()));
	}

}

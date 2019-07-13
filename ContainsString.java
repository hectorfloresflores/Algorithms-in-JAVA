package com.hectorflores;

public class ContainsString {

	
	public static Boolean containsString(String word, String patter) {
		
		if (patter.length() > word.length()) {
			return false;
		}
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			char g = patter.charAt(0);
			
			if (c == g) {
				
				int var = 0;
				
				for (int j = i+1, k = 1; k < patter.length() && j < word.length(); j++,k++) {
					
					var = k;
					if (word.charAt(j) != patter.charAt(k)) {
						
						return false;
						
					}
				}
				
				if (var == patter.length()-1) {
					return true;
				}
				
			}
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ContainsString.containsString("hola", "lal"));
	}

}

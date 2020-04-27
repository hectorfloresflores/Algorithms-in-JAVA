package com.hectorflores;

import java.util.regex.Pattern;

public class ComplexNumberMultiplication {

	public static String complexNumberMultiply(String a, String b) {
		String auxA = a.replaceAll("i", "");
		String auxB = b.replaceAll("i", "");
		String[] array1 = auxA.split(Pattern.quote("+"));
		String[] array2 = auxB.split(Pattern.quote("+"));
		int real = Integer.parseInt(array1[0]);
		int real2 = Integer.parseInt(array2[0]);
		int imagine = Integer.parseInt(array1[1]);
		int imagine2 = Integer.parseInt(array2[1]);
		
		int val1 = real * real2;
		int val2 = imagine2 * real;
		int val3 = real2 * imagine;
		int val4 = imagine * imagine2;
		
		
		
		val1 += -1*(val4);
		val2 += val3; 
		
		return val1+"+"+val2+"i";
	}
	
	public static void main(String[] args) {
		
		System.out.println(complexNumberMultiply("78+-76i", "-86+72i"));
	
//		"78+-76i"
//		"-86+72i"
	}

}

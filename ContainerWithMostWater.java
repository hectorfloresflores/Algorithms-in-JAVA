package com.leetcode.algorithms;

import java.util.Scanner;

/*
 * 
 */

public class ContainerWithMostWater {

	public static int function(int[] myarray) {
		int maxValue = 0;
		for (int i = 0,j =myarray.length-1; i < j; ) {
			int aux = 0;
			if (myarray[j] < myarray[i]) {
				aux = myarray[j];
				aux = aux * (j - i );
				j--;
			}else {
				aux = myarray[i];
				aux = aux * (j - i );
				i++;
			}
			
			
			
			if (aux > maxValue) {
				maxValue = aux;
			}
		}
		
		return maxValue;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,8,6,2,5,4,8,3,7};
		boolean bol[][] = new boolean[8][3];
		Scanner sc = new Scanner(System.in);
		sc.next();
		
		String s = sc.next();
		if (s.charAt(0) > 47 && s.charAt(0) < 58) {
			
		}
		
		switch (s.charAt(0)) {
		case '^':
			
			break;

		default:
			break;
		}
	
		
		
		
		
		
		System.out.println(sc.next());
		System.out.println(9%2);
		System.out.println(ContainerWithMostWater.function(array));
		
		
		
	}

}

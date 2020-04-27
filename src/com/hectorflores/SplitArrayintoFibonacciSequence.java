package com.hectorflores;

import java.util.LinkedList;
import java.util.List;



public class SplitArrayintoFibonacciSequence {

	public static List<Integer> SplitArrayintoFibonacciSequence(String s){
		
		
		
		List<Integer> list;
		char[] array = s.toCharArray();
		int a=0,aPointer=0,b=0,bPointer=0,c=0,cPointer=0,start=0,fPointer=0;
		int sum = 0;
		while(true) {
			
			list = new LinkedList<>();
			
			/*Initialize pointers of a , b ,c*/
			aPointer = 0;
			bPointer = start + 1;
			cPointer = bPointer+1;
			
			
			/*Get values*/
			if (Long.parseLong(s.substring(bPointer, cPointer)) > Integer.MAX_VALUE || Long.parseLong(s.substring(aPointer, bPointer)) > Integer.MAX_VALUE) {
				return new LinkedList<>();
			}
			
			a = Integer.parseInt(s.substring(aPointer, bPointer));
			b = Integer.parseInt(s.substring(bPointer, cPointer));
			
			list.add(a);
			
			
			/*Set final Pointer*/
			fPointer = cPointer +  maxDigits(a, b);
					
			
			
			if (fPointer > array.length) {
				return new LinkedList<>();
			}
			
			c = Integer.parseInt(s.substring(cPointer, fPointer));
	
			while(true) {
				
				
				if (fPointer > array.length) {
					break;
				}
				
				
				if (Long.parseLong(s.substring(bPointer, cPointer)) > Integer.MAX_VALUE || Long.parseLong(s.substring(cPointer, fPointer)) > Integer.MAX_VALUE) {
					break;
				}
				b = Integer.parseInt(s.substring(bPointer, cPointer));
				//fPointer = cPointer +  maxDigits(a, b);
				
				c = Integer.parseInt(s.substring(cPointer, fPointer));
				
				if (String.valueOf(a).length() != (bPointer - aPointer) || String.valueOf(b).length() != (cPointer - bPointer)) {
					break;
				}
				sum = a + b;
				/*Id sum its equal to c means moving pointer to continue checking*/
				if (sum == c) {
					list.add(b);
					if (fPointer >= array.length) {
						list.add(c);
						//System.out.println("success");
						return list;
					}
					
					aPointer = bPointer;
					bPointer = cPointer;
					cPointer = fPointer;
					fPointer = cPointer+1;
					
					a = Integer.parseInt(s.substring(aPointer, bPointer));
					b = Integer.parseInt(s.substring(bPointer, cPointer));
					c = Integer.parseInt(s.substring(cPointer, fPointer));
					
					
				}/*If sum is greater than c means c*/
				else if (sum > c) {
					
					fPointer++;
					
				}/*If not break and start over incrementing start*/
				else {

						cPointer++;
						fPointer = cPointer +  maxDigits(a, b);
					
				}
				//System.out.println(cPointer);
			}
			
			/*Increment start because is the A pointer regulator*/
			start++;
			
		}
		
		
		
	}
	private static int maxDigits(int a, int b) {
		if (a == 0 && b == 0) {
			return 1;
		}
		int max;
		if (a < b) {
			max = b;
		}else {
			max = a;
		}
		int count = 0;
		while(max > 0) {
			max /= 10;
			count++;
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		SplitArrayintoFibonacciSequence("1320581321313221264343965566089105744171833277577").forEach(e -> {
			System.out.println(e);
		});

	}

}

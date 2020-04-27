package com.leetcode;


import java.util.LinkedList;
import java.util.List;

public class PermutationsOfString {

	public static List<List<Integer>> permutations(int[] s){
		
		if (s == null) {
			return null;
		}
		
		List<List<Integer>> mylist = new LinkedList<>();
		
		mylist.add(new LinkedList<Integer>());
		mylist.get(0).add(s[0]);
		
		for(int i = 1; i < s.length; i++) {
			
			int c = s[i];
			int position = 0;
			
			int myListSize = mylist.size();
			
			List<List<Integer>> listAux = new LinkedList<List<Integer>>(mylist);
			
			for(int j = 0; j < myListSize; j++) {
				
				
				for(int posChar = 0; posChar <= listAux.get(0).size(); posChar++) {
					
					List<Integer> listAux2 = new LinkedList<>(listAux.get(j));
					
					listAux2.add(posChar,c);
			
					mylist.add(position,(LinkedList<Integer>) listAux2);
					
					position++;
					
				}
				
				mylist.remove(mylist.size()-1);
				
			}
			
		}
		
		mylist.forEach(charList -> {
			
			charList.forEach(myChar -> {
				
				System.out.print(myChar);
				
			});
			System.out.println();
		});
		
		
		
		return mylist;
	}
	
	public static List<List<Integer>> permutationsFast(int[] s){
		
		if (s == null) {
			return null;
		}
		
		StringBuilder theString = new StringBuilder();
		
		List<List<Integer>> mylist = new LinkedList<>();
		
		mylist.add(new LinkedList<Integer>());
		mylist.get(0).add(s[0]);
		
		for(int i = 1; i < s.length; i++) {
			
			int c = s[i];
			int position = 0;
			
			int myListSize = mylist.size();
			
			List<List<Integer>> listAux = new LinkedList<List<Integer>>(mylist);
			
			for(int j = 0; j < myListSize; j++) {
				
				
				for(int posChar = 0; posChar <= listAux.get(0).size(); posChar++) {
					
					List<Integer> listAux2 = new LinkedList<>(listAux.get(j));
					
					listAux2.add(posChar,c);
			
					mylist.add(position,(LinkedList<Integer>) listAux2);
					
					position++;
					
				}
				
				mylist.remove(mylist.size()-1);
				
			}
			
		}
		
		mylist.forEach(charList -> {
			
			charList.forEach(myChar -> {
				
				System.out.print(myChar);
				
			});
			System.out.println();
		});
		
		
		
		return mylist;
	}
	
	public static void main(String[] args) {
		
		permutations(new int[] {1,2,3,4});
		

	}

}

package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


//Given a string of letters from a to z write a function that test if
//this string has state where a letter can not repetive more than one in secuence
//Eg. input : "aaabbacadf" Result = true, becasue "ababacadaf"

public class NoRepetitiveCharSecuence {

	
	public static boolean function(String str) {
		
		//Lets create the map wehere each character are going to have its frecuency
		HashMap<Character,Integer> map = new HashMap<>();
		
		//Variable to store the max frecuency of certain letter
		Integer maxFrecuency = 0;
		//Variable to store the letter of max frecuency
		Character maxFrecuencyLetter = ' ';
		
		//char array to iterate through the string
		char[] charArray = str.toCharArray();
		
		//Fill the map with the frecuecies
		for(char c : charArray) {
			
			if (!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				
				map.put(c, map.get(c)+1);
				
				if (maxFrecuency < map.get(c)) {
					maxFrecuency = map.get(c)+1;
					maxFrecuencyLetter = c;
				}
				
				
			}
			
		}
		
		int count = maxFrecuency;
		
		ArrayList<LinkedList<Character>> list = new ArrayList<>();
		
		//Create a list of list with the letter with max frecuency
		while(count > 0) {
			LinkedList<Character> linkList = new LinkedList<Character>();
			linkList.add(maxFrecuencyLetter);
			list.add(linkList);
			count--;
			
		}
		//Update map with updating with value zero all the maxFrecuencyletter
		map.put(maxFrecuencyLetter, 0);
		
		int countUp = 0;
		//Fill the list of list with the missing letters
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			
			count = entry.getValue();
			
			while(count > 0) {
				
				list.get(countUp).add(entry.getKey());
				
				count--;
				countUp++;
				
				if (countUp > maxFrecuency) {
					countUp = 0;
				}
			
			}
			
		}
		//Iterate throgh th elist of list to check if the condition stays
		char pastChar = ' ';
		for(int i = 0;i < list.size();i++) {
			
			for (int j = 0; j < list.get(i).size(); j++) {
				
				maxFrecuencyLetter = list.get(i).get(j);
				
				if (maxFrecuencyLetter == pastChar) {
					return false;
				}
				
				pastChar = maxFrecuencyLetter;
				
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NoRepetitiveCharSecuence.function("abbaahgaa"));
	}

}

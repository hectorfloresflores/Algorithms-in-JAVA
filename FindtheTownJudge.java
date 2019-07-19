package com.hectorflores;

public class FindtheTownJudge {

	public static int findtheTownJudge(int N, int[][] trust) {
		int memory = N+1;
		int length = N-1;
		//Create Array N+1 because will start in position 1
		int[] trustTo = new int[memory];
		int[] trustMe = new int[memory];
		
		for(int[] rel : trust) {
			
			trustTo[rel[0]]++;
			trustMe[rel[1]]++;
			
		}
		
		for(int i = 1; i < memory; i++) {
			
			if (trustTo[i] == 0 && trustMe[i] == length) {
				return i;
			}
			
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
			int[][] matrx = {{1,3},{2,3},{3,1}};
			System.out.println(findtheTownJudge(3, matrx));

	}

}

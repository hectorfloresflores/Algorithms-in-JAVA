package com.leetcode;

public class TrappingRainWater {

	public static int trap(int[] height) {
		int sumAux = 0;
		int totalSum = 0;
		int[] maxNumber = {0,0};
		
		for (int i = 0; i < height.length-1; i++) {
			
			for (int j = i+1; j < height.length; j++) {
				
				if (height[j] <= height[i]) {
					if (maxNumber[1] <= height[j]) {
						maxNumber[0] = j;
						maxNumber[1] = height[j];
					}
				}else {
					maxNumber[0] = j;
					maxNumber[1] = height[j];
					break;
				}
				
				
			}
			
			sumAux += (maxNumber[0]-(i+1))*Math.min(maxNumber[1], height[i]);
			
			for (int j = i+1; j < maxNumber[0]; j++) {
				sumAux -= height[j];
			}
			totalSum += sumAux;
			i = maxNumber[0]-1;
			maxNumber[0] = 0;
			maxNumber[1] = 0;
			sumAux = 0;
		}
		
		return totalSum;
	}
	


	public static void main(String[] args) {
		int[] array = {8,0,2,0,10};
		System.out.println(trap(array));
	}

}

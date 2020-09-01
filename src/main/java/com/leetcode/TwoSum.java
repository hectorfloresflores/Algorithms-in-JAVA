package com.leetcode;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myarray = {4,2,4,5,2};
		
		int[] a = twosum(myarray,7);
		System.out.println(a);
		
	}
	
	public static int[] twosum(int[] array, int value)
	{
		int a=0,b=1;
		int[] result = {0,0};
		int size =array.length;
	
		outerloop:
		while(a < (size-1))
		{
			while(b < size)
			{
				if((array[a] + array[b]) == value)
				{
					result[0] = a;
					result[1] = b;
					break outerloop;
					
				} else
				{
					b++;
				}
			}
			a++;
			b = a + 1;
		}
	
		return result;
	}

}


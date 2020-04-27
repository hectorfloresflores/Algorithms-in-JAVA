package com.leetcode;
/*Hi guys this is an implementation of printing a matrix in diagonal from right to left*/
/*
* Example this matrix {{1,2,3},{4,5,6},{7,8,9}}; will print in this order
* 1 
* 2 4 
* 3 5 7 
* 6 8 
* 9 
*/

public class PrintMatrixDiagonal {

	public static void function(int[][] matrix) {
		
		if (matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
			System.out.println("none");
			return;
		}
		/*First part of matrix*/
		for (int i = 0; i < matrix.length; i++) {
		
			int k = i;
			
			for (int j = 0; j <= i; j++) {
				
				System.out.print(matrix[j][k]+" ");
				k--;
				
			}
			
			System.out.println();
			
		}
		/*Second part of matrix*/
		for (int i = 0; i < matrix.length - 1; i++) {
			
			int k = i + 1;
			
			for (int j = matrix.length-1 ; j > i; j--) {
				
				System.out.print(matrix[k][j]+" ");
				k++;
				
			}
			
			System.out.println();
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] matrix4 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix3 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2},{3,4}};
        int[][] matrix1 = {{1}};
        int[][] matrixEmpty= {};
        int[][] matrixEmpty1= {{}};
        PrintMatrixDiagonal.function(matrix2);
	}

}

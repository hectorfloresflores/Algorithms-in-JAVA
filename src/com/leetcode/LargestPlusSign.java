package com.leetcode;



public class LargestPlusSign {

	public static int orderOfLargestPlusSign(int N, int[][] mines) {

		int[][] matrix = new int[N][N];

		for (int[] array : mines) {
			if (array.length != 2) {
				break;
			}
			matrix[array[0]][array[1]] = 1;
		}

		int maxOrder = 0;
		int aux = 0;
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix.length; j++) {
				aux = getMaxZeros(matrix, i, j);
				if (aux > maxOrder) {
					maxOrder = aux;
				}

			}

		}

		return maxOrder;
	}

	public static int getMaxZeros(int[][] matrix, int i, int j) {
		int order = 0;
		int[] pointerLeft = { i, j };
		int[] pointerUp = { i, j };
		int[] pointerRight = { i, j };
		int[] pointerDown = { i, j };
		if (matrix[i][j] != 0) {
			return order;
		} else {
			order++;

			while (true) {
				pointerLeft[1] = pointerLeft[1] - 1;
				pointerUp[0] = pointerUp[0] - 1;
				pointerRight[1] = pointerRight[1] + 1;
				pointerDown[0] = pointerDown[0] + 1;
				if ((pointerLeft[1] >= 0 && pointerLeft[1] < matrix.length && matrix[i][pointerLeft[1]] == 0)
						&& (pointerUp[0] >= 0 && pointerUp[0] < matrix.length && matrix[pointerUp[0]][j] == 0)
						&& (pointerRight[1] >= 0 && pointerRight[1] < matrix.length && matrix[i][pointerRight[1]] == 0)
						&& (pointerDown[0] >= 0 && pointerDown[0] < matrix.length && matrix[pointerDown[0]][j] == 0)) {

					order++;

				} else {
					break;
				}

			}

		}

		return order;

	}

	public static void main(String[] args) {
		int[][] matrix = { {} };
		System.out.println(orderOfLargestPlusSign(2, matrix));

	}

}

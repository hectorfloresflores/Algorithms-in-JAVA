package com.hectorflores;

public class Fibonacci {

	public static int fibonacii(int N) {
		if (N == 0) {
			return 0;
		}
		int a = 0;
		int b = 1;
		int sum = 1;
		
		for (int i = 1; i < N; i++) {
			sum = a + b;
			a = b;
			b = sum;
			
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
	
		System.out.println(Fibonacci.fibonacii(0));
		System.out.println(Fibonacci.fibonacii(1));
		System.out.println(Fibonacci.fibonacii(2));
		System.out.println(Fibonacci.fibonacii(3));
		System.out.println(Fibonacci.fibonacii(4));
	}

}

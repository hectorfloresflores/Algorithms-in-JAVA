package com.hectorflores;

public class Series {

	public static int nSum(int n) {
		int resultado = 0;
		for (int i = 0; i < n; i++) {
			resultado = resultado + i;
			System.out.println(resultado);
		}
		return resultado;
	}

	public static long factorial(int n) {
		long resultado = 1;

		for (int i = 0; i < n; i++) {

			resultado = resultado * i;
			System.out.println(resultado);
			if (i == 0) {
				resultado = 1;
			}
		}

		return resultado;
	}
	
	public static long fibonnaci(int n) {
		long a=0,b=1;
		long resultado = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(resultado);
			resultado = a+b;
			a = b;
			b = resultado;
			
			
		}
		return resultado;
	}

}

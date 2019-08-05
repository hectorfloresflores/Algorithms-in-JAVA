package com.hectorflores;

import java.util.Map.Entry;

import jdk.jfr.Experimental;

import java.util.TreeMap;
import java.util.TreeSet;

class Expression {

	private boolean sign;
	private double Coefficient;
	private String variable;

	public Expression(boolean sign, double coefficient, String variable) {

		this.sign = sign;
		Coefficient = coefficient;
		this.variable = variable;
	}

	public boolean isSign() {
		return sign;
	}

	public void setSign(boolean sign) {
		this.sign = sign;
	}

	public double getCoefficient() {
		return Coefficient;
	}

	public void setCoefficient(double coefficient) {
		Coefficient = coefficient;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public static Expression multiply(Expression a, Expression b) {
		
		boolean sign = !(a.sign ^ b.sign);
		double coefficient = a.Coefficient * b.Coefficient;
		String variable = multiplyVariable(a.variable, b.variable);
		
		Expression expre = new Expression(sign, coefficient, variable);
		
		return expre;
	}
	
//	public static Expression sum(Expression a, Expression b) {
//		
//		
//		
//	}

	public static String multiplyVariable(String a, String b) {
		TreeMap<String, Integer> tree = new TreeMap<>();

		String[] aArray = a.split("\\*");
		String[] bArray = b.split("\\*");

		for (String s : aArray) {

			if (!tree.containsKey(s)) {
				tree.put(s, 1);
			} else {
				tree.put(s, tree.get(s) + 1);
			}

		}

		for (String s : bArray) {

			if (!tree.containsKey(s)) {
				tree.put(s, 1);
			} else {
				tree.put(s, tree.get(s) + 1);
			}

		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Entry<String, Integer> entry : tree.entrySet()) {
			
			for (int i = 0; i < entry.getValue(); i++) {
				sb.append(entry.getKey() + "*");
			}
			
		}

		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}

public class BasicCalculatorIV {

	public static String evaluate(String expression, String[] evalvars, int[] evalints) {
		String s = new String(expression);

		for (int i = 0; i < evalints.length; i++) {
			s = s.replace(evalvars[i], String.valueOf(evalints[i]));
		}

		return s;
	}

	public static void main(String[] args) {
//		String s = "a*b*c*d*e";
//		String[] strings = { "a", "e" };
//		int[] values = { 5, 4 };
//		String g = evaluate(s, strings, values);
//		TreeMap<String, Integer> tree = new TreeMap<>();
//		tree.put("a*a*b*b", 1);
//		tree.put("a*a*c*c", 1);
//		tree.put("a*b*c*c", 1);
//		tree.put("a*a*b*c", 1);

		System.out.println(Expression.multiplyVariable("a*b*c", "4*a*b*c"));
	}

}

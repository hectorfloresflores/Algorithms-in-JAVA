package com.leetcode;

import java.util.Stack;

public class ValidParenthesesString {

	public static boolean checkValidString(String s) {

		Stack<Character> myStack = new Stack<>();

		return recusriveAsterisk(myStack, s);
	}

	public static boolean recusriveAsterisk(Stack<Character> stack,
											String subString) {


		for (int c = 0; c < subString.length(); c++) {

			if (subString.charAt(c) == ')' && stack.empty()) {
				return false;
			}

			if (subString.charAt(c) == '(') {
				stack.push(subString.charAt(c));
			} else if (subString.charAt(c) == ')') {
				if (stack.pop() != '(') {
					return false;
				}
			} else {
				boolean one =recusriveAsterisk((Stack<Character>) stack.clone(),
						subString.substring(c+1));
				if (one) return true;
				boolean two = recusriveAsterisk((Stack<Character>) stack.clone(),
						"(" + subString.substring(c+1));
				if (two) return true;
				boolean three =recusriveAsterisk((Stack<Character>) stack.clone(),
						")" + subString.substring(c+1));
				return three;
			}

		}

		return stack.empty();





	}

	public static boolean checkValidString1(String s) {
		int lo = 0, hi = 0;
		for (char c: s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0) break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}

	public static void main(String[] args) {
		System.out.println(checkValidString1("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

	}

}

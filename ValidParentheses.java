package com.hectorflores;

import java.util.Stack;

public class ValidParentheses {

	public static boolean validParenthesis(String s) {
		Stack<Character> myStack = new Stack<>();
		char value;
		for (int i = 0; i < s.length(); i++) {
			value = s.charAt(i);
			
			
			if (value == '(' || value == '{' || value == '[') {
				myStack.push(value);
			}else if((value == ')' || value == '}' || value == ']') && myStack.isEmpty() == false){
				
				switch (value) {
				case ')':
					if (myStack.pop() != '(') {
						return false;
					}
					break;
				case '}':
					if (myStack.pop() != '{') {
						return false;
					}
					break;
				case ']':
					if (myStack.pop() != '[') {
						return false;
					}
					break;

				default:
					break;
				}
				
			}else {
				return false;
			}
		
		}
		
		if (!myStack.isEmpty()) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(validParenthesis("(){}"));

	}

}

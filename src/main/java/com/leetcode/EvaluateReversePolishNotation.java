package com.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            //Means it is number
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            }
            //Special case when it is the first time to apply the aritmetic
            else {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(applyOperation(token, b, a));
            }
        }
        return stack.pop();
    }

    int applyOperation(String operator, int a, int result) {
        switch (operator) {
            case "/" :
                return (a/result);
            case "*" :
                return a*result;
            case "-" :
                return a-result;
            case "+" :
                return a+result;
        }
        return 0;
    }

    public static void main(String[] args) {

        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(new String[]{"4","13","5","/","+"}));

    }
}

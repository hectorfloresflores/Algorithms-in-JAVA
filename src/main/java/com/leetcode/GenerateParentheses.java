package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    List<String> listOfBalancedParenthesis = new LinkedList<>();
    //As my understanding I have to find all the possible conbinations of balanced parenthesis
    public List<String> generateParenthesis(int n) {
        recursiveCall("", n, n);
        return listOfBalancedParenthesis;
    }

    void recursiveCall(String temporalString, int parenthesisLeft, int parenthesisRight) {

        if (parenthesisLeft == 0 && parenthesisRight == 0) {
            listOfBalancedParenthesis.add(temporalString);
            return;
        }

        if (parenthesisLeft > 0) {

            recursiveCall(temporalString + "(", parenthesisLeft-1, parenthesisRight);
        }
        if (parenthesisRight > parenthesisLeft) {

            recursiveCall(temporalString + ")", parenthesisLeft, parenthesisRight-1);
        }

    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        g.generateParenthesis(3);
    }
}

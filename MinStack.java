package com.hectorflores;

//Min Stack
//        Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.
//
//
//        Example 1:
//
//        Input
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]
//
//        Output
//        [null,null,null,null,-3,null,0,-2]
//
//        Explanation
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin(); // return -3
//        minStack.pop();
//        minStack.top();    // return 0
//        minStack.getMin(); // return -2
//
//
//        Constraints:
//
//        Methods pop, top and getMin operations will always be called on non-empty stacks.
//        Hide Hint #1
//        Consider each node in the stack having a minimum value. (Credits to @aakarshmadhavan)

import java.util.Stack;

public class MinStack {

    private MinStack before;
    private MinStack top;
    private int minvalue;
    private int value;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (top == null) {
            MinStack newNode = new MinStack();
            newNode.value = x;
            newNode.minvalue = x;
            this.top = newNode;
        } else {
            MinStack newNode = new MinStack();
            newNode.value = x;
            newNode.minvalue = Math.min(this.top.minvalue, x);
            newNode.before = this.top;
            this.top = newNode;
        }


    }

    public void pop() {

        this.top = this.top.before;

    }

    public int top() {
        return this.top.value;
    }

    public int getMin() {
        return this.top.minvalue;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);

        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}

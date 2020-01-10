package com.appdevelapp.challenges.gfg;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(41);
        stack.push(3);
        stack.push(32);
        stack.push(2);
        stack.push(11);

        Stack<Integer> auxStack = new Stack<>();
        while (!stack.isEmpty()){
            int top = stack.pop();
            if(auxStack.isEmpty()){
                auxStack.push(top);
                continue;
            }

            if(top <= auxStack.peek()){
                auxStack.push(top);
                continue;
            }

            while (!auxStack.isEmpty() && auxStack.peek() <= top){
                stack.push(auxStack.pop());
            }

            auxStack.push(top);
        }

        while (!auxStack.isEmpty()){
            stack.push(auxStack.pop());
        }

        System.out.println("Results");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

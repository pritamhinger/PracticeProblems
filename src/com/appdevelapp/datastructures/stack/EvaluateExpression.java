package com.appdevelapp.datastructures.stack;

public class EvaluateExpression {
    public static int evaluatePostFix(String expression) throws Exception {
        Stack<Integer> stack = new Stack<>(expression.length());
        Integer second;
        Integer first;
        for (int i = 0; i < expression.length(); i++) {
            Character ch = expression.charAt(i);
            switch (ch) {
                case '+':
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first + second);
                    break;
                case '-':
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                case '*':
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first * second);
                    break;
                case '/':
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(ch.toString()));
            }
        }

        return stack.top();
    }

    public static boolean isBalanced(String exp) throws Exception {
        Stack<Character> stack = new Stack<>(exp.length());

        for (Character ch : exp.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character value = stack.pop();
                if (ch == '}' && value != '{') {
                    return false;
                } else if (ch == ']' && value != '[') {
                    return false;
                } else if (ch == ')' && value != '(') {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}

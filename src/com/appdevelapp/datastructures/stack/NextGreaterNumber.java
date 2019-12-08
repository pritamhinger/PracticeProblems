package com.appdevelapp.datastructures.stack;

public class NextGreaterNumber {

    public static int[] nextGreaterElement(int[] arr) throws Exception {
        int[] result = new int[arr.length];
        Stack<Integer> stack= new Stack<>(arr.length);
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(!stack.isEmpty()){
                while (!stack.isEmpty() && stack.top()<= arr[i]){
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = stack.top();
            }

            stack.push(arr[i]);
        }
        return result;
    }

}

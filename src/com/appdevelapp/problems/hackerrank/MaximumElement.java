package com.appdevelapp.problems.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] inputs = new String[N];
        ArrayList<Long> output = new ArrayList<Long>();
        MaxStack stack = new MaxStack(N);

        for(int i=0; i < N; i++){
            String[] values = scanner.nextLine().split(" ");
            int queryType = Integer.parseInt(values[0]);
            if(values.length == 2){
                long value = Long.parseLong(values[1]);
                if(queryType == 1){
                    stack.push(value);
                }
                continue;
            }

            if(queryType == 2){
                stack.pop();
            }
            else if(queryType == 3){
                output.add(stack.getMaxTop());
            }
        }

        for(Long res: output){
            System.out.println(res);
        }
    }
}

class MaxStack{
    long[] array;
    long[] maxValues;
    int top;

    public MaxStack(int size){
        array = new long[size];
        top = -1;
        maxValues = new long[size];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return (top == array.length-1);
    }

    public void push(long value){
        long maxValue = value;
        if(!isEmpty()){
            maxValue = maxValues[top];
        }

        if(value > maxValue){
            maxValue = value;
        }

        array[++top] = value;
        maxValues[top] = maxValue;
    }

    public long pop(){
        if(!isEmpty()){
            return array[top--];
        }

        return Long.MIN_VALUE;
    }

    public long getTop(){
        if(!isEmpty()){
            return array[top];
        }

        return Long.MIN_VALUE;
    }

    public long getMaxTop(){
        if(!isEmpty()){
            return maxValues[top];
        }

        return Long.MIN_VALUE;
    }
}

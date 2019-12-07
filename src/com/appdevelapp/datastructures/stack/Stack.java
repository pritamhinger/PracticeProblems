package com.appdevelapp.datastructures.stack;

import com.appdevelapp.datastructures.queue.Queue;

import javax.management.StandardEmitterMBean;

public class Stack<T> {
    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    private int top;
    private int maxSize;
    private T array[];

    public  Stack(int maxSize){
        this.maxSize = maxSize;
        this.top  = -1;
        this.array = (T[])new Object[maxSize];
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public T top(){
        if(isEmpty()){
            return null;
        }

        return array[top];
    }

    public void push(T value) throws Exception{
        if(isFull()){
            throw new Exception("Stack is full");
        }

        array[++top] = value;
    }

    public T pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }

        return array[top--];
    }

    public int getCapacity(){
        return maxSize;
    }

    public static void sortStack(Stack<Integer> stack) throws Exception {
        if(stack.isEmpty()){
            return;
        }

        Stack<Integer> tempStack = new Stack<>(stack.getCapacity());
        tempStack.push(stack.pop());

        while(!stack.isEmpty()){
            Integer value = stack.pop();
            while (!tempStack.isEmpty() && value <= tempStack.top()){
                stack.push(tempStack.pop());
            }

            tempStack.push(value);
        }

        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }
}

package com.appdevelapp.datastructures.stack;

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

    public void Push(T value) throws Exception{
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


}

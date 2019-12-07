package com.appdevelapp.datastructures.stack;

public class TwoStackUsingArray<T> {
    private int maxSize;
    private T array[];

    public TwoStackUsingArray(int maxSize) {
        this.maxSize = maxSize;
        array = (T[]) new Object[maxSize];
        top1 = -1;
        top2 = maxSize;
    }

    private int top1;
    private int top2;

    public boolean isEmpty() {
        return (top1 < top2 - 1);
    }

    public boolean isFull() {
        return (top1 == top2 - 1);
    }

    //insert at top of first stack
    public void push1(T value) {
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }

        array[++top1] = value;
    }

    //insert at top of second stack
    public void push2(T value) {
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }

        array[--top2] = value;
    }

    //remove and return value from top of first stack
    public T pop1() {
        if(top1 == -1){
            return null;
        }

        return array[top1--];
    }

    //remove and return value from top of second stack
    public T pop2() {
        if(top2 == -1){
            return null;
        }

        return array[top2++];
    }
}

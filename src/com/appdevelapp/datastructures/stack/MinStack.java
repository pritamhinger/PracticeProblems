package com.appdevelapp.datastructures.stack;

public class MinStack {
    int maxSize;
    int[] array;
    int[] minArray;
    int top;

    //constructor
    public MinStack(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.minArray = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize -1);
    }

    //removes and returns value from stack
    public Integer pop(){
        if(!isEmpty()){
            return array[top--];
        }
        return Integer.MIN_VALUE;
    }

    //pushes value into the stack
    public void push(Integer value){
        // Write -- Your -- Code
        if(isFull()){
            return;
        }

        int index = top+1;
        array[index] = value;
        if(top == -1){
            minArray[index] = value;
        }
        else{
            if(value < minArray[top]){
                minArray[index] = value;
            }
            else{
                minArray[index] = minArray[top];
            }
        }

        top++;
    }
    //returns minimum value in O(1)
    public int min(){
        if(!isEmpty()){
            return minArray[top];
        }
        return Integer.MIN_VALUE;
    }
}

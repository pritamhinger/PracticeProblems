package com.appdevelapp.datastructures.queue;

import com.appdevelapp.datastructures.stack.Stack;

public class QueueUsingStack<V> {

    private int maxSize;
    private Stack<V> stack1;
    private Stack<V> stack2;

    public QueueUsingStack(int maxSize){
        this.maxSize = maxSize;
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }

    public void enqueue(V value) throws Exception {
        if(stack1.isFull()){
            return;
        }

        stack1.push(value);
    }

    public V dequeue() throws Exception {
        if(this.isEmpty()){
            return  null;
        }

        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public boolean isEmpty(){
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}

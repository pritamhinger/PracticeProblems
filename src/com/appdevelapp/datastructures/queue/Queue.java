package com.appdevelapp.datastructures.queue;

public class Queue<T> {
    private int maxSize;
    private int currentSize;
    private int front;
    private int back;
    private T array[];

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        array = (T[]) new Object[maxSize];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean isFull() {
        return (this.currentSize == this.maxSize);
    }

    public T top() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }

        return array[front];
    }

    public void enqueue(T value) throws Exception {
        if (isFull()) {
            throw new Exception("Queue is full");
        }

        back = (back+1)%maxSize;
        currentSize++;
        array[back] = value;
    }

    public T dequeue() throws  Exception{
        if(isEmpty()){
            throw  new Exception("Queue is empty");
        }

        T value = array[front];
        front = (front+1)%maxSize;
        currentSize--;
        return value;
    }
}

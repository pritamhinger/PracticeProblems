package com.appdevelapp.datastructures.linkedlist;

public class DLLNode<T> {
    public T data;
    public DLLNode<T> nextNode;
    public DLLNode<T> prevNode;

    public DLLNode(T data){
        this.data = data;
        this.nextNode = null;
        this.prevNode = null;
    }
}

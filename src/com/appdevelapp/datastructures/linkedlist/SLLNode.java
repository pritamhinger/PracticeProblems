package com.appdevelapp.datastructures.linkedlist;

public class SLLNode<T> {
    public  T data;
    public  SLLNode nextNode;

    public SLLNode(T data){
        this.data = data;
        this.nextNode = null;
    }
}

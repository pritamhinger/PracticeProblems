package com.appdevelapp.datastructures.linkedlist;

public class SinglyLinkedList<T> {
    public SLLNode<T> Head;
    public int size;

    public SinglyLinkedList(){
        Head = null;
        size = 0;
    }

    public boolean IsEmpty(){
        return (size == 0);
    }
}

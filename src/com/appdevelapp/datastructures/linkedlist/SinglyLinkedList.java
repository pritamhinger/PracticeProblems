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

    public void PrintList(){
        if(IsEmpty()){
            System.out.println("List is empty.");
            return;
        }

        SLLNode tempNode = Head;
        while(tempNode != null){
            System.out.print(tempNode.data.toString() + " --> ");
            tempNode = tempNode.nextNode;
        }
        System.out.println("NULL");
    }
}

package com.appdevelapp.datastructures.linkedlist;

import javax.net.ssl.SSLContext;

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

    public void InsertAtStart(T data){
        SLLNode newNode = new SLLNode(data);

        newNode.nextNode = Head;
        Head = newNode;
        size++;
    }

    public void InsertAtEnd(T data) {
        if(IsEmpty()){
            InsertAtStart(data);
            return;
        }

        SLLNode newNode = new SLLNode(data);
        SLLNode temp = Head;
        while(temp.nextNode != null){
            temp = temp.nextNode;
        }

        temp.nextNode = newNode;
        size++;
    }

    public void InsertAfter(T data, T referenceValue){
        SLLNode newNode = new SLLNode(data);
        SLLNode tempNode = this.Head;

        while(tempNode != null && tempNode.data != referenceValue){
            tempNode = tempNode.nextNode;
        }

        if(tempNode != null){
            newNode.nextNode = tempNode.nextNode;
            tempNode.nextNode = newNode;
            size++;
        }
    }

    public boolean searchNode(T data) {
        SLLNode tempNode = this.Head;
        while(tempNode != null && tempNode.data != data){
            tempNode = tempNode.nextNode;
        }

        if(tempNode != null){
            return true;
        }

        return false;
    }

    public void DeleteAtHead(){
        if(IsEmpty()){
            return;
        }

        Head = Head.nextNode;
        size--;
        return;
    }

    public void DeleteByVale(T data){
        if(IsEmpty()){
            return;
        }

        if(Head.data == data){
            Head = Head.nextNode;
            size--;
            return;
        }

        SLLNode tempNode = Head;
        SLLNode currentNode = Head;
        while(currentNode != null){
            if(currentNode.data == data){
                tempNode.nextNode = currentNode.nextNode;
                size--;
                return;
            }

            tempNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }
}

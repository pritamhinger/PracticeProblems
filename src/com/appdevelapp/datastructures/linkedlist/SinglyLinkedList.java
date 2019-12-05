package com.appdevelapp.datastructures.linkedlist;

public class SinglyLinkedList<T> {
    public SLLNode<T> headNode;
    public int size;

    public SinglyLinkedList(){
        headNode = null;
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

        SLLNode tempNode = headNode;
        while(tempNode != null){
            System.out.print(tempNode.data.toString() + " --> ");
            tempNode = tempNode.nextNode;
        }
        System.out.println("NULL");
    }

    public void InsertAtStart(T data){
        SLLNode newNode = new SLLNode(data);

        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    public void InsertAtEnd(T data) {
        if(IsEmpty()){
            InsertAtStart(data);
            return;
        }

        SLLNode newNode = new SLLNode(data);
        SLLNode temp = headNode;
        while(temp.nextNode != null){
            temp = temp.nextNode;
        }

        temp.nextNode = newNode;
        size++;
    }

    public void InsertAfter(T data, T referenceValue){
        SLLNode newNode = new SLLNode(data);
        SLLNode tempNode = this.headNode;

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
        SLLNode tempNode = this.headNode;
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

        headNode = headNode.nextNode;
        size--;
        return;
    }

    public void DeleteByVale(T data){
        if(IsEmpty()){
            return;
        }

        if(headNode.data == data){
            headNode = headNode.nextNode;
            size--;
            return;
        }

        SLLNode tempNode = headNode;
        SLLNode currentNode = headNode;
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

    public <T> void reverse(SinglyLinkedList<T> list){
        if(list.IsEmpty()){
            return;
        }

        SLLNode prevNode = null;
        SLLNode currentNode = headNode;
        while(currentNode != null){
            SLLNode tempNode = currentNode;
            currentNode = currentNode.nextNode;
            tempNode.nextNode = prevNode;
            prevNode = tempNode;
        }

        headNode = prevNode;
    }

    public SLLNode reverseRecursively(SLLNode node){
        if(node == null){
            return null;
        }

        if(node.nextNode == null){
            return node;
        }

        SLLNode newHead = reverseRecursively(node.nextNode);
        node.nextNode.nextNode = node;
        node.nextNode = null;
        return newHead;
    }
}

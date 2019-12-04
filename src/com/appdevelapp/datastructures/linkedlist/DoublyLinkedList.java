package com.appdevelapp.datastructures.linkedlist;

public class DoublyLinkedList<T> {
    private DLLNode<T> headNode;
    private DLLNode<T> tailNode;
    private int size;

    public DoublyLinkedList(){
        headNode = null;
        tailNode = null;
        size = 0;
    }

    public int Size(){
        return size;
    }

    public boolean IsEmpty(){
        return size == 0;
    }

    public DLLNode GetHeadNode(){
        return  headNode;
    }

    public void PrintList(){
        if(IsEmpty()){
            System.out.print("List : NULL");
            return;
        }

        DLLNode tempNode = this.GetHeadNode();
        System.out.print("List : NULL =>");
        while(tempNode != null){
            System.out.print(tempNode.data.toString() + " <==>" );
            tempNode = tempNode.nextNode;
        }

        System.out.println("NULL");
    }

    public void InsertAtHead(T data){
        DLLNode newNode = new DLLNode(data);
        if(IsEmpty()){
            headNode = newNode;
            tailNode = newNode;
            size++;
            return;
        }

        newNode.nextNode = headNode;
        headNode.prevNode = newNode;
        headNode = newNode;
        size++;
    }

    public void InsertAtEnd(T data){
        DLLNode newNode = new DLLNode(data);
        if(IsEmpty()){
            InsertAtHead(data);
            return;
        }

        newNode.prevNode = tailNode;
        tailNode.nextNode = newNode;
        tailNode = newNode;
        size++;
    }

    public void DeleteAtHead(){
        if(IsEmpty()){
            return;
        }

        headNode = headNode.nextNode;
        if(headNode == null){
            tailNode = null;
        }
        else{
            headNode.prevNode = null;
        }

        size--;
    }

    public void DeleteAtTail(){
        if(IsEmpty()){
            return;
        }

        tailNode = tailNode.prevNode;
        if(tailNode == null){
            headNode = null;
        }
        else{
            tailNode.nextNode = null;
        }

        size--;
    }
}

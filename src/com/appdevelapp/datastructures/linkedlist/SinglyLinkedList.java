package com.appdevelapp.datastructures.linkedlist;

import java.util.HashSet;

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

    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        SLLNode slowPtr = list.headNode;
        SLLNode fastPtr = list.headNode;
        while(slowPtr != null && fastPtr != null && fastPtr.nextNode != null) {

            fastPtr = fastPtr.nextNode.nextNode;
            slowPtr = slowPtr.nextNode;

            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        if(list.IsEmpty()){
            return null;
        }

        SLLNode slow = list.headNode;
        SLLNode fast = list.headNode;

        while (slow != null && fast != null && fast.nextNode!= null){
            fast = fast.nextNode.nextNode;
            if(fast != null){
                slow = slow.nextNode;
            }
        }

        return  slow.data;
    }

    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        if(list.IsEmpty()){
            return;
        }

        HashSet<T> set = new HashSet<>();
        SLLNode<T> current = list.headNode;
        SLLNode<T> previous = null;
        while(current != null){
            if(!set.contains(current.data)){
                set.add(current.data);
                previous = current;
                current = current.nextNode;
            }
            else{
                previous.nextNode = current.nextNode;
                current.nextNode = null;
                current = previous.nextNode;
                list.size--;
            }
        }
    }

    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        if(list1.IsEmpty()){
            SinglyLinkedList.removeDuplicates(list2);
            return list2;
        }

        if(list2.IsEmpty()){
            SinglyLinkedList.removeDuplicates(list1);
            return list1;
        }

        SLLNode<T> current = list1.headNode;
        while(current.nextNode != null){
            current = current.nextNode;
        }

        current.nextNode = list2.headNode;
        removeDuplicates(list1);
        return list1;
    }

//    public void removeDuplicatesWithHashing() {
//        SLLNode<T> current = this.headNode;
//        SLLNode<T> prevNode = this.headNode;
//        //will store all the elements that we observe once
//        HashSet<T> visitedNodes = new HashSet<T>();
//
//        if (!IsEmpty() && current.nextNode != null) {
//            while (current != null) {
//                //check if already visited then delete this node
//                if (visitedNodes.contains(current.data)) {
//                    //deleting the node by undating the pointer of previous node
//                    prevNode.nextNode = current.nextNode;
//                    current = current.nextNode;
//                } else {
//                    //if node was not already visited then add it to the visited set
//                    visitedNodes.add(current.data);
//                    //moving on to next element in the list
//                    prevNode = current;
//                    current = current.nextNode;
//                }
//            }
//        }
//    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        if(list1.IsEmpty() || list2.IsEmpty()){
            return result;
        }

        java.util.HashSet<T> set = new java.util.HashSet<>();
        SLLNode<T> current = list1.headNode;
        while(current != null){
            set.add(current.data);
            current = current.nextNode;
        }

        current = list2.headNode;
        while(current != null){
            if(set.contains(current.data)){
                result.InsertAtEnd(current.data);
            }

            current = current.nextNode;
        }

        return result;
    }

    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        if(list.size < n){
            throw new IndexOutOfBoundsException();
        }

        SLLNode tempNode = list.headNode;
        int count = 0;
        while (tempNode != null && count < n){
            tempNode = tempNode.nextNode;
            count++;
        }

        SLLNode trackingNode = list.headNode;
        while (tempNode != null){
            tempNode = tempNode.nextNode;
            trackingNode = trackingNode.nextNode;
        }


        return trackingNode.data;
    }
}

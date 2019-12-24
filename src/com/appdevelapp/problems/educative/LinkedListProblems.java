package com.appdevelapp.problems.educative;

import com.appdevelapp.datastructures.linkedlist.SLLNode;
import org.omg.PortableInterceptor.INACTIVE;

public class LinkedListProblems {

    public static SLLNode<Integer> reverse_list(SLLNode<Integer> head) {
        SLLNode<Integer> reversed_list = head;
        SLLNode<Integer> previousNode = null;
        while (reversed_list != null) {
            SLLNode<Integer> tempNode = reversed_list;
            reversed_list = reversed_list.nextNode;
            tempNode.nextNode = previousNode;
            previousNode = tempNode;
        }

        reversed_list = previousNode;
        return reversed_list;
    }

    public static SLLNode<Integer> reverse_list_recursive(SLLNode<Integer> head) {
        if (head == null || head.nextNode == null) {
            return head;
        }

        SLLNode<Integer> reverseHead = reverse_list_recursive(head.nextNode);
        head.nextNode.nextNode = head;
        head.nextNode = null;
        return reverseHead;
    }

    public static SLLNode<Integer> delete_node(SLLNode<Integer> head, int key) {
        if (head == null) {
            return null;
        }

        SLLNode<Integer> prevNode = null;
        SLLNode<Integer> curNode = head;
        while (curNode != null) {
            if (curNode.data != key) {
                prevNode = curNode;
            } else {
                if (prevNode != null) {
                    prevNode.nextNode = curNode.nextNode;
                } else {
                    head = head.nextNode;
                }
            }

            curNode = curNode.nextNode;
        }

        return head;
    }

    public static SLLNode<Integer> insertion_sort(SLLNode<Integer> head) {
        SLLNode<Integer> newHeadNode = null;
        SLLNode<Integer> currentNode = head;
        while (currentNode!= null){
            SLLNode<Integer> tempNode = currentNode.nextNode;
            newHeadNode = SortedInsert(newHeadNode, currentNode);
            currentNode = tempNode;
        }

        return newHeadNode;
    }

    private static SLLNode SortedInsert(SLLNode<Integer> head, SLLNode<Integer> node){
        if(node == null){
            return head;
        }

        if (head == null || node.data <= head.data){
            node.nextNode = head;
            return node;
        }

        SLLNode<Integer> tempNode = head;
        while (tempNode.nextNode != null && (int)tempNode.nextNode.data <= node.data){
            tempNode = tempNode.nextNode;
        }

        node.nextNode = tempNode.nextNode;
        tempNode.nextNode = node;
        return head;
    }
}



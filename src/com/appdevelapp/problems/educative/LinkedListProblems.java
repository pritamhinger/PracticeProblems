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

    public static SLLNode<Integer> merge_sorted(SLLNode<Integer> head1,SLLNode<Integer> head2) {
        //TODO: Write - Your - Code
        SLLNode<Integer> newHead = null;
        SLLNode<Integer> tempNode = null;
        SLLNode<Integer> curNode = null;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                tempNode = head1;
                head1 = head1.nextNode;
            }
            else{
                tempNode = head2;
                head2 = head2.nextNode;
            }

            tempNode.nextNode = null;

            if(newHead == null){
                newHead = tempNode;
                curNode = tempNode;
            }
            else{
                curNode.nextNode = tempNode;
                curNode = curNode.nextNode;
            }
        }

        if(head1 != null){
            curNode.nextNode = head1;
        }

        if(head2 != null){
            curNode.nextNode = head2;
        }

        return newHead;
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

    static SLLNode<Integer> swap_nth_node(SLLNode<Integer> head, int n) {

        if(head == null){
            return null;
        }

        if(head.nextNode == null){
            return head;
        }

        SLLNode<Integer> curNode = head;
        SLLNode<Integer> prevNode = null;
        for(int i = 1; i < n && curNode != null; i++){
            prevNode = curNode;
            curNode = curNode.nextNode;
        }

        SLLNode<Integer> newHead = head.nextNode;
        prevNode.nextNode = head;
        head.nextNode = curNode;
        prevNode = prevNode.nextNode;
        prevNode.nextNode = curNode.nextNode;
        curNode.nextNode = newHead;
        return curNode;
    }

    public static SLLNode<Integer> merge_sort(SLLNode<Integer> head) {

        if(head == null){
            return head;
        }

        if(head.nextNode == null){
            return head;
        }
        // Find Middle Node
        SLLNode<Integer> middleNode = GetMiddleNode(head);
        SLLNode<Integer> secondListHead = middleNode.nextNode;
        middleNode.nextNode = null;
        head = merge_sort(head);
        secondListHead = merge_sort(secondListHead);
        SLLNode<Integer> newhead = merge_sorted(head, secondListHead);
        // Sort Both Halves Recursively
        // Merge Sorted Halves.
        return newhead;
    }

    private static SLLNode<Integer> GetMiddleNode(SLLNode<Integer> head){
        if(head == null){
            return null;
        }

        SLLNode<Integer> slowPtr = head;
        SLLNode<Integer> fastPtr = head;
        while (fastPtr.nextNode != null){
            fastPtr = fastPtr.nextNode;
            if(fastPtr.nextNode != null){
                fastPtr = fastPtr.nextNode;
                slowPtr = slowPtr.nextNode;
            }
        }

        return slowPtr;
    }

    public static SLLNode<Integer> reverse_even_nodes(SLLNode<Integer> head) {
        if(head == null){
            return null;
        }

        SLLNode<Integer> evenHead = null;
        SLLNode<Integer> curNode = head;
        while (curNode != null && curNode.nextNode != null){
            SLLNode<Integer> tempNode = curNode.nextNode;
            curNode.nextNode = tempNode.nextNode;
            tempNode.nextNode = evenHead;
            evenHead = tempNode;
            curNode = curNode.nextNode;
        }

        curNode = head;
        SLLNode<Integer> evenCurNode = evenHead;
        SLLNode<Integer> previousNode = null;
        while (curNode != null && evenCurNode != null){
            SLLNode<Integer> tempNode = curNode.nextNode;
            curNode.nextNode = evenCurNode;
            curNode = curNode.nextNode;
            evenCurNode = evenCurNode.nextNode;
            curNode.nextNode = tempNode;
            previousNode = curNode;
            curNode = curNode.nextNode;
        }

        if(curNode != null){
            previousNode.nextNode = curNode;
        }

        return head;
    }

    public static SLLNode<Integer> rotate_list(SLLNode<Integer> head, int n) {
        //TODO: Write - Your - Code
        int length = 0;
        SLLNode<Integer> tempNode = head;
        while(tempNode != null){
            length++;
            tempNode = tempNode.nextNode;
        }

        if(length == 0){
            return null;
        }

        n = n% length;
        if(n < 0){
            n = n + length;
        }

        int moveLength = length - n;
        tempNode = head;
        while(moveLength > 1){
            moveLength--;
            tempNode = tempNode.nextNode;
        }

        SLLNode<Integer> newHead = tempNode.nextNode;
        tempNode.nextNode = null;

        SLLNode<Integer> curNode = newHead;
        while(curNode.nextNode != null){
            curNode = curNode.nextNode;
        }

        curNode.nextNode = head;
        head = newHead;
        return head;
    }

    static SLLNode<Integer> reverse_k_nodes(SLLNode<Integer> head, int k) {

        if(k == 1){
            return head;
        }

        int length = 0;
        SLLNode<Integer> tempNode = head;
        while(tempNode != null){
            length++;
            tempNode = tempNode.nextNode;
        }

        SLLNode<Integer> previousNode = null;
        tempNode = head;
        SLLNode<Integer> newHead = null;
        SLLNode<Integer> currentTailNode = null;
        for (int i = 0; i < length; i = i+k) {
            SLLNode<Integer> currentHead = tempNode;
            int j=0;
            while ((j < k && tempNode != null)){
                previousNode = tempNode;
                tempNode = tempNode.nextNode;
                j++;
            }

            previousNode.nextNode = null;
            if(newHead == null){
                newHead = reverse_list(currentHead);
                currentTailNode = getTailNode(newHead);
            }
            else{
                currentHead = reverse_list(currentHead);
                currentTailNode.nextNode = currentHead;
                currentTailNode = getTailNode(currentHead);
            }
        }

        return newHead;
    }

    private static SLLNode<Integer> getTailNode(SLLNode<Integer> head){
        SLLNode<Integer> tempNode = head;
        while(tempNode.nextNode != null){
            tempNode = tempNode.nextNode;
        }

        return tempNode;
    }

}



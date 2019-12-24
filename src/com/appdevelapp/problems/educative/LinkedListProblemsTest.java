package com.appdevelapp.problems.educative;

import com.appdevelapp.datastructures.linkedlist.SLLNode;
import com.appdevelapp.datastructures.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProblemsTest {

    SinglyLinkedList<Integer> list;
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
        list.InsertAtStart(1);
        list.InsertAtStart(1);
        list.InsertAtStart(2);
        list.InsertAtStart(3);
        list.InsertAtStart(4);
        list.InsertAtStart(4);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverse_list() {
        SLLNode<Integer> newHead = LinkedListProblems.reverse_list(list.headNode);
        Assert.that(newHead.data == 1, "Failed");
    }

    @Test
    void reverse_list_recursive() {
        list.PrintList();
        SLLNode<Integer> newHead = LinkedListProblems.reverse_list_recursive(list.headNode);
        list.headNode = newHead;
        list.PrintList();
        Assert.that(newHead.data == 1, "Failed");
    }

    @Test
    void delete_node() {
        list.PrintList();
        list.headNode = LinkedListProblems.delete_node(list.headNode, 5);
        list.PrintList();
        list.headNode = LinkedListProblems.delete_node(list.headNode, 4);
        list.PrintList();
        list.headNode = LinkedListProblems.delete_node(list.headNode, 1);
        list.PrintList();
        list.headNode = LinkedListProblems.delete_node(list.headNode, 1);
        list.PrintList();
    }

    @Test
    void insertion_sort() {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.InsertAtStart(0);
        list1.InsertAtStart(9);
        list1.InsertAtStart(4);
        list1.InsertAtStart(5);
        list1.InsertAtStart(1);
        list1.InsertAtStart(3);
        list1.PrintList();

        list1.headNode = LinkedListProblems.insertion_sort(list1.headNode);
        list1.PrintList();


    }

    @Test
    void swap_nth_node() {
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.InsertAtStart(5);
        list2.InsertAtStart(4);
        list2.InsertAtStart(3);
        list2.InsertAtStart(2);
        list2.InsertAtStart(1);
        list2.PrintList();
        list2.headNode = LinkedListProblems.swap_nth_node(list2.headNode, 3);
        list2.PrintList();;


    }

    @Test
    void merge_sort() {
        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
        list3.InsertAtStart(29);
        list3.InsertAtStart(23);
        list3.InsertAtStart(82);
        list3.InsertAtStart(11);
        list3.InsertAtStart(4);
        list3.InsertAtStart(3);
        list3.InsertAtStart(21);

        list3.PrintList();
        list3.headNode = LinkedListProblems.merge_sort(list3.headNode);
        list3.PrintList();

    }
}
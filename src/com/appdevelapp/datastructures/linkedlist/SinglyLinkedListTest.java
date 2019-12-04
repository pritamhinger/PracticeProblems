package com.appdevelapp.datastructures.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    SinglyLinkedList<Integer> linkedList;
    @BeforeEach
    void setUp() {
        linkedList = new SinglyLinkedList<Integer>();
        linkedList.InsertAtStart(3);
        linkedList.InsertAtStart(2);
        linkedList.InsertAtStart(1);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void isEmpty() {
        Assert.that(linkedList.size == 3, "Failed");
    }

    @Test
    void printList() {
        linkedList.PrintList();
        Assert.that(!linkedList.IsEmpty(), "Failed");
    }

    @Test
    void insertAtStart() {
        Assert.that(linkedList.size == 3,"Failed");
        linkedList.InsertAtStart(4);
        linkedList.PrintList();
        Assert.that(linkedList.Head.data == 4, "Failed");
    }

    @Test
    void insertAtEnd() {
        Assert.that(linkedList.size == 3, "Failed");
        linkedList.InsertAtEnd(4);
        linkedList.PrintList();
        Assert.that(linkedList.size == 4, "Failed");
    }

    @Test
    void insertAfter() {
        Assert.that(linkedList.size == 3, "Failed");
        linkedList.InsertAfter(4,3);
        linkedList.PrintList();
        Assert.that(linkedList.size == 4, "Failed");

        linkedList.InsertAfter(5,5);
        Assert.that(linkedList.size == 4    , "Failed");
        linkedList.InsertAfter(5,1);
        linkedList.PrintList();
        Assert.that(linkedList.size == 5, "Failed");
    }

    @Test
    void searchNode() {
        Assert.that(linkedList.searchNode(1),"Failed");
        Assert.that(!linkedList.searchNode(4), "Failed");
        linkedList.InsertAtEnd(4);
        Assert.that(linkedList.searchNode(4), "Failed");
    }
}
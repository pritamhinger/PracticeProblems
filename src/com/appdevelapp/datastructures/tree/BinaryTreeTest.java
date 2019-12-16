package com.appdevelapp.datastructures.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree tree;

    BinaryTree bst;
    @BeforeEach
    void setUp() {
        tree = new BinaryTree();

        bst = new BinaryTree();
        bst.add(6);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(12);
        bst.add(8);
        bst.add(5);
        bst.add(10);
        bst.add(14);
        bst.add(2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        tree.add(6);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(12);
        tree.add(8);
        tree.add(5);
        tree.add(10);
        tree.add(14);
        tree.add(2);
        System.out.println("Iterative Version");
        tree.printTree(tree.getRoot());
        System.out.println();
        tree.printTreeInOrder(tree.getRoot());
    }

    @Test
    void addRecursively() {
        tree.setRoot(tree.addRecursively(tree.getRoot(),6));
        tree.setRoot(tree.addRecursively(tree.getRoot(),4));
        tree.setRoot(tree.addRecursively(tree.getRoot(),9));
        tree.setRoot(tree.addRecursively(tree.getRoot(),2));
        tree.setRoot(tree.addRecursively(tree.getRoot(),12));
        tree.setRoot(tree.addRecursively(tree.getRoot(),8));
        tree.setRoot(tree.addRecursively(tree.getRoot(),5));
        tree.setRoot(tree.addRecursively(tree.getRoot(),10));
        tree.setRoot(tree.addRecursively(tree.getRoot(),14));
        tree.setRoot(tree.addRecursively(tree.getRoot(),2));
        System.out.println("Recursive Version");
        tree.printTree(tree.getRoot());
        System.out.println();
        tree.printTreeInOrder(tree.getRoot());
    }

    @Test
    void searchIteratively() {
        Assert.that(bst.searchIteratively(4) != null, "Failed");
        Assert.that(bst.searchIteratively(7) == null, "Failed");
    }

    @Test
    void seachRecursively() {
        Assert.that(bst.searchIteratively(4) != null, "Failed");
        Assert.that(bst.searchIteratively(7) == null, "Failed");
        bst.add(7);
        Assert.that(bst.searchIteratively(7) != null, "Failed");
    }
}
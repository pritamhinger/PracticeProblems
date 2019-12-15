package com.appdevelapp.datastructures.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree tree;
    @BeforeEach
    void setUp() {
        tree = new BinaryTree();
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
        tree.printTree(tree.getRoot());
        System.out.println();
        tree.printTreeInOrder(tree.getRoot());
    }
}
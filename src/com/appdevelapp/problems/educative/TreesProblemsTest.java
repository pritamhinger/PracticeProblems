package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreesProblemsTest {

    BinaryTreeNode root = null;
    @BeforeEach
    void setUp() {
        root = new BinaryTreeNode(6);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(9);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(8);
        root.right.right = new BinaryTreeNode(12);
        root.right.right.left = new BinaryTreeNode(10);
        root.right.right.right = new BinaryTreeNode(14);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void inOrderTravesal() throws Exception {
        TreesProblems.inOrderTravesal(root);
    }

    @Test
    void display_tree_perimeter() throws Exception {
        TreesProblems.display_tree_perimeter(root);
    }
}
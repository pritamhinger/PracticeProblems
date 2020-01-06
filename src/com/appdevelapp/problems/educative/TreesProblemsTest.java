package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class TreesProblemsTest {

    BinaryTreeNode root = null;
    ObjectOutputStream stream;
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
    void inOrderTraversal() throws Exception {
        TreesProblems.inOrderTraversal(root);
    }

    @Test
    void display_tree_perimeter() throws Exception {
        TreesProblems.display_tree_perimeter(root);
    }

    @Test
    void populate_sibling_pointers() throws Exception {
        TreesProblems.populate_sibling_pointers(root);
    }

    @Test
    void serializeDeserialize() throws Exception {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        stream = new ObjectOutputStream(byteOutputStream);
        TreesProblems.serialize(root, stream);
        stream.close();

        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteInputStream);
        BinaryTreeNode node = TreesProblems.deserialize(inputStream);
        TreesProblems.inOrderTraversal(root);
        System.out.println();
        TreesProblems.inOrderTraversal(node);
    }
}
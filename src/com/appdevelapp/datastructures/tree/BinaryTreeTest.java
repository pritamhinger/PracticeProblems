package com.appdevelapp.datastructures.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

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
        //bst.add(2);
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
        tree.inOrderTraversal(tree.getRoot());
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
        tree.inOrderTraversal(tree.getRoot());
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

    @Test
    void delete() {
        Assert.that(bst.delete(bst.getRoot(),7) == false, "Failed");
        bst.printTree(bst.getRoot());
        System.out.println();
        Assert.that(bst.delete(bst.getRoot(),6), "Failed");
        bst.printTree(bst.getRoot());
        System.out.println();
        bst.inOrderTraversal(bst.getRoot());
    }

    @Test
    void preOrderTraversal() {
        bst.preOrderTraversal(bst.getRoot());
        System.out.println();
        bst.postOrderTraversal(bst.getRoot());
        System.out.println();
        bst.inOrderTraversal(bst.getRoot());
        Assert.that(bst.getRoot().getData() == 6, "Failed");
    }

    @Test
    void postOrderTraversal() {
        bst.postOrderTraversal(bst.getRoot());
        Assert.that(bst.getRoot().getData() == 6, "Failed");
    }

    @Test
    void inOrderTraversal() {
        bst.inOrderTraversal(bst.getRoot());
        Assert.that(bst.getRoot().getData() == 6, "Failed");
    }

    @Test
    void findMinRecursive() {
        Assert.that(BinaryTree.findMin(bst.getRoot()) == 2, "Failed");
        bst.add(1);
        Assert.that(BinaryTree.findMin(bst.getRoot()) == 1, "Failed");
    }

    @Test
    void findMin() {
        Assert.that(BinaryTree.findMin(bst.getRoot()) == 2, "Failed");
        bst.add(1);
        Assert.that(BinaryTree.findMin(bst.getRoot()) == 1, "Failed");
        bst.add(0);
        Assert.that(BinaryTree.findMin(bst.getRoot()) == 0, "Failed");
    }

    @Test
    void findKthMax() {
        int value = BinaryTree.findKthMax(bst.getRoot(), 3);
        System.out.println(value);
        Assert.that(value == 10, "Failed");
        value = BinaryTree.findKthMax(bst.getRoot(), 1);
        System.out.println(value);
        Assert.that(value == 14, "Failed");
        value = BinaryTree.findKthMax(bst.getRoot(), 5);
        System.out.println(value);
        Assert.that(value == 8, "Failed");
    }

    @Test
    void findAncestors() {
        String ancestors = BinaryTree.findAncestors(bst.getRoot(), 10);
        System.out.println(ancestors);
        Assert.that( ancestors.equals("6,9,12,"), "FailedR");

        ancestors = BinaryTree.findAncestors(bst.getRoot(), 8);
        System.out.println(ancestors);
        Assert.that( ancestors.equals("6,9,"), "FailedR");

        ancestors = BinaryTree.findAncestors(bst.getRoot(), 5);
        System.out.println(ancestors);
        Assert.that( ancestors.equals("6,4,"), "FailedR");

        ancestors = BinaryTree.findAncestors(bst.getRoot(), 7);
        System.out.println(ancestors);
        Assert.that( ancestors.equals(""), "FailedR");

        bst.add(7);
        ancestors = BinaryTree.findAncestors(bst.getRoot(), 7);
        System.out.println(ancestors);
        Assert.that( ancestors.equals("6,9,8,"), "FailedR");
    }

    @Test
    void findHeight() {
        inOrderTraversal();
        System.out.println();
        int height = BinaryTree.findHeight(bst.getRoot());
        System.out.println(height);
        Assert.that( --height == 3, "Failed");
    }

    @Test
    void findKNodes() throws Exception {
        Assert.that(BinaryTree.findKNodes(bst.getRoot(),1).equals("4,9,"), "Failed");
        Assert.that(BinaryTree.findKNodes(bst.getRoot(),2).equals("2,5,8,12,"), "Failed");
        Assert.that(BinaryTree.findKNodes(bst.getRoot(),3).equals("10,14,"), "Failed");
    }

    @Test
    void inOrderIteratively() throws Exception {
        bst.inOrderTraversal(bst.getRoot());
        bst.inOrderIteratively();
    }

    @Test
    void levelOrderTraversal() throws Exception {
        int levelCount = bst.LevelOrderTraversal(bst.getRoot());
        Assert.that(levelCount == 4, "Failed");
    }
}
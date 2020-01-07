package com.appdevelapp.problems.educative;

import com.appdevelapp.datastructures.queue.Queue;
import com.appdevelapp.datastructures.stack.Stack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TreesProblems {
    public static void inOrderTraversal(BinaryTreeNode root) throws Exception {
        BinaryTreeInorderIterator iterator = new BinaryTreeInorderIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.getNext().data + ",");
        }
    }

    public static void display_tree_perimeter(BinaryTreeNode root) throws Exception {
        if (root != null) {
            PrintLeftEdge(root);

            if (root.left != null || root.right != null) {
                PrintAllLeafNodes(root);
            }

            PrintRightEdge(root);
        }
    }

    public static void populate_sibling_pointers(BinaryTreeNode root) throws Exception {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            root.sibling = null;
            return;
        }

        Queue<BinaryTreeNode> queue = new Queue<>(100);
        queue.enqueue(root);
        queue.enqueue(null);
        BinaryTreeNode previousNode = null;
        while (!queue.isEmpty()) {
            BinaryTreeNode curNode = queue.dequeue();
            if (previousNode != null) {
                previousNode.sibling = curNode;
                System.out.print("Setting Sibling of " + previousNode.data);
                if (curNode != null) {
                    System.out.println(" to " + curNode.data);
                } else {
                    System.out.println(" to NULL");
                }
            }

            previousNode = curNode;
            if (curNode == null) {
                if (!queue.isEmpty()) {
                    queue.enqueue(null);
                }
                continue;
            }

            if (curNode.left != null) {
                queue.enqueue(curNode.left);
            }

            if (curNode.right != null) {
                queue.enqueue(curNode.right);
            }
        }
    }

    private static final int MARKER = Integer.MIN_VALUE;

    public static void serialize(BinaryTreeNode node, ObjectOutputStream stream) throws java.io.IOException {
        if(node == null){
            stream.writeInt(MARKER);
            return;
        }

        stream.writeInt(node.data);
        serialize(node.left, stream);
        serialize(node.right, stream);
    }

    public static BinaryTreeNode deserialize(ObjectInputStream stream) throws java.io.IOException {
        //TODO: Write - Your - Code
        int value = stream.readInt();
        if(value == MARKER){
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(value);
        node.left = deserialize(stream);
        node.right = deserialize(stream);
        return node;
    }

    private static void PrintLeftEdge(BinaryTreeNode root) {
        while (root != null) {
            int value = root.data;
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                break;
            }

            System.out.print(value + " --> ");
        }
    }

    private static void PrintAllLeafNodes(BinaryTreeNode root) throws Exception {
        Queue<BinaryTreeNode> queue = new Queue<>(100);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode curNode = queue.dequeue();
            if (curNode.left != null) {
                queue.enqueue(curNode.left);
            }

            if (curNode.right != null) {
                queue.enqueue(curNode.right);
            }

            if (curNode.left == null && curNode.right == null) {
                System.out.print(curNode.data + " --> ");
            }
        }
    }

    private static void PrintRightEdge(BinaryTreeNode root) throws Exception {
        Stack<Integer> stack = new Stack<>(100);
        while (root != null) {
            int value = root.data;
            if (root.right != null) {
                root = root.right;
            } else if (root.left != null) {
                root = root.left;
            } else {
                break;
            }

            stack.push(value);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " --> ");
        }
    }
}

class BinaryTreeInorderIterator{
    Stack<BinaryTreeNode> stack = new Stack<>(10);
    BinaryTreeInorderIterator(BinaryTreeNode root) throws Exception {
        BinaryTreeNode node = root;
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext(){
        return !this.stack.isEmpty();
    }

    public BinaryTreeNode getNext() throws Exception {
        if(this.stack.isEmpty()){
            return null;
        }

        BinaryTreeNode node = this.stack.pop();
        BinaryTreeNode tempNode = node.right;
        while (tempNode != null){
            stack.push(tempNode);
            tempNode = tempNode.left;
        }

        return node;
    }
}

class BinaryTreeNode{
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode sibling;

    BinaryTreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.sibling = null;
    }
}

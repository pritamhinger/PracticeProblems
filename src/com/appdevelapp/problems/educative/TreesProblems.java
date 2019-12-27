package com.appdevelapp.problems.educative;

import com.appdevelapp.datastructures.stack.Stack;
import com.appdevelapp.datastructures.tree.BinaryTree;

public class TreesProblems {
    public static void inOrderTravesal(BinaryTreeNode root) throws Exception {
        BinaryTreeInorderIterator iterator = new BinaryTreeInorderIterator(root);
        while (iterator.hasNext()){
            System.out.print(iterator.getNext().data + ",");
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

    BinaryTreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

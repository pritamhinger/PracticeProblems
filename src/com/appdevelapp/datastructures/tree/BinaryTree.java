package com.appdevelapp.datastructures.tree;

public class BinaryTree {
    public TreeNode getRoot() {
        return root;
    }

    private TreeNode root;

    public boolean add(int value){
        if(isEmpty()){
            root = new TreeNode(value);
            return true;
        }

        TreeNode currentNode = root;
        while (currentNode != null){
            TreeNode leftNode = currentNode.getLeftChild();
            TreeNode rightNode = currentNode.getRightChild();

            if(currentNode.getData() >= value){
                if(leftNode == null){
                    leftNode = new TreeNode(value);
                    currentNode.setLeftChild(leftNode);
                    return true;
                }

                currentNode = currentNode.getLeftChild();
            }
            else{
                if(rightNode == null){
                    rightNode = new TreeNode(value);
                    currentNode.setRightChild(rightNode);
                    return true;
                }

                currentNode = currentNode.getRightChild();
            }
        }

        return false;
    }

    public boolean isEmpty(){
        return  root == null;
    }

    public void printTree(TreeNode node){
        if(node == null){
            return;
        }

        System.out.print(node.getData() + ",");
        printTree(node.getLeftChild());
        printTree(node.getRightChild());
    }

    public void printTreeInOrder(TreeNode node) {
        if (node == null){
            return;
        }

        printTreeInOrder(node.getLeftChild());
        System.out.print(node.getData() + ",");
        printTreeInOrder(node.getRightChild());
    }
}

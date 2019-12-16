package com.appdevelapp.datastructures.tree;

public class BinaryTree {
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private TreeNode root;

    public TreeNode addRecursively(TreeNode currentNode, int value){
        if(currentNode == null){
            return new TreeNode(value);
        }

        if(value <= currentNode.getData()){
            currentNode.setLeftChild(addRecursively(currentNode.getLeftChild(), value));
        }
        else {
            currentNode.setRightChild(addRecursively(currentNode.getRightChild(),value));
        }

        return currentNode;
    }

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

    public TreeNode searchIteratively(int value){
        if(isEmpty()){
            return null;
        }

        TreeNode currentNode = root;
        while (currentNode != null){
            if(currentNode.getData() == value){
                return currentNode;
            }
            else if(value < currentNode.getData()){
                currentNode = currentNode.getLeftChild();
            }
            else {
                currentNode = currentNode.getRightChild();
            }
        }

        return null;
    }

    public TreeNode seachRecursively(TreeNode root, int value){
        if(root == null){
            return null;
        }

        int currentValue = root.getData();
        if(currentValue == value){
            return root;
        }
        else if(value < currentValue){
            return seachRecursively(root.getLeftChild(), value);
        }
        else{
            return seachRecursively(root.getRightChild(), value);
        }
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

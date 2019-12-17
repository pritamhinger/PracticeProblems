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

    public boolean delete(TreeNode currentNode, int value){
        if(isEmpty()){
            return false;
        }

        TreeNode parent = null;
        while (currentNode != null && currentNode.getData() != value){
            parent =  currentNode;
            if(value < currentNode.getData()){
                currentNode = currentNode.getLeftChild();
            }
            else{
                currentNode = currentNode.getRightChild();
            }
        }

        if(currentNode == null){
            return false;
        }

        if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }

            if(currentNode.getData() <= parent.getData()){
                parent.setLeftChild(null);
                currentNode = null;
                return true;
            }
            else{
                parent.setRightChild(null);
                currentNode = null;
                return true;
            }
        }
        else if(currentNode.getRightChild() == null){
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getLeftChild());
                return true;
            }
            else if(currentNode.getData() <= parent.getData()){
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            }
            else{
                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }
        }
        else if(currentNode.getLeftChild() == null){
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getRightChild());
                return true;
            }
            else if(currentNode.getData() <= parent.getData()){
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            }
            else{
                parent.setRightChild(currentNode.getLeftChild());
            }
        }
        else{
            TreeNode minNode =  findMinimumValueNodeInTree(currentNode.getRightChild());
            int tempValue = minNode.getData();
            delete(root, tempValue);
            currentNode.setData(tempValue);
            return true;
        }
        return true;
    }

    private TreeNode findMinimumValueNodeInTree(TreeNode root) {
        TreeNode tempNode = root;

        while (tempNode.getLeftChild() != null) {
            tempNode = tempNode.getLeftChild();
        }

        return tempNode;
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

    public void preOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }

        System.out.print(node.getData() + ", ");
        preOrderTraversal(node.getLeftChild());
        preOrderTraversal(node.getRightChild());
    }

    public void postOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }

        postOrderTraversal(node.getLeftChild());
        postOrderTraversal(node.getRightChild());
        System.out.print(node.getData() + ", ");
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null){
            return;
        }

        inOrderTraversal(node.getLeftChild());
        System.out.print(node.getData() + ",");
        inOrderTraversal(node.getRightChild());
    }
}

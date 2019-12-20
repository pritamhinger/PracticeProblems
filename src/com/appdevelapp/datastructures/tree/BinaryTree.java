package com.appdevelapp.datastructures.tree;

import com.appdevelapp.datastructures.queue.Queue;

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

    static int countOfNodes = 0;
    private static TreeNode findKthMaxRecursively(TreeNode root, int k){
        if(root == null){
            return null;
        }

        TreeNode node = findKthMaxRecursively(root.getRightChild(), k);
        if(countOfNodes != k){
            countOfNodes++;
            node = root;
        }

        if(k == countOfNodes){
            return node;
        }
        else{
            return findKthMaxRecursively(root.getLeftChild(), k);
        }
    }

    public static int findKthMax(TreeNode root, int k) {
        TreeNode node = findKthMaxRecursively(root, k);
        countOfNodes = 0;
        if(node != null){
            return node.getData();
        }

        return -1;
    }

    public static int findMinRecursive(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        if(root.getLeftChild() != null){
            findMinRecursive(root.getLeftChild());
        }

        return root.getData();
    }

    public static int findMin(TreeNode root)
    {
        if(root ==  null){
            return Integer.MIN_VALUE;
        }

        while (root.getLeftChild() != null){
            root = root.getLeftChild();
        }

        return root.getData();
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

    public static String findAncestors(TreeNode root, int k) {
        if(root == null){
            return "";
        }

        String ancestors = "";
        TreeNode tempNode = root;
        while(tempNode != null && tempNode.getData() != k){
            ancestors = ancestors + tempNode.getData() + ",";
            if(k <= tempNode.getData()){
                tempNode = tempNode.getLeftChild();
            }
            else{
                tempNode = tempNode.getRightChild();
            }
        }

        if(tempNode == null){
            return "";
        }

        return ancestors;
    }

    public static int findHeight(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftHeight = findHeight(root.getLeftChild());
        int rightHeight = findHeight(root.getRightChild());
        return Max(leftHeight, rightHeight) + 1;
    }

    private static int Max(int a, int b){
        return (a >= b) ? a : b;
    }

    public static String findKNodes(TreeNode root, int k) throws Exception {

        if(root == null || k == 0){
            return "";
        }

        Queue<TreeNode> queue = new Queue<>(100);
        queue.enqueue(root);
        queue.enqueue(null);
        int level = 0;
        String str = "";
        while (!queue.isEmpty()){
            if(level > k){
                break;
            }

            TreeNode currentNode = queue.dequeue();
            if(currentNode == null){
                level++;
                queue.enqueue(null);
                continue;
            }

            if(level == k) {
                str += currentNode.getData() + ",";
            }

            if(currentNode.getLeftChild() != null){
                queue.enqueue(currentNode.getLeftChild());
            }

            if(currentNode.getRightChild() != null){
                queue.enqueue(currentNode.getRightChild());
            }
        }

        return str;
    }
}

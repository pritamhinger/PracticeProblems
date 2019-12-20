package com.appdevelapp.datastructures.trie;

public class Trie {
    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int getIndex(char ch) {
        return ch - 'a';
    }

    public void insert(String key) {
        if(key == null || key == ""){
            System.out.println("Empty or null keys not allowed");
            return;
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.getRoot();
        for (int i = 0; i < key.length(); i++) {
            int index = getIndex(key.charAt(i));
            if(currentNode.children[index] == null){
                currentNode.children[index] = new TrieNode();
            }

            currentNode = currentNode.children[index];
        }

        currentNode.markAsLeaf();
    }

    public boolean search(String key) {
        TrieNode node = this.getRoot();
        key = key.toLowerCase();
        int index = -1;
        for (int i = 0; i < key.length() && node != null; i++) {
            index = getIndex(key.charAt(i));
            node = node.children[index];
        }

        if(node == null){
            return false;
        }

        return node.isEndWord;
    }

    public void delete(String key) {
        if(key == null || root == null){
            System.out.println("Invalid Trie or key to delete");
            return;
        }

        deleteHelper(key, this.getRoot(), key.length(), 0);
    }

    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level){
        boolean deletedSelf = false;
        if(currentNode == null){
            System.out.println("Key doesn't existes");
            return deletedSelf;
        }

        if(level == length){
            if(hasNoChildren(currentNode)){
                deletedSelf = true;
                currentNode = null;
            }
            else{
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        }
        else{
            TrieNode node = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, node, length, (level+1));
            if(childDeleted){
                currentNode.children[getIndex(key.charAt(level))] = null;
                if(currentNode.isEndWord){
                    deletedSelf = false;
                }
                else if(!hasNoChildren(currentNode)){
                    deletedSelf= false;
                }
                else {
                    currentNode = null;
                    deletedSelf = true;
                }
            }
            else{
                deletedSelf = false;
            }
        }

        return deletedSelf;
    }

    private boolean hasNoChildren(TrieNode currentNode){
        for (int i = 0; i < currentNode.children.length; i++) {
            if(currentNode.children[i] != null){
                return false;
            }
        }

        return true;
    }
}

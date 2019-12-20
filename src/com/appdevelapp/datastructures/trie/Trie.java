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

    public boolean delete(String key) {
        return false;
    }
}

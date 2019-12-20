package com.appdevelapp.datastructures.trie;

public class TrieNode {
    TrieNode[] children;
    boolean isEndWord;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEndWord = false;
    }

    public void markAsLeaf(){
        this.isEndWord = true;
    }

    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }
}

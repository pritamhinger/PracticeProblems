package com.appdevelapp.datastructures.trie;

import com.appdevelapp.datastructures.queue.Queue;

import java.util.ArrayList;

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

    public static int totalWords(TrieNode root)
    {
        int result = 0;

        if(root.isEndWord){
            System.out.println("Found Word");
             ++result;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                System.out.println("Index is " + i);
                result += totalWords(root.children[i]);
            }
        }

        return result;
    }
    public static int totalWordsIterative(TrieNode root) throws Exception {
        if(root == null){
            return 0;
        }

        Queue<TrieNode> queue = new Queue<>(100);
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null){
                queue.enqueue(root.children[i]);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            TrieNode node = queue.dequeue();
            if(node != null){
                if(node.isEndWord){
                    count++;
                }

                for (int i = 0; i < node.children.length; i++) {
                    if(node.children[i] != null){
                        queue.enqueue(node.children[i]);
                    }
                }
            }
        }

        return count;
    }

    private static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str) {
        if(root.isEndWord){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= level; i++) {
                sb.append(str[i]);
            }

            result.add(sb.toString());
        }

        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null){
                str[level+1] = (char)('a' + i);
                getWords(root.children[i], result, (level+1), str);
            }
        }
    }

    public static ArrayList < String > findWords(TrieNode root) {
        ArrayList<String> result = new ArrayList<String>();
        char[] characters = new char[100];
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null){
                characters[0] = (char)('a' + i);
                getWords(root.children[i], result, 0, characters);
            }
        }
        return result;
    }

    public static ArrayList<String> sortArray(String[] arr) {
        ArrayList<String> result = new ArrayList<String>();
        Trie trie = new Trie();
        for (String word: arr) {
            trie.insert(word);
        }

        result = findWords(trie.getRoot());
        return result;
    }
}

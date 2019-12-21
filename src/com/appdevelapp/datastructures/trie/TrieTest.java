package com.appdevelapp.datastructures.trie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;

class TrieTest {

    Trie trie;
    @BeforeEach
    void setUp() {
        trie = new Trie();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        trie.insert("the");
        trie.insert("a");
        trie.insert("there");
        trie.insert("answer");
        trie.insert("any");
        trie.insert("by");
        trie.insert("bye");
        trie.insert("their");
        trie.insert("abc");
        Assert.that(!trie.getRoot().isEndWord, "Failed");
    }

    @Test
    void search() {
        trie.insert("bed");
        Assert.that(!trie.search("bedroom"), "Failed");
        Assert.that(!trie.search("be"), "Failed");
        trie.insert("be");
        Assert.that(trie.search("be"), "Failed");
        Assert.that(trie.search("bed"), "Failed");
    }

    @Test
    void delete() {
        trie.insert("their");
        trie.insert("bat");
        trie.insert("the");
        trie.delete("bat");
        //trie.delete("their");
        trie.delete("there");
    }

    @Test
    void totalWords() throws Exception {
        trie.insert("a");
        Assert.that(Trie.totalWordsIterative(trie.getRoot()) == 1, "Failed");
        trie.insert("abc");
        Assert.that(Trie.totalWordsIterative(trie.getRoot()) == 2, "Failed");
        trie.insert("the");
        Assert.that(Trie.totalWordsIterative(trie.getRoot()) == 3, "Failed");
        trie.delete("abc");
        Assert.that(Trie.totalWordsIterative(trie.getRoot()) == 2, "Failed");
    }

    @Test
    void testTotalWords() {
        trie.insert("a");
        trie.insert("abc");
        Assert.that(Trie.totalWords(trie.getRoot()) == 2, "Failed");
        trie.insert("the");
        Assert.that(Trie.totalWords(trie.getRoot()) == 3, "Failed");
        trie.delete("abc");
        Assert.that(Trie.totalWords(trie.getRoot()) == 2, "Failed");
    }

    @Test
    void findWords() {
        trie.insert("a");
        trie.insert("the");
        trie.insert("abc");
        trie.insert("by");
        trie.insert("their");
        trie.insert("there");
        trie.insert("answer");
        trie.insert("any");
        trie.insert("bye");
        ArrayList<String> words = Trie.findWords(trie.getRoot());
        for (String word:words) {
            System.out.println(word);
        }

        Assert.that(words.size() == 9, "Failed");
    }

    @Test
    void sortArray() {
        String[] arr = {"the", "a", "there", "answer", "any", "by", "bye", "their", "abc"};
        String[] sortedArray = {"a", "abc", "answer", "any", "by", "bye", "the", "their", "there"};
        ArrayList<String> output = Trie.sortArray(arr);
        Assert.that(arr.length == output.size(), "Failed");
        Assert.that(arr.length == sortedArray.length, "Failed");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(output.get(i));
            Assert.that(sortedArray[i].equals(output.get(i)), "Failed");
        }
    }
}
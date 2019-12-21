package com.appdevelapp.datastructures.trie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

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
}
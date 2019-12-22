package com.appdevelapp.datastructures.hashtable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    HashTable hashTable;
    @BeforeEach
    void setUp() {
        hashTable = new HashTable();
        hashTable.insert("Hi", 1);
        hashTable.insert("Hello", 1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        hashTable.insert("Hi", 2);
        hashTable.insert("Hello", 3);
        Assert.that(hashTable.size() == 2, "Failed");
        hashTable.insert("Helloo", 1);
        Assert.that(hashTable.size() == 3, "Failed");

        hashTable.insert("This",1 ); //Key-Value Pair
        hashTable.insert("is",2 );
        hashTable.insert("a",3 );
        hashTable.insert("Test",4 );
        hashTable.insert("Driver",5 );
        Assert.that(hashTable.size() == 8, "Failed");
    }

    @Test
    void getValue() {
    }

    @Test
    void delete() {
    }
}
package com.appdevelapp.datastructures.hashtable;

public class HashEntry {
    String key;
    int value;

    HashEntry next;
    HashEntry(String key,int value){
        this.key = key;
        this.value = value;
    }
}

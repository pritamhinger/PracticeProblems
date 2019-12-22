package com.appdevelapp.datastructures.hashtable;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable(){
        this.bucket = new ArrayList<>();
        this.size = 0;
        this.slots = 10;
        for (int i = 0; i < slots; i++) {
            bucket.add(null);
        }
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void insert(String key, int value){
        int index = getIndex(key);
        HashEntry head = this.bucket.get(index);
        while (head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }

            head = head.next;
        }

        size++;
        head = this.bucket.get(index);
        HashEntry newEntry = new HashEntry(key, value);
        newEntry.next = head;
        this.bucket.set(index, newEntry);

        if((1.0 * size)/slots >= 0.6) {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = slots * 2;
            size = 0;
            for (int i = 0; i < slots; i++) {
                bucket.add(null);
            }

            for (HashEntry entry : temp) {
                while (entry != null){
                    insert(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }
    }

    public Integer getValue(String key){
        int index = getIndex(key);
        HashEntry head = bucket.get(index);
        while (head != null){
            if(head.key.equals(key)){
                return head.value;
            }

            head = head.next;
        }

        return null;
    }

    public Integer delete(String key){
        int index = getIndex(key);
        HashEntry head = bucket.get(index);
        HashEntry prevNode = null;

        while (head != null){
            if(head.key.equals(key)){
                break;
            }

            prevNode = head;
            head = head.next;
        }

        if(head == null){
            return null;
        }

        size--;
        if(prevNode != null){
            prevNode.next = head.next;
        }
        else{
            bucket.set(index, head.next);
        }

        return head.value;
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % slots;
        if(index < 0){
            System.out.println("Negative index for the key " + key);
            index = (index + slots)%slots;
        }

        return index;
    }
}

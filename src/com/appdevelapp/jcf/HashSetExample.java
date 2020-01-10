package com.appdevelapp.jcf;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> lhSet = new HashSet<>();

        set.add(10);
        lhSet.add(100);
        set.add(20);
        lhSet.add(400);
        lhSet.add(40);
        set.add(30);
        lhSet.add(300);

        Iterator<Integer> it = set.iterator();
        System.out.println("HashSet Elements");
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Iterator<Integer> lhIt = lhSet.iterator();
        System.out.println("Linked HashSet Elements");
        while (lhIt.hasNext()){
            System.out.println(lhIt.next());
        }

        if(set.contains(20)){
            System.out.println("20 present in hash set");
        }
        else{
            System.out.println("20 not present in hash set");
        }

        if(set.contains(40)){
            System.out.println("40 present in hash set");
        }
        else{
            System.out.println("40 not present in hash set");
        }

        if(set.remove(20)){
            System.out.println("Removed 20 from HashSet");
        }
        else {
            System.out.println("Failed to remove 20 from HashSet");
        }

        try {
            if (set.remove(40)) {
                System.out.println("Removed 40 from HashSet");
            } else {
                System.out.println("Failed to remove 40 from HashSet");
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        set.addAll(lhSet);
        it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        lhSet.remove(400);
        lhSet.remove(100);
        set.removeAll(lhSet);
        System.out.println("Current HashSet elements are");
        it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

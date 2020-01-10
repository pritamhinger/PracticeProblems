package com.appdevelapp.jcf;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args){
        int v = 0;
        int vv = 0;
        v += v++;
        vv += ++vv;
        System.out.println("V = " + v);
        System.out.println("VV = " + vv);
        LinkedList<Integer> singlyLinkedList = new LinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);

        singlyLinkedList.addFirst(0);
        singlyLinkedList.add(5);
        Iterator<Integer> iterator = singlyLinkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("List iterator forward");
        ListIterator<Integer> listIterator = singlyLinkedList.listIterator();
        int i = 10;
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
            listIterator.add(i++);
        }

        System.out.println("List iterator backword");
        while (listIterator.hasPrevious()){
            int val = listIterator.previous();
            System.out.println(val);
            listIterator.remove();
            val = listIterator.previous();
            System.out.println(val);
        }

        System.out.println("Printing again");
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        System.out.println("Removing elements");
        System.out.println(singlyLinkedList.remove());
        System.out.println(singlyLinkedList.remove());
        System.out.println(singlyLinkedList.removeLast());

        System.out.println(singlyLinkedList.get(0));
        System.out.println(singlyLinkedList.getFirst());
        System.out.println(singlyLinkedList.getLast());
    }
}

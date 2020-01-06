package com.appdevelapp.problems.hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            pQueue.add(AItem);
        }

        int count = 0;
        while (pQueue.size() > 1 && pQueue.peek() < k){
            int first = pQueue.poll();
            int second = pQueue.poll();
            int newSweetnes  = (first + 2*second);
            pQueue.add(newSweetnes);
            count++;
            if(pQueue.peek() >= k){
                System.out.println(count);
                return;
            }
        }

        if(pQueue.peek() < k){
            System.out.println("-1");
        }
        else{
            System.out.println(String.valueOf(count));
        }
    }
}

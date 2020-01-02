package com.appdevelapp.problems.hackerrank;

import java.util.Scanner;

public class GameOfTwoStacks {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            System.out.println(String.valueOf(result));
        }
    }

    static int twoStackHelper(int x, int[] a, int[] b, int aStartIndex, int bStartIndex){
        if(x < 0){
            return -1;
        }
        if(aStartIndex >= a.length){
            int bIndex = bStartIndex;
            int bMoveCount = 0;
            int result = x;
            while(bIndex < b.length){
                if(result - b[bIndex] < 0){
                    break;
                }

                result = result - b[bIndex];
                bIndex++;
                bMoveCount++;
            }

            return bMoveCount;
        }

        if(bStartIndex >= b.length){
            int aIndex = aStartIndex;
            int aMoveCount = 0;
            int result = x;
            while(aIndex < a.length){
                if(result - a[aIndex] < 0){
                    break;
                }

                result = result - a[aIndex];
                aIndex++;
                aMoveCount++;
            }

            return aMoveCount;
        }

        int aMoveCount = 1 + twoStackHelper(x-a[aStartIndex], a,b,aStartIndex + 1, bStartIndex);
        int bMoveCount = 1 + twoStackHelper(x-b[bStartIndex],a,b,bStartIndex,bStartIndex+1);
        return (aMoveCount > bMoveCount) ? aMoveCount : bMoveCount;
    }

    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */
        int ai = 0;
        int bi = 0;
        int count = 0;
        int sum = 0;
        // move bi to the position where if only take elements from B, last element it can take
        while (bi < b.length && sum + b[bi] <= x) {
            sum += b[bi];
            bi++;
        }
        bi--; // loop exits only when bi reaches end or sum > x; in both case bi should decrease
        count = bi + 1;
        while (ai < a.length && bi < b.length) {
            sum += a[ai];
            if (sum > x) {
                while (bi >= 0) {
                    sum -= b[bi];
                    bi--;
                    if (sum <= x) break;
                }
                // if even no elements taken from B, but still sum greater than x, then a[ai] should not be chosen
                // and loop terminates
                if (sum > x && bi < 0) {
                    ai--;
                    break;
                }
            }
            count = Math.max(ai + bi + 2, count);
            ai++;
        }

        return count;
    }
}

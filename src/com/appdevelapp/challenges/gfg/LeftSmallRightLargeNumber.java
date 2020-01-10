package com.appdevelapp.challenges.gfg;

import java.util.Scanner;

public class LeftSmallRightLargeNumber {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        int[] results = new int[T];
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] strNumbers = scanner.nextLine().trim().split(" ");
            int[] numbers = new int[strNumbers.length];
            for (int j = 0; j < strNumbers.length; j++) {
                numbers[j] = Integer.parseInt(strNumbers[j]);
            }

            int value = findElement(numbers);
            results[i] = value == -1 ? -1 : numbers[value];
        }

        for (int res:results) {
            System.out.println(res);
        }
    }

    private static int findElement(int[] arr) {
        boolean leftSmaller[] = new boolean[arr.length];
        boolean rightGreater[] = new boolean[arr.length];

        // First traverse from left to right

        int greatestElementFromLeftToRight = arr[0];

        for ( int i = 1 ; i < arr.length ; i++) {
            if ( arr[i] >= greatestElementFromLeftToRight) {
                leftSmaller[i] = true;
                greatestElementFromLeftToRight = arr[i];
            }
        }

        // Second, traverse from right to left
        int smallestElementFromRightToLeft = arr[arr.length - 1];

        for ( int i = arr.length - 2 ; i >= 0 ; i--)    {
            if ( arr[i] <= smallestElementFromRightToLeft)   {
                rightGreater[i] = true;
                smallestElementFromRightToLeft = arr[i];
            }
        }

        for ( int i = 0 ; i < arr.length ; i++)
            if ( (leftSmaller[i] == true) && (rightGreater[i] == true ))
                return i;

        return -1;
    }
}


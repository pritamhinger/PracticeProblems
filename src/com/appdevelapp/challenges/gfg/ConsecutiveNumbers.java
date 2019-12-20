package com.appdevelapp.challenges.gfg;

import java.util.*;
import java.lang.*;
import java.io.*;

public class ConsecutiveNumbers {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int[] outputValues = new int[t];
        for (int i = 0; i < t; i++) {
            int sizeOfArray = Integer.parseInt(scanner.nextLine());
            String[] strNumbers = scanner.nextLine().split(" ");
            int[] numbers = new int[sizeOfArray];
            for (int j = 0; j < sizeOfArray; j++) {
                numbers[j] = Integer.parseInt(strNumbers[j]);
            }

            if(sizeOfArray == 1){
                outputValues[i] = numbers[0];
                continue;
            }

            Arrays.sort(numbers);

            int sum = numbers[sizeOfArray - 1];
            HashSet<Integer> numbersInSum = new HashSet<>();
            HashSet<Integer> deductNumber = new HashSet<>();
            numbersInSum.add(numbers[sizeOfArray - 1]);
            deductNumber.add(numbers[sizeOfArray - 1] - 1);
            for (int j = sizeOfArray - 2; j >= 0; j--) {
                if (deductNumber.contains(numbers[j])) {
                    numbersInSum.add(numbers[j] - 1);
                }

                if (numbersInSum.contains(numbers[j])) {
                    deductNumber.add(numbers[j] - 1);
                }
                sum += numbers[j];
            }

            for (int j = 0; j < sizeOfArray; j++) {
                if (deductNumber.contains(numbers[j])) {
                    sum -= numbers[j];
                    deductNumber.remove(numbers[j]);
                }
            }

            outputValues[i] = sum;
        }

        for (int value : outputValues) {
            System.out.println(value);
        }
    }
}

package com.appdevelapp.challenges.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortBinaryArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(scanner.nextLine().trim());
            String[] strNumbers = scanner.nextLine().trim().split(" ");
            int[] numbers = new int[length];
            int count = 0;
            for (int j = 0; j < length; j++) {
                if(strNumbers[j].equals("0")){
                    count++;
                }
            }

            int index = 0;
            for(; index < count; index++){
                numbers[index] = 0;
            }

            for(;index < length;index++){
                numbers[index] = 1;
            }

            result.add(numbers);
        }

        for (int[] array: result) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}

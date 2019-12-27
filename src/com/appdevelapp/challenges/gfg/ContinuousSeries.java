package com.appdevelapp.challenges.gfg;

import java.util.Scanner;

public class ContinuousSeries {
    public static void main (String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        int[] output = new int[T];
        for(int i=0; i < T; i++){
            int n = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[n];
            String strNumbers = scanner.nextLine();
            String[] strNumArr = strNumbers.split(" ");
            for(int j = 0; j < n; j++){
                arr[j] = Integer.parseInt(strNumArr[j]);
            }

            int previous = arr[0];
            int count = 0;
            int length = 1;
            for(int j = 1; j < n; j++){
                if(arr[j] == previous + 1){
                    length++;
                }
                else{
                    if(length > 1){
                        count++;
                    }

                    length = 1;
                }

                previous = arr[j];
            }

            if(length > 1){
                count++;
            }
            output[i] = count;
        }

        for(int i=0; i < T; i++){
            System.out.println(output[i]);
        }
    }
}

package com.appdevelapp.challenges.gfg;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GoodScorer {


    public static void main(String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        String[] output = new String[t];
        for (int j = 0; j < t; j++) {
            String[] columns = scanner.nextLine().split(" ");

            int c1 = Integer.parseInt(columns[0]);
            int c2 = Integer.parseInt(columns[1]);
            String[] c1Nums = scanner.nextLine().split(" ");
            int sumC1 = 0;
            for (int i = 0; i < c1; i++) {
                sumC1 += Integer.parseInt(c1Nums[i]);
            }

            String[] c2Nums = scanner.nextLine().split(" ");
            int sumC2 = 0;
            for (int i = 0; i < c2; i++) {
                sumC2 += Integer.parseInt(c2Nums[i]);
            }

            if (sumC1 >= sumC2) {
                output[j] = "C1";
            } else {
                output[j] = "C2";
            }
        }

        for (String str:output) {
            System.out.println(str);
        }
    }

}

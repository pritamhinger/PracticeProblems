package com.appdevelapp.challenges.gfg;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CountFGF {
    public static void main (String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int[] output = new int[t];

        for(int i = 0; i < t; i++){
            String input = scanner.nextLine();
            int count = 0;
            char[] characters = input.toCharArray();
            for (int j = 0; j < characters.length - 2; j++) {
                if(characters[j] == 'g'){
                    if(characters[j+1] == 'f' && characters[j+2] == 'g'){
                        count++;
                    }
                }
            }

            output[i] = (count > 0) ? count : -1;
        }

        for (int outp: output) {
            System.out.println(outp);
        }
    }
}

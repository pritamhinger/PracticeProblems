package com.appdevelapp.problems.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EqualStacks {
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        int[] thStack1 = new int[h1.length];
        thStack1[h1.length-1] = h1[h1.length-1];

        int[] thStack2 = new int[h2.length];
        thStack2[h2.length-1] = h2[h2.length-1];

        int[] thStack3 = new int[h3.length];
        thStack3[h3.length-1] = h3[h3.length-1];


        for(int i = h1.length - 2; i >= 0; i--){
            thStack1[i] = thStack1[i+1] + h1[i];
        }

        for(int i = h2.length - 2; i >= 0; i--){
            thStack2[i] = thStack2[i+1] + h2[i];
        }

        for(int i = h3.length - 2; i >= 0; i--){
            thStack3[i] = thStack3[i+1] + h3[i];
        }

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while(index1 < thStack1.length && index2 < thStack2.length && index3 < thStack3.length){
            if(thStack1[index1] == thStack2[index2] && thStack2[index2] == thStack3[index3]){
                return thStack1[index1];
            }

            if(thStack1[index1] > thStack2[index2]){
                if(thStack1[index1] > thStack3[index3]){
                    index1++;
                }
                else{
                    index3++;
                }
            }
            else{
                if(thStack2[index2] > thStack3[index3]){
                    index2++;
                }
                else{
                    index3++;
                }
            }
        }

        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(result);
    }
}

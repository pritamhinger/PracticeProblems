package com.appdevelapp;

import com.appdevelapp.datastructures.array.Arrays;
import com.appdevelapp.problems.SudokuValidator;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        boolean isNegative = (x < 0);
        if(isNegative){
            x = x*-1;
        }

        int reverseNumber = 0;
        int number = x;
        while(x > 0){
            int reminder = x%10;
            if(reverseNumber > 214748364)
            {
                return 0;
            }
            x = x/10;
            reverseNumber = reverseNumber*10 + reminder;
            System.out.println(reverseNumber);
            if(reverseNumber < 0){
                return 0;
            }
        }

        if(reverseNumber < 0){
            return 0;
        }

        if(isNegative){
            return reverseNumber*-1;
        }

        return reverseNumber;
    }
}

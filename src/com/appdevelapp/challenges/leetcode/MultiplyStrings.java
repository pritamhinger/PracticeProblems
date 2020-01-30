package com.appdevelapp.challenges.leetcode;

public class MultiplyStrings {

    public static void main(String[] args){
        String s1 = "2";
        String s2 = "3";
        System.out.println(multiply(s1,s2));
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int l1 = num1.length();
        int l2 = num2.length();
        int columns = l1+l2;
        int rows = (l1 < l2) ? l1 : l2;
        String first = (l1 >= l2) ? num1 : num2;
        String second = (l1 < l2) ? num1 : num2;


        int[][] matrix = new int[rows][columns];
        for(int i=0; i < rows; i++){
            for(int j=0;j<columns; j++){
                matrix[i][j] = 0;
            }
        }

        l2 = second.length()-1;
        int r1 = 0;
        int reminder = 0;
        while(l2 >= 0){
            int n2 = (int)(second.charAt(l2) - '0');

            l1 = first.length()-1;
            reminder = 0;
            int c1 = columns-1-(r1);
            int colIndex = c1;
            while(l1 >= 0){
                int n1 = (int)(first.charAt(l1) - '0');
                int mul = n1*n2;
                reminder = reminder + mul/10;
                mul = mul % 10;
                matrix[r1][c1] = mul;
                c1--;
                l1--;
            }

            matrix[r1][colIndex] = reminder;
            r1++;
            l2--;
        }

        char[] results = new char[columns];
        int index = columns-1;
        for(int j = columns-1; j>=0; j--){
            reminder = 0;
            int num = 0;
            for(int i = 0; i<rows; i++){
                num = num + reminder + matrix[i][j];
            }

            reminder = num/10;
            num = num % 10;
            results[index] = (char)(num + (int)('0'));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(results);

        String res = sb.toString();
        if(reminder > 0){
            res = String.valueOf((char)(reminder + (int)('0'))) + res;
        }

        return res;
    }
}

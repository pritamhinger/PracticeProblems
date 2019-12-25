package com.appdevelapp.problems.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MathsAndSetsProblems {

    static void find_kth_permutation(List<Character> v, int k, StringBuilder result) {
        if (v.isEmpty()) {
            return;
        }

        int n = v.size();
        int[] factorials = getFactorialSeries(n);
        int sizeOfBlock = factorials[n-1];
        int selectedNumber = (k-1)/sizeOfBlock;
        Character ch = v.get(selectedNumber);
        result.append(ch);
        v.remove(selectedNumber);
        int newK = k - (sizeOfBlock * selectedNumber);
        find_kth_permutation(v, newK, result);
    }

    public static int integer_divide(int x, int y) {
        //TODO: Write - Your - Code
        if(y == 0){
            return -1;
        }

        if(y == 1){
            return x;
        }

        if(x < y){
            return 0;
        }

        if(x == y){
            return 1;
        }

        int quotient = 1;
        int temp = y;
        while(temp <= x){
            quotient = quotient<<1;
            temp = temp<<1;
        }

        if(temp == x){
            return quotient;
        }
        else{
            quotient = quotient>>1;
            temp = temp>>1;
        }
        return quotient + integer_divide(x-temp, y);
    }

    static List<int[]> find_pythagorean_triplets(int[] arr) {
        //TODO: Write - Your - Code
        Arrays.sort(arr);
        List<int[]> triplets = new ArrayList<>();
        int n = arr.length;
        for (int i = n -1 ; i >= 2 ; i--) {
            int square = arr[i] * arr[i];

            int left = i-1;
            int right = 0;
            while (left > right){
                int diff = square - ((arr[left] * arr[left]) + (arr[right]* arr[right]));
                if(diff == 0){
                    int[] triplet = new int[3];
                    triplet[0] = arr[right];
                    triplet[1] = arr[left];
                    triplet[2] = arr[i];
                    //triplets.add(0, triplet);
                    triplets.add(triplet);
                    break;
                }
                else if(diff > 0){
                    right++;
                }
                else{
                    left--;
                }
            }
        }

        return triplets;
    }

    public static List<String> permuteString(String str){
        List<String> result = new ArrayList<>();
        char[] characters = str.toCharArray();
        int index = 0;

        permuteStringHelper(characters, index, result);
        return result;
    }

    private static void permuteStringHelper(char[] characters, int currentIndex, List<String> result){
        if(currentIndex == characters.length - 1){
            result.add(new String(characters));
            return;
        }

        for (int i = currentIndex; i < characters.length; i++) {
            swapCharacters(characters, currentIndex, i);
            permuteStringHelper(characters, currentIndex + 1, result);
            swapCharacters(characters, currentIndex, i);
        }

        return;
    }

    private static void swapCharacters(char[] characters, int left, int right){
        char ch = characters[left];
        characters[left] = characters[right];
        characters[right] = ch;
    }

    static double power(double x, int n) {
        boolean isNegativePower = false;
        if(n < 0){
            isNegativePower = true;
            n = n * -1;
        }

        double result = powerHelper(x,n);
        if(isNegativePower){
            return 1/result;
        }
        else{
            return result;
        }
    }

    private static double powerHelper(double x, int n){
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double num = power(x, n / 2);
        if (n % 2 == 0) {
            return num * num;
        } else {
            return  num * num * x;
        }
    }

    static double squareRoot(double n){
        double error_margin = 0.000000000001;
        double low = 0;
        double high = 1 + (n/2);
        while (low < high){
            double mid = (low + high)/2;
            double square = mid*mid;
            double diff = Math.abs(square - n);
            if(diff <= error_margin){
                return mid;
            }

            if(square < n){
                low = mid;
            }
            else{
                high = mid;
            }
        }

        return  -1.0;
    }

    private static int[] getFactorialSeries(int n) {
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        factorials[1] = 1;
        for (int i = 2; i <= n ; i++) {
            factorials[i] = i * factorials[i-1];
        }

        return factorials;
    }
}

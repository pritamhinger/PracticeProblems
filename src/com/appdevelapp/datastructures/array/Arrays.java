package com.appdevelapp.datastructures.array;

import com.sun.tools.javac.util.Convert;
import org.junit.jupiter.api.parallel.Execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Arrays {
    public static boolean OneDimensionalArrayInitializationExample(){
        try{
            int[] arr1 = new int[5];
            int arr2[] = new int[6];
            int arr3[] =  {1,2,3,4,5};
            int[] arr4 = new int[] {6,7,8,9,10,11};

            System.out.println("Arr1 Size is " + arr1.length);
            System.out.println("Arr2 size is " + arr2.length);
            System.out.println("Arr3 with size : " + arr3.length);
            for (int item: arr3) {
                System.out.println(item);
            }

            System.out.println("Arr4 with size : " + arr4.length);
            for (int item: arr4) {
                System.out.println(item);
            }
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public static boolean TwoDimensionalArrayInitializationExample(){
        try{
            int[][] arr2 = new int[3][4];
            int[][] arr1 = {{1,2,3}, {4,5,6},{7,8,9}};
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    System.out.print(arr1[i][j] + "  ");
                }
                System.out.println();
            }
            return true;
        }
        catch(Exception ex){
            return  false;
        }
    }

    public static int[] removeEven(int[] arr) {

        String str = "";
        for (int item: arr) {
            if(item%2 != 0){
                str += item+ ";";
            }
        }

        String[] strArr = str.split(";");
        int[] result = new int[strArr.length];
        int index = 0;
        for (String str1:strArr) {
            result[index] = Integer.parseInt(str1);
            index++;
        }

        return result;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2)
    {
        int result[] = new int[arr1.length + arr2.length];
        int i=0, j=0,k=0;
        for(; i< arr1.length && j < arr2.length; k++){
            if(arr1[i] <= arr2[j]){
                result[k] = arr1[i];
                i++;
            }
            else{
                result[k] = arr2[j];
                j++;
            }
        }

        while(i < arr1.length){
            result[k] = arr1[i];
            i++;
            k++;
        }

        while(j < arr2.length){
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static int[] findSum(int[] arr, int n)
    {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item: arr) {
            if(map.containsKey(n-item)){
                result[0] = item;
                result[1] = n-item;
                return result;
            }
            else{
                map.put(item,1);
            }
        }
        return  result;
    }

    public static int[] findProduct(int arr[]) {
        int[] result = new int[arr.length];

        int product = 1;
        boolean isZeroPresent = false;
        boolean doesTwoZeroPresent = false;
        for (int item:arr) {
            if(item != 0){
                product *= item;
            }
            else{
                if(isZeroPresent){
                    doesTwoZeroPresent = true;
                }
                isZeroPresent = true;

            }
        }

        if(doesTwoZeroPresent){
            return result;
        }


        for (int i = 0; i < arr.length; i++) {
            if(isZeroPresent && arr[i] != 0){
                result[i] = 0;
            }
            else if(arr[i] == 0){
                result[i] = product;
            }
            else{
                result[i] = product/(arr[i]);
            }
        }

        return result;
    }

    public static int findFirstUnique(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int result = 0;
        for (int item: arr) {
            if(map.containsKey(item)){
                map.put(item, map.get(item) + 1);
            }
            else{
                map.put(item, 1);
            }
        }

        for (int item:arr) {
            if(map.get(item) == 1){
                result = item;
                return  result;
            }
        }

        return result;
    }

    public static int findSecondMaximum(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int item:arr) {
            if(item > max){
                max = item;
            }
        }

        int secondMax = Integer.MIN_VALUE;
        for (int item: arr) {
            if(item == max){ continue;}
            if(item > secondMax){
                secondMax = item;
            }
        }

        System.out.println("Min Integer Values is : " + Integer.MIN_VALUE);
        System.out.println("Max Integer Values is : " + Integer.MAX_VALUE);
        return secondMax;
    }

    public static void rotateArray(int[] arr){
        int n = arr.length;
        int temp1 = arr[n-1];
        int i = n-1;
        for( ; i>0 ; i--){
            arr[i] = arr[i-1];
        }

        arr[0] = temp1;

        for (int item:arr) {
            System.out.print(item + "  ");
        }
    }

    public static void reArrange(int[] arr) {

        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if(arr[i] >= 0 && arr[j] <0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            else if(arr[i] < 0){
                i++;
            }
            else if(arr[j] >= 0){
                j--;
            }
        }

        for (int item: arr) {
            System.out.println(item + "  ");
        }
    }
}

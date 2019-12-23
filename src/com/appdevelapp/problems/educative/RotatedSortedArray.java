package com.appdevelapp.problems.educative;

public class RotatedSortedArray {
    static int binary_search_rotated(int[] arr,int key) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(arr[mid] == key) return mid;

            if(arr[mid] <= arr[end]){
                if(arr[mid] < key && key <= arr[end]){
                    start = mid +1;
                }
                else{
                    end = mid -1;
                }
            }
            else{
                if(arr[start] <= key && key < arr[mid]){
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}

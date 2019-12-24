package com.appdevelapp.problems.educative;

public class SearchLessThanKeyInSortedArray {
    public static int searchNearKey(int[] arr, int key){
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            int mid = (end - start) / 2 + start;

            if (arr[mid] == key) {
                return mid;
            }

            if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}

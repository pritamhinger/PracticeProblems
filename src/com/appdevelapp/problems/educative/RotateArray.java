package com.appdevelapp.problems.educative;

import java.util.List;

public class RotateArray {
    static void rotate_array_in_place(int[] arr, int k, int n) {
        k = (k % n);
        if (k < 0) {
            k = k + n;
        }

        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, arr.length - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static int find_low_index(List<Integer> arr, int key) {
        int start = 0;
        int end = arr.size() - 1;
        int minIndex = end + 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int value = arr.get(mid);
            if (arr.get(mid) == key) {
                if (minIndex > mid) {
                    minIndex = mid;
                    end = mid-1;
                }
            } else {
                if (key <= value) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        if (minIndex == arr.size()) {
            return -1;
        }

        return minIndex;
    }

    static int find_high_index(List<Integer> arr, int key) {
        int start = 0;
        int end = arr.size() - 1;
        int maxIndex = -1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int value = arr.get(mid);
            if (arr.get(mid) == key) {
                if (maxIndex < mid) {
                    maxIndex = mid;
                    start = mid+1;
                }
            } else {
                if (key <= value) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        if (maxIndex == -1) {
            return -1;
        }

        return maxIndex;
    }

    static void move_zeros_to_left_in_array(int[] A) {
        int countOfZeroes = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                countOfZeroes++;
            }
        }

        int forward = A.length - 1;
        int back = A.length - 1;
        while (forward >= 0) {
            if (A[forward] != 0) {
                A[back] = A[forward];
                back--;
            }
            forward--;
        }

        for(int i = 0; i < countOfZeroes; i++){
            A[i] = 0;
        }
    }
}

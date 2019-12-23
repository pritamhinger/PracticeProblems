package com.appdevelapp.problems.educative;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumInSlidingWindow {

    public static ArrayDeque<Integer> findMaximumInSlidingWindow(int[] arr, int windowSize){
        ArrayDeque<Integer> output = new ArrayDeque<>();
        if(arr.length <= 0 || arr.length < windowSize){
            return output;
        }

        Deque<Integer> deque = new LinkedList<Integer>();
        int startIndex = 0;
        for (int i = 0; i < windowSize; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
            startIndex = i + 1;
        }

        for (int i = startIndex; i < arr.length; i++) {
            output.add(arr[deque.peek()]);
            while (!deque.isEmpty() && deque.peekFirst() <= i - windowSize) {
                deque.remove();
            }

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(i);
        }

        output.add(arr[deque.peek()]);

        return output;
    }
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.print("Array = ");
        System.out.println(Arrays.toString(array));

        System.out.println("Max = " + findMaximumInSlidingWindow(array, 3));

        int[] array2 = { 10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67 };
        System.out.println("Array = " + Arrays.toString(array2));

        System.out.println("Max = " + findMaximumInSlidingWindow(array2, 3));

        int[] array3 = {-4,2,-5,3,6,7,3,4,-1,2};
        System.out.println("Max = " + findMaximumInSlidingWindow(array3, 3));

        int[] array4 = {-1,3,7,8,12,-3,-4,8,11,3};
        System.out.println("Max using my implementation = " + findMaximumInSlidingWindow(array3, 3));
        System.out.println("Max using my implementation = " + findMaximumInSlidingWindow(array3, 4));

    }

}
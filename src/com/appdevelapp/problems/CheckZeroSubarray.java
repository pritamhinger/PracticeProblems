package com.appdevelapp.problems;

import java.util.HashMap;

public class CheckZeroSubarray {

    public static boolean findSubZero(int[] arr) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(arr[i] == 0 || sum == 0 || map.get(sum) != null){
                return true;
            }

            map.put(sum, i);
        }

        return false;
    }
}

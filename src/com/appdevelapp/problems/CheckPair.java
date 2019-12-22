package com.appdevelapp.problems;

import java.util.HashMap;
import java.util.Map;

public class CheckPair {

    public static String findPair(int[] arr) {
        String result = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length -1 ; i++){
            for(int j = i+1; j < arr.length; j++){
                int sum = arr[i] + arr[j];
                if(map.containsKey(sum)){
                    int value = map.get(sum);
                    if(value != arr[j]){
                        // This is a separate set
                        result = "{" + value + "," + (sum-value) + "},{" + arr[i] + "," + arr[j] + "}";
                        return result;
                    }
                    else{
                        // Repeated Number
                        continue;
                    }
                }

                map.put(sum, arr[i]);
            }
        }
        return result;
    }
}

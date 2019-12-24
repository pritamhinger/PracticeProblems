package com.appdevelapp.problems.educative;

import java.util.ArrayList;

public class MergeIntervals {
    static ArrayList<Tuple<Integer, Integer>> merge_intervals(ArrayList<Tuple<Integer, Integer>> v1){
        if(v1 == null || v1.size() == 0){
            return new ArrayList<Tuple<Integer, Integer>>();
        }

        if(v1.size() == 1){
            return v1;
        }

        ArrayList<Tuple<Integer, Integer>> output = new ArrayList<>();
        Tuple<Integer, Integer> basePair = v1.get(0);
        int x = basePair.x;
        int y = basePair.y;
        Tuple<Integer, Integer> interval = null;
        for (int i = 1; i < v1.size(); i++) {
            Tuple<Integer, Integer> pair = v1.get(i);
            if(pair.x <= y){
                if(pair.y >= y){
                    y = pair.y;
                }
            }
            else{
                interval = new Tuple<>(x,y);
                output.add(interval);
                x = pair.x;
                y = pair.y;
            }
        }

        if(interval != null && interval.x != x && interval.y != y){
            interval = new Tuple<>(x,y);
            output.add(interval);
        }

        return output;
    }
}

class Tuple<X, Y> {
    public X x;
    public Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}

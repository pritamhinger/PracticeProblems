package com.appdevelapp.problems;

import java.util.*;
import java.util.Map.Entry;

public class PathTracer {
    public static String tracePath(Map<String,String> map) {

        String result = "";

        HashSet<String> sources = new HashSet<>();
        HashSet<String> destination = new HashSet<>();

        for (Entry entry : map.entrySet()) {
            sources.add(entry.getKey().toString());
            destination.add(entry.getValue().toString());
        }

        String startingPoint = "";
        for (String source: sources) {
            if(!destination.contains(source)){
                startingPoint = source;
                break;
            }
        }

        String dest = map.get(startingPoint);
        while(dest != null){
            result += startingPoint + "->" + dest + ", ";
            startingPoint = dest;
            dest = map.get(startingPoint);
        }

        return result;
    }
}

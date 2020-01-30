package com.appdevelapp.problems.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonWord {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] bannedWords = {"hit"};
        System.out.println(sol.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", bannedWords));
        String[] bannedWords1 = {""};
        System.out.println(sol.mostCommonWord("Bob", bannedWords1));
    }
}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if (banned != null && banned.length > 0) {
            for (String word : banned) {
                set.add(word.toLowerCase());
            }
        }

        StringBuilder builder = new StringBuilder();
        String word;
        for (Character ch : paragraph.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                builder.append(ch);
            }

            if (ch == ' ' || ch == '!' || ch == '?' || ch == '`' || ch == ',' || ch == ';' || ch == '.') {
                word = builder.toString();
                if (word.trim().length() != 0) {
                    String lowerWord = word.toLowerCase();
                    if (!set.contains(lowerWord)) {
                        if (map.containsKey(lowerWord)) {
                            Integer count = map.get(lowerWord);
                            map.put(lowerWord, count + 1);
                        } else {
                            map.put(lowerWord, 1);
                        }
                    }
                }

                builder = new StringBuilder();
            }
        }

        if (builder.length() > 0) {
            word = builder.toString();
            if (word.trim().length() != 0) {
                String lowerWord = word.toLowerCase();
                if (!set.contains(lowerWord)) {
                    if (map.containsKey(lowerWord)) {
                        Integer count = map.get(lowerWord);
                        map.put(lowerWord, count + 1);
                    } else {
                        map.put(lowerWord, 1);
                    }
                }
            }
        }
        int maxCount = 0;
        String result = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
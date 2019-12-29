package com.appdevelapp.problems.leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i<s.length(); i++){
            int result = lengthOfLongestSubstringHelper(s, i-1, i+1);
            if(result > maxLength){
                maxLength = result;
            }
        }

        return maxLength;
    }

    private static int lengthOfLongestSubstringHelper(String s, int left, int right){
        HashSet<Character> set = new HashSet<Character>();
        set.add(s.charAt(left+1));
        int count = 1;
        boolean leftNotMatched = false;
        boolean rightNotMatched = false;
        for(; left > 0 && right < s.length(); left--, right++){
            if(!set.contains(s.charAt(left))){
                count++;
                set.add(s.charAt(left));
            }
            else{
                leftNotMatched = true;
                break;
            }

            if(!set.contains(s.charAt(right))){
                count++;
                set.add(s.charAt(right));
            }
            else{
                rightNotMatched = true;
                break;
            }

            if(leftNotMatched && rightNotMatched){
                break;
            }
        }

        while(left >= 0){
            if(!set.contains(s.charAt(left))){
                count++;
                set.add(s.charAt(left));
            }
            else{
                break;
            }

            left--;
        }

        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                count++;
                set.add(s.charAt(right));
            }
            else{
                break;
            }

            right++;
        }

        return count;
    }
}

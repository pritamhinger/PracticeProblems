package com.appdevelapp.problems.leetcode;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {

        String maxString = "";
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            String result = longestPalindromeHelper(s, i-1, i+1);
            if(result.length() > maxLength){
                maxLength = result.length();
                maxString = result;
            }
            result = longestPalindromeHelper(s, i, i+1);
            if(result.length() > maxLength){
                maxLength = result.length();
                maxString = result;
            }
        }

        return maxString;
    }

    private static String longestPalindromeHelper(String s, int left, int right) {
        String result = "";
        for (; left >= 0 && right < s.length(); left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                if (left == right - 1) {
                    return s.substring(left, left);
                } else {
                    return s.substring(++left, right);
                }
            }
        }


        return s.substring(++left, right);
    }
}

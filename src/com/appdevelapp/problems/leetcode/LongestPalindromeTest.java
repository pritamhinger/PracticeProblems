package com.appdevelapp.problems.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    @Test
    void longestPalindrome() {
        String str = LongestPalindrome.longestPalindrome("babad");
        System.out.println("Answer 1");
        System.out.println(str);
        str = LongestPalindrome.longestPalindrome("cbbd");
        System.out.println("Answer 2");
        System.out.println(str);
    }
}
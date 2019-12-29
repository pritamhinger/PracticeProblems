package com.appdevelapp.problems.leetcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void lengthOfLongestSubstring() {
        String str = "jbpnbwwd";
        int result = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str);
        Assert.that(result == 4, "Failed");
    }
}
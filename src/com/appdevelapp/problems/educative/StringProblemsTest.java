package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProblemsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverse_words() {
        String result = StringProblems.reverse_words("Hello World..!!");
        System.out.println(result);
        result = StringProblems.reverse_words("The quick brown fox jumps over the lazy fox..!!");
        System.out.println(result);
    }

    @Test
    void remove_white_spaces() {
        String str = "    this is       some sentence  123..!!";
        StringProblems.remove_white_spaces(str.toCharArray());
    }
}
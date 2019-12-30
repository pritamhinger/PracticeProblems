package com.appdevelapp.problems.leetcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderLogFilesTest {

    ReorderLogFiles reorderLogFiles;
    @BeforeEach
    void setUp() {
        reorderLogFiles = new ReorderLogFiles();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reorderLogFiles() {
        String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        input = reorderLogFiles.reorderLogFiles(input);

    }
}
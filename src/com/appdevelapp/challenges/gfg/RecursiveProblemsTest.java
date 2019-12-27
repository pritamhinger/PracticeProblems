package com.appdevelapp.challenges.gfg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveProblemsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void factorial_recursive() {
        Assert.that(RecursiveProblems.factorial_recursive(5) == 120, "Failed");
    }

    @Test
    void fibbonachi() {
        Assert.that(RecursiveProblems.fibbonachi(6) == 13, "Failed");
    }
}
package com.appdevelapp.problems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class CheckPairTest {

    @BeforeEach
    void setUp() {


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findPair() {
        String result = CheckPair.findPair(new int[]{3, 4, 7, 1, 12, 9});
        System.out.println(result);
        Assert.that(result.equals("{4,12},{7,9}"), "Failed");
    }
}
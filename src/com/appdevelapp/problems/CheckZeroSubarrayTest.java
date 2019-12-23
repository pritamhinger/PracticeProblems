package com.appdevelapp.problems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class CheckZeroSubarrayTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findSubZero() {
        Assert.that(CheckZeroSubarray.findSubZero(new int[] {6,4,-7,3,12,9}), "Failed");
        Assert.that(!CheckZeroSubarray.findSubZero(new int[] {6,4,-7,5, 12,9}), "Failed");
        Assert.that(CheckZeroSubarray.findSubZero(new int[] {6,4,-7,5,-2, 12,9}), "Failed");
    }
}
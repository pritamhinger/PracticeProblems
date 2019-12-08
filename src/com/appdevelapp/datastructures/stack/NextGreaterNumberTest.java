package com.appdevelapp.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class NextGreaterNumberTest {

    int arr[];
    @BeforeEach
    void setUp() {
        arr = new int[]{4,6,3,2,8,1};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void nextGreaterElement() throws Exception {
        arr = NextGreaterNumber.nextGreaterElement(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        Assert.that(arr.length == 6, "Failed");
    }
}
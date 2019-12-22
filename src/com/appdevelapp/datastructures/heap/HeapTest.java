package com.appdevelapp.datastructures.heap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    int[] heapArray;
    @BeforeEach
    void setUp() {
        heapArray = new int[]{ 1, 4, 7, 12, 15, 14, 9, -2, 3, 16 };
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buildMaxHeap() {
        Assert.that(heapArray[0] == 1, "Failed");
        new Heap().buildMaxHeap(heapArray, heapArray.length);
        Assert.that(heapArray[0] == 16, "Failed");
    }

    @Test
    void buildMinHeap() {
        Assert.that(heapArray[0] == 1, "Failed");
        new Heap().buildMinHeap(heapArray, heapArray.length);
        Assert.that(heapArray[0] == -2, "Failed");

        String result = "";
        for (int num:heapArray) {
            result += num + ",";
        }

        result = result.substring(0, result.length()-1);
        System.out.println("[" + result + "]");

    }
}
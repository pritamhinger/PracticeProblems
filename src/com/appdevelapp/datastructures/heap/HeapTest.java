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
        heapArray = new int[]{1, 4, 7, 12, 15, 14, 9, -2, 3, 16};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buildMaxHeap() {
        Assert.that(heapArray[0] == 1, "Failed");
        Heap.buildMaxHeap(heapArray, heapArray.length);
        Assert.that(heapArray[0] == 16, "Failed");
    }

    @Test
    void buildMinHeap() {
        Assert.that(heapArray[0] == 1, "Failed");
        Heap.buildMinHeap(heapArray, heapArray.length);
        Assert.that(heapArray[0] == -2, "Failed");
        String result = "";
        for (int num : heapArray) {
            result += num + ",";
        }

        result = result.substring(0, result.length() - 1);
        System.out.println("[" + result + "]");
    }

    @Test
    void findKSmallest() {
        int[] result = Heap.findKSmallest(heapArray, 10);
        Assert.that(result[0] == -2, "Failed");
        Assert.that(result[1] == 1, "Failed");
        Assert.that(result[2] == 3, "Failed");
        Assert.that(result[3] == 4, "Failed");
        System.out.println(Arrays.toString(result));

        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    @Test
    void findKLargest() {
        int[] result = Heap.findKLargest(heapArray, 10);
        Assert.that(result[0] == 16, "Failed");
        Assert.that(result[1] == 15, "Failed");
        Assert.that(result[2] == 14, "Failed");
        Assert.that(result[3] == 12, "Failed");
        System.out.println(Arrays.toString(result));

        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
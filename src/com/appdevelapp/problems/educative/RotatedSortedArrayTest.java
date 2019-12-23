package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotatedSortedArrayTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void binary_search_rotated() {
        int[] array1 = {176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162};
        int index = RotatedSortedArray.binary_search_rotated(array1, 200);
        if (index >= 0) {   
            System.out.println("Value is " + array1[index]);
        } else {
            System.out.println("Couldn't find the key");
        }
    }
}
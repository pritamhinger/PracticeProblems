package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    List<Integer> array;
    @BeforeEach
    void setUp() {
        array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(5);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(7);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rotate_array_in_place() {
        int[] array = {1,2,3,4,5,6,7,8};
        RotateArray.rotate_array_in_place(array, 3, array.length);
        Assert.that(array[0] == 6, "Failed");
        RotateArray.rotate_array_in_place(array, -3, array.length);
        Assert.that(array[0] == 1, "Failed");
        RotateArray.rotate_array_in_place(array, -10, array.length);
        Assert.that(array[0] == 3, "Failed");
    }

    @Test
    void find_low_index() {
        int index = RotateArray.find_low_index(array, 5);
        Assert.that(index == 3, "Failed");
        index = RotateArray.find_low_index(array, 7);
        Assert.that(index == 6, "Failed");
        index = RotateArray.find_low_index(array, 4);
        Assert.that(index == -1, "Failed");
    }

    @Test
    void find_high_index() {
        int index = RotateArray.find_high_index(array, 5);
        Assert.that(index == 4, "Failed");
        index = RotateArray.find_high_index(array, 7);
        Assert.that(index == 7, "Failed");
        index = RotateArray.find_high_index(array, 4);
        Assert.that(index == -1, "Failed");
    }

    @Test
    void move_zeros_to_left_in_array() {
        int[] array1 = {1,10,20,0,59,63,0,88,0};
        RotateArray.move_zeros_to_left_in_array(array1);
        System.out.println(Arrays.toString(array1));
        Assert.that(array1[0] == 0, "Failed");
        Assert.that(array1[array1.length-1] == 88, "Failed");
    }
}
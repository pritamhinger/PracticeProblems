package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class SearchLessThanKeyInSortedArrayTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void searchNearKey() {
        int[] array = {2,4,6,8,10,12,16,18};
        int index = SearchLessThanKeyInSortedArray.searchNearKey(array, 3);
        Assert.that(index == 0, "Failed");

        index = SearchLessThanKeyInSortedArray.searchNearKey(array, 11);
        Assert.that(index == 4, "Failed");
        index = SearchLessThanKeyInSortedArray.searchNearKey(array, 10);
        Assert.that(index == 4, "Failed");

        index = SearchLessThanKeyInSortedArray.searchNearKey(array, 22);
        Assert.that(index == 7, "Failed");
    }
}
package com.appdevelapp.datastructures.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findBin() throws Exception {
        String[] result = Queue.findBin(3);
        for (String str: result) {
            System.out.println(str);
        }
        Assert.that(result[0] == "1", "Failed");

        result = Queue.findBin(10);
        for (String str: result) {
            System.out.println(str);
        }
    }
}
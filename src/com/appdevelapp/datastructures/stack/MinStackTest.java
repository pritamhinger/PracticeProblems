package com.appdevelapp.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void minStackTests(){
        MinStack stack = new MinStack(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(9);

        Assert.that(stack.min() == 1, "Failed");
        Assert.that(stack.pop() == 9, "failed");

    }
}
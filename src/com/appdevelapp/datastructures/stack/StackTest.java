package com.appdevelapp.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> stack;
    @BeforeEach
    void setUp() throws Exception {
        stack = new Stack<>(6);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void sortStack() throws Exception {
        Stack.sortStack(stack);
        Assert.that(stack.top() == 2, "Failed");
        for (int i = 0; i < stack.getCapacity(); i++) {
            System.out.println(stack.pop().toString());
        }
    }
}
package com.appdevelapp.datastructures.stack;

import com.appdevelapp.datastructures.queue.Queue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class ReverseKItemsInQueueTest {

    Queue<Integer> queue;
    @BeforeEach
    void setUp() throws Exception {
        queue = new Queue<>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverseK() throws Exception {
        ReverseKItemsInQueue.reverseK(queue, 9);
        for (int i = 0; i < queue.getMaxSize(); i++) {
            System.out.println(queue.dequeue().toString());
        }

        Assert.that(queue.getMaxSize() == 10, "Failed");
    }
}
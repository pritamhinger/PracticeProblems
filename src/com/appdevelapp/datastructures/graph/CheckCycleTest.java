package com.appdevelapp.datastructures.graph;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class CheckCycleTest {

    Graph graph;
    @BeforeEach
    void setUp() {
        graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(4,2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void detectCycle() throws Exception {
        Assert.that(CheckCycle.detectCycle(graph), "Failed");
    }
}
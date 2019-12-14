package com.appdevelapp.datastructures.graph;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KosarajuAlgorithmTest {

    Graph graph;
    @BeforeEach
    void setUp() {
        graph = new Graph(9);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,0);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,4);
        graph.addEdge(7,6);
        graph.addEdge(7,8);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void printSCC() throws Exception {
        KosarajuAlgorithm.PrintSCC(graph);
    }
}
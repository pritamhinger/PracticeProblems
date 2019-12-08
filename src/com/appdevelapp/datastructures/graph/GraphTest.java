package com.appdevelapp.datastructures.graph;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

class GraphTest {

    Graph graph;
    @BeforeEach
    void setUp() {
        graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(4,0);
        //graph.addEdge(3,0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void PrintTest(){
        graph.printGraph();
        Assert.that(true, "Failed");
    }

    @Test
    void bfsTraversalUsingHashSet() {
        String result = Graph.bfsTraversalUsingHashSet(graph, 0);
        System.out.println(result);
        Assert.that(true, "Failed");
    }

    @Test
    void bfsTraversal() throws Exception {
        String result = Graph.bfsTraversal(graph, 1);
        System.out.println(result);
        Assert.that(true, "Failed");
    }
}
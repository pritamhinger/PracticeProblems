package com.appdevelapp.datastructures.graph;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class MotherVertexInGraphTest {

    Graph graph;
    Graph otherGraph;
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

        otherGraph = new Graph(9);
        otherGraph.addEdge(3,1);
        otherGraph.addEdge(1,2);
        otherGraph.addEdge(2,0);
        otherGraph.addEdge(3,0);
        otherGraph.addEdge(2,4);
        otherGraph.addEdge(4,5);
        otherGraph.addEdge(5,6);
        otherGraph.addEdge(6,4);
        otherGraph.addEdge(4,8);
        otherGraph.addEdge(8,7);
        otherGraph.addEdge(7,6);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMotherVertex() {
        MotherVertexInGraph motherVertexInGraph = new MotherVertexInGraph(graph);
        int motherVertex = motherVertexInGraph.GetMotherVertex();
        System.out.println(motherVertex);
        Assert.that(motherVertex == -1, "Failed");

        motherVertexInGraph = new MotherVertexInGraph(otherGraph);
        motherVertex = motherVertexInGraph.GetMotherVertex();
        System.out.println(motherVertex);
        Assert.that(motherVertex==3, "Failed");
    }
}
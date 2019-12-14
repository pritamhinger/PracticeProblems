package com.appdevelapp.datastructures.graph;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

class GraphTest {

    Graph graph;

    Graph tree1;
    Graph tree2;

    @BeforeEach
    void setUp() {
        graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(4,0);
        //graph.addEdge(3,0);

        tree1 = new Graph(15);
        tree1.addEdge(0,1);
        tree1.addEdge(0,2);
        tree1.addEdge(1,3);
        tree1.addEdge(1,4);
        tree1.addEdge(2,5);
        tree1.addEdge(2,6);
        tree1.addEdge(3,7);
        tree1.addEdge(3,8);
        tree1.addEdge(4,9);
        tree1.addEdge(4,10);
        tree1.addEdge(5,11);
        tree1.addEdge(5,12);
        tree1.addEdge(6,13);
        tree1.addEdge(6,14);

        tree2 = new Graph(4);
        tree2.addEdge(0,1);
        tree2.addEdge(0,2);
        tree2.addEdge(0,3);
        tree2.addEdge(3,2);
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

    @Test
    void dfsTraversal() throws Exception {
        String result = Graph.dfsTraversal(graph, 0);
        System.out.println(result);
        Assert.that(true, "Failed");
    }

    @Test
    void isTree() {
        Assert.that(Graph.IsTree(tree1), "Failed");
        Assert.that(!Graph.IsTree(tree2), "Failed");
    }
}
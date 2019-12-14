package com.appdevelapp.datastructures.graph;

import com.appdevelapp.datastructures.linkedlist.DLLNode;
import com.appdevelapp.datastructures.linkedlist.DoublyLinkedList;
import com.appdevelapp.datastructures.stack.Stack;

public class KosarajuAlgorithm {

    public static void PrintSCC(Graph g) throws Exception {
        boolean[] visitedNodes = new boolean[g.vertices];
        Stack<Integer> stack = new Stack<>(g.vertices);
        for (int i = 0; i < g.vertices; i++) {
            if(!visitedNodes[i]){
                FillVertexOrder(g, i, visitedNodes, stack);
            }
        }

        Graph transposedGraph = GetTransposeGraph(g);
        visitedNodes = new boolean[g.vertices];

        while (!stack.isEmpty()){
            Integer currentVertex = stack.pop();
            if(!visitedNodes[currentVertex]){
                DFSUtil(transposedGraph,currentVertex, visitedNodes);
                System.out.println();
            }
        }
    }

    public static void FillVertexOrder(Graph graph, int vertex, boolean[] visitedNodes, Stack<Integer> stack) throws Exception {
        visitedNodes[vertex] = true;
        DoublyLinkedList<Integer> neighbourList = graph.adjacencyList[vertex];
        if(neighbourList != null){
            DLLNode<Integer> tempNode = neighbourList.GetHeadNode();
            while (tempNode != null){
                if(!visitedNodes[tempNode.data]){
                    FillVertexOrder(graph, tempNode.data, visitedNodes, stack);
                }

                tempNode = tempNode.nextNode;
            }

            stack.push(vertex);
        }
    }

    public static Graph GetTransposeGraph(Graph graph){
        Graph transposedGraph = new Graph(graph.vertices);
        for (int i = 0; i < graph.vertices; i++) {
            DoublyLinkedList<Integer> neighbourList = graph.adjacencyList[i];
            if(neighbourList != null){
                DLLNode<Integer> tempNode = neighbourList.GetHeadNode();
                while (tempNode != null){
                    transposedGraph.addEdge(tempNode.data, i);
                    tempNode = tempNode.nextNode;
                }

            }
        }

        return transposedGraph;
    }

    private static void DFSUtil(Graph graph, int vertex, boolean[] visitedNodes){
        visitedNodes[vertex] = true;
        System.out.print(vertex + " -> ");
        DoublyLinkedList<Integer> neighbourList = graph.adjacencyList[vertex];
        if(neighbourList != null){
            DLLNode<Integer> tempNode = neighbourList.GetHeadNode();
            while (tempNode != null){
                if(!visitedNodes[tempNode.data]){
                    DFSUtil(graph, tempNode.data, visitedNodes);
                }

                tempNode = tempNode.nextNode;
            }

        }
    }
}

package com.appdevelapp.datastructures.graph;

import com.appdevelapp.datastructures.linkedlist.DLLNode;
import com.appdevelapp.datastructures.linkedlist.DoublyLinkedList;

public class MotherVertexInGraph {
    private Graph graph;
    public MotherVertexInGraph(Graph graph){
        this.graph = graph;
    }

    public int GetMotherVertex() {
        boolean[] visited = new boolean[this.graph.vertices];
        int lastVertex = -1;
        for (int i = 0; i < this.graph.vertices; i++) {
            if (!visited[i]) {
                visited = DFSTraversal(i, visited);
                lastVertex = i;
            }
        }

        visited = new boolean[graph.vertices];
        visited = DFSTraversal(lastVertex, visited);
        for (boolean isNodeVisited : visited) {
            if(!isNodeVisited){
                return -1;
            }
        }

        return lastVertex;
    }

    private boolean[] DFSTraversal(int vertex, boolean[] visitedNodes){
        visitedNodes[vertex] = true;
        DoublyLinkedList<Integer> neighbourList = graph.adjacencyList[vertex];
        if(neighbourList != null){
            DLLNode<Integer> tempNode = neighbourList.GetHeadNode();
            while (tempNode != null){
                if(!visitedNodes[tempNode.data]){
                    visitedNodes = DFSTraversal(tempNode.data, visitedNodes);
                }

                tempNode = tempNode.nextNode;
            }
        }
        return visitedNodes;
    }
}

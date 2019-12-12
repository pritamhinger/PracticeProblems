package com.appdevelapp.datastructures.graph;

import com.appdevelapp.datastructures.linkedlist.DLLNode;
import com.appdevelapp.datastructures.linkedlist.DoublyLinkedList;
import com.appdevelapp.datastructures.stack.Stack;

public class CheckCycle {
    public static boolean detectCycle(Graph g) throws Exception {
        // Write -- Your -- Code
        boolean[] nodeStack = new boolean[g.vertices];
        boolean[] visited = new boolean[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            if (CheckIfCycle(g, i, visited, nodeStack)) {
                return true;
            }
        }

        return false;
    }

    public static int findMotherVertex(Graph g) throws Exception {
        for (int i = 0; i < g.vertices; i++) {
            if(checkIfAllNodesVisited(ModifiedDFS(g, i))){
                return i;
            }
        }

        return -1;
    }

    private static boolean[] ModifiedDFS(Graph g, int source) throws Exception {
        boolean[] visitedNodes = new boolean[g.vertices];
        visitedNodes[source] = true;
        Stack<Integer> stack = new Stack(g.vertices);
        stack.push(source);

        while (!stack.isEmpty()){
            int currentVertex = stack.pop();
            DoublyLinkedList<Integer> neighbourVertexList = g.adjacencyList[currentVertex];
            if(neighbourVertexList != null){
                DLLNode<Integer> neighbourVertex = neighbourVertexList.GetHeadNode();
                while (neighbourVertex != null){
                    if(!visitedNodes[neighbourVertex.data]){
                        stack.push(neighbourVertex.data);
                        visitedNodes[neighbourVertex.data] = true;
                    }
                    neighbourVertex = neighbourVertex.nextNode;
                }
            }
        }

        return  visitedNodes;
    }

    private static boolean checkIfAllNodesVisited(boolean[] visitedNodes){
        for (boolean currentStatus: visitedNodes) {
            if(!currentStatus){
                return false;
            }
        }

        return true;
    }

    private static boolean CheckIfCycle(Graph g, int source, boolean[] visited, boolean[] nodeStack) throws Exception {

        if (nodeStack[source]) {
            return true;
        }

        if (visited[source]) {
            return false;
        }

        visited[source] = true;
        nodeStack[source] = true;

        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);
        DoublyLinkedList<Integer> list = g.adjacencyList[source];
        if (list != null) {
            DLLNode<Integer> tempNode = list.GetHeadNode();
            while (tempNode != null) {
                if(CheckIfCycle(g, tempNode.data, visited, nodeStack)){
                    return true;
                }
                tempNode = tempNode.nextNode;
            }

            nodeStack[source] = false;
        }

        return false;
    }
}
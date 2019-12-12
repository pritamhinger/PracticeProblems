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
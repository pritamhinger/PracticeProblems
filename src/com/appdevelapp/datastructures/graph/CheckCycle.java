package com.appdevelapp.datastructures.graph;

import com.appdevelapp.datastructures.linkedlist.DLLNode;
import com.appdevelapp.datastructures.linkedlist.DoublyLinkedList;
import com.appdevelapp.datastructures.stack.Stack;

public class CheckCycle {
    public static boolean detectCycle(Graph g) throws Exception {
        // Write -- Your -- Code
        for (int i = 0; i < g.vertices; i++) {
            if(CheckIfCycle(g,i)){
                return true;
            }
        }

        return false;
    }

    private static boolean CheckIfCycle(Graph g, int source) throws Exception {
        boolean[] visited = new boolean[g.vertices];
        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(visited[vertex]){
                return true;
            }

            visited[vertex] = true;
            DoublyLinkedList<Integer> list = g.adjacencyList[vertex];
            if(list != null){
                DLLNode<Integer> tempNode = list.GetHeadNode();
                if(tempNode != null){
                    if(visited[tempNode.data]){
                        return true;
                    }

                    stack.push(tempNode.data);
                    tempNode = tempNode.nextNode;
                }
            }
        }

        return false;
    }
}

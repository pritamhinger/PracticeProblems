package com.appdevelapp.datastructures.graph;

import com.appdevelapp.datastructures.linkedlist.DLLNode;
import com.appdevelapp.datastructures.linkedlist.DoublyLinkedList;
import com.appdevelapp.datastructures.queue.Queue;
import com.appdevelapp.datastructures.stack.Stack;

import java.util.HashSet;

public class Graph {

    //Total number of vertices in graph
    int vertices;

    //An array of linked lists to store adjacent vertices.
    DoublyLinkedList<Integer> adjacencyList[];

    public Graph(int size){
        vertices = size;
        adjacencyList = new DoublyLinkedList[size];

        for (int i = 0; i < size; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    //Prints Graph (Adjacency List)
    void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++) {
            DoublyLinkedList list = adjacencyList[i];
            if(!list.IsEmpty()){
                System.out.print("| " + i + " | => ");
                DLLNode tempNode = list.GetHeadNode();
                while (tempNode != null){
                    System.out.print("[" + tempNode.data + "] -> ");
                    tempNode = tempNode.nextNode;
                }

                System.out.println("NULL");
            }
            else{
                System.out.println("| " + i + " | => NULL");
            }
        }
    }

    //Adds an Edge from source vertex to destination vertex
    void addEdge(int source, int destination) {
        if(source >= vertices){
            return;
        }

        this.adjacencyList[source].InsertAtEnd(destination);
    }

    public static String bfsTraversal(Graph g, int source) throws Exception {
        String result = "";
        int num_of_vertices = g.vertices;
        boolean[] visitedNodes = new boolean[num_of_vertices];
        Queue<Integer> queue = new Queue<>(num_of_vertices);
        queue.enqueue(source);
        visitedNodes[source] = true;

        while (!queue.isEmpty()){

            Integer currentVertexData = queue.dequeue();
            result += String.valueOf(currentVertexData);

            DoublyLinkedList vertex = g.adjacencyList[currentVertexData];
            if(vertex.GetHeadNode() != null){
                DLLNode<Integer> currentVertex = vertex.GetHeadNode();
                while (currentVertex != null){
                    if(!visitedNodes[currentVertex.data]){
                        queue.enqueue(currentVertex.data);
                        visitedNodes[currentVertex.data] = true;
                    }

                    currentVertex = currentVertex.nextNode;
                }
            }
        }
        return result;
    }

    public static String bfsTraversalUsingHashSet(Graph g, int source) {
        String result = "";
        int num_of_vertices = g.vertices;
        if (num_of_vertices <= 0) {
            return "";
        }

        HashSet<Integer> visitedNodes = new HashSet<>();
        for (int i = 0; i < num_of_vertices; i++) {
            DoublyLinkedList<Integer> currentVertex = g.adjacencyList[i];
            if(!visitedNodes.contains(i)) {
                visitedNodes.add(i);
                result += i;
            }
            if (currentVertex.GetHeadNode() != null) {
                DLLNode<Integer> tempNode = currentVertex.GetHeadNode();
                while (tempNode != null) {
                    if(!visitedNodes.contains(tempNode.data)) {
                        result += tempNode.data.toString();
                        visitedNodes.add(tempNode.data);
                    }

                    tempNode = tempNode.nextNode;
                }
            }
        }
        // Write - Your - Code
        return result; //For the above graph, it should return "01234" or "02143"
    }

    public static String dfsTraversal(Graph g, int source) throws Exception {
        String result = "";
        int num_of_vertices = g.vertices;
        boolean[] visitedNodes = new boolean[num_of_vertices];
        Stack<Integer> stack = new Stack<>(num_of_vertices);
        stack.push(source);

        while (!stack.isEmpty()){
            Integer value = stack.pop();
            result += String.valueOf(value);
            visitedNodes[value] = true;

            DoublyLinkedList currentVertex = g.adjacencyList[value];
            if (currentVertex.GetHeadNode() != null){
                DLLNode<Integer> vertex = currentVertex.GetHeadNode();
                while (vertex != null){
                    if(!visitedNodes[vertex.data]){
                        stack.push(vertex.data);
                    }

                    vertex = vertex.nextNode;
                }
            }
        }

        return result;
    }

    public static int numEdges(Graph g) {
        int numberOfEdges = 0;
        for (int i = 0; i < g.vertices; i++) {
            DoublyLinkedList<Integer> neighbourList = g.adjacencyList[i];
            if (neighbourList != null) {
                numberOfEdges += neighbourList.Size();
            }
        }

        return numberOfEdges;
    }

    public static boolean CheckPath(Graph graph, int source, int destination){
        boolean[] visitedNodes = new boolean[graph.vertices];
        visitedNodes = DFSTraversalForNode(graph, source, visitedNodes);
        return visitedNodes[destination];
    }

    private static boolean[] DFSTraversalForNode(Graph graph, int vertex, boolean[] visitedNodes){
        visitedNodes[vertex] = true;
        DoublyLinkedList<Integer> neighbourList = graph.adjacencyList[vertex];
        if(neighbourList != null){
            DLLNode<Integer> tempNode = neighbourList.GetHeadNode();
            while (tempNode != null){
                if(!visitedNodes[tempNode.data]){
                    visitedNodes = DFSTraversalForNode(graph, tempNode.data, visitedNodes);
                }

                tempNode = tempNode.nextNode;
            }
        }

        return visitedNodes;
    }

    public static boolean IsTree(Graph graph){
        boolean[] visitedNodes = new boolean[graph.vertices];
        return  IsTreeUtil(graph, 0, visitedNodes);
    }

    private  static  boolean IsTreeUtil(Graph graph, int vertex, boolean[] visitedNodes){
        if(visitedNodes[vertex]){
            return false;
        }

        visitedNodes[vertex] = true;
        DoublyLinkedList<Integer> neighbourList = graph.adjacencyList[vertex];
        if (neighbourList != null){
            DLLNode<Integer> tempNode = neighbourList.GetHeadNode();
            while (tempNode != null){
                if(visitedNodes[tempNode.data]){
                    return false;
                }
                else{
                    boolean result = IsTreeUtil(graph, tempNode.data, visitedNodes);
                    if(!result){
                        return false;
                    }
                }

                tempNode = tempNode.nextNode;
            }
        }

        return true;
    }
}

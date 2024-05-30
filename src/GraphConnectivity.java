/*
Posadas, Tracy Angelo T.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/

/*Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
and find the number of connected components if it is not connected.*/
import java.util.*;

public class GraphConnectivity {
    private int vertices;
    private List<List<Integer>> adjList;

    public GraphConnectivity(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    private void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        DFS(0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    public int countConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        int count = 0;
        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {
                DFS(v, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},   // Cycle (connected)
            {{0, 1}, {1, 2}, {3, 4}},           // Two components
            {{0, 1}, {1, 2}, {2, 3}},           // Linear (connected)
            {{0, 1}, {2, 3}, {4, 5}},           // Three components
            {{0, 1}, {1, 2}, {2, 0}, {3, 4}},   // One component and an isolated pair
        };

        int[] vertices = {4, 5, 4, 6, 5};

        for (int i = 0; i < testCases.length; i++) {
            GraphConnectivity graph = new GraphConnectivity(vertices[i]);
            for (int[] edge : testCases[i]) {
                graph.addEdge(edge[0], edge[1]);
            }
            System.out.println("Graph " + (i + 1) + " is connected: " + graph.isConnected());
            System.out.println("Connected components: " + graph.countConnectedComponents());
        }
        System.out.println("Tracy Angelo Posadas");
    }
}

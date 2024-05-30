/*
Posadas, Tracy Angelo T.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/

/*Write a java program that receives the vertex pairs associated to the edges of a graph, the program should construct an
adjacency matrix for the graph. (Produce a version that works when loops, multiple edges, or directed edges are present.)*/

import java.util.*;

public class AdjacencyMatrix {

    public static int[][] constructAdjacencyMatrix(List<int[]> edges, int vertices) {
        int[][] adjacencyMatrix = new int[vertices][vertices];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacencyMatrix[u][v]++; // For undirected graph
            adjacencyMatrix[v][u]++; // For undirected graph
        }

        return adjacencyMatrix;
    }

    public static void main(String[] args) {
        List<List<int[]>> testCases = Arrays.asList(
            Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}),
            Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{0, 1}, new int[]{1, 2}),
            Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{1, 3}),
            Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{0, 0}), // Loop
            Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{1, 0}, new int[]{2, 0}) // Directed edge
        );

        for (int i = 0; i < testCases.size(); i++) {
            List<int[]> edges = testCases.get(i);
            int vertices = edges.stream().flatMapToInt(Arrays::stream).max().getAsInt() + 1;

            int[][] adjacencyMatrix = constructAdjacencyMatrix(edges, vertices);

            System.out.println("Graph " + (i + 1) + " Adjacency Matrix:");
            for (int[] row : adjacencyMatrix) {
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

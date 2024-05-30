/*
Posadas, Tracy Angelo T.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/

/*Write a java program that accepts vertex pairs associated to the edges of an undirected graph and the number of times
each edge appears. The program should construct an incidence matrix for the graph.*/

import java.util.*;

public class IncidenceMatrix {

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
            int maxVertex = 0;
            for (int[] edge : edges) {
                maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
            }
            int vertices = maxVertex + 1;

            int[] edgeCounts = new int[edges.size()];
            Arrays.fill(edgeCounts, 1);

            int[][] incidenceMatrix = constructIncidenceMatrix(edges, vertices, edgeCounts);

            System.out.println("Incidence Matrix for Test Case " + (i + 1) + ":");
            for (int[] row : incidenceMatrix) {
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int[][] constructIncidenceMatrix(List<int[]> edges, int vertices, int[] edgeCounts) {
        int numEdges = edges.size();
        int[][] incidenceMatrix = new int[vertices][numEdges];

        for (int i = 0; i < numEdges; i++) {
            int[] edge = edges.get(i);
            int u = edge[0], v = edge[1];
            incidenceMatrix[u][i] = edgeCounts[i];
            incidenceMatrix[v][i] = edgeCounts[i];
        }

        return incidenceMatrix;
    }
}

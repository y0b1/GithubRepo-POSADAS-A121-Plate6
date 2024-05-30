/*
Posadas, Tracy Angelo T.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/

/*Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this graph and give
the number of times each edge appears.*/
import java.util.*;

public class GraphEdges {
    public static void main(String[] args) {
        int[][][] testCases = {
            {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
            },
            {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
            },
            {
                {0, 2, 0, 0},
                {2, 0, 3, 0},
                {0, 3, 0, 1},
                {0, 0, 1, 0}
            },
            {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
            },
            {
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 0, 1, 0}
            }
        };

        for (int k = 0; k < testCases.length; k++) {
            int[][] adjacencyMatrix = testCases[k];
            Map<String, Integer> edgeCount = new HashMap<>();
            int vertices = adjacencyMatrix.length;

            for (int i = 0; i < vertices; i++) {
                for (int j = i + 1; j < vertices; j++) {
                    if (adjacencyMatrix[i][j] > 0) {
                        String edge = i + "-" + j;
                        edgeCount.put(edge, adjacencyMatrix[i][j]);
                    }
                }
            }

            System.out.println("Graph " + (k + 1) + " Edges and counts:");
            for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
                System.out.println(entry.getKey() + " appears " + entry.getValue() + " time(s)");
            }
            System.out.println();
        }
        System.out.println("Tracy Angelo Posadas");
    }
}

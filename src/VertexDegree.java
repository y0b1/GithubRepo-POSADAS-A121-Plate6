/*
Posadas, Tracy Angelo T.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/

/*Write a java program, given the pair of vertex associated to the edges of an undirected graph, it will output the degree of
vertex.*/

import java.util.*;

public class VertexDegree {

    public static void main(String[] args) {
        int[][][] testCases = {
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}},
            {{0, 1}, {0, 2}, {0, 3}, {0, 4}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {1, 4}},
            {{0, 1}, {1, 2}, {2, 0}}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[][] edges = testCases[i];
            Map<Integer, Integer> degreeMap = new HashMap<>();

            for (int[] edge : edges) {
                for (int vertex : edge) {
                    degreeMap.put(vertex, degreeMap.getOrDefault(vertex, 0) + 1);
                }
            }

            System.out.println("Graph " + (i + 1) + " Vertex Degrees:");
            for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
                System.out.println("Vertex " + entry.getKey() + " degree: " + entry.getValue());
            }
            System.out.println();
        }
    }
}

/*
Posadas, Tracy Angelo T.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/

//Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices.

import java.util.*;

public class GraphIsomorphism {

    public static void main(String[] args) {
        int[][] graph1 = {{0, 1, 0, 0}, {1, 0, 1, 0}, {0, 1, 0, 1}, {0, 0, 1, 0}};
        int[][] graph2 = {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 0}, {1, 0, 0, 0}};

        int[][] graph3 = {{0, 1, 1}, {1, 0, 0}, {1, 0, 0}};
        int[][] graph4 = {{0, 0, 1}, {0, 0, 1}, {1, 1, 0}};

        int[][] graph5 = {{0, 1, 0, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 1, 1, 0}};
        int[][] graph6 = {{0, 1, 0, 1}, {1, 0, 0, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}};

        int[][] graph7 = {{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}};
        int[][] graph8 = {{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}};

        int[][] graph9 = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
        int[][] graph10 = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};

        boolean isIsomorphic1 = checkIsomorphism(graph1, graph2);
        boolean isIsomorphic2 = checkIsomorphism(graph3, graph4);
        boolean isIsomorphic3 = checkIsomorphism(graph5, graph6);
        boolean isIsomorphic4 = checkIsomorphism(graph7, graph8);
        boolean isIsomorphic5 = checkIsomorphism(graph9, graph10);

        System.out.println("Graph 1 and Graph 2 are " + (isIsomorphic1 ? "" : "not ") + "isomorphic.");
        System.out.println("Graph 3 and Graph 4 are " + (isIsomorphic2 ? "" : "not ") + "isomorphic.");
        System.out.println("Graph 5 and Graph 6 are " + (isIsomorphic3 ? "" : "not ") + "isomorphic.");
        System.out.println("Graph 7 and Graph 8 are " + (isIsomorphic4 ? "" : "not ") + "isomorphic.");
        System.out.println("Graph 9 and Graph 10 are " + (isIsomorphic5 ? "" : "not ") + "isomorphic.");
    }

    public static boolean checkIsomorphism(int[][] graph1, int[][] graph2) {
        int vertices1 = graph1.length;
        int vertices2 = graph2.length;

        if (vertices1 != vertices2) {
            return false;
        }

        int edges1 = countEdges(graph1);
        int edges2 = countEdges(graph2);

        if (edges1 != edges2) {
            return false;
        }

        int[] degrees1 = calculateDegrees(graph1);
        int[] degrees2 = calculateDegrees(graph2);

        Arrays.sort(degrees1);
        Arrays.sort(degrees2);

        return Arrays.equals(degrees1, degrees2);
    }

    public static int countEdges(int[][] graph) {
        int edges = 0;
        int vertices = graph.length;

        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                edges += graph[i][j];
            }
        }

        return edges;
    }

    public static int[] calculateDegrees(int[][] graph) {
        int vertices = graph.length;
        int[] degrees = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                degrees[i] += graph[i][j];
            }
        }

        return degrees;
    }
}

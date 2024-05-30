/*
Posadas, Tracy Angelo T.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/

//Write a java program that receives a list of edges of a simple graph and determine whether the graph is bipartite.

import java.util.*;

public class BipartiteGraph {

    public static boolean isBipartite(List<int[]> edges, int vertices) {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1 && !dfs(edges, color, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<int[]> edges, int[] color, int vertex, int currentColor) {
        color[vertex] = currentColor;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (u == vertex || v == vertex) {
                int neighbor = (u == vertex) ? v : u;
                if (color[neighbor] == -1) {
                    if (!dfs(edges, color, neighbor, 1 - currentColor)) {
                        return false;
                    }
                } else if (color[neighbor] == color[vertex]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<int[]>> testCases = new ArrayList<>();
        testCases.add(Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}));
        testCases.add(Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{0, 4}));
        testCases.add(Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}));
        testCases.add(Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 0}));
        testCases.add(Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4}, new int[]{1, 5}, new int[]{2, 6}));

        for (int i = 0; i < testCases.size(); i++) {
            List<int[]> edges = testCases.get(i);
            int maxVertex = 0;
            for (int[] edge : edges) {
                maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
            }
            int vertices = maxVertex + 1;

            System.out.println("Graph " + (i + 1) + " is bipartite: " + isBipartite(edges, vertices));
        }
    }
}


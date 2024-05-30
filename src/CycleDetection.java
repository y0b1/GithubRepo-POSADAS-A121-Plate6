/*
Posadas, Tracy Angelo T.
BSCS - A121
CS110-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 8 (May 19-26, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
*/

//Write a java program that will determine if a graph has a cycle or not

public class CycleDetection {

    public static boolean hasCycle(int[][] adjacencyMatrix) {
        int vertices = adjacencyMatrix.length;
        boolean[] visited = new boolean[vertices];

        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {
                if (dfs(v, visited, -1, adjacencyMatrix)) {
                    return true;
                }
            }
        }
        return false;
    }
    //DFS traversal explores the Graph and marks vertices as visited. A cycle is detected when the current vertex has an adjacent vertex that has already been visited.
    private static boolean dfs(int v, boolean[] visited, int parent, int[][] adjacencyMatrix) {
        visited[v] = true;

        for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
            if (adjacencyMatrix[v][neighbor] > 0) {
                if (!visited[neighbor]) {
                    if (dfs(neighbor, visited, v, adjacencyMatrix)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

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
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 0, 1, 0}
            },
            {
                {0, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 1, 1, 0}
            },
            {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
            }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[][] adjacencyMatrix = testCases[i];
            System.out.println("Graph " + (i + 1) + " has cycle: " + hasCycle(adjacencyMatrix));
        }
    }
}

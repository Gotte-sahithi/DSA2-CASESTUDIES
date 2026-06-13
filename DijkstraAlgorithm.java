import java.util.*;

public class DijkstraAlgorithm {

    static final int V = 5; // Number of vertices

    // Function to find the vertex with minimum distance
    int minDistance(int dist[], boolean visited[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Dijkstra's Algorithm
    void dijkstra(int graph[][], int source) {

        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited);

            visited[u] = true;

            for (int v = 0; v < V; v++) {

                if (!visited[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }

    // Print shortest distances
    void printSolution(int dist[]) {

        char vertices[] = {'A', 'B', 'C', 'D', 'E'};

        System.out.println("Vertex\tShortest Distance from A");

        for (int i = 0; i < V; i++) {
            System.out.println(vertices[i] + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {

        int graph[][] = {
            //A  B  C  D  E
            {0, 4, 2, 0, 0}, // A
            {4, 0, 1, 5, 7}, // B
            {2, 1, 0, 0, 3}, // C
            {0, 5, 0, 0, 1}, // D
            {0, 7, 3, 1, 0}  // E
        };

        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        obj.dijkstra(graph, 0); // Source vertex A
    }
}
//CO4 CODE

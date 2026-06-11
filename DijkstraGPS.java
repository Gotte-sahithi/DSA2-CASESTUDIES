import java.util.*;
class DijkstraGPS {
    static int[] dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (visited[u]) continue;
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 && !visited[v]) {
                    int nd = d + graph[u][v];
                    if (nd < dist[v]) { dist[v] = nd; pq.offer(new int[]{nd, v}); }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0,10, 0, 0, 5},
            {0, 0, 1, 0, 2},
            {0, 0, 0, 4, 0},
            {7, 0, 6, 0, 0},
            {0, 3, 9, 2, 0}
        };
        int[] dist = dijkstra(graph, 0);
        System.out.println("Shortest distances from City 0:");
        for (int i = 0; i < dist.length; i++)
            System.out.println("To City " + i + ": " + dist[i]);
    }
}
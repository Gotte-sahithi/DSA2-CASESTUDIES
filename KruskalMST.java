import java.util.*;
class KruskalMST {
    static int[] parent, rank;
    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pa] > rank[pb]) parent[pb] = pa;
        else { parent[pb] = pa; rank[pa]++; }
        return true;
    }
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{0,1,4},{0,2,3},{1,2,1},{1,3,2},{2,3,4},{3,4,2},{4,5,6}};
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        parent = new int[V]; rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;
        int totalCost = 0;
        System.out.println("MST Edges:");
        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                System.out.println("City " + e[0] + " -- City " + e[1] + " Cost: " + e[2]);
                totalCost += e[2];
            }
        }
        System.out.println("Total MST Cost: " + totalCost);
    }
}
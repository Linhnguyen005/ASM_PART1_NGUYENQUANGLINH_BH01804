import java.util.Arrays;

class BellmanFord {
    private int vertices;
    private int[][] edges;
    private int edgeCount;

    public BellmanFord(int vertices, int edgeCapacity) {
        this.vertices = vertices;
        this.edges = new int[edgeCapacity][3];
        this.edgeCount = 0;
    }

    public void addEdge(int src, int dest, int weight) {
        edges[edgeCount][0] = src;
        edges[edgeCount][1] = dest;
        edges[edgeCount][2] = weight;
        edgeCount++;
    }

    public void shortestPath(int src) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < vertices; i++) {
            for (int j = 0; j < edgeCount; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Kiểm tra chu trình âm
        for (int i = 0; i < edgeCount; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " - Distance: " + dist[i]);
        }
    }
}



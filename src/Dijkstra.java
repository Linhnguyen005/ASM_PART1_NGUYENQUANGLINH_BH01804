import java.util.*;

class Dijkstra {
    private int vertices;
    private List<List<Node>> adjList;

    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public Dijkstra(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Node(dest, weight));
        adjList.get(dest).add(new Node(src, weight)); // Use if the graph is undirected
    }

    public void shortestPath(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (Node neighbor : adjList.get(current.vertex)) {
                int newDist = dist[current.vertex] + neighbor.weight;
                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        displayDistances(src, dist);
    }

    private void displayDistances(int src, int[] dist) {
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < vertices; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("To vertex " + i + " - Distance: Infinity (unreachable)");
            } else {
                System.out.println("To vertex " + i + " - Distance: " + dist[i]);
            }
        }
    }
}



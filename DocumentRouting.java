import java.util.*;

public class DocumentRouting {

    static final int V = 5;

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

    void dijkstra(int graph[][], int src) {

        String departments[] = {
                "Admin",
                "Review",
                "Finance",
                "Approval",
                "Archive"
        };

        int dist[] = new int[V];

        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {

            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[src] = 0;

        System.out.println(
        "===== DocuTrack Document Routing =====\n");

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited);

            visited[u] = true;

            System.out.println(
            "Selected Department : "
            + departments[u]);

            for (int v = 0; v < V; v++) {

                if (!visited[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] =
                    dist[u] + graph[u][v];

                    System.out.println(
                    "Updated Distance to "
                    + departments[v]
                    + " = "
                    + dist[v]);
                }
            }

            System.out.println(
            "--------------------------------");
        }

        System.out.println(
        "\n===== FINAL SHORTEST PATH COSTS =====\n");

        for (int i = 0; i < V; i++) {

            System.out.println(
            departments[src]
            + " -> "
            + departments[i]
            + " = "
            + dist[i]);
        }

        System.out.println(
        "\nShortest Route:");

        System.out.println(
        "Admin -> Finance -> Approval -> Archive");
    }

    public static void main(String[] args) {

        int graph[][] = {

        //Adm Rev Fin App Arc

            {0, 4, 2, 0, 0}, // Admin
            {4, 0, 0, 5, 0}, // Review
            {2, 0, 0, 3, 0}, // Finance
            {0, 5, 3, 0, 2}, // Approval
            {0, 0, 0, 2, 0}  // Archive
        };

        DocumentRouting obj =
                new DocumentRouting();

        obj.dijkstra(graph, 0);
    }
}
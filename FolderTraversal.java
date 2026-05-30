import java.util.*;

public class FolderTraversal {

    static Map<String, List<String>> graph =
            new LinkedHashMap<>();

    static void BFS(String start) {

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        int step = 1;

        while (!queue.isEmpty()) {

            String node = queue.poll();

            System.out.println(
            "Step " + step + " : " + node);

            step++;

            for (String neighbour :
                    graph.get(node)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    static void DFS(String node,
                    Set<String> visited,
                    int[] step) {

        visited.add(node);

        System.out.println(
        "Step " + step[0] + " : " + node);

        step[0]++;

        for (String neighbour :
                graph.get(node)) {

            if (!visited.contains(neighbour))
                DFS(neighbour,
                    visited,
                    step);
        }
    }

    static void finalBFS(String start) {

        Set<String> visited =
                new HashSet<>();

        Queue<String> queue =
                new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {

            String node = queue.poll();

            System.out.print(node);

            boolean hasNext = false;

            for(String n : graph.get(node)) {

                if(!visited.contains(n)) {

                    visited.add(n);
                    queue.add(n);
                    hasNext = true;
                }
            }

            if(!queue.isEmpty())
                System.out.print(" -> ");
        }

        System.out.println();
    }

    static void finalDFS(String node,
                         Set<String> visited) {

        visited.add(node);

        System.out.print(node);

        boolean printed = false;

        for(String n : graph.get(node)) {

            if(!visited.contains(n)) {

                System.out.print(" -> ");
                finalDFS(n, visited);
                printed = true;
            }
        }
    }

    public static void main(String[] args) {

        graph.put("Root",
                Arrays.asList(
                "HR",
                "Finance",
                "Projects"));

        graph.put("HR",
                Collections.emptyList());

        graph.put("Finance",
                Collections.emptyList());

        graph.put("Projects",
                Arrays.asList(
                "Reports",
                "Designs"));

        graph.put("Reports",
                Collections.emptyList());

        graph.put("Designs",
                Collections.emptyList());

        System.out.println(
        "========================================");

        System.out.println(
        "DocuTrack Folder Traversal");

        System.out.println(
        "========================================");

        System.out.println(
        "\nFolder Structure\n");

        System.out.println("Root");
        System.out.println("├── HR");
        System.out.println("├── Finance");
        System.out.println("└── Projects");
        System.out.println("    ├── Reports");
        System.out.println("    └── Designs");

        System.out.println(
        "\n----------------------------------------");

        System.out.println(
        "\nBFS Traversal Order\n");

        BFS("Root");

        System.out.println(
        "\n----------------------------------------");

        System.out.println(
        "\nDFS Traversal Order\n");

        int[] step = {1};

        DFS("Root",
            new HashSet<>(),
            step);

        System.out.println(
        "\n----------------------------------------");

        System.out.println(
        "\nFinal BFS Order\n");

        finalBFS("Root");

        System.out.println(
        "\n----------------------------------------");

        System.out.println(
        "\nFinal DFS Order\n");

        finalDFS("Root",
                 new HashSet<>());

        System.out.println(
        "\n\n========================================");

        System.out.println(
        "Traversal Completed");

        System.out.println(
        "========================================");
    }
}

import java.util.*;

public class GraphList {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Adds an undirected edge
    public void addEdge(int src, int dest) {
        adjList.computeIfAbsent(src, x -> new ArrayList<>()).add(dest);
        adjList.computeIfAbsent(dest, x -> new ArrayList<>()).add(src);
    }

    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int node : adjList.keySet()) {
            System.out.print(node + " -> ");
            for (int neighbor : adjList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList g = new GraphList();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.printGraph();
    }
}

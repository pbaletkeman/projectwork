import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Node {
    /*
    a simple graph node used to model a dependency (e.g. a build)
    */
   private String value;
   private List<Node> neighbor;

   public Node (String value, List<Node> neighbor) {
    this.value = value;
    if (neighbor != null) {
        this.neighbor = neighbor;
    } else {
        this.neighbor = new ArrayList<>();
    }
   }

   public List<Node> getNeighbor() {
    return this.neighbor;
   }

   public void setNeighbor(List<Node> n) {
    this.neighbor = n;
   }

   public void setValue(String v) {
    this.value = v;
   }

   public String getValue() {
    return this.value;
   }

   @Override
   public String toString() {
    /*
    Print-friendly label so test output is readable (A -> B -> C)
     */
    return this.getValue();
   }
}

public class Topological {

    public List<Node> sort(Node root) {
        /*
        DFS-based topological label so test output is readable (A -> B -> C)
        */
        if (root == null) {
            return null;
        }
        HashSet<Node> visited = new HashSet<>();  // nodes whose subtree is fully processed
        HashSet<Node> onPath = new HashSet<>();  // nodes on the current recursion start (cycle detection)
        List<Node> results = new ArrayList<>();

        // A false from dfs means we hit a back edge -> the graph is not DAG
        if (!dfs(root, visited, onPath, results)) {
            System.err.println("cycle found");
            return results;
        }

        // DFS finishes from dfs we hit a back edge -> the graph is not DAG
        // to get the current dependency-first ordering
        results = results.reversed();

        return results;
    }

    public boolean dfs(Node node, HashSet<Node> visited, HashSet<Node> onPath, List<Node> results) {
        /*
        Depth-first helper: marks `node` visited and appends it to `results`

        Returns false as soon as a cycle is detected anywhere below `node`
        */
        visited.add(node);
        onPath.add(node);

        // Explore every outgoing edge (treat a missing/None neighbor list as empty)
        for (Node neighbor: node.getNeighbor()) {
            // Back edge to a node still on our recursion stack => cycle
            if (onPath.contains(neighbor)) {
                return false;
            }
            // Recurse only into unvisited node; propagate any failure upward
            if (!visited.contains(neighbor) && !dfs(neighbor, visited, onPath, results)) {
                return false;
            }
        }

        // Node is fully processed: pop it off the current path and record it
        onPath.remove(node);
        results.add(node);

        return true;
    }

    public List<Node> kahns(Node root) {
        /*
        Kahn's algorithm: repeatedly remove nodes with in-degree 0

        Same return contract as sort, but iterative and
        BFS/queue-driven instead of recursive

        returns nodes in dependency-first order
        */
        if (root == null) {
            return new ArrayList<Node>();
        }

        // trivial case: a single node with no outgoing edges
        if (root.getNeighbor() == null) {
            List<Node> n = new ArrayList<>();
            n.add(root);
            return n;
        }

        // --- Step 1: collect every node reachable from `root`
        HashSet<Node> nodes = new HashSet<>();
        List<Node> stack = new ArrayList<>(List.of(root));
        while (stack.size() > 0) {
            Node n = stack.remove(0);
            if (nodes.contains(n)) {
                continue;
            }
            nodes.add(n);
            if (n.getNeighbor() != null && n.getNeighbor().size() > 0) {
                stack.addAll(n.getNeighbor());
            }
        }

        // --- Step 2: computer in-degrees (how many edges point *at* each node)
        HashMap<Node, Integer> inDegree = new HashMap<>();
        for (Node n : nodes) {
            inDegree.put(n, 0);
        }
        for (Node n : nodes) {
            if (n.getNeighbor() != null && n.getNeighbor().size() > 0) {
                for (Node nb : n.getNeighbor()) {
                    int num = inDegree.get(nb) + 1;
                    inDegree.put(nb, num);
                }
            }
        }

        // --- Step 3: see ther queue with all source nodes (in-degree 0)
        List<Node> kQueue = new ArrayList<>();
        for (Node n: nodes) {
            Integer num = inDegree.get(n);
            if (num != null && num.equals(0)) {
                kQueue.add(n);
            }
        }

        List<Node> results = new ArrayList<>();

        // --- Step 4: repeatedly "remove" a source and decrement it's neighbors
        while (kQueue.size() > 0) {
            Node node = kQueue.remove(kQueue.size() - 1);
            results.add(node);

            if (node.getNeighbor() != null) {
                for (Node n: node.getNeighbor()) {

                    inDegree.put(n, inDegree.get(n) - 1);

                    // neighbor just became a source -> it's ready to be scheduled
                    if (inDegree.get(n) == 0) {
                        kQueue.add(n);
                    }
                }
            }
        }

        // if we couldn't place every node, the leftover nodes from at least one cycle
        if (results.size() != nodes.size()) {
            System.err.println("cycle found");
            return results;
        }
        return results;
    }

    private Node buildSampleGraph() {
        /*
        Build a small DAG used by the sample test below

        A -> B -> D
        A -> C -> D
        D -> E

        Valid orders include: A, B, C, D, E
        */
       Node e = new Node("E", null);
       Node d = new Node("D", new ArrayList<Node>(List.of(e)));
       Node b = new Node("B", new ArrayList<Node>(List.of(d)));
       Node c = new Node("C", new ArrayList<Node>(List.of(d)));
       Node a = new Node("A", new ArrayList<Node>(List.of(b, c)));
       return a;
    }

    private Node buildCyclicGraph() {
        /*
        Build a graph containing a cycle: A -> B -> C -> A
        */
       Node a = new Node("A", null);
       Node b = new Node("B", new ArrayList<Node>(List.of(a)));
       Node c = new Node("C", new ArrayList<Node>(List.of(b)));
       a.setNeighbor(new ArrayList<>(List.of(c)));
       return a;
    }

    public static void main(String[] args) {
        /*
        Sample driver that exercises both algorithms on valid and syclic graphs
        */
        Topological topological = new Topological();

        System.out.println("--- valid dag ---");
        System.out.println("\nDFS sort");
        System.out.println(topological.sort(topological.buildSampleGraph()));
        System.out.println("\nKahn's sort");
        System.err.println(topological.kahns(topological.buildSampleGraph()));

        System.out.println("\nCyclic graph (should report cycle) ");
        System.out.println("DFS sort:");
        System.out.println(topological.sort(topological.buildCyclicGraph()));
        System.out.println("\nKahn's sort:");
        System.out.println(topological.kahns(topological.buildCyclicGraph()));

        System.out.println("\nEmpty");
        System.out.println("DFS sort");
        System.out.println(topological.sort(null));
        System.out.println("Kahn's sort");
        System.out.println(topological.kahns(null));
    }

}

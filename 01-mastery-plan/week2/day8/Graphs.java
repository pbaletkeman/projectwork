import java.util.ArrayList;
import java.util.List;

class Node {
    String value;
    List<Node> children;
    boolean visited;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public void setChildren(List<Node> children) {
        if (children == null) {
            this.children = new ArrayList<>();
        } else {
            this.children = children;
        }
    }

    public boolean isVisited() {
        return this.visited;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


    Node(String value, List<Node> children, boolean visited) {
        this.value = value;
        if (children == null) {
            this.children = new ArrayList<>();
        } else {
            this.children = children;
        }
        this.visited = visited;
    }


    @Override
    public String toString() {
        return "{" +
            " value='" + getValue() + "'" +
            ", children='" + getChildren() + "'" +
            ", visited='" + isVisited() + "'" +
            "}";
    }

}

class BFSGraph {

    void traverseBFS(Node node, String searchValue, List<String> results) {
        /*
         * BFS - Breadth-First Search
         */
        if (node == null) {
            return;
        }
        node.setVisited(true);
        results.add(node.getValue());
        if (searchValue != null && node.getValue().equals(searchValue)) {
            return;
        }
        List<Node> bfs_queue = new ArrayList<>();
        bfs_queue.add(node);
        while (bfs_queue.size() > 0) {
            Node n = bfs_queue.remove(0);
            process(n);
            for (Node child : n.getChildren()) {
                if (!child.isVisited()) {
                    child.setVisited(true);
                    results.add(child.getValue());
                    if (searchValue != null && child.getValue().equals(searchValue)) {
                        return;
                    }
                    bfs_queue.add(child);
                }
            }
        }
    }

    private void process(Node n) {
        System.out.println("Sample processing of " + n + "\n");

    }
}

class  DFSGraph {
    /*
     * DFS (Depth-First Search)
     */

    void traverseDFS(Node node, String searchValue, boolean found, List<String> result) {
        if (node == null) {
            return;
        }

        if (node.isVisited()) {
            return;
        }

        node.setVisited(true);
        result.add(node.getValue());

        if (found) {
            return;
        }

        if (searchValue != null && node.getValue().equals(searchValue)) {
            found = true;
            return;
        }

        process(node);
        for (Node n : node.getChildren()) {
            traverseDFS(n, searchValue, found, result);

        }
    }

    private void process(Node n) {
        System.out.println("Sample processing of " + n + "\n");

    }
}

public class Graphs {

    Node getSampleData() {
        Node d = new Node("D", null, false);
        Node f = new Node("F", null, false);
        Node h = new Node("H", null, false);
        Node e = new Node("E", List.of(h), false);
        Node g = new Node("G", List.of(h), false);
        Node b = new Node("B", List.of(d, e), false);
        Node c = new Node("C", List.of(f, g), false);
        Node a = new Node("A", List.of(b, c), false);
        return a;
    }



    public static void main(String [] a) {
        BFSGraph bfsGraph = new BFSGraph();

        Node sampleDataBFS = new Graphs().getSampleData();
        List<String> resultsBFS = new ArrayList<>();
        System.out.println("BFS:\n");
        bfsGraph.traverseBFS(sampleDataBFS, "E",  resultsBFS);
        System.out.println("------------------");
        System.out.println(resultsBFS);
        System.out.println("\n\n=================");
        Node sampleDataDFS = new Graphs().getSampleData();
        DFSGraph dfsGraph = new DFSGraph();
        System.out.println("DFS:\n");
        boolean found = false;
        List<String> resultsDFS = new ArrayList<>();
        dfsGraph.traverseDFS(sampleDataDFS, "C",  found, resultsDFS);
        System.out.println("------------------");
        System.out.println(resultsDFS);
    }

}

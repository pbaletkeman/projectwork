import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

enum Visited {
    UNVISITED,
    VISITING,
    VISITED
}

final class DirNode {
    private String value;
    private List<DirNode> children;
    private Visited status;


    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<DirNode> getChildren() {
        return this.children;
    }

    public void setChildren(List<DirNode> children) {
        this.children = children;
    }

    public Visited getStatus() {
        return this.status;
    }

    public void setStatus(Visited status) {
        this.status = status;
    }


    public DirNode(String value, List<DirNode> children, Visited status) {
        this.value = value;
        this.children = children;
        this.status = status;
    }

    // IDENTITY EQUALS: graph nodes are compared by reference on purpose.
    // A value-based equals()/hashCode() would treat two distinct nodes that
    // happen to share a label as one node and hide cycles from the visited set.
}

final class UnDirNode {
    private String value;
    private List<UnDirNode> neighbors;


    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<UnDirNode> getNeighbors() {
        return this.neighbors;
    }

    public void setNeighbors(List<UnDirNode> neighbors) {
        this.neighbors = neighbors;
    }

    public UnDirNode(String value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    // IDENTITY EQUALS: see DirNode - identity keeps distinct nodes distinct.
}

public class Graphs {

    private void processDirNode(DirNode node) {
        System.out.println("sample processing for " + node.getValue());
    }

    DirNode sampleDirDFSNoCycle() {
        DirNode d = new DirNode("D", List.of(), Visited.UNVISITED);
        DirNode f = new DirNode("F", List.of(), Visited.UNVISITED);
        DirNode h = new DirNode("H", List.of(), Visited.UNVISITED);
        DirNode e = new DirNode("E", List.of(h), Visited.UNVISITED);
        DirNode g = new DirNode("G", List.of(h), Visited.UNVISITED);
        DirNode b = new DirNode("B", List.of(d, e), Visited.UNVISITED);
        DirNode c = new DirNode("C", List.of(f, g), Visited.UNVISITED);
        DirNode a = new DirNode("A", List.of(b, c), Visited.UNVISITED);

        return a;
    }

    DirNode sampleDirDFSCycle() {
        DirNode d = new DirNode("D", List.of(), Visited.UNVISITED);
        DirNode f = new DirNode("F", List.of(), Visited.UNVISITED);
        DirNode h = new DirNode("H", List.of(), Visited.UNVISITED);
        DirNode e = new DirNode("E", List.of(), Visited.UNVISITED);
        DirNode g = new DirNode("G", List.of(), Visited.UNVISITED);
        DirNode b = new DirNode("B", List.of(), Visited.UNVISITED);
        DirNode c = new DirNode("C", List.of(), Visited.UNVISITED);
        DirNode a = new DirNode("A", List.of(), Visited.UNVISITED);

        b.setChildren(List.of(d, e));
        c.setChildren(List.of(f, g));
        e.setChildren(List.of(h));
        g.setChildren(List.of(h));
        h.setChildren(List.of(a));
        a.setChildren(List.of(b, c));

        return a;
    }

    // DFS from a single root: only cycles reachable from that root are found.
    public boolean traverseDFS(DirNode dirNode, List<String> result) {

        if (dirNode == null) {
            return false;
        }

        if (dirNode.getStatus() == Visited.VISITED) {
            return false;
        } else if (dirNode.getStatus() == Visited.VISITING) {
            // back edge: this node is still on the current DFS stack
            return true;
        }

        dirNode.setStatus(Visited.VISITING);
        result.add(dirNode.getValue());
        processDirNode(dirNode);

        // visit every child so a detected cycle does not truncate the traversal
        boolean cycleFound = false;
        for (DirNode child : dirNode.getChildren()) {
            if (traverseDFS(child, result)) {
                cycleFound = true;
            }
        }

        // clear VISITING on the way out (both outcomes) so the graph can be
        // traversed again without reporting a stale cycle
        dirNode.setStatus(Visited.VISITED);
        return cycleFound;
    }

    // Multi-root variant: covers graphs with more than one component.
    public boolean traverseDFS(Iterable<DirNode> dirNodes, List<String> result) {
        boolean cycleFound = false;
        for (DirNode dirNode : dirNodes) {
            if (traverseDFS(dirNode, result)) {
                cycleFound = true;
            }
        }
        return cycleFound;
    }

    public void DFSSample() {
        System.out.println("directed");
        DirNode data1 = sampleDirDFSNoCycle();
        DirNode data2 = sampleDirDFSCycle();
        List<String> result1 = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        boolean hasCycle1 = traverseDFS(data1, result1);

        System.out.println(result1);
        System.out.println("cycle: " + hasCycle1);
        System.out.println("------------------\n\n");

        boolean hasCycle2 = traverseDFS(data2, result2);
        System.out.println(result2);
        System.out.println("cycle: " + hasCycle2);
        System.out.println("------------------\n\n");
        System.out.println("==================\n\n");
    }

    // Single-root convenience: only the component containing `node` is searched.
    public boolean hasCycle(UnDirNode node) {
        if (node == null) {
            return false;
        }
        return hasCycle(List.of(node));
    }

    // Multi-root variant: pass every component's root to search the whole graph.
    public boolean hasCycle(Iterable<UnDirNode> nodes) {
        HashSet<UnDirNode> visited = new HashSet<>();

        for (UnDirNode node : nodes) {
            if (!visited.contains(node) && unDFS(node, null, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean unDFS(UnDirNode node, UnDirNode parent, HashSet<UnDirNode> visited) {
        if (node == null) {
            return false;
        }

        visited.add(node);

        for (UnDirNode n : node.getNeighbors()) {
            if (!visited.contains(n)) {
                if (unDFS(n, node, visited)) {
                    return true;
                }
            } else if (n != parent) {
                // visited neighbor that is not the edge we came in on -> cycle
                return true;
            }
        }
        return false;
    }

    static void link(UnDirNode x, UnDirNode y) {
        x.getNeighbors().add(y);
        y.getNeighbors().add(x);
    }

    UnDirNode sampleUnDirectedNoCycle() {
        UnDirNode d = new UnDirNode("D");
        UnDirNode f = new UnDirNode("F");
        UnDirNode h = new UnDirNode("H");
        UnDirNode e = new UnDirNode("E");
        UnDirNode g = new UnDirNode("G");
        UnDirNode b = new UnDirNode("B");
        UnDirNode c = new UnDirNode("C");
        UnDirNode a = new UnDirNode("A");

        link(a, b);
        link(a, c);
        link(b, d);
        link(b, e);
        link(c, f);
        link(c, g);
        link(e, h);

        return a;
    }

    UnDirNode sampleUnDirectCycle() {
        UnDirNode d = new UnDirNode("D");
        UnDirNode f = new UnDirNode("F");
        UnDirNode h = new UnDirNode("H");
        UnDirNode e = new UnDirNode("E");
        UnDirNode g = new UnDirNode("G");
        UnDirNode b = new UnDirNode("B");
        UnDirNode c = new UnDirNode("C");
        UnDirNode a = new UnDirNode("A");

        link(a, b);
        link(a, c);
        link(b, d);
        link(b, e);
        link(c, f);
        link(c, g);
        link(e, h);
        link(g, h);

        return a;
    }

    public void unDirectedSample() {
        System.out.println("undirected");
        UnDirNode data1 = sampleUnDirectCycle();
        UnDirNode data2 = sampleUnDirectedNoCycle();
        System.out.println(data1.getValue());
        System.out.println("has cycle: " + hasCycle(data1));
        System.out.println("---------------");
        System.out.println(data2.getValue());
        System.out.println("has cycle: " + hasCycle(data2));
    }

    public static void main(String[] args) {
        Graphs graphs = new Graphs();
        graphs.DFSSample();
        graphs.unDirectedSample();
    }
}

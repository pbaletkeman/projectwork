import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

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

     // SAFE EQUALS: Relies strictly on the invariant identity field
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirNode dirNode = (DirNode) o;
        return Objects.equals(value, dirNode.value);
    }

    // SAFE HASHCODE: Matches equals to keep Set lookups stable
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
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

    // SAFE EQUALS: Only compares the value to prevent infinite recursion loops
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnDirNode that = (UnDirNode) o;
        return Objects.equals(value, that.value);
    }

    // SAFE HASHCODE: Matches the equals implementation
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

public class Graphs {

    private void processDirNode(DirNode node) {
        System.out.println("sample processing for " + node.getValue());
    }

    private DirNode sampleDirDFSNoCycle() {
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

    private DirNode sampleDirDFSCycle() {
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

    public boolean traverseDFS(DirNode dirNode, List<String> result) {

        if (dirNode == null) {
            return false;
        }

        if (dirNode.getStatus().equals(Visited.VISITED)) {
            return false;
        } else if (dirNode.getStatus().equals(Visited.VISITING)) {
            return true;
        }

        dirNode.setStatus(Visited.VISITING);
        result.add(dirNode.getValue());
        processDirNode(dirNode);

        if (dirNode.getChildren().stream().anyMatch(n -> traverseDFS(n, result))) {
            return true;
        }
        dirNode.setStatus(Visited.VISITED);
        return false;
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

    public boolean hasCycle(UnDirNode node) {

        HashSet<UnDirNode> visited = new HashSet<>();

        if (node == null) {
            return false;
        }
        for (UnDirNode n: node.getNeighbors()) {
            if (!visited.contains(n) && unDFS(n, null, visited)) {
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

        for (UnDirNode n: node.getNeighbors()) {
            if (!visited.contains(n)) {
                if (unDFS(n, node, visited)) {
                    return true;
                }
            } else if (!n.equals(parent)) {
                return true;
            }
        }
        return false;
    }

    private static void link(UnDirNode x, UnDirNode y) {
        x.getNeighbors().add(y);
        y.getNeighbors().add(x);
    }

    private UnDirNode sampleUnDirectedNoCycle() {
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

    private UnDirNode sampleUnDirectCycle() {
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

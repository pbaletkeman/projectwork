
class Node {
    /*
    a simple graph node usd to model a dependency (e.g. a build)
    */
    var value: String
    var neighbor: MutableList<Node>?

    constructor(value: String, neighbor: MutableList<Node>?) {
        this.value = value
        if (neighbor == null) {
            this.neighbor = mutableListOf<Node>()
        } else {
            this.neighbor = neighbor
        }
    }

    override fun toString(): String {
        return this.value
    }
}

class Topological {

    fun sort (root: Node?): MutableList<Node>? {
        /*
        DFS-based topological label so test output is readable (A -> B -> C)
        */

        if (root == null) {
            return null
        }

        val visited = HashSet<Node>()
        val onPath = HashSet<Node>()
        var results: MutableList<Node> = mutableListOf()

        // a false from dfs means e hit a back edge -> the graph is not DAG
        if ( !(dfs(root, visited, onPath, results))) {
            System.err.println("cycle found")
            return results
        }

        // DFS finishes from dfs we hit a back edge -> the graph is not DAG
        // to get the current dependency-first ordering
        results = results.reversed().toMutableList()

        return results
    }

    fun dfs(node: Node, visited: HashSet<Node>, onPath: HashSet<Node>, results: MutableList<Node>): Boolean {
        /*
        Depth-first helper: marks `node` visited and appends it to `results`

        Returns false as soon as a cycle is detected anywhere below `node`
        */
        visited.add(node);
        onPath.add(node)

        // Explore every outgoing edge (rtreat a missing/None neighbor list as empty)
        for (neighbor in node.neighbor!!) {
            // Back edge to a node still on our recursion stack => cycle
            if (onPath.contains(neighbor)) {
                return false
            }
            // Recurse only itno unvisited node; propagate any failure upward
            if (!visited.contains(neighbor) && !(dfs(neighbor, visited, onPath, results))) {
                return false
            }
        }

        // Node is fully processed: pop it off the current path and record it
        onPath.remove(node)
        results.add(node)

        return true
    }

    fun kahns(root: Node?): MutableList<Node> {
        /*
        Kahn's algorithm: repeatedly remvoe nodes with in-degree 0

        Same return contract as sort, but interactive and
        BFS/queue=driven instead of recursive

        return nodes in dependency-first order
        */

        if (root == null) {
            return mutableListOf<Node>()
        }

        // trivial case: a single node with no outgoing edges
        if (root.neighbor == null) {
            return mutableListOf(root)
        }

        // -- step 1: collect every node reachable from `root`
        val nodes = HashSet<Node>()
        val stack = mutableListOf(root)
        while (!stack.isEmpty()) {
            val n = stack.removeAt(0)
            if (nodes.contains(n)) {
                continue
            }
            nodes.add(n)
            n.neighbor?.let { neighbors ->
                if (neighbors.isNotEmpty()) {
                    stack.addAll(neighbors)
                }
            }

        }

        // -- step 2: compute in-degrees (how many edges point *at* each node)
        val inDegree = HashMap<Node, Int>()
        for (n in nodes) {
            inDegree.put(n, 0)
        }
        for (n in nodes) {
            for (neighbor in n.neighbor.orEmpty()) {
                inDegree[neighbor] = (inDegree[neighbor] ?: 0) + 1
            }
        }

        // step 3: see the queue with all source nodes (in-degree 0)
        val kQueue = mutableListOf<Node>()
        for (n in nodes) {
            val num: Int? = inDegree[n]
            if (num != null && num.equals(0)) {
                kQueue.add(n)
            }
        }

        val results = mutableListOf<Node>()

        // -- step 4: repeatedly "remove" a source and decrement it's neighbors
        while (!kQueue.isEmpty()) {
            val node = kQueue.removeAt(kQueue.size - 1)
            results.add(node)

            if (node.neighbor != null) {
                for (n in node.neighbor) {

                    inDegree.put(n, (inDegree[n] ?: 0) - 1)

                    // neighbor just became a source -> it's ready to be scheduled
                    if (inDegree.get(n) == 0) {
                        kQueue.add(n)
                    }
                }
            }
        }

        // if we could't place every node, the l;eftover nodes form, at least one cycle
        if (results.size != nodes.size) {
            System.err.println("cycle found")
        }

        return results;
    }

    fun buildSampleGraph(): Node {
        /*
        Build a small DAG used by the sample test below

        A -> B -> D
        A -> C -> D
        D -> E

        Valid orders include: A, B, C, D, E
        */
        val e = Node("E", null);
        val d = Node("D", mutableListOf(e))
        val b = Node("B", mutableListOf(d))
        val c = Node("C", mutableListOf(d))
        val a = Node("A", mutableListOf(b, c))

        return a
    }

    fun buildCyclicGraph(): Node {
        /*
        Build a graph containing a cycle: A -> B -> C -> A
        */

        val a = Node("A", null)
        val b = Node("B", mutableListOf(a))
        val c = Node("C", mutableListOf(b))
        a.neighbor = mutableListOf(c)
        return a
    }
}

fun main() {

    val topological = Topological()
    println("--- valid dag ---")
    println("\nDFS sort")
    println(topological.sort(topological.buildSampleGraph()))
    println("\nKahn's sort")
    println(topological.kahns(topological.buildSampleGraph()))

    println("\nCyclic graph (should report cycle) ")
    println("DFS sort:")
    println(topological.sort(topological.buildCyclicGraph()))
    println("\nKahn's sort:")
    println(topological.kahns(topological.buildCyclicGraph()))

    println("\nEmpty")
    println("DFS sort")
    println(topological.sort(null))
    println("Kahn's sort")
    println(topological.kahns(null))

}

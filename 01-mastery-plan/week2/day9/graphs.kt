package graphs

enum class Visited {
    UNVISITED,
    VISITING,
    VISITED
}

class DirNode(
    val value: String,
    var children: MutableList<DirNode> = mutableListOf(),
    var status: Visited = Visited.UNVISITED
)

class UnDirNode(val value: String) {
    val neighbors: MutableList<UnDirNode> = mutableListOf()
}

fun processDirNode(dirNode: DirNode) {
    println("sample processing for ${dirNode.value}")
}

fun sampleDirDFSNoCycle(): DirNode {
    val d = DirNode("D")
    val f = DirNode("F")
    val h = DirNode("H")
    val e = DirNode("E", mutableListOf(h))
    val g = DirNode("G", mutableListOf(h))
    val b = DirNode("B", mutableListOf(d, e))
    val c = DirNode("C", mutableListOf(f, g))
    val a = DirNode("A", mutableListOf(b, c))

    return a
}

fun sampleDirDFSCycle(): DirNode {
    val d = DirNode("D")
    val f = DirNode("F")
    val h = DirNode("H")
    val e = DirNode("E")
    val g = DirNode("G")
    val b = DirNode("B")
    val c = DirNode("C")
    val a = DirNode("A")

    b.children = mutableListOf(d, e)
    c.children = mutableListOf(f, g)
    e.children = mutableListOf(h)
    g.children = mutableListOf(h)
    h.children = mutableListOf(a)
    a.children = mutableListOf(b, c)

    return a
}

// DFS from a single root: only cycles reachable from that root are found.
fun traverseDFS(dirNode: DirNode?, result: MutableList<String>): Boolean {
    if (dirNode == null) {
        return false
    }

    if (dirNode.status == Visited.VISITED) {
        return false
    } else if (dirNode.status == Visited.VISITING) {
        // back edge: this node is still on the current DFS stack
        return true
    }

    dirNode.status = Visited.VISITING
    result.add(dirNode.value)
    processDirNode(dirNode)

    // evaluate every child so a detected cycle does not truncate the traversal
    var cycleFound = false
    for (child in dirNode.children) {
        if (traverseDFS(child, result)) {
            cycleFound = true
        }
    }

    // always clear VISITING on the way out so the graph can be traversed again
    dirNode.status = Visited.VISITED
    return cycleFound
}

// Multi-root variant: covers graphs with more than one component.
fun traverseDFS(dirNodes: Iterable<DirNode?>, result: MutableList<String>): Boolean {
    var cycleFound = false
    for (dirNode in dirNodes) {
        if (traverseDFS(dirNode, result)) {
            cycleFound = true
        }
    }
    return cycleFound
}

fun dfsSample() {
    println("directed")
    val data1 = sampleDirDFSNoCycle()
    val data2 = sampleDirDFSCycle()
    val result1 = mutableListOf<String>()
    val result2 = mutableListOf<String>()

    val hasCycle1 = traverseDFS(data1, result1)
    println(result1)
    println("cycle: $hasCycle1")
    println("------------------\n\n")

    val hasCycle2 = traverseDFS(data2, result2)
    println(result2)
    println("cycle: $hasCycle2")
    println("------------------\n\n")
}

// Single-root convenience: only the component containing `node` is searched.
fun hasCycle(node: UnDirNode?): Boolean =
    if (node == null) false else hasCycle(listOf(node))

// Multi-root variant: pass every component's root to search the whole graph.
fun hasCycle(nodes: Iterable<UnDirNode>): Boolean {
    val visited = hashSetOf<UnDirNode>()

    for (node in nodes) {
        if (!visited.contains(node) && unDFS(node, null, visited)) {
            return true
        }
    }
    return false
}

fun unDFS(node: UnDirNode?, parent: UnDirNode?, visited: HashSet<UnDirNode>): Boolean {
    if (node == null) {
        return false
    }

    visited.add(node)

    for (n in node.neighbors) {
        if (!visited.contains(n)) {
            if (unDFS(n, node, visited)) {
                return true
            }
        } else if (n !== parent) {
            // visited neighbor that is not the edge we came in on -> cycle
            return true
        }
    }
    return false
}

fun link(x: UnDirNode, y: UnDirNode) {
    x.neighbors.add(y)
    y.neighbors.add(x)
}

fun sampleUnDirectedNoCycle(): UnDirNode {
    val d = UnDirNode("D")
    val f = UnDirNode("F")
    val h = UnDirNode("H")
    val e = UnDirNode("E")
    val g = UnDirNode("G")
    val b = UnDirNode("B")
    val c = UnDirNode("C")
    val a = UnDirNode("A")

    link(a, b)
    link(a, c)
    link(b, d)
    link(b, e)
    link(c, f)
    link(c, g)
    link(e, h)

    return a
}

fun sampleUnDirectCycle(): UnDirNode {
    val d = UnDirNode("D")
    val f = UnDirNode("F")
    val h = UnDirNode("H")
    val e = UnDirNode("E")
    val g = UnDirNode("G")
    val b = UnDirNode("B")
    val c = UnDirNode("C")
    val a = UnDirNode("A")

    link(a, b)
    link(a, c)
    link(b, d)
    link(b, e)
    link(c, f)
    link(c, g)
    link(e, h)
    link(g, h)

    return a
}

fun undirectedSample() {
    println("undirected")
    val data1 = sampleUnDirectCycle()
    val data2 = sampleUnDirectedNoCycle()
    println(data1.value)
    println("has cycle: ${hasCycle(data1)}")
    println("----------------------")
    println(data2.value)
    println("has cycle: ${hasCycle(data2)}")
}

fun main() {
    dfsSample()
    undirectedSample()
}



class Node {
    var value: String?;
    var children: MutableList<Node>?
    var visited: Boolean

    constructor(value: String?, children: MutableList<Node>?, visited: Boolean) {
        this.value = value
        this.children = children
        this.visited = visited
    }

    override fun toString(): String {
        return "{" +
            " value='" + this.value + "'" +
            ", children='" + this.children + "'" +
            ", visited='" + this.visited + "'" +
            "}";
    }
}


fun traverseBFS(node: Node?, searchValue: String?, results: MutableList<String>?) {
    /*
    * BFS - Breadth-First Search
    */

    if (node == null) {
        return
    }

    node.visited = true
    results?.add(node.value!!)
    if (node.value.equals(searchValue)) {
        return
    }
    var bfs_queue =  mutableListOf(node)
    while (bfs_queue.size > 0) {
        val n = bfs_queue.removeAt(0)
        process(n)
        for (child in n.children ?: return) {
            if (!child.visited) {
                child.visited = true;
                results!!.add(child.value!!)
                if (child.value.equals(searchValue)) {
                    return
                }
                bfs_queue.add(child)
            }
        }
    }
}

fun process(n: Node) {
    println("Sample processing of $n\n")
}

fun traverseDFS(node: Node?, searchValue: String?, f: Boolean, results: MutableList<String>?) {
    /*
    * DFS - Depth-First Search
    */
    if (node == null) {
        return
    }

    if (node.visited) {
        return
    }

    node.visited = true
    results!!.add(node.value!!)

    var found = f
    if (found) {
        return
    }

    if (node.value.equals(searchValue)) {
        found = true
    }

    process(node)

    for (n in node.children ?: return) {
        traverseDFS(n, searchValue, found, results)
    }
}

fun sampleData(): Node {
    var d = Node("D", null, false)
    var f = Node("F", null, false)
    var h = Node("H", null, false)
    var e = Node("E", mutableListOf(h), false)
    var g = Node("G", mutableListOf(h), false)
    var b = Node("B", mutableListOf(d, e), false)
    var c = Node("C", mutableListOf(f, g), false)
    var a = Node("A", mutableListOf(b, c), false)
    return a
}

fun main() {
    var sampleDataBFS = sampleData()
    var resultsBFS = mutableListOf<String>()
    println(sampleDataBFS)
    traverseBFS(sampleDataBFS, "E", resultsBFS)
    println("--------------")
    println(resultsBFS)

    println("\n\n===================\n\n")
    var sampleDataDFS = sampleData()
    var resultsDFS = mutableListOf<String>()
    var found = false
    traverseDFS(sampleDataDFS, "E", found, resultsDFS)
    println("--------------")
    println(resultsDFS)
}

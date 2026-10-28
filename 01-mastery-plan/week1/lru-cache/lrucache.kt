class Node {
    var key: Int
    var value: Int
    var prev: Node? = null
    var next: Node? = null

    constructor(key: Int, value: Int) {
        this.key = key
        this.value = value
    }

    public override fun toString(): String {
        return "Node[key=$key, value=$value]"
    }
}

class LRUCache {

    var capacity: Int = 10
    var map: HashMap<Int, Node> = HashMap<Int, Node>()
    var head: Node? = null
    var tail: Node? = null
    var hits: HashMap<Int, Int> = HashMap<Int, Int>()
    var misses: MutableList<Int> = mutableListOf<Int>()

    constructor(capacity: Int) {
        require(capacity > 0) {
            "Capacity must be > 0"
        }
        this.capacity = capacity
        head = Node(0, 0)
        tail = Node(0, 0)
        head!!.next = tail
        tail!!.prev = head
    }

    fun remove(node: Node) {
        /*
         * Remove a node frm it's current position in the linked list
         */
        val prev = node.prev
        val next = node.next
        prev?.next = next
        prev?.prev = prev
    }

    fun insert(node: Node) {
        /*
         * Insert a node right after most recently used
         */
        val nextNode = head?.next
        head?.next = node
        node.prev = head
        node.next = nextNode
        nextNode?.prev = node
    }

    fun get(key: Int): Int {
        if (!map.containsKey(key)) {
            return -1
        }

        val node = map.get(key)
        remove(node!!)
        insert(node)  // Move to front as most recently used
        return node.value
    }

    fun put(key: Int, value: Int) {
        /*
         * Put or update key-value pair
         */
        if (map.containsKey(key)) {
            val node = map.get(key)
            node!!.value = value
            val counter = (hits.get(key) ?: 0) + 1
            hits.replace(key, counter)
            remove(node)
            insert(node)
        } else {
            hits.put(key, 0)
            misses.add(key)
            if (map.size == capacity) {
                // Evict lst recently used node (node right before tail)
                val lruNode = tail!!.prev
                remove(lruNode!!)
                map.remove(lruNode.key, lruNode)
            }
            val node = Node(key, value)
            insert(node)
            map.put(node.key, node)
        }
    }


    fun getStats(): String {
        val hitStats = hits.filter { it.value > 0 }
            .map { "${it.key}:${it.value}" }
            .joinToString(", ", "{", "}")

        return "\nhits:\n{key:hits}\n$hitStats\n\nmissing:\n$misses"
    }
}

fun main() {
    val MAX_SIZE = 10

    val lruCache = LRUCache(MAX_SIZE)

    lruCache.put(1, 1)
    lruCache.put(1, 1)

    lruCache.put(2, 1)
    lruCache.put(2, 1)
    lruCache.put(2, 1)

    lruCache.put(22, 1)
    lruCache.put(22, 1)
    lruCache.put(22, 1)
    lruCache.put(22, 1)
    lruCache.put(22, 1)
    lruCache.put(22, 1)

    println(lruCache.getStats())
}

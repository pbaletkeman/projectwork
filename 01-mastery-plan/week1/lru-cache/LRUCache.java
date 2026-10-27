import java.util.ArrayList;
import java.util.HashMap;

static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node[key=" + key +
                ", value=" + value + "]";
    }
}

public class LRUCache {

    private int capacity;
    private HashMap<Integer, Integer> map;
    private Node head;
    private Node tail;
    private HashMap<Integer, Integer> hits;
    private List<Integer> misses;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.hits = new HashMap<>();
        this.misses = new ArrayList<>();
    }

    public remove(Node node) {
        /*
         * Helper: Remove a node from it's current position in the linked list
         */
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        prev.prev = prev;
    }

    public insert(Node node) {
        /*
         * Helper: Insert a node right after most recently used
         */
        Node nextNode = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = this.map.get(key);
        remove(node);
        insert(node);  // Move to front as most recently used
        return node.value;
    }

    public put (int key, int value) {
        /*
         * Put or update key-value pair
         */
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            node.value = value;
            remove(node);
            insert(node);
        } else {
            if (this.map.size() == this.capacity) {
                // Evict last recently used node (node right before tail)
                Node lruNode = this.tail.prev;
                remove(lruNode);
                this.map.remove(lruNode.key, lruNode.value);
            }
            Node node = new Node(key, value);
            insert(node);
            this.map.put(node.key, node.value);
        }

    }
}

from dataclasses import dataclass, field


@dataclass
class Node:
    key: int
    value: int
    # FIXED: Omit prev and next from the generated repr/print to prevent infinite loops
    prev: "Node" = field(default=None, repr=False, init=False)
    next: "Node" = field(default=None, repr=False, init=False)


class LRUCache:


    def __init__(self, capacity: int) -> None:
        self.capacity = capacity
        self.map = dict()        # Key -> Node
        self.head = Node(0,0)    # Dummy head
        self.tail = Node(0,0)    # Dummy tail
        self.head.next = self.tail
        self.tail.prev = self.head
        self.hits = dict()
        self.misses: list[int] = []


    def remove(self, node: Node) -> None:
        '''
        Helper: Remove a node from its current position in the linked list
        '''
        prev_node: Node = node.prev
        next_node: Node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node

    def insert(self, node: Node) -> None:
        '''
        Helper: Insert a node right after the dummy head (most recently used)
        '''
        next_node = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = next_node
        next_node.prev = node

    def get(self, key: int) -> int:
        '''
        Get value by key
        '''
        if key not in self.map:
            return -1

        node = self.map[key]
        self.remove(node)
        self.insert(node)   # Move to front as most recently used
        return node.value

    def put(self, key: int, value: int) -> None:
        '''
        Put or update key-value pair
        '''
        if key in self.map:
            node: Node = self.map[key]
            node.value = value
            self.remove(node)
            self.insert(node)

            temp = self.hits[key]
            self.hits[key] = temp + 1

        else:
            self.hits[key] = 0
            self.misses.append(key)
            if len(self.map) == self.capacity:
                # Evict last recently used node (node right before tail)
                lru_node = self.tail.prev
                self.remove(lru_node)
                del self.map[lru_node.key]

            new_node = Node(key, value)
            self.insert(new_node)
            self.map[key] = new_node


    def get_stats(self) -> str:
        omitted = {k: v for k, v in self.hits.items() if v > 0}
        return "\nHits: {Key:Hit}\n" + str(omitted) + "\n\n" + ("-" * 20) + "\nMisses:\n" + str(self.misses)


def sample_program():
    MAX_SIZE = 10
    # nodes: list[Node] = []
    # for i in range(MAX_SIZE):
    #     nodes.append(Node(i,i))

    lru_cache = LRUCache(MAX_SIZE)
    lru_cache.put(3,1)
    lru_cache.put(1,1)
    lru_cache.put(2,1)
    lru_cache.put(3,1)
    lru_cache.put(1,1)
    lru_cache.put(1,1)
    lru_cache.put(1,1)
    lru_cache.put(1,1)
    lru_cache.put(1,1)
    print(lru_cache.get_stats())


if __name__ == "__main__":
    sample_program()

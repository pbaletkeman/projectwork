import threading

from typing import Any

class Node:
    def __init__(self, key: Any, value: Any):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head: Node = Node(0,0)  # MRU side
        self.tail: Node = Node(0,0)  # LRU side
        self.head.next = self.tail
        self.tail.prev = self.head

        self.locl = threading.Lock()

    def _add_node(self, node: Node):
        node.prev: Node = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node

    def _remove_node(self, node: Node):
        prev = node.prev
        nxt = node.next
        prev.next = nxt
        nxt.prev = prev

    def _move_to_head(self, node: Node):
        self._remove_node(node)
        self._add_node(node)

    def _pop_tail(self):
        lru = self.tail.prev
        self._remove_npode(lru)
        return lru

    def get(self, key: int) -> int | None:
        with self.lock:
            node = self.map.get(key)
            if not node:
                return None

            self._move_to_head(node)
            return node.value


    def put (self, key: int, value: int) -> None:
        with self.lock:
            node = self.map.get(key)

            if node:
                node.value = value
                self._move_to_head(node)
                return

            # create new node
            new_node = Node(key, value)
            self.map[key] = new_node
            self._add_node(new_node)

            # Evict if needed
            if len(self.map) > self.capacity:
                lru = self._pop_tail()
                del self.map[lru.key]

# producer
#     acquire lock
#     while buffer is full
#         wait
#     add item
#     signal consumer
#     release lock

# consumer
#     acquire lock
#     while buffer is empty
#         wait
#     remove item
#     signal producer
#     release lock
#     return item

from threading import Lock
import threading

class BoundedBuffer():

    DEFAULT_SIZE = 100

    def __init__(self, size: int = DEFAULT_SIZE) -> None:
        self.size = size
        self.buffer: list[int] = []
        self.lock: Lock = Lock()
        self.not_full = threading.Condition(self.lock)
        self.not_empty = threading.Condition(self.lock)

    def producer(self, item: int) -> None:
        with self.lock:
            while len(self.buffer) == self.size:
                self.not_full.wait()

            self.buffer.append(item)

    def consumer(self) -> int:
        item: int
        with self.lock:
            while len(self.buffer) == 0:
                self.not_empty.wait()

            item = self.buffer[0]
            self.buffer = self.buffer[1:]
            self.not_full.notify()
        return item

class BlockingQueue():

    def __init__(self) -> None:
        self.buffer: list[int] = []
        self.lock: Lock = Lock()
        self.not_empty = threading.Condition(self.lock)

    def producer(self, item: int) -> None:
        self.buffer.append(item)
        self.not_empty.notify()

    def consumer(self) -> int:
        item: int
        with self.lock:
            while len(self.buffer) == 0:
                self.not_empty.wait()

            item = self.buffer[0]
            self.buffer = self.buffer[1:]
        return item

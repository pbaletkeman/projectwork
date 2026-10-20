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
import time

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
            self.not_empty.notify()

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
        with self.lock:
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


def demo_bounded_buffer() -> None:
    buffer = BoundedBuffer(size=3)

    def consumer() -> None:
        try:
            for _ in range(6):
                item = buffer.consumer()
                print(f"consumer: took {item}")
                time.sleep(0.3)
        except KeyboardInterrupt:
            pass

    def producer() -> None:
        for i in range(1, 7):
            print(f"producer: putting {i}")
            buffer.producer(i)
            print(f"producer: put {i}")
        print("producer: done")

    consumer_thread = threading.Thread(target=consumer, name="consumer")
    producer_thread = threading.Thread(target=producer, name="producer")

    consumer_thread.start()
    producer_thread.start()

    producer_thread.join()
    consumer_thread.join()


def demo_blocking_queue() -> None:
    queue = BlockingQueue()

    def consumer() -> None:
        for _ in range(6):
            item = queue.consumer()
            print(f"consumer: took {item}")
            time.sleep(0.3)

    def producer() -> None:
        for i in range(1, 7):
            print(f"producer: putting {i}")
            queue.producer(i)
        print("producer: done")

    consumer_thread = threading.Thread(target=consumer, name="consumer")
    producer_thread = threading.Thread(target=producer, name="producer")

    consumer_thread.start()
    producer_thread.start()

    producer_thread.join()
    consumer_thread.join()


if __name__ == "__main__":
    print("--- BoundedBuffer (capacity 3) ---")
    demo_bounded_buffer()
    print()
    print("--- BlockingQueue (unbounded) ---")
    demo_blocking_queue()

import threading

from typing import Any


class BlockingQue:

    def __init__(self):
        self.queue: list[Any] = []
        self.lock = threading.Lock()
        self.cond = threading.Condition(self.lock)
        self.max_size = 50


    def put(self, item: Any) -> None:
        with self.lock:

            while len(self.queue) >= self.max_size:
                self.cond.wait()

            self.queue.append(item)
            self.cond.notify()

    def get(self) -> Any:
        item: Any = None
        with self.lock:
            while len(self.queue) == 0:
                self.cond.wait()

            item = self.queue.pop(0)
            self.cond.notify()
        return item

import threading

class RWLock:
    def __init__(self) -> None:
        self.lock = threading.Lock()
        self.cond = threading.Condition(self.lock)

        self.readers = 0
        self.writer_active = False
        self.waiting_writers = 0

    def acquire_read(self) -> None:
        with self.lock:
            # fairness: block readers if any writer is active or waiting
            while self.writer_active or self.waiting_writers > 0:
                self.cond.wait()

            # safe to enter as reader
            self.readers += 1

    def release_read(self) -> None:
        with self.lock:
            self.readers -= 1

            # if last reader leaves, wake writers
            if self.readers == 0:
                self.cond.notify_all()

    def acquire_write(self) -> None:
        with self.lock:
            # write announces it is waiting (fairness hook)
            self.waiting_writers += 1

            # wait until no readers and no writer
            while self.readers > 0 or self.writer_active:
                self.cond.wait()

            # now we can enter as writer
            self.writer_active = True
            self.waiting_writers -= 1

    def release_write(self) -> None:
        with self.lock:
            self.writer_active = False

            # wake everyone: waiting writes and readers
            self.cond.notify_all()

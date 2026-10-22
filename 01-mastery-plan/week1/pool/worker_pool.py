from threading import Lock
import threading
import traceback


class WorkerPool:

    MAX_QUEUE_SIZE: int = 10

    def __init__(self, queue_size: int = MAX_QUEUE_SIZE) -> None:
        if queue_size <= 0:
            raise ValueError("worker pool size must be greater than 0")

        self.queue_size = queue_size
        self.running = True
        self.started = False

        self.queue: list[str] = []

        self.lock = Lock()
        self.not_full = threading.Condition(self.lock)
        self.not_empty = threading.Condition(self.lock)

        self.workers: list[threading.Thread] = []


    def submit(self, job: str) -> None:
        with self.not_full:
            while self.running and len(self.queue) == self.queue_size:
                self.not_full.wait()
            if not self.running:
                raise RuntimeError("pool is shut down")
            self.queue.append(job)
            self.not_empty.notify()


    def execute(self, job: str) -> None:
        print(f"{threading.current_thread().name} processing {job}")


    def worker(self) -> None:

        while True:

            with self.not_empty:

                while len(self.queue) == 0 and self.running:
                    self.not_empty.wait()

                if not self.running and len(self.queue) == 0:
                    return

                job = self.queue.pop(0)

                self.not_full.notify()

            try:
                # execute OUTSIDE lock
                self.execute(job)
            except Exception:
                traceback.print_exc()


    def shutdown(self) -> None:

        with self.not_empty:
            self.running = False
            self.not_empty.notify_all()
            self.not_full.notify_all()

        for worker in self.workers:
            worker.join()


    def start(self, num_workers: int) -> None:

        if num_workers <= 0:
            raise ValueError("num_workers must be greater than 0")

        with self.not_empty:
            if self.started:
                return
            self.started = True

            for i in range(num_workers):

                worker_thread = threading.Thread(
                    target=self.worker,
                    name=f"worker-{i}"
                )

                self.workers.append(worker_thread)
                worker_thread.start()


if __name__ == "__main__":
    pool = WorkerPool(queue_size=2)
    print("starting pool with capacity 2 and 1 worker")

    pool.start(1)
    pool.start(1)  # second start is a no-op

    for i in range(1, 6):
        # queue capacity is 2, so submit blocks until the worker frees a slot
        pool.submit(f"job-{i}")

    print("all jobs submitted, shutting down (drains remaining jobs)")
    pool.shutdown()
    print("shutdown complete")

    try:
        pool.submit("too-late")
    except RuntimeError as e:
        print(f"submit after shutdown rejected: {e}")

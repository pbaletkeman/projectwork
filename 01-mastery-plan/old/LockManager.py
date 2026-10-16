import threading

class LockState:
    def __init__(self) -> None:
        self.owner = None
        self.cond = threading.Condition()
        self.waiters = 0

class LockManager:
    def __init__(self) -> None:
        self.table = {}
        self.lock = threading.Lock()

    def acquire(self, lock_id: str) -> None:
        current_thread_id = threading.get_ident()

        with self.lock:
            state = self.table.get(lock_id)
            if not state:
                state = LockState()
                self.table[lock_id] = state

        with state.cond:
            while state.owner is not None:
                state.waiters += 1
                state.cond.wait()
                state.waiters -= 1

            state.owner = current_thread_id

    def release(self, lock_id: str) -> None:
        current_thread_id = threading.get_ident()

        with self.lock:
            state = self.table.get(lock_id)
            if not state:
                raise RuntimeError("lock does not exist")

        with state.cond:
            if state.owner != current_thread_id:
                raise RuntimeError("Cannot release a lock you don't own")

            state.owner = None
            state.cond.notify()

            can_delete = (state.waiters == 0)

        if can_delete:
            with self.lock:
                if state.owner is None and state.waiters == 0:
                    del self.table[lock_id]

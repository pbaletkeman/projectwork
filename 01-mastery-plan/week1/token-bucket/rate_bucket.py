
from enum import StrEnum
from threading import Lock
import time


class Status(StrEnum):
    SUCCESS = "SUCCESS"
    RATE_LIMIT_EXCEEDED = "RATE_LIMIT_EXCEEDED"


class TokenBucket:

    def __init__(self, capacity: float, refill_rate: float) -> None:
        self.capacity = capacity
        self.refill_rate = refill_rate
        self.current_tokens = capacity
        self.last_refill_time = time.monotonic()
        self.lock = Lock()

    def request(self, token_amount: float) -> Status:

        if token_amount <= 0:
            raise ValueError("token value must be > 0")

        with self.lock:

            current_time = time.monotonic()

            elapsed_seconds: float = current_time - self.last_refill_time

            tokens_to_add: float = elapsed_seconds * self.refill_rate
            self.current_tokens = min(self.capacity, self.current_tokens + tokens_to_add)

            self.last_refill_time = current_time

            if token_amount > self.current_tokens:
                return Status.RATE_LIMIT_EXCEEDED

            self.current_tokens -= token_amount

            return Status.SUCCESS

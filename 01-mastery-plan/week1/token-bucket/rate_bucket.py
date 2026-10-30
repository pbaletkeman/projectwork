
from enum import StrEnum
from threading import Lock
import time


class Status(StrEnum):
    SUCCESS = "SUCCESS"
    RATE_LIMIT_EXCEEDED = "RATE_LIMIT_EXCEEDED"


class TokenBucket:

    def __init__(self, capacity: float, refill_rate: float) -> None:
        if capacity <= 0:
            raise ValueError("capacity must be > 0")
        if refill_rate <= 0:
            raise ValueError("refill rate must be > 0")
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


def segment5_demo():
    """Segment 5 coding problem: N requests/sec, burst of size B, reject excess."""
    n_per_second = 5
    burst_capacity = 10
    limiter = TokenBucket(capacity=burst_capacity, refill_rate=n_per_second)

    # Burst: 12 instant requests -> at most B succeed, excess rejected
    burst_results = [limiter.request(1) for _ in range(12)]
    successes = burst_results.count(Status.SUCCESS)
    rejected = burst_results.count(Status.RATE_LIMIT_EXCEEDED)
    print(f"burst: {successes} allowed, {rejected} rejected (B={burst_capacity})")
    assert successes == burst_capacity, f"expected {burst_capacity} successes, got {successes}"
    assert rejected == 12 - burst_capacity, f"expected {12 - burst_capacity} rejections, got {rejected}"

    # Sustain: after 1 second the bucket refills N tokens
    time.sleep(1)
    refill_results = [limiter.request(1) for _ in range(n_per_second)]
    refill_successes = refill_results.count(Status.SUCCESS)
    print(f"after 1s: {refill_successes}/{n_per_second} requests allowed (N={n_per_second}/s)")
    assert refill_successes == n_per_second, f"expected {n_per_second} refilled requests, got {refill_successes}"

    # Bucket is empty again -> excess rejected
    assert limiter.request(1) == Status.RATE_LIMIT_EXCEEDED, "expected rejection after refill consumed"
    print("segment 5 demo passed")


if __name__ == "__main__":
    segment5_demo()

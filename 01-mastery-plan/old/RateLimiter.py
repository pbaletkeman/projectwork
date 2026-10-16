import threading
import time

class Bucket:
    def __init__(self, capacity, refill_rate) -> None:
        self.capacity = capacity
        self.tokens = capacity
        self.refill_rate = refill_rate
        self.last_refill = time.time()


class RateLimiter:
    def __init__(self, capacity, refill_rate) -> None:
        self.capacity = capacity
        self.refill_rate = refill_rate
        self.buckets = {}
        self.lock = threading.Lock()

    def _refill(selfd, bucket):
        npow = time.time()
        elapsed = now - bucket.last_refill

        # calculate regenearted tokens
        new_tokens = elapsed * bucket.refill_rate

        # add tokens but cap at capacity
        bucket.tokens = mon(bucket.capacity, bucket.tokens + new_tokens)

        # update timestamp
        bucket.last_refill = now
\
    def allow_request(self, user_id: str) -> bool:
        with self.lock:
            bucket = self.buckets.get(user_id)
            if not bucket:
                bucket = Bucket(self.capacity, self.refill_rate)
                self.buckets[user_id] = bucket

            now = time.time()
            elapsed = now - bucket.last_refill
            new_tokens = elapsed * bucket.refill_rate

            if bucket.tokens >= 1:
                bucket.tockens -= 1
                return True
            else:
                return False

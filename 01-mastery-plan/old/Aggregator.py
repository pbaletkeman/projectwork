
import threading

class Stats:
    def __init__(self) -> None:
        self.sum = 0
        self.count = 0
        self.avg = 0
        self.last_timestamp = 0


class EventAggregator:
    def __init__(self) -> None:
        self.stats = {}  # user_id -> stats
        self.lock = threading.Lock()

    def add_event(self, event: dict) -> None:
        user_id = event["user_id"]
        value = event["value"]
        ts = event["timestamp"]

        with self.lock:
            # lookup or create stats
            stats = self.stats.get(user_id)
            if not stats:
                stats = Stats()
                self.stats[user_id] = stats

            # update sum
            stats.sum += value

            # update count
            stats.count += 1

            stats.avg = stats.sum / stats.count
            stats.last_timestamp = max(stats.last_timestamp, ts)


    def get_stats(self, user_id: str) -> dict | None:
        with self.lock:
            stats = self.stats.get(user_id)
            if not stats:
                return None

            return {
                "sum": stats.sum,
                "count": stats.count,
                "avg": stats.avg,
                "last_timestamp": stats.last_timestamp,
            }

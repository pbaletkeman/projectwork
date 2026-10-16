import bisect
from typing import Any

class TimeWindowedStore:
    def __init__(self) -> None:
        # key -> list of (timestamp, value) , sort by timestamp
        self.store: dict[Any, list[tuple[int, Any]]] = {}

    def put(self, key: Any, value: Any, timestamp: int) -> None:
        """
        Insert (value, timestamp) for key.
        Assumes timestamps for given key are non-decreasing.
        """
        entries = self.store.get(key)
        if entries is None:
            entries = []
            self.store[key] = entries

        # if timestamps are guaranteed increasing, we can just append.
        # otherwise, we could use bisect.insort to keep it sorted.
        if entries and timestamp < entries[-1][0]:
            # fallback: insert into sorted order if monotonicity is violated.
            idx = bisect.bisect_right(entries, (timestamp, value))
            entries.insert(idx, (timestamp, value))
        else:
            entries.append((timestamp, value))

    def get(self, key: Any, start_ts: int, end_ts:int) -> list[Any]:
        """
        Return all values for a key with timestamp in [start_ts, end_ts].
        """
        entries = self.store.get(key)
        if not entries:
            return []

        # find first index with timestamp >= start_ts
        # we search on (timestamp, smallest possible value) to ensure correct position
        start_idx = bisect.bisect_left(entries,(start_ts, float("-inf")))

        result: list[Any] = []
        # scan forward until timestamp > end_ts
        for i in range(start_idx, len(entries)):
            ts, val = entries[i]
            if ts > end_ts:
                break
            result.append(val)

        return result

    def delete_older_than(self, cutoff_ts: int) -> None:
        """
        Remove all entries with timestamp < cutoff_ts for all keys
        """
        for key, entries in list(self.store.items()):
            # find first index with timestamp >= cutoff_ts
            idx = bisect.bisect_left(entries, (cutoff_ts, float("-inf")))
            if idx == 0:
                # nothing to delete
                continue
            elif idx >= len(entries):
                # all entries are older; remove the key entirely
                del self.store[key]
            else:
                # drop the prefix
                self.store[key] = entries[idx:]

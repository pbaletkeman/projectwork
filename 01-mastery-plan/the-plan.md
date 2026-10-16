# Warm-Up Interview Prep — Cleaned Up

## Foundational Backend Patterns

The original six core primitives:

1. Global mutex + condition variable
2. Counter + queue + fairness flag
3. Append-only list + binary search
4. Hash map + linked list
5. Token bucket math
6. Queue + worker threads

---

## Essential Data Structures & Algorithms

### Graph Problems

**Core patterns:** DFS, BFS, visited sets, adjacency lists, in-degree counting.

1. **Graph Traversal (DFS/BFS)** — The foundation. Given an adjacency list, print all nodes reachable from a starting node. Tests recursion, queue usage, visited sets.
2. **Detect Cycle in Directed Graph** — Use three states: unvisited, visiting, visited. Cycle exists if you revisit a "visiting" node.
3. **Detect Cycle in Undirected Graph** — DFS with parent tracking.
4. **Topological Sort** — Used for dependency resolution (course schedule, build order, task dependencies). Two approaches: DFS postorder, Kahn's algorithm (BFS + in-degree).
5. **Connected Components** — Count connected components. Used in clustering, islands problems, social networks, grouping.
6. **Shortest Path in Unweighted Graph** — Use BFS. Find minimum steps from A to B.
7. **Shortest Path in Weighted Graph (Dijkstra)** — Use a priority queue. Rarely asked to implement fully, but may be asked conceptually.
8. **Clone a Graph** — Use a map: original → cloned node. DFS or BFS both work.
9. **Number of Islands** — Grid graph problem. Use DFS/BFS to mark visited land.
10. **Word Ladder** — BFS shortest-path problem disguised as a string puzzle.

### Array Problems

1. **Two Sum** — Hash maps, O(n) reasoning.
2. **Move Zeroes** — In-place operations, stable ordering.
3. **Rotate Array** — Reverse-three-times trick.
4. **Merge Intervals** — Sorting + merging logic.
5. **Insert Interval** — Interval overlap reasoning.
6. **Product of Array Except Self** — Prefix/suffix arrays, O(n), no division.
7. **Sliding Window Maximum** — Deque, O(n) optimization.
8. **Find Missing Number** — XOR trick or sum trick.

**Core patterns:** Two Pointers (palindromes, sorted arrays, merging), Sliding Window (longest substring, max window, frequency windows), Hash Map Frequency Counting (anagrams, duplicates, substring windows), Prefix/Suffix Arrays (product except self, range sums), Sorting + Merging (intervals, anagrams, grouping).

### String Problems

1. **Reverse Words** — "the sky is blue" → "blue is sky the". Pointer manipulation, trimming, splitting.
2. **String Compression** — aabccc → a2b1c3. Run-length encoding, counting, edge cases.
3. **First Non-Repeating Character** — Frequency maps, O(n) passes.
4. **Longest Substring Without Repeating Characters** — Classic sliding window. Hash sets, window expansion/contraction.
5. **Check if Two Strings Are Anagrams** — Frequency counting, sorting.
6. **Group Anagrams** — Hashing canonical forms.
7. **Valid Palindrome** — Two-pointer technique.
8. **Longest Palindromic Substring** — Expand-around-center pattern.

### Backtracking & Permutations

**Level 1 — Warm-up (core pattern)**
- Generate all permutations of a string ("abc" → ["abc","acb","bac","bca","cab","cba"])
- Generate permutations of an integer array ([1,2,3] → all 3! permutations)
- Count permutations instead of listing them (n=5 → 120, tests factorial growth understanding)

**Level 2 — Interview-standard**
- Next permutation ([1,2,3] → [1,3,2]; [3,2,1] → [1,2,3]) — lexicographic reasoning
- Permutations with duplicates ([1,1,2] → ["112","121","211"]) — pruning + sorting + skip-duplicate logic
- K-th permutation (n=4, k=9 → "2314") — factorial number system

**Level 3 — Harder variations**
- Permutations of length k (nums=[1,2,3], k=2 → ["12","13","21","23","31","32"])
- Letter case permutations ("a1b" → ["a1b","a1B","A1b","A1B"]) — branching on characters
- Phone keypad permutations ("23" → ["ad","ae","af","bd","be","bf","cd","ce","cf"]) — mapping + recursion

**Level 4 — Advanced (rare, shows mastery)**
- Permutation sequence with constraints ("Generate permutations where no two adjacent numbers differ by 1")
- Permutation of a linked list — pointer manipulation + recursion
- Permutation of multiset with frequency map — hashmap instead of sorting + skipping

---

## System Design / Micro-Design Questions

### High-Frequency Core Questions

1. **Design a Rate Limiter** — Token bucket, sliding window, fixed window. Redis, atomic counters, fairness, burst handling.
2. **Design a URL Shortener** — Hashing, collision avoidance, DB schema, read/write patterns.
3. **Design a Caching Layer** — Eviction (LRU), TTL, invalidation, cache stampede protection.
4. **Design a Job Queue** — Workers, retries, DLQ, visibility timeout.
5. **Design a Notification System** — Fan-out, retries, rate limiting, multi-channel delivery.

### CRUD-Heavy & Data-Flow Questions

6. **Design a Search Autocomplete** — Trie vs prefix index, caching, ranking, latency.
7. **Design a Favorites/Likes Feature** — Idempotent writes, pagination, DB schema.
8. **Design a Listing Recommendation Engine** — Signals, scoring, caching, batch jobs.
9. **Design a File Upload Service** — Chunking, resumable uploads, virus scanning, CDN.

### Web Infrastructure Questions

10. **Design an Idempotent API** — PUT vs PATCH, idempotency keys, retries.
11. **Design a Pagination System** — Offset vs cursor, consistency, performance.
12. **Design a Logging Pipeline** — Batching, ingestion, storage, querying.

### Concurrency-Focused Micro-Design

13. **Design a Thread-Safe Counter** — Locks, CAS, atomic operations.
14. **Design a Worker Pool** — Queue, workers, backpressure, graceful shutdown.
15. **Design a Read-Write Lock** — Fairness, starvation, concurrency.

---

## Concurrency Concepts

- What is a race condition?
- What is a deadlock?
- What is a lost wakeup?
- What is a thundering herd problem?
- What is a critical section?
- What is atomicity?
- What is a memory barrier?

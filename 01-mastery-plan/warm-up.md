# Warm-up Notes

> Note: the "6 patterns" were the core primitives, not the full universe. Each item begins with a Guided Link.
>
> The original six foundational backend patterns:
>
> - Global mutex + condition variable
> - Counter + queue + fairness flag
> - Append-only list + binary search
> - Hash map + linked list
> - Token bucket math
> - Queue + worker threads

---

## 1. Micro-Design Questions

### Category 1 — High-frequency micro-design

These appear constantly in short interviews.

1. **Design a Rate Limiter**
   Token bucket, sliding window, fixed window.
   Key topics: Redis, atomic counters, fairness, burst handling.

2. **Design a URL Shortener**
   Hashing, collision avoidance, DB schema, read/write patterns.

3. **Design a Caching Layer**
   Eviction (LRU), TTL, invalidation, cache stampede protection.

4. **Design a Job Queue**
   Workers, retries, DLQ, visibility timeout.

5. **Design a Notification System**
   Fan-out, retries, rate limiting, multi-channel delivery.

### Category 2 — Data-flow & CRUD-heavy

Houseful is a real-estate platform → lots of CRUD, search, and filtering.

6. **Design a Search Autocomplete**
   Trie vs prefix index, caching, ranking, latency.

7. **Design a "Favorites" Feature**
   Idempotent writes, pagination, DB schema.

8. **Design a Listing Recommendation Engine**
   Signals, scoring, caching, batch jobs.

9. **Design a File Upload Service**
   Chunking, resumable uploads, virus scanning, CDN.

### Category 3 — Web infrastructure

These test HTTP knowledge + backend reasoning.

10. **Design an Idempotent API**
    PUT vs PATCH, idempotency keys, retries.

11. **Design a Pagination System**
    Offset vs cursor, consistency, performance.

12. **Design a Logging Pipeline**
    Batching, ingestion, storage, querying.

### Category 4 — Concurrency-focused micro-design

13. **Design a Thread-Safe Counter**
    Locks, CAS, atomic operations.

14. **Design a Worker Pool**
    Queue, workers, backpressure, graceful shutdown.

15. **Design a Read-Write Lock**
    Fairness, starvation, concurrency.

---

## 2. Concurrency Correctness (Conceptual)

You're already strong here — but they may ask conceptual questions:

- What is a race condition?
- What is a deadlock?
- What is a lost wakeup?
- What is a thundering herd problem?
- What is a critical section?
- What is atomicity?
- What is a memory barrier?

---

## 3. Graph Problems

### Essential problems

1. **Graph Traversal (DFS/BFS)** — the foundation of everything.
   Typical prompt: given an adjacency list, print all nodes reachable from a starting node.
   Tests: recursion, queue usage, visited sets.

2. **Detect Cycle in Directed Graph** — classic interview question.
   Key idea: use three states — unvisited, visiting, visited.
   Cycle exists if you revisit a "visiting" node.

3. **Detect Cycle in Undirected Graph** — simpler: DFS with parent tracking.

4. **Topological Sort** — used for dependency resolution.
   Examples: course schedule, build order, task dependencies.
   Two approaches: DFS postorder, or Kahn's algorithm (BFS + in-degree).

5. **Connected Components** — given a graph, count how many connected components exist.
   Used in: clustering, islands problems, social networks, grouping.

6. **Shortest Path in Unweighted Graph** — use BFS.
   Example: find minimum number of steps from A to B.

7. **Shortest Path in Weighted Graph (Dijkstra)** — use a priority queue.
   Interviewers rarely ask you to implement this fully, but they may ask conceptually.

8. **Clone a Graph** — very common.
   Key idea: use a map from original → cloned node. DFS or BFS both work.

9. **Number of Islands** — a grid graph problem.
   Use DFS/BFS to mark visited land.

10. **Word Ladder** — a BFS shortest-path problem disguised as a string puzzle.

### Patterns you must know

These patterns appear in almost every graph question:

- **DFS** — recursive or stack-based.
- **BFS** — queue-based, level-order traversal.
- **Visited sets** — prevent infinite loops.
- **Adjacency lists** — most common representation.
- **In-degree counting** — used in topological sort.

### Lightweight graph reasoning

- Detect cycles
- Topological sort
- BFS/DFS traversal
- Shortest path in an unweighted graph
- Graph-like data models

---

## 4. Array Problems

1. **Two Sum** — tests hash maps, O(n) reasoning.
2. **Move Zeroes** — tests in-place operations, stable ordering.
3. **Rotate Array** — tests reverse-three-times trick.
4. **Merge Intervals** — tests sorting + merging logic.
5. **Insert Interval** — tests interval overlap reasoning.
6. **Product of Array Except Self** — tests prefix/suffix arrays, O(n), no division.
7. **Sliding Window Maximum** — tests deque, O(n) optimization.
8. **Find Missing Number** — tests XOR trick or sum trick.

### Patterns you must know

These patterns appear repeatedly across string/array problems:

- **Two Pointers** — palindromes, sorted arrays, merging.
- **Sliding Window** — longest substring, max window, frequency windows.
- **Hash Map Frequency Counting** — anagrams, duplicates, substring windows.
- **Prefix/Suffix Arrays** — product except self, range sums.
- **Sorting + Merging** — intervals, anagrams, grouping.

---

## 5. String Problems

1. **Reverse Words**
   Given `"the sky is blue"` → `"blue is sky the"`
   Tests: pointer manipulation, trimming, splitting.

2. **String Compression**
   `aabccc` → `a2b1c3`
   Tests: run-length encoding, counting, edge cases.

3. **First Non-Repeating Character** — tests frequency maps, O(n) passes.

4. **Longest Substring Without Repeating Characters** — classic sliding window.
   Tests: hash sets, window expansion/contraction.

5. **Check if Two Strings Are Anagrams** — tests frequency counting, sorting.

6. **Group Anagrams** — tests hashing canonical forms.

7. **Valid Palindrome** — tests two-pointer technique.

8. **Longest Palindromic Substring** — tests expand-around-center pattern.

---

## 6. Permutations & Backtracking

### Level 1 — Warm-up (core pattern)

These test whether you can implement the basic backtracking template cleanly.

- **Generate all permutations of a string**
  Input: `"abc"` → Output: `["abc","acb","bac","bca","cab","cba"]`
- **Generate permutations of an integer array**
  Input: `[1,2,3]` → Output: all 3! permutations
- **Count permutations instead of listing them**
  Input: `n = 5` → Output: `120` (tests whether you understand factorial growth)

### Level 2 — Interview-standard permutation problems

These are the ones companies actually ask.

- **Next permutation**
  Input: `[1,2,3]` → Output: `[1,3,2]`
  Input: `[3,2,1]` → Output: `[1,2,3]`
  (Tests lexicographic reasoning)
- **Permutations with duplicates**
  Input: `[1,1,2]` → Output: `["112","121","211"]`
  (Tests pruning + sorting + skip-duplicate logic)
- **K-th permutation**
  Input: `n=4, k=9` → Output: `"2314"`
  (Tests factorial number system)

### Level 3 — Harder backtracking variations

These test whether you can adapt the permutation template to constraints.

- **Permutations of length k**
  Input: `nums=[1,2,3], k=2` → Output: `["12","13","21","23","31","32"]`
- **Letter case permutations**
  Input: `"a1b"` → Output: `["a1b","a1B","A1b","A1B"]`
  (Tests branching on characters)
- **Phone keypad permutations**
  Input: `"23"` → Output: `["ad","ae","af","bd","be","bf","cd","ce","cf"]`
  (Tests mapping + recursion)

### Level 4 — Advanced (if they want to push you)

These are rare but show mastery.

- **Permutation sequence with constraints**
  Example: "Generate permutations where no two adjacent numbers differ by 1."
- **Permutation of a linked list** — tests pointer manipulation + recursion.
- **Permutation of multiset with frequency map** — tests using a hashmap instead of sorting + skipping.

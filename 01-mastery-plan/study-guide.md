# 30-Day Backend Foundations Mastery Plan
### (Java + Python Implementation)
### Based on `the-plan.md`

This plan assumes **3–4 hours/day**, broken into **1-hour segments**.
Every segment includes **learning**, **coding**, and **reinforcement**.

---

# WEEK 1 — Core Concurrency Primitives (from the-plan.md)

## Day 1 — Global Mutex + Condition Variable
### Segment 1 — Concept Study
- Understand: mutex, condition variable, critical section, atomicity.
- Read: “Global mutex + condition variable” (from the-plan.md).

### Segment 2 — Java Implementation
**Task:** Implement a `BoundedBuffer` using `ReentrantLock` + `Condition`.

### Segment 3 — Python Implementation
**Task:** Implement the same using `threading.Lock` + `threading.Condition`.

### Segment 4 — Coding Problem
**Problem:**
Implement a thread-safe `BlockingQueue` with:
- `put(item)`
- `take()`
- Blocking behavior when full/empty.

---

## Day 2 — Counter + Queue + Fairness Flag
### Segment 1 — Concept Study
- Understand fairness, starvation, counters, queues.

### Segment 2 — Java Implementation
**Task:**
Implement a fair semaphore using:
- Counter
- FIFO queue
- Fairness flag

### Segment 3 — Python Implementation
Same as above using `threading`.

### Segment 4 — Coding Problem
**Problem:**
Build a fair `RateLimiter` that ensures FIFO fairness for requests.

---

## Day 3 — Append-Only List + Binary Search
### Segment 1 — Concept Study
- Append-only logs
- Binary search invariants

### Segment 2 — Java Implementation
**Task:**
Implement an append-only log with binary search lookup.

### Segment 3 — Python Implementation
Same task.

### Segment 4 — Coding Problem
**Problem:**
Given a sorted append-only list of timestamps, implement:
- `findFirstEventAfter(t)`
- `findLastEventBefore(t)`

---

## Day 4 — Hash Map + Linked List
### Segment 1 — Concept Study
- LRU cache internals
- Hash map + doubly linked list

### Segment 2 — Java Implementation
Implement LRU Cache.

### Segment 3 — Python Implementation
Implement LRU Cache.

### Segment 4 — Coding Problem
**Problem:**
Implement LRU with:
- `get(key)`
- `put(key, value)`
- O(1) operations

---

## Day 5 — Token Bucket Math
### Segment 1 — Concept Study
- Token bucket refill rate
- Burst capacity
- Fairness

### Segment 2 — Java Implementation
Implement `TokenBucketRateLimiter`.

### Segment 3 — Python Implementation
Same.

### Segment 4 — Coding Problem
**Problem:**
Implement a rate limiter that:
- Allows `N` requests per second
- Supports bursts of size `B`
- Rejects excess requests

---

## Day 6 — Queue + Worker Threads
### Segment 1 — Concept Study
- Worker pool
- Backpressure
- Graceful shutdown

### Segment 2 — Java Implementation
Implement worker pool with:
- Task queue
- Worker threads
- Shutdown signal

### Segment 3 — Python Implementation
Same.

### Segment 4 — Coding Problem
**Problem:**
Implement a worker pool that processes jobs and retries failed jobs once.

---

## Day 7 — Consolidation Day
### Segment 1 — Review
Review all 6 primitives.

### Segment 2 — Mixed Java/Python Drills
Implement 2 primitives from scratch.

### Segment 3 — Interview Simulation
Explain each primitive verbally.

### Segment 4 — Coding Problem
**Problem:**
Build a mini “threading library” that includes:
- Mutex wrapper
- Condition wrapper
- Semaphore
- Worker pool

---

# WEEK 2 — Graphs, Arrays, Strings (from the-plan.md)

## Day 8 — DFS + BFS
### Segment 1 — Concept Study
- Adjacency lists
- Visited sets

### Segment 2 — Java Implementation
DFS + BFS.

### Segment 3 — Python Implementation
DFS + BFS.

### Segment 4 — Coding Problem
**Problem:**
Given a graph, print all nodes reachable from `start`.

---

## Day 9 — Cycle Detection (Directed + Undirected)
### Segment 1 — Concept Study
- 3-state marking
- Parent tracking

### Segment 2 — Java Implementation
Cycle detection.

### Segment 3 — Python Implementation
Cycle detection.

### Segment 4 — Coding Problem
**Problem:**
Detect cycle in:
- Directed graph
- Undirected graph

---

## Day 10 — Topological Sort
### Segment 1 — Concept Study
- DFS postorder
- Kahn’s algorithm

### Segment 2 — Java Implementation
Topo sort.

### Segment 3 — Python Implementation
Topo sort.

### Segment 4 — Coding Problem
**Problem:**
Course schedule problem.

---

## Day 11 — Connected Components + Islands
### Segment 1 — Concept Study
- Components
- Grid graphs

### Segment 2 — Java Implementation
Connected components.

### Segment 3 — Python Implementation
Number of islands.

### Segment 4 — Coding Problem
**Problem:**
Count connected components in a graph.

---

## Day 12 — Array Patterns (Two Pointers, Sliding Window)
### Segment 1 — Concept Study
- Two pointers
- Sliding window
- Frequency maps

### Segment 2 — Java Implementation
Longest substring without repeating characters.

### Segment 3 — Python Implementation
Sliding window maximum.

### Segment 4 — Coding Problem
**Problem:**
Group anagrams.

---

## Day 13 — Interval Problems
### Segment 1 — Concept Study
- Sorting + merging
- Overlap logic

### Segment 2 — Java Implementation
Merge intervals.

### Segment 3 — Python Implementation
Insert interval.

### Segment 4 — Coding Problem
**Problem:**
Given intervals, insert a new interval and merge.

---

## Day 14 — String Patterns
### Segment 1 — Concept Study
- Palindromes
- Run-length encoding
- Anagrams

### Segment 2 — Java Implementation
Longest palindromic substring.

### Segment 3 — Python Implementation
Reverse words.

### Segment 4 — Coding Problem
**Problem:**
String compression.

---

# WEEK 3 — Backtracking & Permutations (Level 1–4)

## Day 15 — Level 1 Permutations
### Segment 1 — Concept Study
- Backtracking template
- Swap-based vs used-array

### Segment 2 — Java Implementation
Generate permutations of string.

### Segment 3 — Python Implementation
Generate permutations of array.

### Segment 4 — Coding Problem
**Problem:**
Count permutations (n=5 → 120).

---

## Day 16 — Level 2 Permutations
### Segment 1 — Concept Study
- Next permutation
- Duplicate pruning
- Factorial number system

### Segment 2 — Java Implementation
Next permutation.

### Segment 3 — Python Implementation
Permutations with duplicates.

### Segment 4 — Coding Problem
**Problem:**
K-th permutation.

---

## Day 17 — Level 3 Permutations
### Segment 1 — Concept Study
- Branching
- Character mapping

### Segment 2 — Java Implementation
Letter case permutations.

### Segment 3 — Python Implementation
Phone keypad permutations.

### Segment 4 — Coding Problem
**Problem:**
Permutations of length k.

---

## Day 18 — Level 4 Permutations
### Segment 1 — Concept Study
- Constraint-based permutations
- Multiset permutations

### Segment 2 — Java Implementation
Permutation with adjacency constraints.

### Segment 3 — Python Implementation
Permutation of multiset using frequency map.

### Segment 4 — Coding Problem
**Problem:**
Generate permutations where no two adjacent numbers differ by 1.

---

## Day 19 — Consolidation Day
### Segment 1 — Review
All permutation levels.

### Segment 2 — Mixed Java/Python Drills
Implement 2 permutation problems from scratch.

### Segment 3 — Interview Simulation
Explain backtracking template.

### Segment 4 — Coding Problem
**Problem:**
Implement a generic backtracking engine.

---

# WEEK 4 — System Design + Concurrency Theory

## Day 20 — Rate Limiter Design
### Segment 1 — Concept Study
Token bucket, sliding window.

### Segment 2 — Java Implementation
Rate limiter.

### Segment 3 — Python Implementation
Rate limiter.

### Segment 4 — Coding Problem
**Problem:**
Design a distributed rate limiter using Redis.

---

## Day 21 — URL Shortener + Caching Layer
### Segment 1 — Concept Study
Hashing, collisions, TTL, eviction.

### Segment 2 — Java Implementation
URL shortener.

### Segment 3 — Python Implementation
LRU cache.

### Segment 4 — Coding Problem
**Problem:**
Implement cache stampede protection.

---

## Day 22 — Job Queue + Notification System
### Segment 1 — Concept Study
Workers, retries, DLQ.

### Segment 2 — Java Implementation
Job queue.

### Segment 3 — Python Implementation
Notification fan-out.

### Segment 4 — Coding Problem
**Problem:**
Implement retry with exponential backoff.

---

## Day 23 — Search Autocomplete + Favorites Feature
### Segment 1 — Concept Study
Trie, prefix index, idempotency.

### Segment 2 — Java Implementation
Autocomplete.

### Segment 3 — Python Implementation
Favorites feature.

### Segment 4 — Coding Problem
**Problem:**
Implement cursor-based pagination.

---

## Day 24 — Logging Pipeline + Pagination
### Segment 1 — Concept Study
Batching, ingestion, storage.

### Segment 2 — Java Implementation
Logging pipeline.

### Segment 3 — Python Implementation
Cursor pagination.

### Segment 4 — Coding Problem
**Problem:**
Implement log ingestion with batching.

---

## Day 25 — Concurrency Theory
### Segment 1 — Concept Study
Race condition, deadlock, lost wakeup, thundering herd, memory barrier.

### Segment 2 — Java Implementation
Thread-safe counter.

### Segment 3 — Python Implementation
Read-write lock.

### Segment 4 — Coding Problem
**Problem:**
Implement a fair read-write lock.

---

## Day 26 — Worker Pool + Backpressure
### Segment 1 — Concept Study
Backpressure, graceful shutdown.

### Segment 2 — Java Implementation
Worker pool.

### Segment 3 — Python Implementation
Worker pool.

### Segment 4 — Coding Problem
**Problem:**
Implement bounded worker pool with backpressure.

---

## Day 27 — Micro-Design Drills
### Segment 1 — Rate limiter
### Segment 2 — Caching layer
### Segment 3 — Job queue
### Segment 4 — Notification system

---

## Day 28 — Full System Design Simulation
### Segment 1 — URL shortener
### Segment 2 — Search autocomplete
### Segment 3 — Logging pipeline
### Segment 4 — Favorites feature

---

## Day 29 — Mixed Java/Python Interview Drills
### Segment 1 — Graph problem
### Segment 2 — Array problem
### Segment 3 — String problem
### Segment 4 — Concurrency problem

---

## Day 30 — Final Consolidation
### Segment 1 — Review all primitives
### Segment 2 — Review all patterns
### Segment 3 — Review all designs
### Segment 4 — Mock interview simulation

---

# End of Plan

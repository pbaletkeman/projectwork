# 30-Day Backend Foundations Mastery Plan

## (Java, Kotlin + Python Implementation)

- [30-Day Backend Foundations Mastery Plan](#30-day-backend-foundations-mastery-plan)
  - [(Java, Kotlin + Python Implementation)](#java-kotlin--python-implementation)
  - [Based on `the-plan.md`](#based-on-the-planmd)
  - [WEEK 1 — Core Concurrency Primitives (from the-plan.md)](#week-1--core-concurrency-primitives-from-the-planmd)
    - [Day 1 — Global Mutex + Condition Variable](#day-1--global-mutex--condition-variable)
      - [Segment 1 — Concept Study - Day 1](#segment-1--concept-study---day-1)
      - [Segment 2 — Java Implementation - Day 1](#segment-2--java-implementation---day-1)
      - [Segment 3 — Kotlin Implementation - Day 1](#segment-3--kotlin-implementation---day-1)
      - [Segment 4 — Python Implementation - Day 1](#segment-4--python-implementation---day-1)
      - [Segment 5 — Coding Problem - Day 1](#segment-5--coding-problem---day-1)
    - [Day 2 — Counter + Queue + Fairness Flag](#day-2--counter--queue--fairness-flag)
      - [Segment 1 — Concept Study - Day 2](#segment-1--concept-study---day-2)
      - [Segment 2 — Java Implementation - Day 2](#segment-2--java-implementation---day-2)
      - [Segment 3 — Kotlin Implementation - Day 2](#segment-3--kotlin-implementation---day-2)
      - [Segment 4 — Python Implementation - Day 2](#segment-4--python-implementation---day-2)
      - [Segment 5 — Coding Problem - Day 2](#segment-5--coding-problem---day-2)
    - [Day 3 — Append-Only List + Binary Search](#day-3--append-only-list--binary-search)
      - [Segment 1 — Concept Study - Day 3](#segment-1--concept-study---day-3)
      - [Segment 2 — Java Implementation - Day 3](#segment-2--java-implementation---day-3)
      - [Segment 3 — Kotlin Implementation - Day 3](#segment-3--kotlin-implementation---day-3)
      - [Segment 4 — Python Implementation - Day 3](#segment-4--python-implementation---day-3)
      - [Segment 5 — Coding Problem - Day 3](#segment-5--coding-problem---day-3)
    - [Day 4 — Hash Map + Linked List](#day-4--hash-map--linked-list)
      - [Segment 1 — Concept Study - Day 4](#segment-1--concept-study---day-4)
      - [Segment 2 — Java Implementation - Day 4](#segment-2--java-implementation---day-4)
      - [Segment 3 — Kotlin Implementation - Day 4](#segment-3--kotlin-implementation---day-4)
      - [Segment 4 — Python Implementation - Day 4](#segment-4--python-implementation---day-4)
      - [Segment 5 — Coding Problem - Day 4](#segment-5--coding-problem---day-4)
    - [Day 5 — Token Bucket Math](#day-5--token-bucket-math)
      - [Segment 1 — Concept Study - Day 5](#segment-1--concept-study---day-5)
      - [Segment 2 — Java Implementation - Day 5](#segment-2--java-implementation---day-5)
      - [Segment 3 — Kotlin Implementation - Day 5](#segment-3--kotlin-implementation---day-5)
      - [Segment 4 — Python Implementation - Day 5](#segment-4--python-implementation---day-5)
      - [Segment 5 — Coding Problem - Day 5](#segment-5--coding-problem---day-5)
    - [Day 6 — Queue + Worker Threads](#day-6--queue--worker-threads)
      - [Segment 1 — Concept Study - Day 6](#segment-1--concept-study---day-6)
      - [Segment 2 — Java Implementation - Day 6](#segment-2--java-implementation---day-6)
      - [Segment 3 — Kotlin Implementation - Day 6](#segment-3--kotlin-implementation---day-6)
      - [Segment 4 — Python Implementation - Day 6](#segment-4--python-implementation---day-6)
      - [Segment 5 — Coding Problem - Day 6](#segment-5--coding-problem---day-6)
    - [Day 7 — Consolidation Day](#day-7--consolidation-day)
      - [Segment 1 — Review - Day 7](#segment-1--review---day-7)
      - [Segment 2 — Mixed Java/Python Drills - Day 7](#segment-2--mixed-javapython-drills---day-7)
      - [Segment 3 — Interview Simulation - Day 7](#segment-3--interview-simulation---day-7)
      - [Segment 4 — Coding Problem - Day 7](#segment-4--coding-problem---day-7)
      - [Segment 5 — Kotlin Implementation - Day 7](#segment-5--kotlin-implementation---day-7)
  - [WEEK 2 — Graphs, Arrays, Strings (from the-plan.md)](#week-2--graphs-arrays-strings-from-the-planmd)
    - [Day 8 — DFS + BFS](#day-8--dfs--bfs)
      - [Segment 1 — Concept Study - Day 8](#segment-1--concept-study---day-8)
      - [Segment 2 — Java Implementation - Day 8](#segment-2--java-implementation---day-8)
      - [Segment 3 — Kotlin Implementation - Day 8](#segment-3--kotlin-implementation---day-8)
      - [Segment 4 — Python Implementation - Day 8](#segment-4--python-implementation---day-8)
      - [Segment 5 — Coding Problem - Day 8](#segment-5--coding-problem---day-8)
    - [Day 9 — Cycle Detection (Directed + Undirected)](#day-9--cycle-detection-directed--undirected)
      - [Segment 1 — Concept Study - Day 9](#segment-1--concept-study---day-9)
      - [Segment 2 — Java Implementation - Day 9](#segment-2--java-implementation---day-9)
      - [Segment 3 — Kotlin Implementation - Day 9](#segment-3--kotlin-implementation---day-9)
      - [Segment 4 — Python Implementation - Day 9](#segment-4--python-implementation---day-9)
      - [Segment 5 — Coding Problem - Day 9](#segment-5--coding-problem---day-9)
    - [Day 10 — Topological Sort](#day-10--topological-sort)
      - [Segment 1 — Concept Study - Day 10](#segment-1--concept-study---day-10)
      - [Segment 2 — Java Implementation - Day 10](#segment-2--java-implementation---day-10)
      - [Segment 3 — Kotlin Implementation - Day 10](#segment-3--kotlin-implementation---day-10)
      - [Segment 4 — Python Implementation - Day 10](#segment-4--python-implementation---day-10)
      - [Segment 5 — Coding Problem - Day 10](#segment-5--coding-problem---day-10)
    - [Day 11 — Connected Components + Islands](#day-11--connected-components--islands)
      - [Segment 1 — Concept Study - Day 11](#segment-1--concept-study---day-11)
      - [Segment 2 — Java Implementation - Day 11](#segment-2--java-implementation---day-11)
      - [Segment 3 — Kotlin Implementation - Day 11](#segment-3--kotlin-implementation---day-11)
      - [Segment 4 — Python Implementation - Day 11](#segment-4--python-implementation---day-11)
      - [Segment 5 — Coding Problem - Day 11](#segment-5--coding-problem---day-11)
    - [Day 12 — Array Patterns (Two Pointers, Sliding Window)](#day-12--array-patterns-two-pointers-sliding-window)
      - [Segment 1 — Concept Study - Day 12](#segment-1--concept-study---day-12)
      - [Segment 2 — Java Implementation - Day 12](#segment-2--java-implementation---day-12)
      - [Segment 3 — Kotlin Implementation - Day 12](#segment-3--kotlin-implementation---day-12)
      - [Segment 4 — Python Implementation - Day 12](#segment-4--python-implementation---day-12)
      - [Segment 5 — Coding Problem - Day 12](#segment-5--coding-problem---day-12)
    - [Day 13 — Interval Problems](#day-13--interval-problems)
      - [Segment 1 — Concept Study - Day 13](#segment-1--concept-study---day-13)
      - [Segment 2 — Java Implementation - Day 13](#segment-2--java-implementation---day-13)
      - [Segment 3 — Kotlin Implementation - Day 13](#segment-3--kotlin-implementation---day-13)
      - [Segment 4 — Python Implementation - Day 13](#segment-4--python-implementation---day-13)
      - [Segment 5 — Coding Problem - Day 13](#segment-5--coding-problem---day-13)
    - [Day 14 — String Patterns](#day-14--string-patterns)
      - [Segment 1 — Concept Study - Day 14](#segment-1--concept-study---day-14)
      - [Segment 2 — Java Implementation - Day 14](#segment-2--java-implementation---day-14)
      - [Segment 3 — Kotlin Implementation - Day 14](#segment-3--kotlin-implementation---day-14)
      - [Segment 4 — Python Implementation - Day 14](#segment-4--python-implementation---day-14)
      - [Segment 5 — Coding Problem - Day 14](#segment-5--coding-problem---day-14)
  - [WEEK 3 — Backtracking \& Permutations (Level 1–4)](#week-3--backtracking--permutations-level-14)
    - [Day 15 — Level 1 Permutations - Day 15](#day-15--level-1-permutations---day-15)
      - [Segment 1 — Concept Study - Day 15](#segment-1--concept-study---day-15)
      - [Segment 2 — Java Implementation - Day 15](#segment-2--java-implementation---day-15)
      - [Segment 3 — Kotlin Implementation - Day 15](#segment-3--kotlin-implementation---day-15)
      - [Segment 4 — Python Implementation - Day 15](#segment-4--python-implementation---day-15)
      - [Segment 5 — Coding Problem - Day 15](#segment-5--coding-problem---day-15)
    - [Day 16 — Level 2 Permutations](#day-16--level-2-permutations)
      - [Segment 1 — Concept Study - Day 16](#segment-1--concept-study---day-16)
      - [Segment 2 — Java Implementation - Day 16](#segment-2--java-implementation---day-16)
      - [Segment 3 — Kotlin Implementation - Day 16](#segment-3--kotlin-implementation---day-16)
      - [Segment 4 — Python Implementation - Day 16](#segment-4--python-implementation---day-16)
      - [Segment 5 — Coding Problem - Day 16](#segment-5--coding-problem---day-16)
    - [Day 17 — Level 3 Permutations](#day-17--level-3-permutations)
      - [Segment 1 — Concept Study - Day 17](#segment-1--concept-study---day-17)
      - [Segment 2 — Java Implementation - Day 17](#segment-2--java-implementation---day-17)
      - [Segment 3 — Kotlin Implementation - Day 17](#segment-3--kotlin-implementation---day-17)
      - [Segment 4 — Python Implementation - Day 17](#segment-4--python-implementation---day-17)
      - [Segment 5 — Coding Problem - Day 17](#segment-5--coding-problem---day-17)
    - [Day 18 — Level 4 Permutations](#day-18--level-4-permutations)
      - [Segment 1 — Concept Study - Day 18](#segment-1--concept-study---day-18)
      - [Segment 2 — Java Implementation - Day 18](#segment-2--java-implementation---day-18)
      - [Segment 3 — Kotlin Implementation - Day 18](#segment-3--kotlin-implementation---day-18)
      - [Segment 4 — Python Implementation - Day 18](#segment-4--python-implementation---day-18)
      - [Segment 5 — Coding Problem - Day 18](#segment-5--coding-problem---day-18)
    - [Day 19 — Consolidation Day](#day-19--consolidation-day)
      - [Segment 1 — Review - Day 19](#segment-1--review---day-19)
      - [Segment 2 — Mixed Java/Python Drills - Day 19](#segment-2--mixed-javapython-drills---day-19)
      - [Segment 3 — Interview Simulation - Day 19](#segment-3--interview-simulation---day-19)
      - [Segment 4 — Coding Problem - Day 19](#segment-4--coding-problem---day-19)
      - [Segment 5 — Kotlin Implementation - Day 19](#segment-5--kotlin-implementation---day-19)
  - [WEEK 4 — System Design + Concurrency Theory](#week-4--system-design--concurrency-theory)
    - [Day 20 — Rate Limiter Design - Day 20](#day-20--rate-limiter-design---day-20)
      - [Segment 1 — Concept Study - Day 20](#segment-1--concept-study---day-20)
      - [Segment 2 — Java Implementation - Day 20](#segment-2--java-implementation---day-20)
      - [Segment 3 — Kotlin Implementation - Day 20](#segment-3--kotlin-implementation---day-20)
      - [Segment 4 — Python Implementation - Day 20](#segment-4--python-implementation---day-20)
      - [Segment 5 — Coding Problem - Day 20](#segment-5--coding-problem---day-20)
    - [Day 21 — URL Shortener + Caching Layer](#day-21--url-shortener--caching-layer)
      - [Segment 1 — Concept Study - Day 21](#segment-1--concept-study---day-21)
      - [Segment 2 — Java Implementation - Day 21](#segment-2--java-implementation---day-21)
      - [Segment 3 — Kotlin Implementation - Day 21](#segment-3--kotlin-implementation---day-21)
      - [Segment 4 — Python Implementation - Day 21](#segment-4--python-implementation---day-21)
      - [Segment 5 — Coding Problem - Day 21](#segment-5--coding-problem---day-21)
    - [Day 22 — Job Queue + Notification System](#day-22--job-queue--notification-system)
      - [Segment 1 — Concept Study - Day 22](#segment-1--concept-study---day-22)
      - [Segment 2 — Java Implementation - Day 22](#segment-2--java-implementation---day-22)
      - [Segment 3 — Kotlin Implementation - Day 22](#segment-3--kotlin-implementation---day-22)
      - [Segment 4 — Python Implementation - Day 22](#segment-4--python-implementation---day-22)
      - [Segment 5 — Coding Problem - Day 22](#segment-5--coding-problem---day-22)
    - [Day 23 — Search Autocomplete + Favorites Feature](#day-23--search-autocomplete--favorites-feature)
      - [Segment 1 — Concept Study - Day 23](#segment-1--concept-study---day-23)
      - [Segment 2 — Java Implementation - Day 23](#segment-2--java-implementation---day-23)
      - [Segment 3 — Kotlin Implementation - Day 23](#segment-3--kotlin-implementation---day-23)
      - [Segment 4 — Python Implementation - Day 23](#segment-4--python-implementation---day-23)
      - [Segment 5 — Coding Problem - Day 23](#segment-5--coding-problem---day-23)
    - [Day 24 — Logging Pipeline + Pagination](#day-24--logging-pipeline--pagination)
      - [Segment 1 — Concept Study - Day 24](#segment-1--concept-study---day-24)
      - [Segment 2 — Java Implementation - Day 24](#segment-2--java-implementation---day-24)
      - [Segment 3 — Kotlin Implementation - Day 24](#segment-3--kotlin-implementation---day-24)
      - [Segment 4 — Python Implementation - Day 24](#segment-4--python-implementation---day-24)
      - [Segment 5 — Coding Problem - Day 24](#segment-5--coding-problem---day-24)
    - [Day 25 — Concurrency Theory](#day-25--concurrency-theory)
      - [Segment 1 — Concept Study - Day 25](#segment-1--concept-study---day-25)
      - [Segment 2 — Java Implementation - Day 25](#segment-2--java-implementation---day-25)
      - [Segment 3 — Kotlin Implementation - Day 25](#segment-3--kotlin-implementation---day-25)
      - [Segment 4 — Python Implementation - Day 25](#segment-4--python-implementation---day-25)
      - [Segment 5 — Coding Problem - Day 25](#segment-5--coding-problem---day-25)
    - [Day 26 — Worker Pool + Backpressure](#day-26--worker-pool--backpressure)
      - [Segment 1 — Concept Study - Day 26](#segment-1--concept-study---day-26)
      - [Segment 2 — Java Implementation - Day 26](#segment-2--java-implementation---day-26)
      - [Segment 3 — Kotlin Implementation - Day 26](#segment-3--kotlin-implementation---day-26)
      - [Segment 4 — Python Implementation - Day 26](#segment-4--python-implementation---day-26)
      - [Segment 5 — Coding Problem - Day 26](#segment-5--coding-problem---day-26)
    - [Day 27 — Micro-Design Drills](#day-27--micro-design-drills)
      - [Segment 1 — Rate limiter - Day 27](#segment-1--rate-limiter---day-27)
      - [Segment 2 — Caching layer - Day 27](#segment-2--caching-layer---day-27)
      - [Segment 3 — Job queue - Day 27](#segment-3--job-queue---day-27)
      - [Segment 4 — Notification system - Day 27](#segment-4--notification-system---day-27)
      - [Segment 5 — Kotlin Implementation - Day 27](#segment-5--kotlin-implementation---day-27)
    - [Day 28 — Full System Design Simulation](#day-28--full-system-design-simulation)
      - [Segment 1 — URL shortener - Day 28](#segment-1--url-shortener---day-28)
      - [Segment 2 — Search autocomplete - Day 28](#segment-2--search-autocomplete---day-28)
      - [Segment 3 — Logging pipeline - Day 28](#segment-3--logging-pipeline---day-28)
      - [Segment 4 — Favorites feature - Day 28](#segment-4--favorites-feature---day-28)
      - [Segment 5 — Kotlin Implementation - Day 28](#segment-5--kotlin-implementation---day-28)
    - [Day 29 — Mixed Java/Python Interview Drills](#day-29--mixed-javapython-interview-drills)
      - [Segment 1 — Graph problem - Day 29](#segment-1--graph-problem---day-29)
      - [Segment 2 — Array problem - Day 29](#segment-2--array-problem---day-29)
      - [Segment 3 — String problem - Day 29](#segment-3--string-problem---day-29)
      - [Segment 4 — Concurrency problem - Day 29](#segment-4--concurrency-problem---day-29)
      - [Segment 5 — Kotlin Implementation - Day 29](#segment-5--kotlin-implementation---day-29)
    - [Day 30 — Final Consolidation](#day-30--final-consolidation)
      - [Segment 1 — Review all primitives - Day 30](#segment-1--review-all-primitives---day-30)
      - [Segment 2 — Review all patterns - Day 30](#segment-2--review-all-patterns---day-30)
      - [Segment 3 — Review all designs - Day 30](#segment-3--review-all-designs---day-30)
      - [Segment 4 — Mock interview simulation - Day 30](#segment-4--mock-interview-simulation---day-30)
      - [Segment 5 — Kotlin Implementation - Day 30](#segment-5--kotlin-implementation---day-30)

## Based on `the-plan.md`

This plan assumes **3–4 hours/day**, broken into **1-hour segments**.
Every segment includes **learning**, **coding**, and **reinforcement**.

---

## WEEK 1 — Core Concurrency Primitives (from the-plan.md)

### Day 1 — Global Mutex + Condition Variable

#### Segment 1 — Concept Study - Day 1

- Understand: mutex, condition variable, critical section, atomicity.
- Read: “Global mutex + condition variable” (from the-plan.md).

#### Segment 2 — Java Implementation - Day 1

**Task:** Implement a `BoundedBuffer` using `ReentrantLock` + `Condition`.

#### Segment 3 — Kotlin Implementation - Day 1

**Task:**
Implement a `BoundedBuffer` using `ReentrantLock` + `Condition` (optionally a coroutines `Channel`).

#### Segment 4 — Python Implementation - Day 1

**Task:** Implement the same using `threading.Lock` + `threading.Condition`.

#### Segment 5 — Coding Problem - Day 1

**Problem:**
Implement a thread-safe `BlockingQueue` with:

- `put(item)`
- `take()`
- Blocking behavior when full/empty.

---

### Day 2 — Counter + Queue + Fairness Flag

#### Segment 1 — Concept Study - Day 2

- Understand fairness, starvation, counters, queues.

#### Segment 2 — Java Implementation - Day 2

**Task:**
Implement a fair semaphore using:

- Counter
- FIFO queue
- Fairness flag

#### Segment 3 — Kotlin Implementation - Day 2

**Task:**
Implement a fair semaphore: counter + FIFO queue + fairness flag.

#### Segment 4 — Python Implementation - Day 2

Same as above using `threading`.

#### Segment 5 — Coding Problem - Day 2

**Problem:**
Build a fair `RateLimiter` that ensures FIFO fairness for requests.

---

### Day 3 — Append-Only List + Binary Search

#### Segment 1 — Concept Study - Day 3

- Append-only logs
- Binary search invariants

#### Segment 2 — Java Implementation - Day 3

**Task:**
Implement an append-only log with binary search lookup.

#### Segment 3 — Kotlin Implementation - Day 3

**Task:**
Implement an append-only log with binary search lookup.

#### Segment 4 — Python Implementation - Day 3

Same task.

#### Segment 5 — Coding Problem - Day 3

**Problem:**
Given a sorted append-only list of timestamps, implement:

- `findFirstEventAfter(t)`
- `findLastEventBefore(t)`

---

### Day 4 — Hash Map + Linked List

#### Segment 1 — Concept Study - Day 4

- LRU cache internals
- Hash map + doubly linked list

#### Segment 2 — Java Implementation - Day 4

Implement LRU Cache.

#### Segment 3 — Kotlin Implementation - Day 4

**Task:**
Implement an LRU Cache.

#### Segment 4 — Python Implementation - Day 4

Implement LRU Cache.

#### Segment 5 — Coding Problem - Day 4

**Problem:**
Implement LRU with:

- `get(key)`
- `put(key, value)`
- O(1) operations

---

### Day 5 — Token Bucket Math

#### Segment 1 — Concept Study - Day 5

- Token bucket refill rate
- Burst capacity
- Fairness

#### Segment 2 — Java Implementation - Day 5

Implement `TokenBucketRateLimiter`.

#### Segment 3 — Kotlin Implementation - Day 5

**Task:**
Implement a `TokenBucketRateLimiter`.

#### Segment 4 — Python Implementation - Day 5

Same.

#### Segment 5 — Coding Problem - Day 5

**Problem:**
Implement a rate limiter that:

- Allows `N` requests per second
- Supports bursts of size `B`
- Rejects excess requests

---

### Day 6 — Queue + Worker Threads

#### Segment 1 — Concept Study - Day 6

- Worker pool
- Backpressure
- Graceful shutdown

#### Segment 2 — Java Implementation - Day 6

Implement worker pool with:

- Task queue
- Worker threads
- Shutdown signal

#### Segment 3 — Kotlin Implementation - Day 6

**Task:**
Implement a worker pool: task queue, worker threads, shutdown signal.

#### Segment 4 — Python Implementation - Day 6

Same.

#### Segment 5 — Coding Problem - Day 6

**Problem:**
Implement a worker pool that processes jobs and retries failed jobs once.

---

### Day 7 — Consolidation Day

#### Segment 1 — Review - Day 7

Review all 6 primitives.

#### Segment 2 — Mixed Java/Python Drills - Day 7

Implement 2 primitives from scratch.

#### Segment 3 — Interview Simulation - Day 7

Explain each primitive verbally.

#### Segment 4 — Coding Problem - Day 7

**Problem:**
Build a mini “threading library” that includes:

- Mutex wrapper
- Condition wrapper
- Semaphore
- Worker pool

#### Segment 5 — Kotlin Implementation - Day 7

**Task:**
Implement 2 concurrency primitives from scratch.

---

## WEEK 2 — Graphs, Arrays, Strings (from the-plan.md)

### Day 8 — DFS + BFS

#### Segment 1 — Concept Study - Day 8

- Adjacency lists
- Visited sets

#### Segment 2 — Java Implementation - Day 8

DFS + BFS.

#### Segment 3 — Kotlin Implementation - Day 8

**Task:**
DFS + BFS.

#### Segment 4 — Python Implementation - Day 8

DFS + BFS.

#### Segment 5 — Coding Problem - Day 8

**Problem:**
Given a graph, print all nodes reachable from `start`.

---

### Day 9 — Cycle Detection (Directed + Undirected)

#### Segment 1 — Concept Study - Day 9

- 3-state marking
- Parent tracking

#### Segment 2 — Java Implementation - Day 9

Cycle detection.

#### Segment 3 — Kotlin Implementation - Day 9

**Task:**
Cycle detection (directed + undirected).

#### Segment 4 — Python Implementation - Day 9

Cycle detection.

#### Segment 5 — Coding Problem - Day 9

**Problem:**
Detect cycle in:

- Directed graph
- Undirected graph

---

### Day 10 — Topological Sort

#### Segment 1 — Concept Study - Day 10

- DFS postorder
- Kahn’s algorithm

#### Segment 2 — Java Implementation - Day 10

Topo sort.

#### Segment 3 — Kotlin Implementation - Day 10

**Task:**
Topological sort.

#### Segment 4 — Python Implementation - Day 10

Topo sort.

#### Segment 5 — Coding Problem - Day 10

**Problem:**
Course schedule problem.

---

### Day 11 — Connected Components + Islands

#### Segment 1 — Concept Study - Day 11

- Components
- Grid graphs

#### Segment 2 — Java Implementation - Day 11

Connected components.

#### Segment 3 — Kotlin Implementation - Day 11

**Task:**
Number of islands / connected components.

#### Segment 4 — Python Implementation - Day 11

Number of islands.

#### Segment 5 — Coding Problem - Day 11

**Problem:**
Count connected components in a graph.

---

### Day 12 — Array Patterns (Two Pointers, Sliding Window)

#### Segment 1 — Concept Study - Day 12

- Two pointers
- Sliding window
- Frequency maps

#### Segment 2 — Java Implementation - Day 12

Longest substring without repeating characters.

#### Segment 3 — Kotlin Implementation - Day 12

**Task:**
Longest substring without repeating characters.

#### Segment 4 — Python Implementation - Day 12

Sliding window maximum.

#### Segment 5 — Coding Problem - Day 12

**Problem:**
Group anagrams.

---

### Day 13 — Interval Problems

#### Segment 1 — Concept Study - Day 13

- Sorting + merging
- Overlap logic

#### Segment 2 — Java Implementation - Day 13

Merge intervals.

#### Segment 3 — Kotlin Implementation - Day 13

**Task:**
Merge intervals.

#### Segment 4 — Python Implementation - Day 13

Insert interval.

#### Segment 5 — Coding Problem - Day 13

**Problem:**
Given intervals, insert a new interval and merge.

---

### Day 14 — String Patterns

#### Segment 1 — Concept Study - Day 14

- Palindromes
- Run-length encoding
- Anagrams

#### Segment 2 — Java Implementation - Day 14

Longest palindromic substring.

#### Segment 3 — Kotlin Implementation - Day 14

**Task:**
Longest palindromic substring.

#### Segment 4 — Python Implementation - Day 14

Reverse words.

#### Segment 5 — Coding Problem - Day 14

**Problem:**
String compression.

---

## WEEK 3 — Backtracking & Permutations (Level 1–4)

### Day 15 — Level 1 Permutations - Day 15

#### Segment 1 — Concept Study - Day 15

- Backtracking template
- Swap-based vs used-array

#### Segment 2 — Java Implementation - Day 15

Generate permutations of string.

#### Segment 3 — Kotlin Implementation - Day 15

**Task:**
Generate permutations of an array.

#### Segment 4 — Python Implementation - Day 15

Generate permutations of array.

#### Segment 5 — Coding Problem - Day 15

**Problem:**
Count permutations (n=5 → 120).

---

### Day 16 — Level 2 Permutations

#### Segment 1 — Concept Study - Day 16

- Next permutation
- Duplicate pruning
- Factorial number system

#### Segment 2 — Java Implementation - Day 16

Next permutation.

#### Segment 3 — Kotlin Implementation - Day 16

**Task:**
Permutations with duplicates.

#### Segment 4 — Python Implementation - Day 16

Permutations with duplicates.

#### Segment 5 — Coding Problem - Day 16

**Problem:**
K-th permutation.

---

### Day 17 — Level 3 Permutations

#### Segment 1 — Concept Study - Day 17

- Branching
- Character mapping

#### Segment 2 — Java Implementation - Day 17

Letter case permutations.

#### Segment 3 — Kotlin Implementation - Day 17

**Task:**
Phone keypad permutations.

#### Segment 4 — Python Implementation - Day 17

Phone keypad permutations.

#### Segment 5 — Coding Problem - Day 17

**Problem:**
Permutations of length k.

---

### Day 18 — Level 4 Permutations

#### Segment 1 — Concept Study - Day 18

- Constraint-based permutations
- Multiset permutations

#### Segment 2 — Java Implementation - Day 18

Permutation with adjacency constraints.

#### Segment 3 — Kotlin Implementation - Day 18

**Task:**
Permutation of a multiset using a frequency map.

#### Segment 4 — Python Implementation - Day 18

Permutation of multiset using frequency map.

#### Segment 5 — Coding Problem - Day 18

**Problem:**
Generate permutations where no two adjacent numbers differ by 1.

---

### Day 19 — Consolidation Day

#### Segment 1 — Review - Day 19

All permutation levels.

#### Segment 2 — Mixed Java/Python Drills - Day 19

Implement 2 permutation problems from scratch.

#### Segment 3 — Interview Simulation - Day 19

Explain backtracking template.

#### Segment 4 — Coding Problem - Day 19

**Problem:**
Implement a generic backtracking engine.

#### Segment 5 — Kotlin Implementation - Day 19

**Task:**
Implement 2 permutation problems from scratch.

---

## WEEK 4 — System Design + Concurrency Theory

### Day 20 — Rate Limiter Design - Day 20

#### Segment 1 — Concept Study - Day 20

Token bucket, sliding window.

#### Segment 2 — Java Implementation - Day 20

Rate limiter.

#### Segment 3 — Kotlin Implementation - Day 20

**Task:**
Rate limiter.

#### Segment 4 — Python Implementation - Day 20

Rate limiter.

#### Segment 5 — Coding Problem - Day 20

**Problem:**
Design a distributed rate limiter using Redis.

---

### Day 21 — URL Shortener + Caching Layer

#### Segment 1 — Concept Study - Day 21

Hashing, collisions, TTL, eviction.

#### Segment 2 — Java Implementation - Day 21

URL shortener.

#### Segment 3 — Kotlin Implementation - Day 21

**Task:**
LRU cache.

#### Segment 4 — Python Implementation - Day 21

LRU cache.

#### Segment 5 — Coding Problem - Day 21

**Problem:**
Implement cache stampede protection.

---

### Day 22 — Job Queue + Notification System

#### Segment 1 — Concept Study - Day 22

Workers, retries, DLQ.

#### Segment 2 — Java Implementation - Day 22

Job queue.

#### Segment 3 — Kotlin Implementation - Day 22

**Task:**
Notification fan-out.

#### Segment 4 — Python Implementation - Day 22

Notification fan-out.

#### Segment 5 — Coding Problem - Day 22

**Problem:**
Implement retry with exponential backoff.

---

### Day 23 — Search Autocomplete + Favorites Feature

#### Segment 1 — Concept Study - Day 23

Trie, prefix index, idempotency.

#### Segment 2 — Java Implementation - Day 23

Autocomplete.

#### Segment 3 — Kotlin Implementation - Day 23

**Task:**
Favorites feature.

#### Segment 4 — Python Implementation - Day 23

Favorites feature.

#### Segment 5 — Coding Problem - Day 23

**Problem:**
Implement cursor-based pagination.

---

### Day 24 — Logging Pipeline + Pagination

#### Segment 1 — Concept Study - Day 24

Batching, ingestion, storage.

#### Segment 2 — Java Implementation - Day 24

Logging pipeline.

#### Segment 3 — Kotlin Implementation - Day 24

**Task:**
Cursor pagination.

#### Segment 4 — Python Implementation - Day 24

Cursor pagination.

#### Segment 5 — Coding Problem - Day 24

**Problem:**
Implement log ingestion with batching.

---

### Day 25 — Concurrency Theory

#### Segment 1 — Concept Study - Day 25

Race condition, deadlock, lost wakeup, thundering herd, memory barrier.

#### Segment 2 — Java Implementation - Day 25

Thread-safe counter.

#### Segment 3 — Kotlin Implementation - Day 25

**Task:**
Read-write lock.

#### Segment 4 — Python Implementation - Day 25

Read-write lock.

#### Segment 5 — Coding Problem - Day 25

**Problem:**
Implement a fair read-write lock.

---

### Day 26 — Worker Pool + Backpressure

#### Segment 1 — Concept Study - Day 26

Backpressure, graceful shutdown.

#### Segment 2 — Java Implementation - Day 26

Worker pool.

#### Segment 3 — Kotlin Implementation - Day 26

**Task:**
Worker pool.

#### Segment 4 — Python Implementation - Day 26

Worker pool.

#### Segment 5 — Coding Problem - Day 26

**Problem:**
Implement bounded worker pool with backpressure.

---

### Day 27 — Micro-Design Drills

#### Segment 1 — Rate limiter - Day 27

#### Segment 2 — Caching layer - Day 27

#### Segment 3 — Job queue - Day 27

#### Segment 4 — Notification system - Day 27

#### Segment 5 — Kotlin Implementation - Day 27

**Task:**
Rate limiter.

---

### Day 28 — Full System Design Simulation

#### Segment 1 — URL shortener - Day 28

#### Segment 2 — Search autocomplete - Day 28

#### Segment 3 — Logging pipeline - Day 28

#### Segment 4 — Favorites feature - Day 28

#### Segment 5 — Kotlin Implementation - Day 28

**Task:**
URL shortener.

---

### Day 29 — Mixed Java/Python Interview Drills

#### Segment 1 — Graph problem - Day 29

#### Segment 2 — Array problem - Day 29

#### Segment 3 — String problem - Day 29

#### Segment 4 — Concurrency problem - Day 29

#### Segment 5 — Kotlin Implementation - Day 29

**Task:**
Implement the graph, array, string and concurrency problems in Kotlin.

---

### Day 30 — Final Consolidation

#### Segment 1 — Review all primitives - Day 30

#### Segment 2 — Review all patterns - Day 30

#### Segment 3 — Review all designs - Day 30

#### Segment 4 — Mock interview simulation - Day 30

#### Segment 5 — Kotlin Implementation - Day 30

**Task:**
Review all primitives, patterns and designs in Kotlin.

---

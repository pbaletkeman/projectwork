# Backend Developer Knowledge Study Plan

A 30-day study plan for backend interview preparation, with every exercise implemented in Python, Java, and Kotlin.

- [Backend Developer Knowledge Study Plan](#backend-developer-knowledge-study-plan)
  - [Summary](#summary)
  - [Week 1: Backend Foundations \& Concurrency](#week-1-backend-foundations--concurrency)
    - [Day 1: Mutex + Condition Variable](#day-1-mutex--condition-variable)
    - [Day 2: Semaphore \& Fairness](#day-2-semaphore--fairness)
    - [Day 3: Binary Search \& Event Logs](#day-3-binary-search--event-logs)
    - [Day 4: LRU Cache](#day-4-lru-cache)
    - [Day 5: Rate Limiting](#day-5-rate-limiting)
    - [Day 6: Worker Pools](#day-6-worker-pools)
    - [Day 7: Review Day](#day-7-review-day)
  - [Week 2: Core LeetCode Patterns](#week-2-core-leetcode-patterns)
    - [Day 8: DFS \& BFS](#day-8-dfs--bfs)
    - [Day 9: Cycle Detection](#day-9-cycle-detection)
    - [Day 10: Topological Sort](#day-10-topological-sort)
    - [Day 11: Graph Applications](#day-11-graph-applications)
    - [Day 12: Hash Maps \& Sliding Window](#day-12-hash-maps--sliding-window)
    - [Day 13: Intervals](#day-13-intervals)
    - [Day 14: String Patterns](#day-14-string-patterns)
  - [Week 3: Backtracking \& Advanced Patterns](#week-3-backtracking--advanced-patterns)
    - [Day 15: Core Template](#day-15-core-template)
    - [Day 16: Interview Variants](#day-16-interview-variants)
    - [Day 17: Branching Variants](#day-17-branching-variants)
    - [Day 18: K-Length Permutations](#day-18-k-length-permutations)
    - [Day 19: Review Day](#day-19-review-day)
    - [Day 20: Heap \& Priority Queue](#day-20-heap--priority-queue)
    - [Day 21: Mixed Drill](#day-21-mixed-drill)
  - [Week 4: Backend Interview Simulation](#week-4-backend-interview-simulation)
    - [Day 22: Rate Limiter](#day-22-rate-limiter)
    - [Day 23: URL Shortener](#day-23-url-shortener)
    - [Day 24: Job Queue](#day-24-job-queue)
    - [Day 25: Notification System](#day-25-notification-system)
    - [Day 26: Pagination \& Idempotency](#day-26-pagination--idempotency)
    - [Day 27: Logging Pipeline](#day-27-logging-pipeline)
    - [Day 28: Concurrency Theory](#day-28-concurrency-theory)
    - [Day 29: Mock Interview](#day-29-mock-interview)
    - [Day 30: Final Review](#day-30-final-review)


## Summary

- **Week 1 (Days 1-7): Backend Foundations & Concurrency** — Core primitives built from scratch: mutexes, condition variables, semaphores, binary search over event logs, LRU cache, rate limiting, and worker pools, ending with a review of the six foundational patterns.
- **Week 2 (Days 8-14): Core LeetCode Patterns** — Graph traversal (DFS/BFS), cycle detection, topological sort, graph applications, hash maps, sliding window, intervals, and string problems.
- **Week 3 (Days 15-21): Backtracking & Advanced Patterns** — A short, focused week on permutations and backtracking variants, plus heaps/priority queues and a mixed drill.
- **Week 4 (Days 22-30): Backend Interview Simulation** — System design drills (rate limiter, URL shortener, job queue, notification system, pagination/idempotency, logging pipeline), concurrency theory review, a 4-round mock interview, and a final review checklist of all algorithms, backend systems, and concurrency concepts.

## Week 1: Backend Foundations & Concurrency

### Day 1: Mutex + Condition Variable

- Producer/Consumer
- Blocking Queue
- Race Conditions
- Critical Sections

**Implement:**

- BlockingQueue

**Interview question:**

- Design a thread-safe bounded queue

### Day 2: Semaphore & Fairness

- Fair semaphore
- Starvation
- FIFO fairness

**Implement:**

- Fair semaphore
- Fair rate limiter

### Day 3: Binary Search & Event Logs

- Binary search invariants
- Append-only logs

**Implement:**

- findFirstEventAfter()
- findLastEventBefore()

### Day 4: LRU Cache

- HashMap + doubly linked list

**Implement:**

- Full LRU cache from scratch

**LeetCode:**

- LRU Cache

### Day 5: Rate Limiting

- Token bucket
- Sliding window
- Burst capacity

**Implement:**

- TokenBucketRateLimiter

### Day 6: Worker Pools

- Worker threads
- Graceful shutdown
- Retries

**Implement:**

- Worker pool

### Day 7: Review Day

Be able to build from memory:

- BlockingQueue
- Semaphore
- LRU Cache
- Worker Pool
- Rate Limiter

These six primitives are repeatedly emphasized as foundational backend patterns.

---

## Week 2: Core LeetCode Patterns

### Day 8: DFS & BFS

**Problems:**

- Graph Traversal
- Number of Islands

**Goal:**

- Write BFS and DFS from memory

### Day 9: Cycle Detection

**Problems:**

- Directed cycle detection
- Undirected cycle detection

**Goal:**

- Master 3-state DFS

### Day 10: Topological Sort

**Problems:**

- Course Schedule
- Course Schedule II

**Goal:**

- Kahn's algorithm from memory

### Day 11: Graph Applications

**Problems:**

- Clone Graph
- Connected Components
- Word Ladder

### Day 12: Hash Maps & Sliding Window

**Problems:**

- Two Sum
- Longest Substring Without Repeating Characters
- Group Anagrams

Patterns:

- Frequency maps
- Sliding windows

### Day 13: Intervals

**Problems:**

- Merge Intervals
- Insert Interval

**Pattern:**

- Sorting + merging

### Day 14: String Patterns

**Problems:**

- Reverse Words
- String Compression
- Valid Palindrome
- Longest Palindromic Substring

These graph, array, and string patterns are repeatedly identified as the highest-value interview patterns.

---

## Week 3: Backtracking & Advanced Patterns

Since you already know the template well, keep this week short and focused.

### Day 15: Core Template

**Problems:**

- Generate Permutations
- Permutations of Array

**Goal:**

- Implement from memory

### Day 16: Interview Variants

**Problems:**

- Next Permutation
- Permutations II
- K-th Permutation

You already have implementations for unique permutations and next permutation.

### Day 17: Branching Variants

**Problems:**

- Letter Case Permutation
- Phone Number Combinations

### Day 18: K-Length Permutations

**Problems:**

- Permutations of Length K

### Day 19: Review Day

**Explain:**

- Backtracking template
- Duplicate pruning
- Factorial number system

### Day 20: Heap & Priority Queue

**Problems:**

- K Largest Elements
- Dijkstra overview

### Day 21: Mixed Drill

- 1 Graph
- 1 Array
- 1 String
- 1 Backtracking

The permutation progression aligns with the four levels outlined in your materials.

---

## Week 4: Backend Interview Simulation

### Day 22: Rate Limiter

**Design:**

- Token Bucket
- Sliding Window

**Discuss:**

- Redis
- Atomic counters

### Day 23: URL Shortener

**Cover:**

- IDs
- Hashing
- Collisions
- Database schema

### Day 24: Job Queue

**Cover:**

- Workers
- Retries
- DLQ
- Visibility timeout

### Day 25: Notification System

**Cover:**

- Fan-out
- Retries
- Multi-channel delivery

### Day 26: Pagination & Idempotency

**Design:**

- Cursor pagination
- Idempotency keys

### Day 27: Logging Pipeline

**Design:**

- Ingestion
- Batching
- Storage
- Querying

### Day 28: Concurrency Theory

**Review:**

- Race conditions
- Deadlocks
- Lost wakeups
- Atomicity
- Memory barriers
- Thundering herd

### Day 29: Mock Interview

Round 1

- DFS/BFS

Round 2

- LRU Cache

Round 3

- Rate Limiter

Round 4

- Worker Pool

### Day 30: Final Review

Must be able to explain and implement:

**Algorithms:**

- BFS
- DFS
- Cycle Detection
- Topological Sort
- Binary Search
- Sliding Window
- Two Pointers
- Hash Map Counting
- LRU Cache
- Permutations

**Backend:**

- Blocking Queue
- Semaphore
- Worker Pool
- Rate Limiter
- Job Queue
- URL Shortener
- Notification System
- Logging Pipeline

**Concurrency:**

- Race Conditions
- Deadlocks
- Memory Barriers
- Read/Write Locks

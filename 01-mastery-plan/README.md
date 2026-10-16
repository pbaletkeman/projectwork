# 30-Day Backend Foundations Mastery Plan

A structured, self-guided 30-day interview preparation curriculum for backend software engineering roles. Covers concurrency primitives, data structures, algorithms, system design, and concurrency theory — with implementation in **Python**, **Java**, and **Kotlin**.

## Overview

This plan is broken into four progressive segments:

| Week   | Focus   | Topics   |
| ------ | ------- | -------- |
| **Week 1** | Core Concurrency Primitives | Mutex, condition variables, fair semaphore, append-only list, LRU cache, token bucket, worker pool |
| **Week 2** | Graphs, Arrays & Strings | DFS/BFS, cycle detection, topological sort, connected components, sliding window, intervals, string patterns |
| **Week 3** | Backtracking & Permutations | 4 levels of increasing difficulty — unique permutations, next permutation, k-th permutation |
| **Week 4** | System Design + Theory | Rate limiter, URL shortener, caching, job queue, autocomplete, logging pipeline, mock interviews |

Each day follows a daily block structure:

1. **Concept Study** — Read and internalize the theory
2. **Python Implementation** — Build it in Python
3. **Java Implementation** — Build it in Java
4. **Kotlin Implementation** — Build it in Kotlin
5. **Practice Problem** — Apply the pattern to a coding problem

## Repository Structure

```plaintext
.
├── README.md            # This file
├── the-plan.md          # Master curriculum — categorized list of all problems and concepts
├── study-guide.md       # Detailed 30-day day-by-day schedule
├── update-plan.md       # Updated 30-day schedule (Python/Java/Kotlin), including system design drills
├── warm-up.md           # Quick-reference flashcard-style notes for rapid review
├── week1/               # Week 1 implementations (BlockingQueue, backtracking drills, etc.)
└── old/                 # Earlier standalone exercises (backtracking, LRU cache, rate limiter, etc.)
```

## How to Use

1. **Start with `the-plan.md`** — get a bird's-eye view of all topics and what's expected.
2. **Follow `update-plan.md`** day by day — the current schedule covering concurrency, algorithms, and system design with tri-language implementations.
3. **Use `study-guide.md`** for the alternative detailed day-by-day schedule.
4. **Use `warm-up.md`** for quick review — condensed problem statements, key insights, and pattern summaries.

## Prerequisites

- Python 3, Java (JDK), and Kotlin installed
- A code editor
- No build system or package manager required — all exercises are standalone files

## Running the Exercises

**Python:**

```bash
python <file>.py
```

**Java:**

```bash
javac <file>.java && java <classname>
```

**Kotlin:**

```bash
kotlinc <file>.kt -include-runtime -d <file>.jar && java -jar <file>.jar
```

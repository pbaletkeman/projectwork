# Projectwork

A personal workspace combining backend interview preparation, a game design plan, and a Java concurrency practice project. This is a **multi-project workspace** (not yet a formal monorepo — see [Repository Status](#repository-status)), tracked in git and pushed to [`pbaletkeman/projectwork`](https://github.com/pbaletkeman/projectwork).

## Contents

| Folder | What it is |
|--------|------------|
| [`sequence.md`](sequence.md) | **Order of operations** — the top-level roadmap that sequences everything below: concurrency plan (Months 1–2), Polyglot AI Model Hub MVP (Months 3–6), job applications (Month 7), Godot game (Months 8–12). |
| [`01-mastery-plan/`](01-mastery-plan/) | **30-Day Backend Foundations Mastery Plan** — a self-guided interview prep curriculum covering concurrency, data structures, algorithms, and system design, with implementations in Python, Java, and Kotlin. See its [README](01-mastery-plan/README.md) for the day-by-day schedule. |
| [`02-pollygot/`](02-pollygot/) | **Week 1 producer-consumer project** — a Gradle/Java project (`week1-producer-consumer`) implementing a blocking queue, producer/consumer, task tracking, and statistics, with JUnit tests, Checkstyle, and JaCoCo. Kotlin sources live in `kotlin_src/`. Includes notes on race conditions in `src/README.md`. |
| [`03-corps/`](03-corps/) | **Project Emerald phase plan** — the phased development plan for an original 2D Metroidvania game built in Godot, from prototype (Phase 1) through a Steam MVP and post-launch platform engineering (Phase 5), plus optional extras. See its [README](03-corps/README.md). Planning docs only — no game code here. |
| [`.github/`](.github/) | GitHub support files (currently tooling hooks under `modernize/java-upgrade/` — no workflows yet). |

## Getting Started

- **Roadmap first:** read [`sequence.md`](sequence.md) to see how the three projects are meant to sequence over the year.
- **Backend prep:** start at [`01-mastery-plan/the-plan.md`](01-mastery-plan/the-plan.md) for the full curriculum, then follow [`update-plan.md`](01-mastery-plan/update-plan.md) day by day. Requires Python 3, a JDK, and Kotlin.
- **Game plan:** start at [`03-corps/phase1.md`](03-corps/phase1.md). Phases are sequential; don't start a phase until the previous one's definition of done is met. To open Phase 1 early, follow the two-week trial in [`03-corps/phase1-kickoff.md`](03-corps/phase1-kickoff.md).
- **Java project:** from `02-pollygot/`, run:

  ```bash
  gradle build    # compiles, runs tests + Checkstyle, generates JaCoCo coverage
  ```

  Requires a JDK and Gradle.

## Repository Status

This workspace **is a git repository**:

- Remote: `origin` → `https://github.com/pbaletkeman/projectwork.git` (branch `main`).
- Root `.gitignore` covers Gradle/Maven output, `*.class`, `*.jar`, `bin/`, `build/`, IDE and Python noise — **no build artifacts are tracked**.
- `.gitattributes` normalizes line endings to LF and marks binaries (images, jars, archives) as binary.
- There is still no root-level build orchestration (no root Gradle composite build or npm workspace).

To add another JVM project to a root composite build, the remaining step would be a root `settings.gradle` that `include`s `02-pollygot` (and any successors).

## Layout

```
projectwork/
├── README.md          # This file
├── sequence.md        # Order-of-operations roadmap
├── .gitignore         # Root ignore rules (build output, jars, IDE, Python)
├── .gitattributes     # LF normalization + binary markers
├── .github/           # GitHub tooling hooks
├── 01-mastery-plan/   # 30-day backend prep curriculum
│   ├── the-plan.md / update-plan.md / study-guide.md / warm-up.md
│   ├── week1/         # Week 1 implementations (try1 … try6 iterations)
│   └── old/           # Earlier standalone exercises
├── 02-pollygot/       # Gradle Java/Kotlin producer-consumer project
│   ├── build.gradle / settings.gradle
│   ├── src/           # Java sources + tests
│   └── kotlin_src/    # Kotlin sources
└── 03-corps/          # Game phase plan (docs only)
    ├── phase1.md … phase5.md
    └── optional/      # Phase 6–10 (optional extras)
```

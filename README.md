# Projectwork

A personal workspace combining backend interview preparation, a game design plan, and a Java concurrency practice project. This is a **multi-project workspace** (not yet a formal monorepo — see [Repository Status](#repository-status)).

## Contents

| Folder | What it is |
|--------|------------|
| [`01-mastery-plan/`](01-mastery-plan/) | **30-Day Backend Foundations Mastery Plan** — a self-guided interview prep curriculum covering concurrency, data structures, algorithms, and system design, with implementations in Python, Java, and Kotlin. See its [README](01-mastery-plan/README.md) for the day-by-day schedule. |
| [`02-pollygot/`](02-pollygot/) | **Week 1 producer-consumer project** — a Gradle/Java project (`week1-producer-consumer`) implementing a blocking queue, producer/consumer, task tracking, and statistics, with JUnit tests, Checkstyle, and JaCoCo. Kotlin sources live in `kotlin_src/`. Includes notes on race conditions in `src/README.md`. |
| [`03-corps/`](03-corps/) | **Project Emerald phase plan** — the phased development plan for an original 2D Metroidvania game built in Godot, from prototype (Phase 1) through a Steam MVP and post-launch platform engineering (Phase 5), plus optional extras. See its [README](03-corps/README.md). Planning docs only — no game code here. |
| [`.github/`](.github/) | GitHub support files (currently tooling hooks under `modernize/java-upgrade/` — no workflows yet). |

## Getting Started

- **Backend prep:** start at [`01-mastery-plan/the-plan.md`](01-mastery-plan/the-plan.md) for the full curriculum, then follow [`update-plan.md`](01-mastery-plan/update-plan.md) day by day. Requires Python 3, a JDK, and Kotlin.
- **Game plan:** start at [`03-corps/phase1.md`](03-corps/phase1.md). Phases are sequential; don't start a phase until the previous one's definition of done is met.
- **Java project:** from `02-pollygot/`, run:

  ```bash
  gradle build    # compiles, runs tests + Checkstyle, generates JaCoCo coverage
  ```

  Requires a JDK and Gradle.

## Repository Status

This workspace is **not yet set up as a monorepo**:

- It is not a git repository (no `.git`).
- There is no root-level build orchestration (no root Gradle composite build or npm workspace).
- `02-pollygot/` contains committed build artifacts (`build/`, `bin/`, `*.class`) that would normally be gitignored.

To turn this into a proper monorepo, the basics would be: `git init`, a root `.gitignore` (excluding `02-pollygot/build/`, `02-pollygot/bin/`, `*.class`, `*.jar`), and optionally a root `settings.gradle` that includes `02-pollygot` if more JVM projects are added.

## Layout

```
projectwork/
├── README.md          # This file
├── .github/           # GitHub tooling hooks
├── 01-mastery-plan/   # 30-day backend prep curriculum
│   ├── the-plan.md / update-plan.md / study-guide.md / warm-up.md
│   ├── week1/         # Week 1 implementations
│   └── old/           # Earlier standalone exercises
├── 02-pollygot/       # Gradle Java/Kotlin producer-consumer project
│   ├── build.gradle / settings.gradle
│   ├── src/           # Java sources + tests
│   └── kotlin_src/    # Kotlin sources
└── 03-corps/          # Game phase plan (docs only)
    ├── phase1.md … phase5.md
    └── optional/      # Phase 6–10 (optional extras)
```

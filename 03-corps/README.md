# Corps — Project Emerald Phase Plan

This folder contains the phased development plan for **Project Emerald**, an original 2D Metroidvania game (Lantern/Green-Lantern-inspired theme, built in Godot). Each file defines one phase: its objective, scope, success criteria, and definition of done.

## Core Phases (required, in order)

| File | Phase | Goal |
|------|-------|------|
| `phase1.md` | Phase 1 — Prototype | A single-room playable Godot prototype (move, jump, shoot, one enemy, health, checkpoint, door). 40-hour cap. |
| `phase2.md` | Phase 2 — Vertical Slice | Turn the prototype into one complete, polished level — prove "I can build one complete level." |
| `phase3,md` | Phase 3 — Demo Release | Ship a public demo. *(Note: filename uses a comma instead of a period — `phase3,md`.)* |
| `phase4.md` | Phase 4 — Steam MVP | The smallest commercially viable version of the game. |
| `phase5.md` | Phase 5 — Post-Launch Engineering | Use the game as a platform-engineering portfolio piece: Spring Boot API, PostgreSQL, Kafka, Docker, Kubernetes, Terraform, Grafana/Prometheus, GitHub Actions CI/CD. |

Phases are sequential — do not start a phase until the previous one ships. Phase 1 explicitly forbids adding backend, AI, multiplayer, inventory, or procedural generation until later phases.

## Optional Phases (`optional/`)

Extras to tackle only after the core plan is complete:

| File | Phase | Focus |
|------|-------|-------|
| `optional/phase6.md` | Phase 6 — AI Companion | Companion character |
| `optional/phase7.md` | Phase 7 — Analytics Platform | Player analytics |
| `optional/phase8.md` | Phase 8 — Mod Support | Modding tools |
| `optional/phase9.md` | Phase 9 — Procedural Content | Procedural generation |
| `optional/phase10.md` | Phase 10 — Studio Quality Release | Final polish pass |

## How to Use This Plan

1. Start with `phase1.md` and work through its success criteria and definition of done.
2. Only plan the next phase once the current phase's "Definition of Done" is met.
3. Keep scope inside the phase's stated time budget; if you run over, cut scope instead of adding features.

This folder contains planning documents only — no game code lives here.

# Phase 1 Kickoff — Two-Week Trial

A start-here checklist for opening Phase 1 alongside the backend plan.

This is **not a re-plan**. Phase 1 still has its 40-hour cap and its Definition
of Done in [`phase1.md`](phase1.md) — this file only sequences the first two
weeks and defines what the trial is meant to prove.

**Trial window:** Oct 17 – Oct 31, 2026
**Decision date:** Oct 31
**Time budget for the trial:** 15–20 hours (Phase 1's full cap remains 40h)

---

## What this trial decides

The pull toward this project is strong during the *idea* stage. The trial tests
whether it survives contact with the unglamorous parts — collision shapes,
camera tuning, input maps, respawn logic.

So the ladder below is deliberately **boring-first**: movement feel and
collision come before any animation, juice, or art. If the interest evaporates
at M1–M2, that is the answer, and it is a useful one.

If you reach M4 still wanting to work on it, the signal is real.

---

## Ground rules

Taken from `phase1.md`, non-negotiable for the trial:

- **Placeholders only.** Squares and circles are acceptable. Programmer art is
  acceptable. No asset-hunting, no pixel-art rabbit holes.
- **No scope additions.** No inventory, NPCs, AI companion, save system,
  multiple levels, bosses, backend, Kafka, PostgreSQL, LLM integration — the
  full forbidden list lives in `phase1.md`.
- **Cut scope, never add it.** If a milestone runs long, shrink the milestone.
- **Track hours.** Log actual hours per milestone; stop at 40h even if the
  phase is unfinished.
- **Backend work stays out.** The platform engineering in Phase 5 is where the
  backend portfolio lives — Phase 1 is learning Godot, not wiring up Spring.

---

## Day 0 — Setup

- [ ] Install Godot 4.x (standard, not .NET — GDScript only for Phase 1)
- [ ] Decide where game code lives (see note below) and `git init` there
- [ ] Create the project structure from `phase1.md`:

  ```
  project/
  ├── scenes/
  │   ├── player/Player.tscn
  │   ├── enemies/Drone.tscn
  │   └── world/PrototypeRoom.tscn
  ├── scripts/
  │   ├── player.gd
  │   ├── drone.gd
  │   └── projectile.gd
  └── assets/placeholder/
  ```

- [ ] Bind the Input Map: `move_left` (A / Left), `move_right` (D / Right),
      `jump` (Space), `shoot` (Left Mouse)
- [ ] Commit after every milestone — not at the end

> **Where does the code go?** `03-corps/` is planning docs only, by design.
> Recommendation: a **separate repo** (`emerald`), because a Godot project
> carries import files and editor state that don't belong in this workspace.
> Alternative: a sibling `04-emerald/` here, plus Godot entries in
> `.gitignore` (`*.import` exceptions, `.godot/`). Pick one on Day 0 and don't
> revisit it.

---

## Milestone ladder

Ordered so the test happens early. Times are estimates — log the real number.

| # | Milestone | Done when | Est. |
|---|-----------|-----------|------|
| M0 | **It boots** | Empty `PrototypeRoom`, a square that moves left/right, no gravity yet | 2h |
| M1 | **Jump + collision** | Gravity, jump, and correct collision with floor and walls — *tune the feel until it's not annoying* | 3h |
| M2 | **Room + camera** | One `TileMap` room sized to fit, camera follows the player without jitter | 3h |
| M3 | **Shoot** | Energy bolt: damage 1, cooldown 0.25s, range = screen width, despawns at edge | 3h |
| M4 | **Enemy** | Training Drone patrols, turns at walls, HP 3; player HP 5; both take damage; drone dies | 4h |
| M5 | **Death and respawn** | Player dies, returns to activated checkpoint, run resumes | 2h |
| M6 | **Finish line** | Exit door → "Prototype Complete"; 60 seconds play crash-free | 2h |

**Trial ends at M4 or beyond.** M5–M6 may spill past Oct 31 — that is fine and
counts as a positive signal.

### M1 is the test

M1 is collision tuning and jump arcs: tedious, unglamorous, no visible payoff
for hours. It sits second on purpose. Everything after it is more of the same
kind of work. Treat your own reaction to M1 as the data point it is.

---

## Daily shape

Backend floor comes first and is not negotiable — it is the only time-sensitive
item in `sequence.md`:

1. **One mastery-plan session** (~60–90 min), new material, done — no re-running
   problems already implemented in all three languages.
2. **Corps block** with whatever hours remain (target ~1.5–2h on weekdays).

If the two compete for the same hour, the backend floor wins. Corps gets what
is left over.

---

## Decision gate — Oct 31

Answer three questions honestly:

1. **Did I reach M4?** If no — why not: no time, or avoided it?
2. **Which was I reaching for when the slot was free?** M1-style collision
   work, or the next permutation drill?
3. **Did the backend floor hold?** One session a day, most days.

Then choose one:

| Outcome | Action |
|---------|--------|
| Reached M4, still pulling, backend floor held | Keep both. Continue the trial as-is into November; Phase 1 cap is 40h. |
| Reached M4 but backend floor slipped | Corps goes back to weekends only until the floor holds for two straight weeks. |
| Did not reach M4 and avoided the work | The pull was to the *idea*, not the build. Close the trial, no guilt, back to the plan as written. |
| Backend prep is still unfulfilling on its own merits | Now revise `sequence.md` for real — with the tradeoff written down, not as drift. |

Record the outcome in `sequence.md` on the decision date. An unrecorded decision
is how the roadmap drifts.

# Phase 1 - Lantern-Inspired Metroidvania Prototype

## Objective

Create a single-room playable prototype in Godot.

The prototype must be playable for at least 60 seconds without crashing.

This phase exists to learn:

- Godot
- GDScript
- Scenes
- Physics
- Animation
- Collision Detection
- Basic Combat

No multiplayer.

No backend.

No AI.

No procedural generation.

No quests.

No inventory.

No save system.

---

# Theme

Working Title:

Project Emerald

Genre:

2D Metroidvania

Inspirations:

- Super Metroid
- Hollow Knight
- Green Lantern

The player is a light-powered guardian who creates energy constructs.

This is an original IP.

Do not use:

- Green Lantern
- Hal Jordan
- Sinestro
- Oa
- Lantern Corps

---

# Success Criteria

The player can:

- Move left
- Move right
- Jump
- Shoot energy blast

The game contains:

- One room
- One enemy
- Health system
- One checkpoint
- One door

Enemy can:

- Move
- Take damage
- Die

Player can:

- Take damage
- Die
- Respawn

---

# Project Structure

project/

├── scenes/
│   ├── player/
│   │   └── Player.tscn
│   ├── enemies/
│   │   └── Drone.tscn
│   └── world/
│       └── PrototypeRoom.tscn
│
├── scripts/
│   ├── player.gd
│   ├── drone.gd
│   └── projectile.gd
│
└── assets/
    └── placeholder/

All art may use placeholders.

Squares are acceptable.

Circles are acceptable.

Programmer art is acceptable.

---

# Controls

A / Left Arrow     Move Left

D / Right Arrow    Move Right

Space              Jump

Left Mouse         Shoot

---

# Player Abilities

## Ability 1

Energy Bolt

Description:

Small projectile fired forward.

Requirements:

Damage: 1

Cooldown: 0.25s

Range: Screen Width

---

# Health System

Player:

Max Health = 5

Enemy:

Max Health = 3

---

# Enemy

Name:

Training Drone

Behavior:

- Move left
- Move right
- Turn around when hitting wall

No advanced AI.

No pathfinding.

No state machine yet.

---

# Checkpoint

Player touches checkpoint.

Checkpoint activates.

Upon death:

Player returns to checkpoint.

---

# Completion Condition

Player reaches exit door.

Display:

Prototype Complete

Return to menu.

---

# Technical Goals

Learn:

## Godot Nodes

- CharacterBody2D
- Area2D
- CollisionShape2D
- AnimatedSprite2D
- TileMap

## Godot Concepts

- Signals
- Scenes
- Physics Process
- Input System
- Timers

---

# Time Budget

Maximum:

40 hours

If not complete after 40 hours:

STOP.

Reduce scope further.

Do not add features.

Finish prototype first.

---

# Explicitly Forbidden Until Phase 2

Do NOT add:

- AI companion
- Kafka
- PostgreSQL
- Java backend
- Kubernetes
- Terraform
- Authentication
- Inventory
- Crafting
- Dynamic dialogue
- Procedural generation
- LLM integration
- NPCs
- Skill trees
- Multiple levels
- Bosses

These belong in later phases.

---

# Definition of Done

A stranger can:

1. Launch the game
2. Move
3. Jump
4. Shoot
5. Kill one enemy
6. Reach the exit

Without assistance.

When all six are true:

PHASE 1 COMPLETE

Only then plan Phase 2.

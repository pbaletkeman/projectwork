# Phase 5 - Post Launch Engineering

## Objective

Use the game as a platform engineering portfolio project.

Do NOT start Phase 5 until Phase 4 ships.

---

## Backend Integration

Build:

- Spring Boot API
- PostgreSQL Database

Godot sends:

- Session Started
- Session Ended
- Boss Defeated
- Player Died

Events

Example:

{
  "eventType": "boss_defeated",
  "boss": "crystal_guardian",
  "timeToKill": 133
}

---

## Kafka

Introduce:

- Event Topics
- Producers
- Consumers

Pipeline:

Godot
  ->
API
  ->
Kafka
  ->
Consumers

---

## Analytics

Track:

- Death Locations
- Most Difficult Boss
- Ability Usage
- Completion Rates

---

## Dashboards

Add:

- Grafana
- Prometheus

Metrics:

- Active Players
- Average Completion Time
- Crash Counts

---

## Kubernetes

Deploy:

- API
- Database
- Kafka
- Dashboards

Using:

- Docker
- Kubernetes

---

## Terraform

Create:

- Infrastructure As Code

Provision:

- Development Environment
- Test Environment

---

## CI/CD

Implement:

- GitHub Actions
- Automated Testing
- Automated Builds

---

## Resume Goal

Be able to say:

"Designed and shipped a commercial Godot game. Extended the platform with Spring Boot, Kafka, PostgreSQL, Docker, Kubernetes, Terraform, and observability tooling."

PHASE 5 COMPLETE

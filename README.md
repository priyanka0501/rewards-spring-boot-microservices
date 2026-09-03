# Customer Rewards API

## Overview

A Spring Boot REST API that calculates customer reward
points based on purchase transactions over a three-month period.

## Reward Rules

- No points for purchases up to $50.
- 1 point for every dollar spent between $50 and $100.
- 2 points for every dollar spent above $100.

Example:

$120 purchase:

50 × 1 + 20 × 2 = 90 points

## Technology

- Java 17
- Spring Boot 4.1.1
- Gradle
- REST API
- JUnit 5
- Mockito
- Stream API

## API

GET /api/rewards

## Example Response

...

## How to Run

mvn clean test

mvn spring-boot:run

## Design

Controller
↓
Service
↓
Repository
↓
In-memory transaction data

## Testing

Unit tests cover:
- Amount below $50
- Amount equal to $50
- Amount between $50 and $100
- Amount equal to $100
- Amount above $100
- Multiple customers
- Monthly aggregation
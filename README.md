# Java Development | Spring Boot | REST APIs | Spring Data JPA

**A structured, hands-on journey through Java backend development, from core Java concepts to reactive applications and database integration.**

This repository documents my practical learning and implementation of Java backend development, with a focus on Spring Framework, Spring Boot, RESTful APIs, persistence, ORM, and modern backend application architecture.

Rather than keeping isolated code snippets, I organize my work into day-wise modules and runnable projects to track my progress, revisit concepts, and strengthen my understanding through implementation.

## About This Repository

The repository contains practical implementations of concepts covered during my Java development training, including:

- Core Java concepts and prerequisites for enterprise development
- Spring Framework fundamentals, configuration, annotations, and dependency injection
- Spring Bean lifecycle and application configuration
- Spring MVC and REST API development
- Layered backend architecture and service-oriented business logic
- Spring Data JPA, entity relationships, and database access
- Spring Security and web application security
- GraphQL fundamentals and API development
- Reactive programming and reactive REST APIs
- Reactive database integration using R2DBC
- Maven-based project configuration and dependency management

## Tech Stack

| Category | Technologies |
|---|---|
| Language | Java |
| Backend Framework | Spring Framework, Spring Boot |
| Web Development | Spring MVC, REST APIs |
| Persistence | Spring Data JPA, Hibernate, R2DBC |
| API Technologies | REST, GraphQL |
| Security | Spring Security |
| Database | MySQL |
| Build Tool | Maven |
| Development Tools | Spring Tool Suite (STS), IntelliJ IDEA, Git, GitHub |
| API Testing | Postman, Swagger/OpenAPI where configured |

*Technologies listed reflect the subjects and tools used across the repository; individual projects may use different subsets.*

## Repository Roadmap

The code is organized by training day so that concepts can be traced from fundamentals to more advanced implementations.

### Day 00 — Prerequisites and Core Concepts

- Java annotations and interfaces
- JDBC fundamentals
- Middleware, proxies, and reflection
- Foundational concepts required for framework-based development

### Days 01–04 — Spring Framework and Spring Boot Fundamentals

- XML-based and annotation-based configuration
- Spring Boot application setup
- Bean configuration and lifecycle
- Stereotype annotations and component scanning
- Dependency injection and autowiring
- Conditional configuration and Spring profiles

### Days 05–08 — Data Access and Application Architecture

- DAO and repository patterns
- Service-layer business logic
- Music and book application examples
- Spring MVC fundamentals
- REST API demonstrations

### Days 09–13 — REST APIs, Security, and Data Access

- JavaScript and client-side integration exercises
- Book REST application
- Spring Security configuration
- Spring Data JPA introduction
- Native queries, JPQL, parameter binding, and projections
- Update and delete operations

### Days 14–16 — JPA Relationships and Entity Lifecycle

- One-to-one, one-to-many, many-to-one, and many-to-many relationships
- Entity lifecycle and persistence concepts
- JPA inheritance strategies
- Embedded objects and composite primary keys
- Self-referencing entities
- Primary-key generation
- Query methods and derived queries

### Day 17 — REST and GraphQL

- Music REST API
- Book REST API exercises
- GraphQL fundamentals and implementation

### Day 18 — Reactive Programming

- Reactive programming fundamentals
- Reactive application examples
- Reactive REST API development

### Day 19 — Reactive Database Integration

- Reactive database access using R2DBC
- Database connectivity and reactive persistence exercises

*Each module contains its corresponding project or exercise folder. Refer to the source code for the exact implementation of each topic.*

## Projects and Practical Implementations

### 1. Music REST API
A backend application used to explore REST API development and data access with Spring Boot.

**Concepts:** Controllers, request handling, persistence, and REST endpoints.

### 2. Book REST API
A backend application focused on implementing and understanding book-related API operations.

**Concepts:** REST endpoints, application layering, database interaction, and API testing.

### 3. Spring Data JPA Exercises
A collection of focused implementations covering ORM and entity mapping.

**Concepts:** Entity relationships, inheritance, embedded types, composite keys, query methods, JPQL, and native queries.

### 4. Spring Security Exercises
Practical modules for understanding the configuration and integration of Spring Security into web applications.

**Concepts:** Security configuration, web request handling, and authentication-related fundamentals.

### 5. Reactive Applications
Projects exploring reactive application development and reactive database connectivity.

**Concepts:** Reactive programming, reactive REST endpoints, and R2DBC integration.

### 6. GraphQL Exercises
A dedicated module for exploring GraphQL alongside conventional REST API development.

**Concepts:** GraphQL API structure and query-based data access.

## What I Am Learning Through Implementation

My focus is not limited to making an application run. I am working toward understanding the decisions behind backend implementations:

- How dependency injection and inversion of control simplify application design.
- How controllers, services, and repositories separate responsibilities.
- How JPA maps Java objects to relational database tables.
- How entity relationships affect fetching, serialization, and database queries.
- How API design and security influence backend reliability.
- How reactive programming differs from traditional blocking request processing.
- How to diagnose configuration, dependency, persistence, and runtime errors.

## Running a Project Locally

Requirements depend on the individual module.

1. Install a compatible JDK, Maven, and the required database.
2. Clone the repository:

   ```bash
   git clone https://github.com/atharv-kondekar/java-development.git
   cd java-development
   ```

3. Navigate to the project you want to run.
4. Configure the database URL, username, and password in the project's application configuration.
5. Open the project in your preferred Java IDE or run it using Maven:

   ```bash
   mvn spring-boot:run
   ```

   Run this command from a directory containing the relevant Spring Boot project's `pom.xml`. Projects with different configurations may require different startup steps.

6. Test available endpoints using Postman or the project's configured API documentation.

**Configuration note:** Do not commit real database passwords, API keys, access tokens, or other secrets. Use environment variables or local configuration for sensitive values.

## Repository Structure

```text
java-development/
├── Day-00-Prerequisites/
├── Day-01/
├── Day-02/
├── Day-03/
├── Day-04/
├── Day-05/
├── Day-06/
├── Day-07/
├── Day-08/
├── Day-09/
├── Day-10/
├── Day-11/
├── Day-12/
├── Day-13/
├── Day-14/
├── Day-15/
├── Day-16/
├── Day-17/
├── Day-18/
└── Day-19/
```

The day-wise structure makes it easier to navigate individual exercises and follow the progression of the training.

## Current Focus

I am strengthening my backend development skills through hands-on Java and Spring Boot implementation, with particular attention to REST API design, persistence, entity relationships, security, and reactive systems.

My objective is to build a solid foundation for developing maintainable, database-driven backend applications and to apply these concepts in real-world software engineering projects.

## Connect

**GitHub:** [atharv-kondekar](https://github.com/atharv-kondekar)

**Repository:** [java-development](https://github.com/atharv-kondekar/java-development)

---

*This repository represents my ongoing practical work in Java backend development. Individual projects reflect different stages of learning and experimentation, with implementation details available in their respective source files.*

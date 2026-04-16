# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

All commands run from the `backend/` directory.

```bash
# Build
./gradlew build

# Run
./gradlew bootRun

# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "com.example.library.LibraryApplicationTests"
```

The server runs on port **8090**. A PostgreSQL instance is required (`localhost:5432`, database `library`, user/password `postgres`).

## Architecture

This is a Spring Boot 4 / Java 25 backend following **Hexagonal Architecture (Ports & Adapters)**. The `frontend/` directory is currently empty.

### Package structure per domain

Each domain (`book`, `user`, `loan`) follows this layout:

```
domain/          — Pure domain objects (no Spring, no JPA)
application/
  port/in/       — Inbound port interfaces (use case contracts)
  port/out/      — Outbound port interfaces (persistence/external contracts)
  *.java         — Use case implementations (@UseCase)
adapter/
  in/web/        — REST controllers (call inbound ports)
  out/persistence/ — JPA adapters implementing outbound ports (@PersistenceAdapter)
  out/external/  — Cross-domain adapters bridging loan ↔ book/user ports
```

`@UseCase` and `@PersistenceAdapter` are custom stereotype annotations in `common/` that alias `@Component`.

### Cross-domain wiring

The `loan` domain does not directly depend on the `book` or `user` persistence adapters. Instead:
- `BookQueryAdapter` (in `loan/adapter/out/external/`) implements `LoadBookPort` and `UpdateBookStatusPort` by delegating to `book`'s own `FindBookPort` and `ModifyBookStatusPort`.
- `UserQueryAdapter` (same package) implements `LoadUserPort` by delegating to `user`'s `FindUserPort`.

This keeps the loan use case decoupled from persistence details of other domains.

### Current implementation state

All persistence adapters (`BookPersistenceAdapter`, `UserPersistenceAdapter`, `LoanPersistenceAdapter`) throw `UnsupportedOperationException` with a TODO comment — DB integration is not yet implemented. Only `UserEntity` (JPA) and `UserRepository` (Spring Data) exist; `BookEntity` and `LoanEntity` have not been created yet.

### Domain rules

- Default loan period is **15 days** (`LoanPolicy.DEFAULT_LOAN_DAYS`).
- A loan is blocked if the user's status is `SUSPENDED` or the book's status is not `AVAILABLE`.
- Loan endpoint: `POST /api/loans` with `{ userId, bookId, workerId }`.

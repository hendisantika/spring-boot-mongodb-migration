# spring-boot-mongodb-migration

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-mongodb-migration/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-mongodb-migration/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-6DB33F?logo=springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-8.0-47A248?logo=mongodb)

A sample Spring Boot REST API that manages **employees** and **departments** in MongoDB and runs
database migrations with [Mongock](https://mongock.io/).

## Tech Stack

| Component        | Version / Tool                                |
|------------------|-----------------------------------------------|
| Java             | 25 (Temurin)                                  |
| Spring Boot      | 4.1.2 (Web, Data MongoDB, Validation)         |
| Database         | MongoDB 8.0                                   |
| Migration        | Mongock 5 (`mongodb-springdata-v4-driver`)    |
| API docs         | springdoc-openapi (Swagger UI)                |
| Build            | Maven Wrapper (`./mvnw`)                      |
| Testing          | JUnit 5 + Testcontainers (MongoDB)            |
| Local infra      | Docker Compose (MongoDB + mongo-express)      |

## Prerequisites

- JDK 25
- Docker (for Docker Compose and for Testcontainers during tests)

## Running Locally

The project includes `spring-boot-docker-compose`, so `compose.yaml` is started automatically when the app
runs:

```shell
./mvnw spring-boot:run
```

Or start the infrastructure yourself:

```shell
docker compose up -d
./mvnw spring-boot:run
```

| Service       | URL / Port                      |
|---------------|---------------------------------|
| Application   | http://localhost:8080           |
| Swagger UI    | http://localhost:8080/swagger-ui |
| OpenAPI JSON  | http://localhost:8080/v3/api-doc |
| MongoDB       | `localhost:27017` (db `employee`) |
| mongo-express | http://localhost:8002           |

## Database Migrations

Mongock change units live in `src/main/java/id/my/hendisantika/mongodbmigration/dbmigration`:

| Order | Change Unit                | Description                                      |
|-------|----------------------------|--------------------------------------------------|
| 1     | `DatabaseInitChangeLog`    | Seeds departments and employees                  |
| 2     | `DatabaseUpdateChangeLog`  | Sets every employee's salary to `100.0`          |

Each change unit also defines a `@RollbackExecution` method.

## API Endpoints

| Method | Endpoint                 | Description           |
|--------|--------------------------|-----------------------|
| GET    | `/api/employees`         | List employees        |
| POST   | `/api/employees`         | Create an employee    |
| GET    | `/api/employees/{id}`    | Get employee by ID    |
| PUT    | `/api/employees/{id}`    | Update employee       |
| DELETE | `/api/employees/{id}`    | Delete employee       |
| GET    | `/api/departments`       | List departments      |
| POST   | `/api/departments`       | Create a department   |
| GET    | `/api/departments/{id}`  | Get department by ID  |
| PUT    | `/api/departments/{id}`  | Update department     |
| DELETE | `/api/departments/{id}`  | Delete department     |

Example request:

```shell
curl -X 'POST' \
  'http://localhost:8080/api/employees' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "ID001",
  "firstName": "ITADORI",
  "lastName": "YUJI",
  "email": "yuji@ypmail.com",
  "salary": 150,
  "department": {
    "id": "DP001",
    "code": "DP001",
    "name": "HRD"
  }
}'
```

## Testing

Tests start a disposable MongoDB container via Testcontainers (`@ServiceConnection`), so no local database
is required — only a running Docker daemon:

```shell
./mvnw test
```

## CI/CD & Dependency Updates

- **GitHub Actions** (`.github/workflows/maven.yml`): builds and tests on JDK 25 for every push and pull
  request to `main` (can also be triggered manually). On pushes to `main` it submits the Maven dependency
  graph to GitHub.
- **Dependabot** (`.github/dependabot.yml`):
  - Maven — daily, with grouped PRs for Spring Boot, Testcontainers, Mongock, springdoc and other
    minor/patch updates.
  - GitHub Actions — daily, grouped into a single PR.
  - Docker Compose images — weekly.

## Author

**Hendi Santika** — [s.id/hendisantika](https://s.id/hendisantika)

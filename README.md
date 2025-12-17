# Copilot Task Manager

A simple Spring Boot REST API for managing tasks. Built with Spring Boot 4.0, Java 17, and H2 database. Includes Maven Wrapper for easy builds.

## Features
- Task CRUD endpoints (create, read, update, delete)
- H2 database with console enabled
- Persistent file-based H2 configuration
- Lightweight JSON responses

## Requirements
- Java 17
- No need to install Maven (uses `mvnw`)

## Quick Start (Windows PowerShell)
```powershell
# Build the project
.\mvnw clean package -DskipTests

# Run the application
.\mvnw spring-boot:run
```

Alternatively, run the packaged JAR after building:
```powershell
java -jar target\copilot-task-manager-0.0.1-SNAPSHOT.jar
```

## Configuration
Main settings are in `src/main/resources/application.properties`:
- Server port: `8084`
- H2 DB URL (persistent): `jdbc:h2:./data/taskdb;AUTO_SERVER=TRUE`
- H2 Console: `/h2-console`

## H2 Console Login
- JDBC URL: `jdbc:h2:./data/taskdb`
- Driver Class: `org.h2.Driver`
- User: `sa`
- Password: (empty)
- Console: http://localhost:8084/h2-console

## API Endpoints
- GET `/api/tasks` — List all tasks
- POST `/api/tasks` — Create a task
- PUT `/api/tasks/{id}` — Update a task
- DELETE `/api/tasks/{id}` — Delete a task
- GET `/` — Root welcome/info

### JSON fields
- `title` (string)
- `description` (string)
- `status` (enum): `TODO`, `IN_PROGRESS`, `DONE`, `BLOCKED`
- `priority` (enum): `LOW`, `MEDIUM`, `HIGH`, `URGENT`

### Examples (PowerShell)
```powershell
# Get all tasks
Invoke-WebRequest -Uri "http://localhost:8084/api/tasks" -Method GET | Select-Object -ExpandProperty Content

# Create a task
$body = @{ title = "Complete project"; description = "Finish the Spring Boot task manager"; status = "TODO"; priority = "HIGH" } | ConvertTo-Json
Invoke-WebRequest -Uri "http://localhost:8084/api/tasks" -Method POST -ContentType "application/json" -Body $body | Select-Object -ExpandProperty Content

# Update a task (replace 1 with actual ID)
$update = @{ title = "Updated title"; description = "Updated description"; status = "DONE"; priority = "LOW" } | ConvertTo-Json
Invoke-WebRequest -Uri "http://localhost:8084/api/tasks/1" -Method PUT -ContentType "application/json" -Body $update | Select-Object -ExpandProperty Content

# Delete a task (replace 1 with actual ID)
Invoke-WebRequest -Uri "http://localhost:8084/api/tasks/1" -Method DELETE | Select-Object -ExpandProperty Content
```

### Examples (Bash)
```bash
# Get all tasks
curl -s http://localhost:8084/api/tasks

# Create a task
curl -X POST http://localhost:8084/api/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Complete project",
    "description": "Finish the Spring Boot task manager",
    "status": "TODO",
    "priority": "HIGH"
  }'

# Update a task
curl -X PUT http://localhost:8084/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated title",
    "description": "Updated description",
    "status": "DONE",
    "priority": "LOW"
  }'

# Delete a task
curl -X DELETE http://localhost:8084/api/tasks/1
```

## Troubleshooting
- `mvn` not recognized: use `.\mvnw` (Maven Wrapper)
- 500 on `/`: root endpoint provided by `RootController`
- Favicon warnings: safe to ignore; no static `favicon.ico`

## Project Structure
- `src/main/java/.../controller` — controllers (`TaskController`, `RootController`)
- `src/main/java/.../entity` — JPA entities (`Task`, enums)
- `src/main/java/.../repository` — Spring Data repositories (`TaskRepository`)
- `src/main/java/.../service` — business logic (`TaskService`)
- `src/main/resources` — configuration (`application.properties`)

## License
For internal/demo use.

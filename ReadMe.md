# BrainTeaser

**BrainTeaser** is a production-grade, web-based online quiz platform built with **Spring Boot**, **JPA/Hibernate**, and **H2 in-memory database**. It allows admins to create quizzes, assign topics and categories, and manage users. The application supports roles, permissions, and answer key management.

---

## Features

- **Quiz Management**: Create, update, and delete quizzes with multiple-choice questions.
- **Answer Key Management**: Map correct answers to quiz questions.
- **User Management**: Create and manage users with different roles.
- **Roles and Permissions**: Define roles (ADMIN, USER) and assign permissions.
- **Categories, Topics, Tags, and Difficulty Levels**: Organize quizzes effectively.
- **Bootstrap Data**: Preloaded sample data using `CommandLineRunner`.
- **Swagger/OpenAPI**: API documentation available via `springdoc-openapi`.
- **H2 Database**: Lightweight, in-memory database for development and testing.

---

## Tech Stack

- **Java 23**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **MapStruct** for DTO mapping
- **Springdoc OpenAPI** for API documentation
- **Maven** for dependency management

---

## Getting Started

### Prerequisites

- Java 23
- Maven 3.x
- IDE like IntelliJ IDEA or Eclipse

---

### Clone the Repository

```bash
git clone <repository-url>
cd BrainTeaser
```

## Run the Application

Ensure the H2 database is configured in application.properties:
```bash
spring.datasource.url=jdbc:h2:mem:brainteaserdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```


# Database Access Endpoint
```bash
Access the H2 console at: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:brainteaserdb

Username: sa

Password: (leave blank)
```


## Start the application using Maven:
```bash
mvn spring-boot:run
```

## API Documentation

You can view and interact with all available APIs using **Swagger UI**:

[View APIs in Swagger UI](http://localhost:8080/swagger-ui/index.html)

```bash
com.BrainTeaser
│
├─ model          # Entity classes (User, Roles, Quiz, QuestionPaper, etc.)
├─ repository     # Spring Data JPA repositories
├─ service        # Service layer for business logic
├─ controller     # REST controllers
├─ bootstrap      # CommandLineRunner for bootstrap data
├─ util           # Utility classes

```

## Bootstrap Data

The application loads sample data at startup via `CommandLineRunner`:

- **Categories**: `General Knowledge`, `Science`
- **Topics**: `Physics`, `History`
- **Tags**: `Important`, `Revision`
- **Difficulty Levels**: `Easy`, `Medium`
- **Roles**: `ADMIN`, `USER`
- **Users**: `admin`, `user`
- **Sample Quizzes and Answer Keys**

## Notes

- Passwords in bootstrap data are **plain text** (for testing). Use `BCryptPasswordEncoder` to encrypt passwords in production.
- H2 database is **in-memory**, so all data is lost on restart.
- For persistent storage in production, use **MySQL** or **PostgreSQL**.


## Dependencies

- **Spring Boot Starter Web**
- **Spring Boot Starter Data JPA**
- **Spring Boot Starter Validation**
- **H2 Database**
- **Lombok**
- **MapStruct**
- **Springdoc OpenAPI**



## API Endpoints

## Answer Key Controller

**Base URL:** `/api/v1/answer-keys`

This controller manages **Answer Keys** for Question Papers. It provides endpoints to create, read, update, and delete answer keys.

---

### Endpoints

#### 1. Create a new Answer Key

- **URL:** `/create`
- **Method:** `POST`
- **Request Body:** `AnswerKeyDto`
- **Response:** `AnswerKeyDto`
- **Description:** Creates a new answer key for a question paper.
  
- POST /api/v1/answer-keys/create

```json
{
  "questionPaperTitle": "Physics Paper 1",
  "answers": {
    "1": "A",
    "2": "B",
    "3": "C"
  }
}
```


#### 2. Get Answer Key by Question Paper Title

- **URL:** `/{questionPaperTitle}`
- **Method:** `GET`
- **Response:** `AnswerKeyDto`
- **Description:** Retrieves the answer key for the specified question paper.

- GET /api/v1/answer-keys/Physics%20Paper%201

```json
{
  "questionPaperTitle": "Physics Paper 1",
  "answers": {
    "1": "A",
    "2": "B",
    "3": "C"
  }
}
```

#### 3. Get All Answer Keys

- **URL:** `/all`
- **Method:** `GET`
- **Response:** `List<AnswerKeyDto>`
- **Description:** Retrieves all answer keys.

- GET /api/v1/answer-keys/all

```json
[
  {
    "questionPaperTitle": "Physics Paper 1",
    "answers": {
      "1": "A",
      "2": "B",
      "3": "C"
    }
  },
  {
    "questionPaperTitle": "History Paper 1",
    "answers": {
      "1": "A",
      "2": "C",
      "3": "D"
    }
  }
]
```
#### 4. Update Answer Key by Question Paper Title

- **URL:** `/{questionPaperTitle}`
- **Method:** `PUT`
- **Request Body:** `AnswerKeyDto`
- **Response:** `AnswerKeyDto`
- **Description:** Updates the answer key for a specific question paper.

- PUT /api/v1/answer-keys/Physics%20Paper%201

```json
{
  "answers": {
    "1": "B",
    "2": "C",
    "3": "D"
  }
}
```

#### 5. Delete Answer Key by Question Paper Title

- **URL:** `/{questionPaperTitle}`
- **Method:** `DELETE`
- **Response:** `String`
- **Description:** Deletes the answer key for the specified question paper.

- DELETE /api/v1/answer-keys/Physics%20Paper%201

```json
"Answer Key deleted successfully for Question Paper: Physics Paper 1"
```

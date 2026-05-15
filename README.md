# must configure application_properties to run the project 
# Student Grade Management REST API

A Spring Boot-based RESTful API for managing students, courses, and grades with JWT authentication and Swagger documentation.

## Features
- **Student Management**: CRUD operations for student records.
- **Course Management**: Manage course details and credits.
- **Grade Management**: Teachers can assign and update grades for students in specific courses.
- **Security**: JWT-based authentication with role-based access control (Admin, Teacher).
- **Documentation**: Interactive API documentation using Swagger UI.

## Tech Stack
- **Java 17**
- **Spring Boot 3.2**
- **Spring Security & JWT**
- **Spring Data JPA & PostgreSQL**
- **Maven**
- **Swagger/OpenAPI**

## Getting Started

### Prerequisites
- **JDK 17** or higher
- **Maven**
- **PostgreSQL**

### Database Setup
1. Create a database named `grade_manage` in PostgreSQL.
2. Open `src/main/resources/application.properties`.
3. Update `spring.datasource.username` and `spring.datasource.password` with your PostgreSQL credentials.

### Running the Application
1. Navigate to the project root directory.
2. Run the following command:
```bash
mvn spring-boot:run
```

## How to Test the API

### 1. API Documentation (Swagger)
Once the application is running, open your browser and go to:
`http://localhost:8080/swagger-ui.html`

### 2. Authentication Flow
To access most endpoints, you need a JWT token:
1. **Register**: Send a POST request to `/api/v1/auth/register` with:
   ```json
   {
     "username": "admin",
     "password": "password123",
     "role": "ADMIN"
   }
   ```
2. **Login**: Send a POST request to `/api/v1/auth/login` with your credentials.
3. **Copy the Token**: You will receive a JSON response with a `"token"`.
4. **Authorize in Swagger**: Click the **"Authorize"** button in Swagger UI and paste the token as `Bearer <your_token>`.

### 3. Role-Based Access
- **ADMIN**: Can manage Students, Courses, Grades, and Users.
- **TEACHER**: Can only add and edit Grades.
- **Unauthorized**: Can only view data (if permitted) or access the login/register endpoints.

## Project Structure
- **controller**: REST API endpoints.
- **service**: Business logic and data processing.
- **repository**: Database interaction using Spring Data JPA.
- **model**: Database entities.
- **security**: JWT logic and Spring Security configuration.
- **dto**: Data Transfer Objects for clean API communication.

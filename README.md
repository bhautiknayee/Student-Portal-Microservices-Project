
# Student Portal Microservices Project

This project is a microservices-based Student Portal that allows students to enroll in courses and manage their information. It is built with Spring Boot, designed to demonstrate the implementation of a microservices architecture using Java.

## Project Overview

This Student Portal system consists of three core microservices:
1. **Student Microservice**: Manages student data such as name, email, and student-specific information.
2. **Course Microservice**: Manages course details like course name, description, and other relevant data.
3. **Enrollment Microservice**: Handles the enrollment process, which associates students with courses.

### Technology Stack:
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL** (for database)
- **Maven** (for dependency management)
- **REST API** (for communication between microservices)

## Architecture

This project uses a **microservices architecture** where each service is self-contained and interacts with others through RESTful APIs. Each microservice has its own database, following the Database-per-Service pattern.

### Microservices:

1. **Student Microservice**:
   - **Purpose**: Manage students.
   - **Key Features**:
     - Add a new student.
     - Retrieve student details.
     - Update student information.
   - **Database**: Manages the `students` table.
   
2. **Course Microservice**:
   - **Purpose**: Manage courses.
   - **Key Features**:
     - Add a new course.
     - Retrieve course details.
     - Update course information.
   - **Database**: Manages the `courses` table.

3. **Enrollment Microservice**:
   - **Purpose**: Handle student enrollments (junction between students and courses).
   - **Key Features**:
     - Enroll a student in a course.
     - View courses a student is enrolled in.
     - View students enrolled in a course.
     - Unenroll a student from a course.
   - **Database**: Manages the `enrollments` table.

## Getting Started

### Prerequisites

- **Java 11+**
- **Maven 3+**
- **PostgreSQL**

### Clone the Repository

```bash
git clone https://github.com/your-username/student-portal-microservices.git
cd student-portal-microservices
```

### Setting Up Databases

Ensure that you have PostgreSQL running, and create databases for each microservice. Update the database connection details in the `application.properties` files in each microservice.

Example (for `Student` microservice):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Repeat this step for the Course and Enrollment microservices.

### Running the Microservices

Each microservice can be started individually using Maven:

```bash
cd student-microservice
mvn spring-boot:run

cd ../course-microservice
mvn spring-boot:run

cd ../enrollment-microservice
mvn spring-boot:run
```

Once the microservices are up, they will run on different ports (configured in `application.properties`):
- Student Microservice: `http://localhost:8081`
- Course Microservice: `http://localhost:8082`
- Enrollment Microservice: `http://localhost:8083`

### Key API Endpoints

#### Student Microservice
- `POST /students`: Add a new student.
- `GET /students/{id}`: Retrieve student details.
- `PUT /students/{id}`: Update student information.
- `DELETE /students/{id}`: Remove a student.

#### Course Microservice
- `POST /courses`: Add a new course.
- `GET /courses/{id}`: Retrieve course details.
- `PUT /courses/{id}`: Update course information.
- `DELETE /courses/{id}`: Remove a course.

#### Enrollment Microservice
- `POST /enrollments`: Enroll a student in a course.
- `GET /enrollments/student/{studentId}`: View courses a student is enrolled in.
- `GET /enrollments/course/{courseId}`: View students enrolled in a course.
- `DELETE /enrollments/{id}`: Unenroll a student from a course.

### Testing the API

You can use Postman or cURL to test the API endpoints. Here’s an example cURL command to enroll a student in a course:

```bash
curl -X POST http://localhost:8083/enrollments -H "Content-Type: application/json" -d '{"studentId": 1, "courseId": 101}'
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

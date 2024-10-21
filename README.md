
# Student Portal Microservices Project

This project is a microservices-based Student Portal, which allows students to enroll in courses and manage their information. It is built with Spring Boot and Docker, leveraging a microservices architecture using Spring Cloud, Kubernetes, and advanced cloud-native principles.

## Project Overview

The Student Portal system consists of three core microservices:
1. **Student Microservice**: Manages student data such as name, email, and student-specific information.
2. **Course Microservice**: Manages course details like course name, description, and other relevant data.
3. **Enrollment Microservice**: Handles the enrollment process, which associates students with courses.

### Additional Features from Course:
- **Docker & Docker Compose**: Each microservice is containerized and can be run independently in Docker containers. Docker Compose is used to run the entire system together.
- **Kubernetes (GKE)**: The project is orchestrated and deployed on Kubernetes, with services being managed and scaled within a cluster.
- **Spring Cloud Components**: Used for service discovery, configuration management, and routing.
- **Helm**: Used for managing Kubernetes resources efficiently.

### Technology Stack:
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL** (for database)
- **Docker & Docker Compose** (for containerization)
- **Kubernetes (GKE)** (for container orchestration)
- **Spring Cloud Config** (for configuration management)
- **Spring Eureka** (for service discovery)
- **Spring Cloud Gateway** (for routing)
- **Prometheus & Grafana** (for monitoring and observability)
- **OAuth2 & Spring Security** (for security)
- **Kafka & RabbitMQ** (for event-driven microservices)
- **Helm** (for managing Kubernetes resources)

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

### Docker & Kubernetes Integration

Each microservice is containerized using Docker. You can build Docker images for each microservice and run them using Docker Compose for local development, or deploy them on a Kubernetes cluster (e.g., Google Kubernetes Engine).

#### Docker Commands:
To build Docker images:
```bash
docker build -t student-microservice ./student-microservice
docker build -t course-microservice ./course-microservice
docker build -t enrollment-microservice ./enrollment-microservice
```

To run the microservices using Docker Compose:
```bash
docker-compose up
```

#### Kubernetes Commands:
To deploy the services in Kubernetes:
```bash
kubectl apply -f kubernetes/student-deployment.yaml
kubectl apply -f kubernetes/course-deployment.yaml
kubectl apply -f kubernetes/enrollment-deployment.yaml
```

### Helm Integration
Helm charts are used to manage Kubernetes resources, simplifying deployments and configurations.

To deploy the microservices using Helm:
```bash
helm install student-portal ./helm/student-portal
```

## Key API Endpoints

### Student Microservice
- `POST /students`: Add a new student.
- `GET /students/{id}`: Retrieve student details.
- `PUT /students/{id}`: Update student information.
- `DELETE /students/{id}`: Remove a student.

### Course Microservice
- `POST /courses`: Add a new course.
- `GET /courses/{id}`: Retrieve course details.
- `PUT /courses/{id}`: Update course information.
- `DELETE /courses/{id}`: Remove a course.

### Enrollment Microservice
- `POST /enrollments`: Enroll a student in a course.
- `GET /enrollments/student/{studentId}`: View courses a student is enrolled in.
- `GET /enrollments/course/{courseId}`: View students enrolled in a course.
- `DELETE /enrollments/{id}`: Unenroll a student from a course.

## Monitoring and Observability

The project integrates monitoring tools like **Prometheus** and **Grafana** for system observability and metrics. Logs are collected using **Loki**, and traces are managed through **Tempo**. These tools provide insights into the performance and behavior of microservices in real-time.

## Security

The microservices are secured using **OAuth2** and **OpenID Connect** implemented via **Spring Security**. This ensures that only authorized users can access the APIs, and secure communication is maintained between microservices.

## Event-Driven Microservices

The project leverages event-driven communication using **RabbitMQ** and **Kafka**. This allows for asynchronous processing, making the system more resilient and scalable.

## Deployment

### Local Deployment
You can run the microservices locally using Docker Compose:
```bash
docker-compose up
```

### Kubernetes Deployment
Deploy the services in a Kubernetes cluster:
```bash
kubectl apply -f kubernetes/student-deployment.yaml
kubectl apply -f kubernetes/course-deployment.yaml
kubectl apply -f kubernetes/enrollment-deployment.yaml
```

### Helm Deployment
To manage and deploy using Helm charts:
```bash
helm install student-portal ./helm/student-portal
```

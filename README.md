# Greeting Apps

## Overview
The **GreetingApps** repository is a Java and Spring Boot-based application that provides a simple greeting API. It supports various HTTP methods, user authentication, and dynamic user attributes. The application is designed for learning and implementing RESTful APIs using Spring Boot.

## Features
- **Dynamic Greeting Messages**: Generate personalized greetings.
- **CRUD Operations**: Manage greetings efficiently.
- **User Authentication**: Secure access using JWT authentication.
- **Database Integration**: Store and manage greetings persistently.
- **Swagger API Documentation**: Interactive API documentation for easy testing.

## Technologies Used
- **Java 17+**
- **Spring Boot 3+**
- **Spring Security & JWT**
- **Spring Data JPA (Hibernate)**
- **MySQL/PostgreSQL**
- **Swagger (OpenAPI)**
- **Lombok**

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ayanpandey27/GreetingApps.git
   ```
2. Navigate to the project directory:
   ```bash
   cd GreetingApps
   ```
3. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/greetingdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
5. Access the API documentation at:
   ```
   http://localhost:8080/swagger-ui/
   ```

## Usage
- **Register/Login**: Authenticate users via JWT.
- **Get Greeting**: Fetch a greeting message.
- **Create Greeting**: Add a new greeting message.
- **Update/Delete Greeting**: Modify or remove an existing greeting.

## Future Enhancements
- **Multi-Language Support**: Greetings in multiple languages.
- **Role-Based Access Control**: Restrict access based on user roles.
- **Caching Mechanism**: Improve performance with Redis caching.

## License
This project is open-source and available under the MIT License.

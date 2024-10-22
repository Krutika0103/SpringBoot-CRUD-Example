# Spring Boot CRUD Example

This project demonstrates a simple CRUD (Create, Read, Update, Delete) application built with Spring Boot. It provides two implementations: one using a relational database and the other using a file system.

## Features

- **Database CRUD**: Manage employee records stored in a relational database (MySQL, PostgreSQL, etc.).
- **File System CRUD**: Perform CRUD operations on a text file, allowing data storage and retrieval from the file system.
- **RESTful API**: Expose endpoints for interacting with employee data, making it easy to integrate with other applications.

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/spring-boot-crud-example.git
   
2. **Navigate to the project directory**:
   cd spring-boot-crud-example
   
3. **Configure the application**:
   Update application.properties for database connection details.

4. **Run the application**:
   ./mvnw spring-boot:run
   
5. **API Endpoints**:
   Employee CRUD Operations:
          POST /employee/save - Create an employee
          GET /employee/getEmp - Retrieve all employees
          PUT /employee/{id} - Update an employee
          DELETE /employee/{id} - Delete an employee
File CRUD Operations:
          POST /file/save - Create a file entry
          GET /file/read - Retrieve all file entries
          PUT /file/update - Update a file entry
          DELETE /file/delete - Delete a file entry
   
6. **Technologies Used**:
   Spring Boot
   JPA/Hibernate
   MySQL (for database CRUD)
   Java I/O (for file system CRUD)

**Feel free to customize the repository link and any other details as necessary!**

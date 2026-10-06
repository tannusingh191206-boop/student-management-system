# Student Management System

A web-based **Student Management System** built using **Spring Boot, Thymeleaf, Spring Data JPA, and MySQL**.

The application allows users to manage student records through a simple web interface.

## Features

* Add new students
* View all students
* Search students by roll number
* Update student information
* Delete students
* MySQL database integration
* Thymeleaf-based web interface
* Spring Data JPA for database operations

## Technologies Used

* **Java**
* **Spring Boot**
* **Spring MVC**
* **Spring Data JPA**
* **Hibernate**
* **Thymeleaf**
* **MySQL**
* **Maven**
* **HTML**
* **CSS**

## Project Structure

```text
student-management-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │       ├── DemoApplication.java
│   │   │       ├── Student.java
│   │   │       ├── StudentController.java
│   │   │       └── StudentRepository.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── index.html
│   │       │   ├── add-student.html
│   │       │   ├── view-students.html
│   │       │   ├── search-student.html
│   │       │   ├── update-student.html
│   │       │   └── delete-student.html
│   │       │
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Main Functions

### Add Student

Users can enter student details such as:

* Roll Number
* Name
* Age
* Gender
* Course
* Phone
* Email
* Address

### View Students

Displays all registered students stored in the MySQL database.

### Search Student

Students can be searched using their **roll number**.

### Update Student

Existing student information can be modified using the student's roll number.

### Delete Student

Students can be removed from the database using their roll number.

## Database

The application uses **MySQL** as its database.

The main database table stores student information including:

```text
rollNo
name
age
gender
course
phone
email
address
```

Hibernate/JPA is used to manage database operations.

## Running the Project Locally

### 1. Clone the repository

```bash
git clone https://github.com/tannusingh191206-boop/student-management-system.git
```

### 2. Open the project

```bash
cd student-management-system
```

### 3. Configure MySQL

Create a MySQL database:

```sql
CREATE DATABASE studentdb;
```

Configure your databas

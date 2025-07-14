
🎓 Student Management System

A console-based Java application that performs CRUD operations (Create, Read, Update, Delete) on student records using Hibernate (JPA) and PostgreSQL. This project serves as a basic example of ORM-based Java development with Maven.


🛠️ Technologies Used

Java 

Hibernate ORM (JPA)

PostgreSQL

Maven (for dependency management)






🗃️ PostgreSQL Database Schema



Database Name:

students

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(100),
    grade VARCHAR(5)
);







📦 Project Structure

StudentManagement/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org.example/
│   │   │       ├── Main.java
│   │   │       ├── entity/
│   │   │       │   └── Student.java
│   │   │       ├── dao/
│   │   │       │   └StudentDao.java
│   │   │       └── util/
│   │   │           └── HibernateUtil.java
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
├── pom.xml



📸 Screenshot 




---

✅ Features

Add a new student

View all students

Update student details

Delete a student

Exit the application

# 🌍 Travel Planner – Spring Boot Application

This project is a **Spring Boot backend application** for a travel destination planner [Demo Video](https://drive.google.com/file/d/1VqmdOwzAY3HJT7mYTBNYzC9xevIm5kUH/view?usp=sharing).  
It uses **Spring Security**, **JPA**, **Flyway**, **MySQL**, and **JWT** for authentication and data management.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot 4.0.2
- Spring Security
- Spring Data JPA
- Flyway (Database Migrations)
- MySQL
- JWT (jjwt)
- Gradle

---

## 📂 Requirements

Before running the project, make sure you have:

- Java JDK 21
- MySQL 8 or higher
- Gradle (or use the Gradle Wrapper)

---

## 🛠️ Database Setup

1. Start your MySQL server
2. Create the database:

```sql
CREATE DATABASE travelplanner;
```

## Configure DataBase Credentials

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/travelplanner
    username: root
    password: root
```
⚠️ Make sure the username and password match your local MySQL setup.

---

## ▶️ Running the Application
Using Gradle Wrapper (Recommended)
```
./gradlew bootRun
or 
gradlew bootRun
```

---
⚠️ Make sure the port 8080 is free to use.






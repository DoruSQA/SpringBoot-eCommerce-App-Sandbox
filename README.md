 <a id="top"></a>
# 🛒 eCommerce App (Spring Boot · Java · H2)

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Framework-green?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)
![H2](https://img.shields.io/badge/H2-Database-lightgrey)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Templates-green?logo=thymeleaf)

> **Note:** This application is a personal development project and is still a work in progress. It is primarily used as an Application Under Test (AUT) for QA automation projects.

---

## 📖 Overview

A self-developed **monolithic e-commerce web application** built using **Java**, **Spring Boot**, **Thymeleaf**, and an **H2 file-based database**.

The application follows a traditional layered architecture, separating request handling, business logic, and database operations into dedicated components.

Its primary purpose is to provide a controlled environment for practicing and implementing automated software testing, particularly **UI and database testing**.

---

## 🏗️ Application Architecture

The application follows a layered monolithic architecture:

| Layer | Responsibility |
|-------|----------------|
| Controller | Handles HTTP requests and application endpoints |
| Service | Contains application business logic |
| Repository | Manages database access and operations |
| Entity | Defines application data models |
| Config | Provides application configuration |

---

## 🛠️ Tech Stack

- **Java 17** — Programming language
- **Spring Boot** — Application framework
- **Spring MVC** — Web request handling
- **Thymeleaf** — Server-side HTML templates
- **Spring Data JPA** — Database access
- **H2 Database** — File-based data storage
- **Maven** — Dependency and build management

---

## 🧪 Testing Purpose

The application serves as a testing environment for developing and validating automation frameworks, including:

- **UI Testing** — Automated browser interactions and functional verification.
- **Database Testing** — SQL-based verification of data consistency, persistence, and integrity.
- **UI & Database Integration Testing** — Verification of database changes resulting from UI operations.

---

## 🚧 Project Status

**Work in Progress** — The application is not yet feature-complete and is being developed and extended as needed for testing purposes.

---

**Author:** [DoruSQA](https://github.com/DoruSQA) | [LinkedIn](https://www.linkedin.com/in/sava-doru/)

<p align="right"><a href="#top">Back to Top</a></p>
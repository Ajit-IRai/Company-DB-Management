# Employee & Department Management System (Spring Boot)

## 📌 Project Overview

This is a Spring Boot REST API project that manages **Employees and Departments** within a company.

The project demonstrates:

* Layered architecture (Controller → Service → DAO → Repository)
* One-to-Many relationship between **Department and Employee**
* Custom exception handling
* Structured API responses

---

## 🧱 Architecture

```
Controller → Service → DAO → Repository → Database
```

---

## 🚀 Features

### 👨‍💼 Employee Management

* Add Employee
* Update Employee
* Delete Employee
* Get Employee by ID
* Get all Employees

### 🏢 Department Management

* Create Department
* Assign Employees to Department
* Fetch Department details with Employees

---

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

---

## 📂 Project Structure

```
src/main/java/employee_Depart/

├── controller
│   └── CompanyController.java

├── service
│   └── Company_service.java

├── dao
│   └── Company_dao.java

├── repository
│   ├── EmployeeRepository.java
│   └── DepartmentRepository.java

├── entity
│   ├── Employee.java
│   └── Department.java

├── dto
│   └── ResponseStructure.java

├── exception
│   ├── GlobalExceptionHnadler.java
│   ├── IdNotFoundException.java
│   └── NoRecordFoundException.java

└── EmployeeDepartApplication.java
```

---

## 🔗 API Endpoints

### 📍 Employee APIs

| Method | Endpoint       | Description        |
| ------ | -------------- | ------------------ |
| POST   | /employee      | Save Employee      |
| GET    | /employee/{id} | Get Employee by ID |
| GET    | /employee      | Get all Employees  |
| PUT    | /employee      | Update Employee    |
| DELETE | /employee/{id} | Delete Employee    |

---

### 📍 Department APIs

| Method | Endpoint         | Description         |
| ------ | ---------------- | ------------------- |
| POST   | /department      | Create Department   |
| GET    | /department/{id} | Get Department      |
| GET    | /department      | Get all Departments |

---

## 🔄 Relationship

* One Department can have multiple Employees
* Implemented using:

  * `@OneToMany`
  * `@ManyToOne`

---

## ⚙️ Configuration

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_depart
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📦 Sample JSON

### Employee

```json
{
  "name": "Ajit Rai",
  "email": "ajit@gmail.com",
  "contact": "9876543210"
}
```

### Department

```json
{
  "name": "IT"
}
```

---

## ⚠️ Exception Handling

* `IdNotFoundException`
* `NoRecordFoundException`
* Handled using `GlobalExceptionHnadler`

---

## 📬 API Response Format

```json
{
  "statusCode": 200,
  "message": "Success",
  "data": {}
}
```

---

## 📸 API Screenshots

### 🔹 Get All Employees

<img width="973" height="621" alt="Screenshot 2026-03-18 124135" src="https://github.com/user-attachments/assets/6c1a6ae2-8fdc-42cd-b5e7-d0891df64ca2" />

* Endpoint: `GET /employee`
* Description: Retrieves all employee records with department details

---

### 🔹 Get Employee By ID

![Get Employee By I<img width="977" height="445" alt="Screenshot 2026-03-18 124217" src="https://github.com/user-attachments/assets/01af272f-2ea9-4f51-b0a2-d85e99ccec3d" />
D](screenshots/get-employee-by-id.png)

* Endpoint: `GET /api/employee/{id}`
* Description: Fetch a specific employee by ID

---

### 🔹 Get All Departments

![Get All Departments](scre<img width="977" height="623" alt="Screenshot 2026-03-18 124946" src="https://github.com/user-attachments/assets/10bd94c1-fe93-4dd7-9721-e61a5161a4bb" />
enshots/get-departments.png)

* Endpoint: `GET /department`
* Description: Retrieves all department records

---

## ▶️ How to Run

1. Clone the repository:

```
git clone https://github.com/your-username/employee-department.git
```

2. Open in Eclipse / IntelliJ

3. Configure MySQL database

4. Run:

```
EmployeeDepartApplication.java
```

---

## 👨‍💻 Author

**Ajit Rai**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!

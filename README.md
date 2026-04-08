# 📋 Task Management System (Backend API)

## 📌 Overview
The **Task Management System** is a backend REST API built using **Spring Boot** that helps users efficiently manage daily work tasks.

It replaces manual tracking (like spreadsheets) by providing structured task management, progress tracking, and deadline monitoring.

---

## 🎯 Objective
To build a scalable backend system that allows:
- Task creation and updates  
- Workflow tracking (TODO → IN_PROGRESS → COMPLETED)  
- Priority and deadline management  
- Filtering and searching tasks  
- Viewing task statistics  

---

## 🧠 Key Features

### 📝 Task Management
- Create tasks with:
  - Title
  - Description
  - Priority
  - Due Date  

- Update and delete tasks  
- View all tasks or a specific task  

---

### 🔄 Task Workflow
Each task follows a lifecycle:
- **TODO**
- **IN_PROGRESS**
- **COMPLETED**

---

### ⚡ Priority Management
Tasks can have:
- LOW  
- MEDIUM  
- HIGH  

---

### ⏱ Deadline Monitoring
- View overdue tasks  
- View tasks due today  
- Track pending deadlines  

---

### 🔍 Search & Filtering
- Filter tasks by:
  - Status  
  - Priority  
- Search tasks by title  

---

### 📊 Task Summary / Statistics
Provides insights like:
- Total tasks  
- Completed tasks  
- Pending tasks  
- Overdue tasks  

---

## ⚙️ Tech Stack

- **Backend**: Spring Boot  
- **Database**: MySQL  
- **ORM**: Spring Data JPA (Hibernate)  
- **Build Tool**: Maven  
- **API Type**: REST  

---

## 🏗️ System Design

### 📊 Core Entity
- `Task`

---

### 🔗 Fields
- title  
- description  
- priority (LOW, MEDIUM, HIGH)  
- status (TODO, IN_PROGRESS, COMPLETED)  
- dueDate  
- createdAt  

---

## 🧩 API Highlights

### 📌 Task APIs
- Create Task  
- Get All Tasks  
- Get Task by ID  
- Update Task  
- Delete Task  

---

### 📌 Filtering APIs
- Filter by status  
- Filter by priority  
- Search by title  

---

### 📌 Analytics APIs
- Get task summary  
- Get overdue tasks  
- Get tasks due today  

---

## 🧠 Key Concepts Used

- REST API design  
- Layered architecture (Controller → Service → Repository)  
- DTO pattern  
- Enum usage for status and priority  
- Exception handling  
- Database design with JPA  

---

## 🚀 How to Run

1. Clone repository  
2. Configure MySQL database  
3. Update `application.properties`  
4. Run application  

```bash
mvn spring-boot:run

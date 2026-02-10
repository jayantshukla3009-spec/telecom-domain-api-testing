📡 Telecom Domain API Automation Framework
📌 Project Overview

This project focuses on automation testing of REST APIs for a Contact List Application in the Telecom domain. The framework validates end-to-end API workflows using Postman and REST Assured to ensure correctness, reliability, and security of API responses.

The automation suite validates authentication, CRUD operations, API chaining, response validations, and negative scenarios using a structured TestNG-based automation framework.

🌐 Application Under Test

Contact List API
https://thinking-tester-contact-list.herokuapp.com

This application provides REST APIs to manage users and contact details including authentication, contact creation, update, retrieval, and deletion operations.

🎯 Automation Scope
👤 User Management APIs

Add new user

Get user profile

Update user details

Login user and generate authentication token

Logout user

📇 Contact Management APIs

Add new contact

Retrieve contact list

Retrieve contact by ID

Update full contact details (PUT)

Update partial contact details (PATCH)

❌ Negative Testing

Validate login failure with invalid credentials

Validate response status codes and error handling

🛠 Tech Stack
Category	Technology
Programming Language	Java
API Automation Tool	REST Assured
Manual API Tool	Postman
Test Framework	TestNG
Build Tool	Maven
Reporting	Extent Reports
Serialization	POJO + Jackson Databind
Version Control	Git & GitHub
🏗 Framework Architecture Highlights
✔ API Chaining Implementation

Dynamic user token generation

Token reuse across dependent API calls

Contact ID extraction and reuse

✔ POJO-Based Serialization

Request payload mapping using Java POJO classes

Response deserialization for structured validation

✔ Test Execution Flow Automation
Add User → Get Profile → Update User → Login → 
Add Contact → Get Contact List → Get Contact → 
Update Contact → Partial Update → Logout


(Aligned with project requirement flow)

✔ Centralized Reporting Framework

Extent Reports integration using TestNG Listener

Execution logs and result tracking

✔ Response Validation

Status code validation

Status message validation

JSON body validation using Hamcrest assertions

src/main/java
 ├── telecom_report
 │    └── ExtentManager.java
 │
 └── telecom_resource
      ├── addUser_POJO.java
      ├── Contact_POJO.java
      ├── User_POJO.java
      └── UserResponse_POJO.java

src/test/java
 ├── telecom_domain_REST
 │    └── Telecom_API.java
 │
 └── telecom_Listeners
      └── Listeners.java

Reports/ – Extent HTML reports  
Postman Collection – API manual testing scripts  

testng.xml – Test suite configuration  
pom.xml – Maven dependencies

✅ Test Scenarios Covered
User APIs

Add user validation

Authentication token validation

User profile verification

User update validation

Logout validation

Contact APIs

Contact creation validation

Contact retrieval validation

Contact update validation

Partial update validation

Negative Scenarios

Invalid login validation

Error response validation

📊 Reporting Features

Extent HTML execution reports

Step-level logging

Test lifecycle tracking using TestNG Listener

▶️ How To Execute The Project
Prerequisites

Java JDK 8+

Maven Installed

Postman (Optional for manual verification)

Git

Clone Repository
git clone <repository-url>

Run Using Maven
mvn clean test

Run Using TestNG

Execute:

testng.xml

🚀 Key Learning Outcomes

REST API automation framework design

Token-based authentication testing

API chaining implementation

Serialization & Deserialization using POJO

Response validation using REST Assured

Hybrid manual + automation API testing approach

👨‍💻 Author

Jayant Kumar Shukla
🔗 LinkedIn: https://www.linkedin.com/in/jayant-kumar-shukla

🔗 GitHub: https://github.com/jayantshukla3009-spec

📎 Notes

This project was developed as part of Telecom domain API testing capstone assignment to demonstrate real-world REST API automation testing practices.

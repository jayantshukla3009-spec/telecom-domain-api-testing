# Telecom Domain API Testing – Contact List Application

## Project Overview
This project focuses on end-to-end API testing of a Telecom domain **Contact List Application**.  
The application allows users to manage contacts by performing operations such as user registration, login, add contact, update contact, retrieve contact details, and delete contacts.

The project is implemented using **both Postman (manual API testing)** and **REST Assured (automation)** to demonstrate strong understanding of API testing concepts, validation techniques, and automation practices.

---

## Application Features Tested
- User Registration
- User Login & Authentication
- Add Contact
- Get Contact Details
- Update Contact (PUT / PATCH)
- Delete Contact
- Logout

---

## Tech Stack

### Manual API Testing
- Tool: Postman
- API Type: REST
- Authentication: Token-based
- Validations: Status codes, response body, headers

### Automation API Testing
- Language: Java
- Automation Tool: REST Assured
- Test Framework: TestNG
- Build Tool: Maven
- JSON Parsing: Jackson / JsonPath
- Assertions: TestNG & Hamcrest
- Reporting: Console & TestNG reports

---

## Project Structure
Telecom_Domain_API/
│
├── src/main/java
│   ├── telecom_report
│   │   └── ExtentManager.java
│   │
│   └── telecom_resource
│       ├── addUser_POJO.java
│       ├── Contact_POJO.java
│       ├── User_POJO.java
│       └── UserResponse_POJO.java
│
├── src/test/java
│   ├── telecom_domain_REST
│   │   └── Telecom_API.java
│   │
│   └── telecom_Listeners
│       └── Listeners.java
│
├── src/main/resources
│
├── src/test/resources
│
├── Reports
│   └── TelecomAPI_Report.html
│
├── pom.xml
├── testng.xml
└── README.md



---

## Key Testing Activities
- Validated HTTP status codes (200, 201, 400, 401, 404)
- Verified response body fields and data integrity
- Performed API chaining across multiple requests
- Used POJO classes for request and response serialization
- Automated CRUD operations using REST Assured
- Logged request and response details for debugging

---

## How to Run Automation Tests
1. Clone the repository
2. Import the project as a Maven project
3. Update base URI if required
4. Run tests using:
   - `testng.xml`  
   **or**
   - `mvn test`

---

## Notes
This project was created for learning and hands-on practice of **API testing in a real-time Telecom domain scenario**, covering both **manual and automation testing approaches**.

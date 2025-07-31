# Janitri Dashboard Login Page Automation:
This project is an automated test suite for the login functionality of the Janitri Dashboard Login page (https://dev-dash.janitri.in).
It is built using Java, Selenium WebDriver, TestNG, and Maven, and follows the Page Object Model (POM) design pattern for better maintainability and scalability.

## Tech Stack:
- **Java**  
- **Selenium WebDriver**  
- **TestNG**  
- **Maven**  
- **Page Object Model (POM)**  
- **GitHub**

## Project Structure
```
project-root/
│
├── base/
│   └── BaseTest.java             # Base setup for WebDriver and configuration
│
├── pages/
│   └── LoginPage.java            # Page Object Model class for login page
│
├── tests/
│   └── LoginPageTests.java       # TestNG test cases for login functionality
│
├── testng.xml                    # TestNG suite configuration
├── pom.xml                       # Maven dependencies and build setup
└── README.md                     # Project documentation
```

## Features Covered:

- Positive and Negative Login Test Cases
- Validations for:
  - Empty fields
  - Invalid credentials
  - Error message displays
- TestNG annotations used for structured test flows
- WebDriver setup and teardown with reusable base class

## Prerequisites:
- Java (JDK 8 or higher)
- Maven
- IDE (Eclipse / IntelliJ IDEA)
- ChromeDriver (compatible with your Chrome browser)

## 👤 Tested by:
Niyojith S
Trained in Manual & Automation Testing using Java
Coimbatore, Tamil Nadu

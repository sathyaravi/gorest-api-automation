# gorest-api-automation

## Tech Stack
- Java
- REST Assured
- TestNG
- Maven
- Allure Reports
- Log4j2

## Framework Features
- API Client Design Pattern
- POJO Request/Response Models
- JSON Data Driven Testing
- Schema Validation
- Reusable Request Specification
- Dynamic Test Data
- Allure Reporting
- Logging

## APIs Covered
- Create User
- Get User
- Update User
- Delete User

## How to Run

mvn clean test in bash

Use testng.xml -> Run as TestNG suite in Eclipse

## Generate Allure Report

Navigate to the project folder in cmd prompt or bash
allure serve allure-results

## Important note
If not able to generate an allure report, make sure it is installed in the system or not.
We can check if the allure is installed in the system by using the command: allure --version
If it is not installed, download the allure.zip from https://github.com/allure-framework/allure2/releases and install and add path to the environment variable.


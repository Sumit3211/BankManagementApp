BankManagementApp

Overview
BankManagementApp is a Spring Boot application designed for managing bank accounts. It provides a RESTful API for creating, reading, updating, and deleting bank account information. The application uses Spring Data JPA for database interactions and is connected to a MySQL database.

Features
Create a new bank account
Retrieve details of an existing account by account number
Retrieve details of all accounts
Deposit an amount into an account
Withdraw an amount from an account
Delete an account

Technologies Used
Java 21
Spring Boot 3.3.2
Spring Data JPA
Spring Web
MySQL
Maven

Getting Started

Prerequisites
Before you begin, ensure you have the following installed on your machine:
Java 21
Maven
MySQL

Installation
Clone the repository:

Configure the MySQL Database:
Create a MySQL database named bankmanagement and update the application.properties file with your MySQL username and password.

The application will start on port 8080. You can change the port by updating the application.properties file.

Endpoints

Create Account
URL: /account/create
Method: POST
Request Body:

{
  "account_holder_name": "John Doe",
  "account_balance": 1000.00
}
Response:
{
  "account_number": 1,
  "account_holder_name": "John Doe",
  "account_balance": 1000.00
}

Get Account by Account Number
URL: /account/{id}
Method: GET
Response:
{
  "account_number": 1,
  "account_holder_name": "John Doe",
  "account_balance": 1000.00
}
Get All Accounts
URL: /account/getallaccount
Method: GET
Response:

  {
    "account_number": 1,
    "account_holder_name": "John Doe",
    "account_balance": 1000.00
  }

Deposit Amount
URL: /account/deposit/{accountNumber}/{amount}
Method: PUT
Response:
{
  "account_number": 1,
  "account_holder_name": "John Doe",
  "account_balance": 1100.00
}

Withdraw Amount
URL: /account/withdraw/{accountNumber}/{amount}
Method: PUT
Response:
{
  "account_number": 1,
  "account_holder_name": "John Doe",
  "account_balance": 900.00
}

Delete Account
URL: /account/delete/{accountNumber}
Method: DELETE
Response:

{
  "message": "Account Closed"
}


Project Structure

com.bm: Main application package.
com.bm.controller: Contains the REST controllers.
com.bm.entity: Entity classes representing database tables.
com.bm.repositories: Repository interfaces for data access.
com.bm.service: Service interfaces and their implementations.

How It Works

1.Controllers: The MainController class handles HTTP requests and maps them to corresponding service methods.
2.Services: The AccountServiceImpl class contains the business logic for account operations.
3.Repositories: The AccountRepo interface extends JpaRepository to provide CRUD operations.

Configuration
Update the src/main/resources/application.properties file with your database configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/bankmanagement
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true




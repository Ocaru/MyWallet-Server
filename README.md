# MyWallet-Server - expenditure monitoring application

## Introduction
MyWallet is a simple application that allows you to manage your own expenditures and gives you the ability to analyze them more easily.
The project was created as part of learning Spring and REST architecture.

## Technologies
- Java
- SpringBoot
- Spring Web
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## Required
- Java 11
- MySQL 8.0.27
- Maven 3.8.6
  
## Launch of the application
 ### I. MySQL configuration
 1. Log in through your default MySQL account (An example of a command that can be entered on the command line for a user named 'root' is shown below). 
    ```
      mysql -u root -p
    ```  
    After entering it you will be asked for a password.  
		   
       
2. Next, enter the following commands via the command line:  
    ```
      CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';  
      GRANT ALL PRIVILEGES ON * . * TO 'student'@'localhost';  
      CREATE DATABASE mywallet;  
    ```
    And that's it, the rest will be taken care of by the program (creating tables and inserting data)  
		
    It is important to remember that the application connects to the database through the default port **3306**.  

###	II. Starting MyWallet server application  
1. Clone this repository
2. Go to the folder with the project, run command line ('SHIFT' + 'Mouse Right Click' on a project folder, and select 'Open PowerShell window here') and enter the below command:   
    ```
	    mvn spring-boot:run
    ```
    or 
    ```
	    ./mvnw spring-boot:run
    ``` 

3. **THIS APPLICATION WORKS WITH THE MYWALLET-CLIENT APPLICATION, SO IF YOU HAVEN'T RUN MYWALLET-CLIENT YET, GO TO MY OTHER REPOSITORY AND READ THE 'README' FILE ABOUT IT.**

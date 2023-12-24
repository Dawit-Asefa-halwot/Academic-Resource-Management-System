# Project Name: Academic Resource Management System

## Introduction Academic Resource Management System! 
This project aims to provide a comprehensive solution for managing academic resources at Haramaya University.

This Java application is an Academic Resource Management System for Haramaya University.
It provides functionality for both students and teachers to interact with the academic resources of the university.
The system uses a MySQL database for data storage, and the JDBC API for Java is employed for database connectivity.

This Java application is an Academic Resource Management System for Haramaya University.
It provides functionality for both students and teachers to interact with the academic resources of the university.
The system uses a MySQL database for data storage, and the JDBC API for Java is employed for database connectivity.

Prerequisites

Java Development Kit (JDK)
MySQL Server
MySQL Connector/J (JDBC Driver)


## How to Run

1) Database Setup
To set up the database for the project, use the  SQL code we provided:
-- Create tables for users, class schedules, exam schedules,
   assignment schedules, and materials (see attached code for the complete SQL setup).

2. Run the project using a Java Virtual Machine (JVM).
3. Follow the on-screen instructions to log in or register as a new user.
4. Once logged in, you can access various features such as:
   - Viewing your schedule
   - Viewing grades
   - Viewing materials
   - Uploading schedules (teachers only)
   - Uploading grades (teachers only)
   - Uploading materials (teachers only)

## Notes
- The provided code require additional development such as workbench username and password to implement all features.
- The project uses a relational database (MySQL) to store data.
- Ensure that the MySQL Server is running and accessible.
- Set up the database by executing the SQL scripts provided in the database_scripts folder.
- enter the you databse username and password
- if you enter incorrect username and password the system gives yo second chance if you again enter incorrect password the system exits autuomatically
- Compile and run the AcademicResourceManagementSystem class.

Features

Student Functionality

Registration: Students can register by providing a username and password.
View Schedule: Students can view their class schedule, assignment schedule, and exam schedule.
View Grades: Students can view their grades for various subjects.
View Materials: Students can access and view academic materials.

Teacher Functionality

Upload Schedule: Teachers can upload class schedules, assignment schedules, and exam schedules.
Upload Grades: Teachers can upload grades for students.
Upload Materials: Teachers can upload academic materials.

Usage

Database Connection: Users are prompted to enter the database username and password at the beginning of the program.
User Type Selection: Users specify whether they are a student or a teacher.
Student Functionality: Students can register, view schedules, grades, and materials.
Teacher Functionality: Teachers can upload schedules, grades, and materials.

Database Tables

users: Stores information about registered users (username, password, role).
class_schedule: Stores class schedules (subject, days, class_time).
Assignment_Schedule: Stores assignment schedules (subject, start_date, deadline).
exam_schedule: Stores exam schedules (subject, exam_name, exam_date, exam_time).
materials: Stores academic materials (subject, material_name).
data_structure, oop_java, statistics, coa, networking, operating_system: Subject-specific tables storing grades for students.

Error Handling

The system provides error handling for database connection issues, invalid user inputs, and SQL query execution errors.

Notes

The application assumes a predefined set of subjects and grading criteria.
The user interface is text-based and relies on the console for input and output.
Feel free to customize the application based on your specific requirements and extend it with additional features.

Academic Resource Management System
This Java application is an Academic Resource Management System for Haramaya University. It provides functionality for both students and teachers to interact with the academic resources of the university. The system uses a MySQL database for data storage, and the JDBC API for Java is employed for database connectivity.

Prerequisites
Java Development Kit (JDK)
MySQL Server
MySQL Connector/J (JDBC Driver)
How to Run
Ensure that the MySQL Server is running and accessible.
Set up the database by executing the SQL scripts provided in the database_scripts folder.
Compile and run the AcademicResourceManagementSystem class.
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

-- Create a database
CREATE DATABASE IF NOT EXISTS university_system;
USE university_system;

-- Create a table for users
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role ENUM('student', 'teacher') NOT NULL
);

-- Create a table for class schedules
CREATE TABLE IF NOT EXISTS class_schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(50) NOT NULL,
    days VARCHAR(50) NOT NULL,
    class_time TIME NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create a table for exam schedules
CREATE TABLE IF NOT EXISTS exam_schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(50) NOT NULL,
    exam_name ENUM('mid_term', 'final_term') NOT NULL,
    exam_date DATE NOT NULL,
    exam_time TIME NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create a table for assignment schedules
CREATE TABLE IF NOT EXISTS assignment_schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(50) NOT NULL,
    start_date DATE NOT NULL,
    deadline TIME NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);



-- Create a table for materials
CREATE TABLE IF NOT EXISTS materials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(50) NOT NULL,
    material_tnameTEXT NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE coa (
    subject_name VARCHAR(255),
    student_username VARCHAR(50),
    mark INT,
    grade CHAR(2),
    PRIMARY KEY (student_username)
);

-- Table for OOP Java (Object-Oriented Programming in Java)
CREATE TABLE oop_java (
    subject_name VARCHAR(255),
    student_username VARCHAR(50),
    mark INT,
    grade CHAR(2),
    PRIMARY KEY (student_username)
);

-- Table for Statistics
CREATE TABLE statistics (
    subject_name VARCHAR(255),
    student_username VARCHAR(50),
    mark INT,
    grade CHAR(2),
    PRIMARY KEY (student_username)
);

-- Table for Networking
CREATE TABLE networking (
    subject_name VARCHAR(255),
    student_username VARCHAR(50),
    mark INT,
    grade CHAR(2),
    PRIMARY KEY (student_username)
);

-- Table for Data Structure
CREATE TABLE data_structure (
    subject_name VARCHAR(255),
    student_username VARCHAR(50),
    mark INT,
    grade CHAR(2),
    PRIMARY KEY (student_username)
);

-- Table for Operating System
CREATE TABLE operating_system (
    subject_name VARCHAR(255),
    student_username VARCHAR(50),
    mark INT,
    grade CHAR(2),
    PRIMARY KEY (student_username)
);


